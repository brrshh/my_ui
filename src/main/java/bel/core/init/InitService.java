package bel.core.init;

import bel.core.domain.Scheduler;
import bel.core.domain.User;
import bel.core.repositories.IUserRepository;
import bel.core.service.ISchedulerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
@Service
public class InitService {

	@Autowired
	private IUserRepository userServ;

	@Autowired
	private ISchedulerService schedulerServ;

	@Transactional
	@PostConstruct
	public void init() {
		userServ.save(Stream.of("Devid", "Piter", "Cotin", "Jen", "Volga", "Sin", "Son", "Tag")
				.map(name -> new User(name, RandomStringUtils.random(5), new Date(RandomUtils.nextLong(0, 123456789))))
				.collect(Collectors.toList()));

		schedulerServ.save(Stream.of("status", "wether", "currency")
				.map(name -> new Scheduler(name, name + " _" + RandomStringUtils.random(5), " * * * * *"))
				.collect(Collectors.toList()));
	}
}
