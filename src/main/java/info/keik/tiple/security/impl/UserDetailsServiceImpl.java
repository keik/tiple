package info.keik.tiple.security.impl;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		logger.warn(id);

		User user = userService.getById(id);
		logger.warn("@@@" + user);
		if (user == null)
			throw new UsernameNotFoundException("Authentication failed.");
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_USER", "USER"));
	}

}
