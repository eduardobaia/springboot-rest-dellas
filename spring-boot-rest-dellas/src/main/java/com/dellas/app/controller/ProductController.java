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

import com.dellas.app.dto.ProductDTO;
import com.dellas.app.service.ProductService;
import com.dellas.app.util.Error;
import com.dellas.app.util.TaskExceptionHandler;

@RequestMapping("/product")
@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// TODO implementar handle de excessões

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(@RequestParam final Map<String, String> params){
		try {
			if(params.isEmpty()) {
				return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
			}else {
				return null;
				//return new ResponseEntity<>(productService.findByFilter(UserConverter.toDTO(params)), HttpStatus.OK);
			}
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable final Long id){
		try {
			final ProductDTO dto = productService.findById(id);
			return new ResponseEntity<ProductDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> persist(@RequestBody final ProductDTO dto){
		try {
			final ProductDTO inserted= productService.persist(dto);
			return new ResponseEntity<ProductDTO>(inserted, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final ProductDTO dto){
		try {
			final ProductDTO updated= productService.update(dto);
			return new ResponseEntity<ProductDTO>(updated, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, TaskExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		productService.delete(id);
	}
}
