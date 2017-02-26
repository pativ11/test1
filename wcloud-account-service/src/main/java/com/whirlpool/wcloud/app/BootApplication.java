package com.whirlpool.wcloud.app;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.whirlpool.wcloud.common.utils.LoggerUtil;


@ComponentScan(basePackages={"com.whirlpool.wcloud"})
@SpringBootApplication
public class BootApplication {
	
	static final Logger logger = Logger.getLogger(BootApplication.class);
	
			
	public static void main(String[] args) {
		
		LoggerUtil.logMessage(logger, "BootApplication : Main: Start");
		
        ConfigurableApplicationContext context = SpringApplication.run(new Class[] { BootApplication.class, AppInitializer.class }, args);
        //context.get
        LoggerUtil.logMessage(logger,"BootApplication : Main: Application loaded: ready to server webservices");
	}
}
