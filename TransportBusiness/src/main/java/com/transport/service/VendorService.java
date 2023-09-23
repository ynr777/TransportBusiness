package com.transport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.transport.entity.Vendor;
import com.transport.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {

	@Autowired
	VendorRepository vendorRepository;

	public List<Vendor> getvendorByName() {
		log.info("Getting vendors from the repository.");

		List<Vendor> vendorList = vendorRepository.findAll();

		if (CollectionUtils.isEmpty(vendorList)) {
			log.info("No vendor found ");
			return new ArrayList<Vendor>();
		}
		log.info("found {} vendor", vendorList.size());
		return vendorList;
	}

	public Vendor editvendor(String id, Vendor vendor) {
		Optional<Vendor> vendorData = vendorRepository.findById(id);
		Vendor editvendor = vendorData.get();
		editvendor.setActiveFlag(false);
		vendorRepository.save(editvendor);

		return vendorRepository.insert(vendor);

	}

	public Vendor addvendor(Vendor vendor) {
		log.info("Adding vendor {} to database", vendor.getCompanyName());
		Vendor vendor2 = vendorRepository.insert(vendor);
		log.info("Added vendor {} successfully", vendor2.getCompanyName());
		return vendor2;
	}
}
