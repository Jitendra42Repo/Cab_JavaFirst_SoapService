package edu.jiten.uber.CabService;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.feature.Features;

import edu.jiten.uber.Exception.ServiceException;
import edu.jiten.uber.dto.CabServiceRequest;
import edu.jiten.uber.dto.CabServiceResponse;
import edu.jiten.uber.dto.Ride;


@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CabServiceImpl implements ICabService {
	
	private Map<BigInteger, Ride> cabRides = new HashMap<BigInteger, Ride>();

	@Override
	public CabServiceResponse requestCab(CabServiceRequest cabRequest) throws ServiceException{
		Ride ride = cabRequest.getRide();

		CabServiceResponse cabResponse = new CabServiceResponse();

		if ((cabRequest.getCabRequestStatus()).isCancle() == false) {

			if (null != ride.getTo() && null != ride.getFrom() && null != ride.getId()
					&& Double.valueOf(0.0) != ride.getCost()) {
				
				cabRides.put(ride.getId(), ride);
				cabResponse.setResult(true);

			} else {
				cabResponse.setResult(false);
				System.out.println("\n*********\nRequest is missing 'Ride' Details.\n************\n");
			}
		}
		else {
			System.out.println("\n*********\nCab Request has incorrect 'CabReserve': true.\n************\n");
			throw new ServiceException("CabReserve cannot be 'true' for requestCab operation.");
		}

		return cabResponse;
	}

	
	@Override
	public CabServiceResponse cancleCab(CabServiceRequest cabRequest) throws ServiceException{
		CabServiceResponse cabResponse = new CabServiceResponse();
		if ((cabRequest.getCabRequestStatus()).isCancle() == true) {
			BigInteger id = cabRequest.getRide().getId();
			if(cabRides.containsKey(id) ) {
				cabRides.remove(id);
				cabResponse.setResult(true);
			}
			else {
				System.out.println("\n*********\nThere is no cab reservation for id: "+id+".\n************\n");
				throw new ServiceException("There is no cab reservation for id: "+ id);
			}
		}
		else {
			//cabResponse.setResult(false);
			System.out.println("\n*********\nCancle Cab Request has incorrect 'CabReserve' as false.\n************\n");
			throw new ServiceException("CabStatus cannot be 'false' for cancleCab operation.");
		}
		
		return cabResponse;
	}

}
