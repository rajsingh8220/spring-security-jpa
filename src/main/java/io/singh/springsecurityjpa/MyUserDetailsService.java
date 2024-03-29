package io.singh.springsecurityjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.singh.springsecurityjpa.models.MyUserDetails;
import io.singh.springsecurityjpa.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//return new MyUserDetails(username);
		Optional<User> user = userRepository.findByEmail(email);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : "+ email));
		return user.map(MyUserDetails::new).get();
	}

}
