package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyEncodingFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(MyEncodingFilter.class);

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); //체인연결
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("debug");
	}

}
