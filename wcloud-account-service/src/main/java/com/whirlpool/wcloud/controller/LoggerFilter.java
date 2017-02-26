package com.whirlpool.wcloud.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.whirlpool.wcloud.common.utils.LoggerUtil;

/**
 * This is Filter class, which will be executed every time  when any endpoint in the micro service is invoked. This will pull out auditing information like, SAID , transaction id 
 * from request and set in the Log4 diagnostic context for logging.
 * 
 * @author Syntel
 * @since 6-Feb-2017
 */

@WebFilter(urlPatterns = {"/*"}, description = "Logger Filter")
public class LoggerFilter implements Filter{
	
	static final Logger logger = Logger.getLogger(LoggerFilter.class);
	
	 public void init(FilterConfig config) throws ServletException {
	   
	    }

	 public void destroy() {
	   }
	 
	 public void doFilter(ServletRequest req, ServletResponse res,
             FilterChain chain)
			throws ServletException, IOException {
			
				HttpServletRequest request = (HttpServletRequest) req;
				
				LoggerUtil.logMessage(logger, "************ Setting MDC ********");
				
				//TODO: Get SAID, Transaction id from request and set in logger MDC.
				LoggerUtil.initMDC("WPTest100"); 
				
				chain.doFilter(req, res);
			}

}
