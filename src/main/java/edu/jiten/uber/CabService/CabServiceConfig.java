package edu.jiten.uber.CabService;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.jiten.uber.Security.PwCallBackHandler;


@Configuration
public class CabServiceConfig {
		
	@Autowired
	private Bus bus;

	@Bean
	public Endpoint cabService() {
		EndpointImpl endPoint = new EndpointImpl(bus, new CabServiceImpl());
		endPoint.publish("/cabService");
		
		// 1. Create HashMap with properties to be passed into WSS4JInInterceptor.
		Map<String, Object> properties =  new HashMap<>();
		properties.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		properties.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// This is the class that implements CallbackHandler Interface that validates username & adds password.
		properties.put(ConfigurationConstants.PW_CALLBACK_CLASS, PwCallBackHandler.class.getName());
		
		
		//2. Pass the properties into the WSS4JInInterceptor Object. 
		WSS4JInInterceptor wss4jIntercept = new WSS4JInInterceptor(properties );
		
		//3. Add the WSS4JInInterceptor to the list of Interceptors of the end-point.
		endPoint.getInInterceptors().add(wss4jIntercept);
		
		return endPoint;
	}
	
	

}
