# Cab_JavaFirst_SoapService: Online Cab Service

1. Online Cab service that allows consumer application to reserve Rides and cancel rides.
2. Validate the consumer application is requesting the service with valid username and password using WS-Security (USERNAME_TOKEN).

## Tech Stack

1. Create Java First SOAP service using following steps:

  I. Add "Apache CXF JAX-WS dependency" in pom.xml for JAX-WS support. 
  II. Mark the Java Beans (DTO) with JAXB annotation. And mark the endpoint with JAX-WS annotation (@WebService, @WebMethod, @WebParam, @WebResult). 
  III. Write the configuration file to publish the endpoint. EndpointImpl(new CabServiceImpl()).publish("/cabService");

2. Implement the WS-Security from WS-Standard for Authentication: 

I. Add "CXF WS Security" dependency in pom.xml for WS-Securiy support.           
II. Instantiate WSS4JInInterceptor and add it to the enpoint for enabling the Security Interceptor. Configure "WSSecurity ACTION" as USERNAME_TOKEN PROFILE.        
III. Configure the "CallbackHandler" as PWCallBackHandler class. Implement "handle(Callback[] callbacks)" method from CallbackHandler (interface) to autheticate 
the username in the request from in-memory database.         

3. SOAP UI Testing: Add the following wsse:security tag in the request soapenv:Header. Otherwise the service will return soap:Fault.


<soapenv:Header> 
  <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" soapenv:mustUnderstand="1"> 
    <wsse:UsernameToken xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org /wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"> 
      <wsse:Username xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">test-user</wsse:Username> 
      <wsse:Password xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" Type="http://docs.oasis-open.org /wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">dummy-pwd</wsse:Password> 
    </wsse:UsernameToken> 
  </wsse:Security> 
</soapenv:Header>
