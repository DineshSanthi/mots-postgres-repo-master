package solutions.mots.repo.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import solutions.mots.repo.i18n.Messages;

public abstract class AbstractController <S extends AbstractService, E> {

	protected Logger logger = LoggerFactory.getLogger(AbstractController.class);
	
	protected S service;
	
	protected String controllerName;
	
	@Autowired
	public AbstractController(S service) {
		this.service = service;
		this.controllerName = this.getClass().getSimpleName();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		logger.info(Messages.getMessage("1112", "Read", controllerName));
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody E entity) {
		logger.info(Messages.getMessage("1112", "Save", controllerName));
		return new ResponseEntity<>(service.save(entity), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody E entity) {
		logger.info(Messages.getMessage("1112", "Update", controllerName));
		return new ResponseEntity<>(service.saveorUpdate(entity), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		logger.info(Messages.getMessage("1112", "Delete", controllerName));
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	

	
}
