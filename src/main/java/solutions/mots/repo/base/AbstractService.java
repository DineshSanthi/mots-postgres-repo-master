package solutions.mots.repo.base;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import solutions.mots.repo.i18n.Messages;

public abstract class AbstractService <R extends MotsCrudRepository<E, I>, E, I> implements GenericService<E, I> {

	protected Logger logger = LoggerFactory.getLogger(AbstractService.class);
	
	protected R repository;
	
	protected E entity;	
	
	protected String serviceName;
	
	@Autowired
	public AbstractService(R repository) {
		this.repository = repository;
		this.serviceName = this.getClass().getSimpleName();
	}

	@Override
	public E get(I id) {
		Optional<E> entity = repository.findById(id);
		if(entity.isPresent()) {
			logger.info(Messages.getMessage("1112", "Read", serviceName));
			return entity.get();
		}
		return null;
	}
	
	@Override
	public List<E> getAll(Integer pageNumber, Integer size) {
		logger.info(Messages.getMessage("1112", "Read", serviceName));
		pageNumber = pageNumber != null? pageNumber : 0;
		Pageable page = PageRequest.of(pageNumber, size);
		//List<E> list = repository.findAllById(page);
		return null;
	}	
	
	@Override
	public E saveorUpdate(E entity) {
		logger.info(Messages.getMessage("1112", "Save", serviceName));
		return repository.save(entity);
	}	
	
	@Override
	public E save(E entity) {
		logger.info(Messages.getMessage("1112", "Update", serviceName));
		return repository.save(entity);
	}
	
	@Override
	public void delete(I id) {
		logger.info(Messages.getMessage("1112", "Delete", serviceName));
		repository.deleteById(id);
	}
	
	@Override
	public boolean isExist(I id) {
		logger.info(Messages.getMessage("1112", "isExists", serviceName));
		return repository.findById(id).isPresent();
	}
	
}
