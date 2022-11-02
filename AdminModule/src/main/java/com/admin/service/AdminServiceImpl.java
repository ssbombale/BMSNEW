package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.AdminDetail;
import com.admin.entity.CustomeLoanApply;
import com.admin.repository.AdminRepository;
import com.admin.repository.CustomerLoanRepo;

@Service
public class AdminServiceImpl  implements AdminService{

	@Autowired
	AdminRepository customerRepo;
	
	
	@Autowired
	CustomerLoanRepo customeRepo;
	
	@Override
	public AdminDetail saveUser(AdminDetail user) {
		AdminDetail savedUser = customerRepo.save(user);
		return  savedUser;
	}
	
//	@Override
//	public Integer saveUser(User user) {
//		User savedUser = customerRepo.save(user);
//		return  savedUser.getId();
//	}
//	

	@Override
	public AdminDetail loadUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomeLoanApply> getAllLoanDetails() {
		// TODO Auto-generated method stub
		return customeRepo.findAll();
	}

	@Override
	public CustomeLoanApply getLoanbyId(Integer loanid) {
		// TODO Auto-generated method stub
		return customeRepo.findById(loanid).orElseThrow();
	}

	@Override
	public void updateLoanDetails(CustomeLoanApply customeLoanApply) {
		// TODO Auto-generated method stub
		customeRepo.save(customeLoanApply);
	}

	@Override
	public List<Object[]> getCustById(Integer id) {
		// TODO Auto-generated method stub
		return (List<Object[]>) customeRepo.findById(id).get();
	}

}
