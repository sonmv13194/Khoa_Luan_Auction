package vn.smartdev.user.dao.manager;

import java.util.Date;

import vn.smartdev.user.dao.entity.UserAttempt;

public interface UserAttemptsManager {
	 void insertAttempts(String username);
	 void updateAttempts(String username);
	 void lockUser(String username);
	 void resetAttempts(String username);
	 UserAttempt geAttemptsEntity(String name);
	 boolean isExists(String name);
	 boolean isTimeUp(Date d);
}
