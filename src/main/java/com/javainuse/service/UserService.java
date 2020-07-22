package com.javainuse.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;

@Service
public class UserService {
	@Autowired
	UserDao userdao;
	
	public void addNewEmployee(DAOUser emp) {
        userdao.addNewEmployee(emp);
    }
	public DAOUser getUser(String username) throws SQLException {
		return userdao.getUser(username);
		
	}
}
