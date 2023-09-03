package com.sabji.contoller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.config.JwtTokenUtil;
import com.sabji.model.JwtRequest;
import com.sabji.model.JwtResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class JwtAuthenticationController
 {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService UserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String username,@RequestParam String password )
			throws Exception {

		System.out.println("for login usrname:"+username+"$$"+password);
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(username, password);

		final UserDetails userDetails = UserDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
// for path variable and encrypted in one string 
	@RequestMapping(value = "/authenticate/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationTokenWithPath(@PathVariable("id") String requestData)
			throws Exception {

		String username="",password="";
		System.out.println("path variable "+requestData);
		System.out.println("for login usrname:"+username+"$&&$"+password);
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(username, password);

		final UserDetails userDetails = UserDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	// for json 
		@RequestMapping(value = "/authenticatebyjson", method = RequestMethod.POST)
		public ResponseEntity<?> createAuthenticationTokenWithPath(@RequestBody JwtRequest authenticationRequest)
				throws Exception {

			System.out.println("for login usrname:"+authenticationRequest.getUsername()+"$REQUESTBODY$"+authenticationRequest.getPassword());
		   authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		//	authenticate(username, password);

			final UserDetails userDetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String token = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new JwtResponse(token));
		}
		
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			//throw new Exception("INVALID_CREDENTIALS", e);
			throw new UsernameNotFoundException("INVALID_CREDENTIALS", e);
		}
	}
}
