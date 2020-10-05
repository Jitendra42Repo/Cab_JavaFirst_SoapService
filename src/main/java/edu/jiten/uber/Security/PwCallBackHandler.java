package edu.jiten.uber.Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PwCallBackHandler implements CallbackHandler {

	Map<String, String> usrnamePwd = new HashMap<>();
	
	public PwCallBackHandler() {
		usrnamePwd.put("test-user", "dummy-pwd");
		
	}
	
	
	/*
	 * @ Param: Callback[] contains the user-name. We need to validate it against in-memory database.
	 * If the user-name exists then set the corresponding password to the Callback Object.
 	 * 
	 */
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException { 
		
		for (Callback callback : callbacks) {
			
			WSPasswordCallback pwdCallback = (WSPasswordCallback)callback;
			
			String pwd = usrnamePwd.get(pwdCallback.getIdentifier());
			
			if(null != pwd ) {
				pwdCallback.setPassword(pwd);
				return ;
			}
			
			
		}
		
		
	}

}
