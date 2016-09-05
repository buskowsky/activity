package jfonferko.genuitek.activity.service;

import jfonferko.genuitek.activity.domain.User;
import jfonferko.genuitek.activity.repository.UserRepository;
import jfonferko.genuitek.activity.utils.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JFonferko on 2016-08-29.
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void save(User user) throws UserExistException{
		User userToSave = userRepository.findByLogin(user.getLogin());
		if (userToSave == null) {
			userRepository.save(user);
		} else {
            throw new UserExistException("user login exist");
		}
		// userRepository.findAll();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	private User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
}
