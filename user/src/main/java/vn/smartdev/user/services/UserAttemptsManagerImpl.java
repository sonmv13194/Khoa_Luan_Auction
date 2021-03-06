package vn.smartdev.user.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smartdev.user.dao.entity.UserAttempt;
import vn.smartdev.user.dao.repository.UserAttemptsRepository;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.dao.manager.UserAttemptsManager;

@Service
public class UserAttemptsManagerImpl implements UserAttemptsManager {

	@Autowired
	UserAttemptsRepository uar;

	@Autowired
	UserRepository uer;

	@Override
	public void insertAttempts(String username) {
		uar.save(new UserAttempt(username, 1, new Date()));

	}

	@Override
	public void updateAttempts(String username) {
		uar.updateAttempts(username);
	}

	@Override
	public void lockUser(String username) {
		uer.updateLocked(username, false);
	}

	@Override
	public void resetAttempts(String username) {
		uer.updateLocked(username, true);
		uar.resetAttempts(username);
	}

	@Override
	public UserAttempt geAttemptsEntity(String name) {
		return uar.findByUsername(name);
	}

	@Override
	public boolean isExists(String name) {
		if(uar.countAttempts(name)==1)
			return true;
		else return false;
	}

	@Override
	public boolean isTimeUp(Date d) {
		Calendar timeLocked = Calendar.getInstance();
		timeLocked.setTime(d);
		timeLocked.add(Calendar.MINUTE, 5);
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date());
		if (currentTime.getTime().after(timeLocked.getTime())){
			return true;
		}
		return false;
	}

}
