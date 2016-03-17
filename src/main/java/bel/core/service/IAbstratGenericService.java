package bel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Shlyaga_BA on 29.01.2016.
 */
@NoRepositoryBean
public interface IAbstratGenericService<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {


}
