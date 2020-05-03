package com.cognizant.hi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.hi.dao.UserRepository;
import com.cognizant.hi.entity.UserEntity;
import com.cognizant.hi.model.User;
import com.cognizant.hi.model.UserLogin;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override

	public String validateUser(UserLogin user) {

		UserEntity u = userDao.validateUser(user.getUserid(), user.getPassword());
		if (u != null) {
			return u.getUserCategory();
		} else {
			return null;
		}
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		boolean result = false;
		// converting model object to entity object
		// UserEntity ue=new UserEntity();
		// ue.setFirstName(user.getFirstName());
		UserEntity u = modelMapper.map(user, UserEntity.class);
		// boolean found=userDao.existsById(user.getUserid());
		UserEntity res = userDao.save(u);
		if (res != null)
			result = true;
		return result;
	}

}
