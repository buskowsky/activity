package jfonferko.genuitek.activity.bean;

import jfonferko.genuitek.activity.domain.User;
import jfonferko.genuitek.activity.model.UserTableModel;
import jfonferko.genuitek.activity.service.UserService;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by JFonferko on 2016-08-29.
 */
@ManagedBean(name = "userBackingBean")
@Component
@RequestScoped
public class UserBackingBean {

	@Autowired
	private UserService userService;

	private UserTableModel userTableModel;

	private Long id;
	private String login;
	private String firstname;
	private String lastname;
    private User selectedUser;


	@PostConstruct
	public void init() {
		setUserTableModel(new UserTableModel(userService.findAll()));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserTableModel getUserTableModel() {
		return userTableModel;
	}

	public void setUserTableModel(UserTableModel userTableModel) {
		this.userTableModel = userTableModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((User) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((User) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
