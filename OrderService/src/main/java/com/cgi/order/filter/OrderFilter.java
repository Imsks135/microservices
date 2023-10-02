package com.cgi.order.filter;

import java.io.IOException;
import java.security.SignatureException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String tokenStr = req.getHeader("Authorization");
		System.out.println(tokenStr);
		if (tokenStr != null) {

			String token = tokenStr.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey("CGI-JAVAFULLSTACK-WAVE2").parseClaimsJws(token).getBody();

				System.out.println(claims);
				String emailId = claims.getSubject();
				req.setAttribute("emailId", emailId);
			} catch (SignatureException e) {
				System.out.println("Invalid signature");

			}
		}
		chain.doFilter(request, response);

	}
}
