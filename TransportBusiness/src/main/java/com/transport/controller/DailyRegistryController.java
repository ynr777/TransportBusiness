package com.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transport.entity.DailyRegistry;
import com.transport.service.DailyRegistryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DailyRegistryController {

	@Autowired
	DailyRegistryService dailyRegistryService;

	@GetMapping("/dailyRegistry/{date}")
	public List<DailyRegistry> getdailyRegistryByDate(@PathVariable String date) {

		log.info("Getting dailyRegistry by date {} ", date);
		List dailyRegistryList = dailyRegistryService.getDailyRegistryByDate(date);
		log.info("Received {} dailyRegistry by date {}", dailyRegistryList.size(), date);
		return dailyRegistryList;
	}

	@GetMapping("/dailyRegistry/{startDate}/{endDate}")
	public List<DailyRegistry> getdailyRegistryBetweenDates(@PathVariable String startDate,
			@PathVariable String endDate) {

		log.info("Getting dailyRegistry by start date {} and end date {}", startDate, endDate);
		List dailyRegistryList = dailyRegistryService.getDailyRegistryBetweenDates(startDate, endDate);
		log.info("Received {} dailyRegistry by start date {} and end date {}", dailyRegistryList.size(), startDate,
				endDate);
		return dailyRegistryList;
	}
	
	@GetMapping("/activeDailyRegistry/{date}")
	public List<DailyRegistry> getActiveDailyRegistryByDate(@PathVariable String date) {

		log.info("Getting Active dailyRegistry by date {} ", date);
		List dailyRegistryList = dailyRegistryService.getActiveDailyRegistryByDate(date);
		log.info("Received Active {} dailyRegistry by date {}", dailyRegistryList.size(), date);
		return dailyRegistryList;
	}

	@GetMapping("/activeDailyRegistry/{startDate}/{endDate}")
	public List<DailyRegistry> getActiveDailyRegistryBetweenDates(@PathVariable String startDate,
			@PathVariable String endDate) {

		log.info("Getting Active dailyRegistry by start date {} and end date {}", startDate, endDate);
		List dailyRegistryList = dailyRegistryService.getActiveDailyRegistryBetweenDates(startDate, endDate);
		log.info("Received Active {} dailyRegistry by start date {} and end date {}", dailyRegistryList.size(), startDate,
				endDate);
		return dailyRegistryList;
	}

	@PostMapping("/dailyRegistry")
	public DailyRegistry addDailyRegistry(@RequestBody DailyRegistry dailyRegistry) {
		log.info("Adding dailyRegistry date {}, Company {}, employee to the Database", dailyRegistry.getIsoDate(),
				dailyRegistry.getCompanyName(), dailyRegistry.getEmployee());
		return dailyRegistryService.addDailyRegistry(dailyRegistry);
	}

	@PutMapping("/dailyRegistry/{id}")
	public DailyRegistry editDailyRegistry(@PathVariable String id, @RequestBody DailyRegistry dailyRegistry) {
		log.info("Editing  dailyRegistry with registry id {} by user {} to the Database", dailyRegistry.getRegistryId(),
				dailyRegistry.getUpdatedUser());
		return dailyRegistryService.editDailyRegistry(id, dailyRegistry);
	}
}
