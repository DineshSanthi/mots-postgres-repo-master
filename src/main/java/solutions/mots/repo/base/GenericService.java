package solutions.mots.repo.base;

import java.util.List;

public interface GenericService <E, I>{

	public E get(I id);
	public List<E> getAll(Integer pageNumber, Integer size);
	public E saveorUpdate(E entiry);
	public void delete(I id);
	public boolean isExist(I id);
	public E save(E entity);
	
}
