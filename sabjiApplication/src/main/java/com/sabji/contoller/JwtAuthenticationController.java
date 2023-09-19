package com.sabji.contoller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.config.JwtTokenUtil;
import com.sabji.model.JwtRequest;
import com.sabji.model.Response2;
import com.sabji.model.ResponseForToken;

import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name="Login-API")
public class JwtAuthenticationController
{

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService UserDetailsService;




	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String username,@RequestParam String password )
			throws Exception {

		System.out.println("for login usrname:"+username+"$$"+password);
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(username, password);

		final UserDetails userDetails = UserDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);

		//return ResponseEntity.ok(new JwtResponse(token));
		if (token != null) {
			return ResponseForToken.generateResponse(token, HttpStatus.OK, "200");
		} else {
			return ResponseForToken.generateResponse(" ", HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}
	}
	// for path variable and encrypted in one string
	@PostMapping(value = "/authenticate/{id}")
	public ResponseEntity<?> createAuthenticationTokenWithPath(@PathVariable("id") String requestData)
			throws Exception {

		String username="",password="";
		System.out.println("path variable "+requestData);
		System.out.println("for login usrname:"+username+"$&&$"+password);
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(username, password);

		final UserDetails userDetails = UserDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);

		if (token != null) {
			return ResponseForToken.generateResponse(token, HttpStatus.OK, "200");
		} else {
			return ResponseForToken.generateResponse(" ", HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}
	}

	// for json
	@PostMapping(value = "/authenticatebyjson")
	public ResponseEntity<?> createAuthenticationTokenWithPath(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		System.out.println("for login usrname:"+authenticationRequest.getUsername()+"$REQUESTBODY$"+authenticationRequest.getPassword());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		//	authenticate(username, password);

		final UserDetails userDetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		if (token != null) {
			return ResponseForToken.generateResponse(token, HttpStatus.OK, "200");
		} else {
			return ResponseForToken.generateResponse(" ", HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}
	}
	@GetMapping(value = "/refreshtoken")
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");
		if (claims == null) {
			return Response2.generateResponse("Token is already valid ", HttpStatus.UNAUTHORIZED, "000");
		} else {
			Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
			String token = jwtTokenUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
			return ResponseForToken.generateResponse(token, HttpStatus.OK, "200");
		}
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
	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
}
