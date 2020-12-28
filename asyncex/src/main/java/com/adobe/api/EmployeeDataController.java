package com.adobe.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.entity.EmployeeAddress;
import com.adobe.entity.EmployeeAddresses;
import com.adobe.service.AsyncService;

@RestController
public class EmployeeDataController {

	private static Logger Log = LoggerFactory.getLogger(AsyncService.class);
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public EmployeeAddresses getAddresses() 
	{
		
		Log.info("get Addresses start");
		
		EmployeeAddresses employeeAdressesList = new EmployeeAddresses();
		
		EmployeeAddress employeeAddress1 = new EmployeeAddress();
		EmployeeAddress employeeAddress2 = new EmployeeAddress();
		
		List<EmployeeAddress> addressList = new ArrayList<EmployeeAddress>();
		
		{
			employeeAddress1.setHouseNo("1111");
			employeeAddress1.setStreetNo("111");
			employeeAddress1.setZipCode("111111111");
			
			employeeAddress2.setHouseNo("2222");
			employeeAddress2.setStreetNo("222");
			employeeAddress2.setZipCode("2222222222");
			
			addressList.add(employeeAddress1);
			addressList.add(employeeAddress2);
			
			employeeAdressesList.setEmployeeAddressList(addressList);
			
		}
		
		return employeeAdressesList;
		
	}

}
