package com.dellas.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dellas.app.converter.UserConverter;
import com.dellas.app.dto.UserDTO;
import com.dellas.app.exception.Error;
import com.dellas.app.exception.UserExceptionHandler;
import com.dellas.app.service.UserService;

@RequestMapping("/user")
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(@RequestParam final Map<String, String> params){
		try {
			if(params.isEmpty()) {
				return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(userService.findByFilter(UserConverter.toDTO(params)), HttpStatus.OK);
			}
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UserExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable final Long id){
		try {
			final UserDTO dto = userService.findById(id);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UserExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> persist(@RequestBody final UserDTO dto){
		try {
			final UserDTO inserted= userService.persist(dto);
			return new ResponseEntity<UserDTO>(inserted, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UserExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final UserDTO dto){
		try {
			final UserDTO updated= userService.update(dto);
			return new ResponseEntity<UserDTO>(updated, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, UserExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		userService.delete(id);
	}
}
