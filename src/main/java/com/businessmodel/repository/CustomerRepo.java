package com.businessmodel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.businessmodel.entity.Customer;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	Page<Customer> findByCountry(String country, Pageable pageable);
	public List<Customer> findTop10ByOrderByCreditLimitDesc();
}