package jfonferko.genuitek.activity.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jfonferko.genuitek.activity.domain.Activity;
import jfonferko.genuitek.activity.repository.ActivityRepository;

/**
 * Created by JFonferko on 2016-08-22.
 */
@RestController
@RequestMapping("/api")
public class ActivityControllerRestApi {

    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public void add(Activity activity) {

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") long id) {
        activityRepository.delete(id);
    }
}