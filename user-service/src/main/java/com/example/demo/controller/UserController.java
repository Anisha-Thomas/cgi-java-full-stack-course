package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.MyCustomException;
import com.example.demo.service.UserService;
import com.example.demo.ui.ErrorModel;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	private final ModelMapper modelMapper;
	private final UserService userService;

	public UserController(ModelMapper modelMapper, UserService userService) {
		super();
		this.modelMapper = modelMapper;
		this.userService = userService;
	}

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}

	@ExceptionHandler(value = MyCustomException.class)
	public ResponseEntity<ErrorModel> handleIdNotFoundException(MyCustomException e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);

	}

	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel requestModel) {
		// log.info("within createUser endpoint of User Controller...");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(requestModel, UserDto.class);

		StringBuffer sb = new StringBuffer();
		sb.append(requestModel.getPassword());

		userDto.setEncrytedPassword(sb.reverse().toString());

		UserResponseModel responseModel = userService.createUser(userDto);

		// log.debug("called service layer..");
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);

	}

	@GetMapping

	public ResponseEntity<List<UserResponseModel>> getusers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> models = new ArrayList<UserResponseModel>();

		List<UserEntity> list = userService.getAllUsers();

		for (UserEntity entity : list) {
			models.add(modelMapper.map(entity, UserResponseModel.class));
		}

		return ResponseEntity.ok(models);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") int id) throws NumberFormatException, MyCustomException {

		UserResponseModel model = userService.getuserById(id);
		System.out.println(model);
		if (model == null) {
			throw new MyCustomException("Id "+id+" Not Found");
		} else {
			return ResponseEntity.ok(model);
		}
	}

	@GetMapping("/findByUserId/{userId}")
	public ResponseEntity<?> getUserByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userService.findByUserId(userId));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id)
			throws NumberFormatException, MyCustomException {

		UserResponseModel model = userService.getuserById(id);
		System.out.println(model);
		if (model == null) {
			throw new MyCustomException("User Id"+id +"Not Found");
		} else {
			userService.deleteUserById(id);
			return ResponseEntity.ok().body("Deleted Sucessfully");
		}
	}

	@DeleteMapping("/")
	public ResponseEntity<?> deleteAllUser() {
		userService.deleteAllUsers();
		return ResponseEntity.ok().body("Deleted Sucessfully");
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseModel> updateUserById(@PathVariable("id") int id,
			@RequestBody UserRequestModel userRequestModel) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUserById(id, userRequestModel));
	}

}
