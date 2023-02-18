package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConsumerDTO;
import com.example.demo.entity.ConsumerEntity;
import com.example.demo.repository.ConsumerRepo;

@RestController
public class ConsumerController {
	
	@Autowired
	public ConsumerRepo consumerRepo;
	
	@RequestMapping(value = "/consumer/save",method = RequestMethod.POST)
	public ResponseEntity insertRecord(@RequestBody ConsumerDTO consumer){
		ConsumerEntity result=consumerRepo.save(new ConsumerEntity(consumer));
		return new ResponseEntity(result,HttpStatus.OK);
	}
	@RequestMapping(value = "/consumer/put",method = RequestMethod.PUT)
	public ResponseEntity updateRecord(@RequestBody ConsumerDTO consumer){
		Optional<ConsumerEntity> consumerToUpdate=consumerRepo.findById(consumer.getId());
		if(consumerToUpdate.isPresent()) {
			ConsumerEntity updateRecord=consumerToUpdate.get();
			updateRecord.updateExistingIfPresent(consumer);
			updateRecord=consumerRepo.save(updateRecord);
			return new ResponseEntity(updateRecord,HttpStatus.OK);
		}
		
		return new ResponseEntity("Not Present",HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/consumer/get/{id}",method = RequestMethod.GET)
	public ResponseEntity findRecord(@PathVariable int id){
		Optional<ConsumerEntity> result=consumerRepo.findById(id);
		if(result.isPresent())
			return new ResponseEntity(result.get(),HttpStatus.OK);
		else
			return new ResponseEntity("Nothing There",HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value = "/consumer/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity deleteRecord(@PathVariable int id){
		consumerRepo.deleteById(id);
		return new ResponseEntity("Deleted data if present",HttpStatus.OK);
	}
	
}
