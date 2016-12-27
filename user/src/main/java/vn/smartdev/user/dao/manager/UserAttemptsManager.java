package vn.smartdev.user.dao.manager;

import java.util.Date;

import vn.smartdev.user.dao.entity.UserAttempt;

public interface UserAttemptsManager {
	public void insertAttempts(String username);
	public void updateAttempts(String username);
	public void lockUser(String username);
	public void resetAttempts(String username);
	public UserAttempt geAttemptsEntity(String name);
	public boolean isExists(String name);
	public boolean isTimeUp(Date d);
}
