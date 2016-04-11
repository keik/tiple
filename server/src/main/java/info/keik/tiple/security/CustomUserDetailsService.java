package info.keik.tiple.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userService.get(id);
		if (user == null)
			throw new UsernameNotFoundException("Authentication failed.");
		return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_USER", "USER"));
	}

}
