package solutions.mots.repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import solutions.mots.repo.service.MetaService;

@RestController
@RequestMapping(value = "/meta")
public class MetaController{

	@Autowired
	MetaService metaService;
		
	@RequestMapping(value = { "/data" }, method = RequestMethod.GET)
	public ResponseEntity<?> getDatabaseTables() throws Exception {
		return new ResponseEntity<>(metaService.getData(), HttpStatus.OK);
	}
	
	
}
