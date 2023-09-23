package com.transport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.transport.entity.DailyRegistry;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface DailyRegistryRepository extends MongoRepository<DailyRegistry, String> {

	List<DailyRegistry> findByInvoiceDate(LocalDateTime date);

	List<DailyRegistry> findByEmployee(String Employee);

	List<DailyRegistry> findDailyRegistryByInvoiceDateBetween(LocalDateTime from, LocalDateTime to);

	List<DailyRegistry> findTopByOrderByRegistryIdDesc();

	List<DailyRegistry> findByInvoiceDateAndActiveFlag(LocalDateTime date, Boolean activefalg);

	List<DailyRegistry> findDailyRegistryByActiveFlagAndInvoiceDateBetween(Boolean activefalg, LocalDateTime from,
			LocalDateTime to);

	// @Query("{'invoiceDate':{$gte:'?0', $lte:'?1'}}")

}
