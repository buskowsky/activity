package jfonferko.genuitek.activity.model;

import jfonferko.genuitek.activity.domain.Activity;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created by JFonferko on 2016-08-17.
 */

public class ActivityTableModel extends ListDataModel<Activity>
		implements SelectableDataModel<Activity> {

	public ActivityTableModel() {
	}

	public ActivityTableModel(List<Activity> list) {
		super(list);
	}

	@Override
	public Object getRowKey(Activity object) {
		return null;
	}

	@Override
	public Activity getRowData(String s) {
		List<Activity> activities = (List<Activity>) getWrappedData();

		for (Activity activity : activities) {
			if (activity.getId() == new Long(s))
				return activity;
		}
		return null;
	}
}