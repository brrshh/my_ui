package bel.core.repositories;

import bel.core.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
