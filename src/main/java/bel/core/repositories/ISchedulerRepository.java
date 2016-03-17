package bel.core.repositories;

import bel.core.domain.Scheduler;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
public interface ISchedulerRepository extends PagingAndSortingRepository<Scheduler, Long> {
}
