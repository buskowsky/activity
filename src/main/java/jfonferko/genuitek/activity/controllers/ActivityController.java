package jfonferko.genuitek.activity.controllers;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jfonferko.genuitek.activity.bean.ActivityBackingBean;
import jfonferko.genuitek.activity.domain.Activity;
import jfonferko.genuitek.activity.model.ActivityTableModel;
import jfonferko.genuitek.activity.service.ActivityService;
import jfonferko.genuitek.activity.utils.MessagesView;
import jfonferko.genuitek.activity.utils.REPOSITORY_ENUM_STATUS;

/**
 * Created by JFonferko on 2016-08-17.
 */
@ManagedBean
@Component
@RequestScoped
public class ActivityController {

	@Autowired
	private ActivityBackingBean activityBackingBean;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private MessagesView messagesView;

	public void removeActivity() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		Long id = Long.parseLong(params.get("id"));
		activityService.delete(id);
		activityBackingBean
				.setActivityTableModel(new ActivityTableModel(activityService.findAll()));
		messagesView.info(REPOSITORY_ENUM_STATUS.SUCCESS, "Activity", "remove");
	}

	public void addActivity() {
		Activity activity = new Activity();
		// activity.setId(activityBackingBean.getId());
		activity.setDate(activityBackingBean.getDate());
		activity.setTime(activityBackingBean.getTime());
		activity.setUsername(activityBackingBean.getUsername().toUpperCase());

		try {
			activityService.save(activity);
			activityBackingBean
					.setActivityTableModel(new ActivityTableModel(activityService.findAll()));
			messagesView.info(REPOSITORY_ENUM_STATUS.SUCCESS, "Activity", "add");
			cleanForm();
		} catch (Exception e) {
			messagesView.error(REPOSITORY_ENUM_STATUS.ERROR, "Activity", "add");
		}
	}

	private void cleanForm(){
		activityBackingBean.setTime(0);
		activityBackingBean.setUsername(null);
	}

	public ActivityBackingBean getActivityBackingBean() {
		return activityBackingBean;
	}

	public void setActivityBackingBean(ActivityBackingBean activityBackingBean) {
		this.activityBackingBean = activityBackingBean;
	}

	public void changeText() {
		if (this.getActivityBackingBean().getText() == "tekst") {
			this.getActivityBackingBean().setText("zmiena");
		}else{
			this.getActivityBackingBean().setText("tekst");
		}
	}

}