package jfonferko.genuitek.activity.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jfonferko.genuitek.activity.model.ActivityTableModel;
import jfonferko.genuitek.activity.service.ActivityService;

import java.util.Date;

/**
 * Created by JFonferko on 2016-08-17.
 */
@ManagedBean(name = "activityBackingBean")
@Component
@RequestScoped
public class ActivityBackingBean {

    @Autowired
    private ActivityService activityService;

    private ActivityTableModel activityTableModel;

    private Long id;
    private String username = null;
    private int time = 0;
    private Date date = null;
    private String text = "tekst";


    @PostConstruct
    public void init() {setActivityTableModel(new ActivityTableModel(activityService.findAll()));
    }

    public ActivityBackingBean() {
    }
    public ActivityTableModel getActivityTableModel() {
        return this.activityTableModel;
    }

    public void setActivityTableModel(ActivityTableModel activityTableModel) {
        this.activityTableModel = activityTableModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ActivityService getActivityService() {
        return activityService;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}