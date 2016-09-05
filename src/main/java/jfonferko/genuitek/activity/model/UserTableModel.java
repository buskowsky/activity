package jfonferko.genuitek.activity.model;

import jfonferko.genuitek.activity.domain.Activity;
import jfonferko.genuitek.activity.domain.User;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created by JFonferko on 2016-08-29.
 */
public class UserTableModel extends ListDataModel<User> implements SelectableDataModel<User> {

	public UserTableModel(List<User> list) {
		super(list);
	}

	@Override
	public Object getRowKey(User object) {
		return null;
	}

	@Override
	public User getRowData(String s) {
		List<User> users = (List<User>) getWrappedData();

		for (User user : users) {
			if (user.getId() == new Long(s))
				return user;
		}
		return null;
	}
}
