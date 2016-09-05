package jfonferko.genuitek.activity.repository;

import jfonferko.genuitek.activity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by JFonferko on 2016-08-17.
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
        List<Activity> findByUsername(String username);
        List<Activity> findByDateAndUsername(Date data, String username);
}