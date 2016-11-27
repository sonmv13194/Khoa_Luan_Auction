package vn.smartdev.userService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import vn.smartdev.role.dao.entity.Role;
import vn.smartdev.role.manager.RoleManager;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserManager;

public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userManager.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		ModelMap model = new ModelMap();
		model.addAttribute("user",user);
		List<Role> roles = roleManager.getAll();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (Role role : roles ) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}
