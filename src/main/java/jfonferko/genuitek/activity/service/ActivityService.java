package jfonferko.genuitek.activity.service;

import jfonferko.genuitek.activity.domain.Activity;
import jfonferko.genuitek.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by JFonferko on 2016-08-17.
 */
@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	public void save(Activity activity) throws Exception {
		List<Activity> activityList = activityRepository.findByDateAndUsername(activity.getDate(),
				activity.getUsername());
		if (!activityList.isEmpty()) {
			Activity activityToSave = activityList.get(0);
			activityToSave.setTime(activityToSave.getTime() + activity.getTime());
			activityRepository.saveAndFlush(activityToSave);
		} else {
			activityRepository.save(activity);
		}
	}

	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	public List<Activity> findByUsername(String username) {
		return activityRepository.findByUsername(username);
	}

	public List<Activity> findByDateAndUsername(Date date, String username) {
		return activityRepository.findByDateAndUsername(date, username);
	}

	public void delete(Long id) {
		activityRepository.delete(id);
	}

}