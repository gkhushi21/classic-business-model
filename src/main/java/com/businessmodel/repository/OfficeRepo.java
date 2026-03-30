package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Office;

public interface OfficeRepo extends JpaRepository<Office, String> {

}
