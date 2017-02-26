package com.whirlpool.wcloud.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.controller.LoggerFilter;

@Configuration
public class AppInitializer implements ServletContextInitializer  {

	 final Logger logger = Logger.getLogger(BootApplication.class);
	 
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
     
    		LoggerUtil.logMessage(logger, "+++++++++++++++ AppInitializer :onStartup : About to setup logger filter in servlet context ");
    	    LoggerFilter loggerFilter = new LoggerFilter();
    	    servletContext.addFilter("LoggerFilter", loggerFilter).addMappingForUrlPatterns(null, true, "/*");
    	    LoggerUtil.logMessage(logger, "+++++++++++++++ AppInitializer :onStartup : Logger filter added to context ");
    }

   
}
