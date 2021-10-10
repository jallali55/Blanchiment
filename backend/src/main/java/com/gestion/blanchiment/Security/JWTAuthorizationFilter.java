package com.gestion.blanchiment.Security;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException {
	response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Headers",
		"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
	response.addHeader("Access-Control-Expose-Headers",
		"Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization");
	response.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS,DELETE");
	if (request.getMethod().equals("OPTIONS")) {
	    response.setStatus(HttpServletResponse.SC_OK);
	} else if (request.getRequestURI().equals("/login")) {
	    filterChain.doFilter(request, response);
	    return;
	} else {
	    String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
	   if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
		filterChain.doFilter(request, response);
		return;
	    }
	    Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
		    .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();
	    String username = claims.getSubject();
	    
	    String role = (String) claims.get("role");
	    Collection<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority(role));
	    UsernamePasswordAuthenticationToken authenticationtoken = new UsernamePasswordAuthenticationToken(username,
		    null, authorities);
	    SecurityContextHolder.getContext().setAuthentication(authenticationtoken);
	    filterChain.doFilter(request, response);
	}
    }
}

