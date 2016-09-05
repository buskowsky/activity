package jfonferko.genuitek.activity.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.enums.Enum;
import org.springframework.stereotype.Component;

/**
 * Created by JFonferko on 2016-09-01.
 */
@ManagedBean
@Component
@ViewScoped
public class MessagesView {

	private Enum status;
	private String className;
	private String action;

	public void info(REPOSITORY_ENUM_STATUS status, String className, String action) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, status.getName(), className + " " + action));
	}

	public void error(REPOSITORY_ENUM_STATUS status, String className, String action) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, status.getName(), className + " " + action));
	}

	public void error(REPOSITORY_ENUM_STATUS status, String className, String action, String reason) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, status.getName(), className + " " + action +" - "+reason ));
	}

	public void infoAddUser() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "User added"));
	}

	public void errorAddUser() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not add user"));
	}

	public void errorUserExist() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "User exist"));
	}

	public Enum getStatus() {
		return status;
	}

	public void setStatus(Enum status) {
		this.status = status;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
