package com.adobe.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adobe.entity.EmployeeAddresses;
import com.adobe.entity.EmployeeNames;
import com.adobe.entity.EmployeePhone;

@Service
public class AsyncService {

	private static Logger Log = LoggerFactory.getLogger(AsyncService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException {
		Log.info("getEmployeeName starts");
		
		EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8080/names", EmployeeNames.class);
		
		Log.info("EmployeeNameData, {}", employeeNameData);

		Thread.sleep(1000L);
		
		Log.info("EmployeeNameData completed");

		return CompletableFuture.completedFuture(employeeNameData);	
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException {
		Log.info("getEmployeeAddress starts");
		
		EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8080/address", EmployeeAddresses.class);
		
		Log.info("EmployeeAddressData, {}", employeeAddressData);

		Thread.sleep(1000L);
		
		Log.info("EmployeeAddressData completed");

		return CompletableFuture.completedFuture(employeeAddressData);	
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {
		Log.info("getEmployeePhone starts");
		
		EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8080/phone", EmployeePhone.class);
		
		Log.info("EmployeePhoneData, {}", employeePhoneData);

		Thread.sleep(1000L);
		
		Log.info("EmployeePhoneData completed");

		return CompletableFuture.completedFuture(employeePhoneData);	
	}
	
	
}
