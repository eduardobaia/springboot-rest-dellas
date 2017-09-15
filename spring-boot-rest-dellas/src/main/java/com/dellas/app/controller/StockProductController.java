package com.dellas.app.controller;

import java.text.ParseException;
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

import com.dellas.app.converter.StockProductConverter;
import com.dellas.app.dto.StockProductDTO;
import com.dellas.app.exception.Error;
import com.dellas.app.exception.StockProductExceptionHandler;
import com.dellas.app.service.StockProductService;

@RequestMapping("/stockProduct")
@CrossOrigin
@RestController
public class StockProductController {

	@Autowired
	private StockProductService stockProductService;

	@RequestMapping(method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(@RequestParam final Map<String, String> params) throws ParseException{
		try {
			if(params.isEmpty()) {
				return new ResponseEntity<>(stockProductService.findAll(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(stockProductService.findByFilter(StockProductConverter.toDTO(params)), HttpStatus.OK);
			}
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, StockProductExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable final Long id){
		try {
			final StockProductDTO dto = stockProductService.findById(id);
			return new ResponseEntity<StockProductDTO>(dto, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, StockProductExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> persist(@RequestBody final StockProductDTO dto){
		try {
			final StockProductDTO inserted= stockProductService.persistStockAndProduct(dto);
			return new ResponseEntity<StockProductDTO>(inserted, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, StockProductExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody final StockProductDTO dto){
		try {
			final StockProductDTO updated= stockProductService.updateStockAndProduct(dto);
			return new ResponseEntity<StockProductDTO>(updated, HttpStatus.OK);
		} catch (final RuntimeException e) {
			return new ResponseEntity<Error>(new Error(1, StockProductExceptionHandler.getExcetionError(e)), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE , produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable final Long id){
		stockProductService.deleteStockAndProduct(id);
	}
}
