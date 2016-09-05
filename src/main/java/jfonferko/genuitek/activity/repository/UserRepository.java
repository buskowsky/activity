package jfonferko.genuitek.activity.repository;

import jfonferko.genuitek.activity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JFonferko on 2016-08-29.
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
    User findByLogin(String login);
}
