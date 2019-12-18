package com.example.varma.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncodedTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
		for (int i = 1; i <= 10; i++)
			System.out.println(encoded.encode("user"));
	}

}
