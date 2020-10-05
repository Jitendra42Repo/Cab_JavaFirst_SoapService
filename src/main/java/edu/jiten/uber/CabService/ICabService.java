package edu.jiten.uber.CabService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.jiten.uber.Exception.ServiceException;
import edu.jiten.uber.dto.CabServiceRequest;
import edu.jiten.uber.dto.CabServiceResponse;


@WebService
public interface ICabService {
	
	/*
	 * @Param: CabServiceRequest. If the request has CabReserve:cancel set to "false" throws Service Exception.
	 */
	@WebMethod(operationName = "requestCab")
	public @WebResult(name="carServiceResponse") CabServiceResponse requestCab(
			@WebParam(name = "cabServiceRequest") CabServiceRequest cabRequest) throws ServiceException ;
	
	/*
	 * @Param : CabServiceRequest. If the request has CabReserve:cancel set to "true" throws Service Exception.
	 */
	@WebMethod(operationName = "cancleCab")
	public @WebResult(name="carServiceResponse") CabServiceResponse cancleCab(
			@WebParam(name = "cabServiceRequest")CabServiceRequest cabRequest) throws ServiceException;

}
