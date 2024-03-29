package com.example.varma.security.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "user",
				"$2a$10$E66CVNAnJdfiglcgMVWWq.p6N/XJbGWWvfHTCvWDF.CxmiM4pAJ7q", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "varma",
				"$2a$10$gxGfRw4BTH0DOo89a.uFYetq2DStDBrR4EHEvyzfxZHoRYfXXj7Xu", "ROLE_USER_2"));

		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent())
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));

		return findFirst.get();
	}

}