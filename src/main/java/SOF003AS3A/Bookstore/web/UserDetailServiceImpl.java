package SOF003AS3A.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SOF003AS3A.Bookstore.domain.User;
import SOF003AS3A.Bookstore.domain.UserRepositery;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepositery repository;

	@Autowired
	public UserDetailServiceImpl(UserRepositery userRepository) {
		this.repository = userRepository;
	}

    
	// paketoidaan meidän projektin User-luokan olion tiedot Springin oman User-luokan olioksi
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 
