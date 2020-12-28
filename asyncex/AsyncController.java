package com.adobe.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.entity.EmployeeAddresses;
import com.adobe.entity.EmployeeNames;
import com.adobe.entity.EmployeePhone;
import com.adobe.service.AsyncService;

@RestController
public class AsyncController 
{

	private static Logger Log = LoggerFactory.getLogger(AsyncService.class);
	
	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/testAsync", method = RequestMethod.GET)
	public String testAsync() throws InterruptedException, ExecutionException 
	{
		
		Log.info("testAsync start");
		
		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
		
		//wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
		
		Log.info("EmployeeAddress--> " + employeeAddress.get());
		Log.info("EmployeeName--> " + employeeName.get());
		Log.info("EmployeePhone--> " + employeePhone.get());
		
		return "done";
		
	}

}
