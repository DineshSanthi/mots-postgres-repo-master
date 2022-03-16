package solutions.mots.repo.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MotsCrudRepository<T,ID> extends CrudRepository<T, ID>{

}
