package vn.smartdev.user.userService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserAttemptsManager;
import vn.smartdev.user.manager.UserManager;

public class UserServiceImpl implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserAttemptsManager attemptsManager;
	@Autowired
	UserManager userManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = null;
		try {
			userEntity = userManager.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		if (userEntity == null)
			throw new UsernameNotFoundException("No such user: " + username);
		else {
			Account acc = new Account(userEntity);
			logger.info("========== User Info: ", acc.toString());
			if (attemptsManager.geAttemptsEntity(acc.getUsername()) != null && attemptsManager.isTimeUp(attemptsManager.geAttemptsEntity(username).getLastModified()))
				attemptsManager.resetAttempts(username);
			return acc;
		}
	}
}
