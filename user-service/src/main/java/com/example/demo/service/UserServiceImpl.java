package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
		super();
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		// log.info("within create user method of service layer");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		userEntity.setUserId(UUID.randomUUID().toString());
		System.out.println("Service Layer " + userEntity);
		userRepository.save(userEntity);
		// log.debug("done updating data");
		UserResponseModel responseModel = modelMapper.map(userEntity, UserResponseModel.class);
		return responseModel;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserResponseModel getuserById(int id) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<UserEntity> e = userRepository.findById(id);

		if (!e.isPresent()) {
			return null;
		} else {
			return modelMapper.map(e, UserResponseModel.class);
		}

	}

	@Override
	public void deleteUserById(int id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		userRepository.delete(userRepository.getById(id));
	}

	@Override
	public void deleteAllUsers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		userRepository.deleteAll();

	}

	@Override
	public UserResponseModel findByUserId(String userId) {
		UserEntity entity = userRepository.findByUserId(userId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(entity, UserResponseModel.class);
	}

	@Override
	public UserResponseModel updateUserById(int id, UserRequestModel userRequestModel) {
		UserResponseModel userResponseModel = null;
		Optional<UserEntity> userEntityFromDb = userRepository.findById(id);
		if (userEntityFromDb.isPresent()) {
			UserEntity entity = userEntityFromDb.get();
			System.out.println("Entity "+entity);
			entity.setFirstName(userResponseModel.getFirstName());
			entity.setLastName(userResponseModel.getLastName());
			entity.setEmail(userResponseModel.getEmail());
			UserEntity user = userRepository.save(entity);
			System.out.println("User " +user);
			userResponseModel = modelMapper.map(user, UserResponseModel.class);
		}
		return userResponseModel;
	}

}
