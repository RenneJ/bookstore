package hh.sof03.bookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService{
	
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepo) {
		this.repository = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
	}

}
