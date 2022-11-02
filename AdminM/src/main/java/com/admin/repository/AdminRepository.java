package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.AdminDetail;

public interface AdminRepository extends JpaRepository <AdminDetail, Integer>{
	AdminDetail findByUserName(String username);

	AdminDetail findByemail(String username);

}
