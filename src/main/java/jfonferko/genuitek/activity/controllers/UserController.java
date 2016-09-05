package jfonferko.genuitek.activity.controllers;

import jfonferko.genuitek.activity.bean.UserBackingBean;
import jfonferko.genuitek.activity.domain.User;
import jfonferko.genuitek.activity.model.UserTableModel;
import jfonferko.genuitek.activity.service.UserService;
import jfonferko.genuitek.activity.utils.MessagesView;
import jfonferko.genuitek.activity.utils.REPOSITORY_ENUM_STATUS;
import jfonferko.genuitek.activity.utils.UserExistException;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by JFonferko on 2016-09-02.
 */
@ManagedBean
@Component
@ViewScoped
public class UserController {

	@Autowired
	private UserBackingBean userBackingBean;

	@Autowired
	private UserService userService;

	@Autowired
	private MessagesView messagesView;

	public void addUser() {
		User user = new User();
		user.setLogin(userBackingBean.getLogin().toUpperCase());
		user.setFirstname(capitalizeFirstName());
		user.setLastname(capitalizeLastname());

		try {
			userService.save(user);
			userBackingBean.setUserTableModel(new UserTableModel(userService.findAll()));
			messagesView.info(REPOSITORY_ENUM_STATUS.SUCCESS, "User", "add");
		} catch (UserExistException e) {
			messagesView.error(REPOSITORY_ENUM_STATUS.ERROR, "User", "add", e.getMessage());
		} catch (Exception e) {
			messagesView.error(REPOSITORY_ENUM_STATUS.ERROR, "User", "add");

		}
	}

	private String capitalizeFirstName() {
		return WordUtils.capitalize(userBackingBean.getFirstname());
	}

	private String capitalizeLastname() {
		return WordUtils.capitalize(userBackingBean.getLastname());
	}
}