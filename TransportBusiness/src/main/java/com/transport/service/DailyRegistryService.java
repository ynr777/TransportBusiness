package com.transport.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.transport.entity.DailyRegistry;
import com.transport.entity.Employee;
import com.transport.repository.DailyRegistryRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DailyRegistryService {

	@Autowired
	DailyRegistryRepository dailyRegistryRepository;

	public List<DailyRegistry> getDailyRegistryByDate(String stringDate) {
		log.info("Getting DailyRegistry {} from the repository.", stringDate);
		String[] resultDate = stringDate.split("-");

		List<DailyRegistry> dailyRegistryList = dailyRegistryRepository
				.findByInvoiceDate(convertStringDate(stringDate));

		if (CollectionUtils.isEmpty(dailyRegistryList)) {
			log.info("No DailyRegistry found by date {}", stringDate);
			return new ArrayList<DailyRegistry>();
		}

		log.info("found {} DailyRegistry by date {}", dailyRegistryList.size(), stringDate);

		return dailyRegistryList;
	}

	public List<DailyRegistry> getDailyRegistryBetweenDates(String startDate, String endDate) {
		log.info("Getting DailyRegistry {} from the repository.", startDate);

		List<DailyRegistry> dailyRegistryList = dailyRegistryRepository
				.findDailyRegistryByInvoiceDateBetween(convertStringDate(startDate), convertStringDate(endDate));

		if (CollectionUtils.isEmpty(dailyRegistryList)) {
			log.info("No DailyRegistry found by date {}", startDate);
			return new ArrayList<DailyRegistry>();
		}

		log.info("found {} DailyRegistry by date {}", dailyRegistryList.size(), startDate);

		return dailyRegistryList;
	}

	public DailyRegistry addDailyRegistry(DailyRegistry dailyRegistry) {
		// log.info("Adding DailyRegistry {} to database", DailyRegistry.getName());

		DailyRegistry dailyRegistryOld = dailyRegistryRepository.findTopByOrderByRegistryIdDesc().get(0);
		Long registryId = 0L;
		if (dailyRegistryOld != null) {
			registryId = dailyRegistryOld.getRegistryId();
		}
		dailyRegistry.setRegistryId(registryId + 1);

		dailyRegistry.setInvoiceDate(convertStringDate(dailyRegistry.getIsoDate()));
		DailyRegistry dailyRegistry2 = dailyRegistryRepository.insert(dailyRegistry);
		// log.info("Added DailyRegistry {} successfully", customer2.getName());
		return dailyRegistry2;
	}

	public DailyRegistry editDailyRegistry(String id, DailyRegistry dailyRegistry) {
		Optional<DailyRegistry> employeeData = dailyRegistryRepository.findById(id);
		DailyRegistry editDailyRegistry = employeeData.get();
		editDailyRegistry.setActiveFlag(false);
		dailyRegistryRepository.save(editDailyRegistry);
		return dailyRegistryRepository.insert(dailyRegistry);

	}

	private LocalDateTime convertStringDate(String stringDate) {

		String[] resultDate = stringDate.split("-");

		int year = Integer.valueOf(resultDate[0]);
		int month = Integer.valueOf(resultDate[1]);
		int day = Integer.valueOf(resultDate[2]);

		LocalDateTime datetime = LocalDateTime.of(year, month, day, 0, 0);
		return datetime;

	}
}
