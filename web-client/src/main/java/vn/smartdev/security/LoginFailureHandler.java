package vn.smartdev.security;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.entity.UserAttempt;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.dao.manager.UserAttemptsManager;
import vn.smartdev.user.dao.manager.UserManager;


public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    UserAttemptsManager attemptsManager;

    @Autowired
    UserManager userManager;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        UserAttempt userAttempt = attemptsManager.geAttemptsEntity(name);
        try {
            User user = userManager.findUserByUsername(name);
            if (user == null)
                exception = new BadCredentialsException("Username or Password wrong");
            else if (user != null && password != user.getPassword()){
                logger.info("Role User: "+user.getRoles().get(0).getRoleName());
                if(!attemptsManager.isExists(name)){
                    attemptsManager.insertAttempts(name);
                    exception = new BadCredentialsException("Username or Password wrong");
                }
            }else if (userAttempt.getAttempts() >= 3) {
                attemptsManager.lockUser(name);
                exception = new LockedException("Account is Locked from " +  new SimpleDateFormat("HH:mm dd-MM-yyyy").format(userAttempt.getLastModified()));
            } else {
                attemptsManager.updateAttempts(name);
                exception = new BadCredentialsException("Username or Password wrong");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        exception.printStackTrace();
        super.onAuthenticationFailure(request, response, exception);
    }

}