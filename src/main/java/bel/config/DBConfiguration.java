package bel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */

@Configuration
@EntityScan("bel.core.domain")
//@ComponentScan("bel.domain")
@EnableJpaRepositories("bel.core.repositories")
@EnableTransactionManagement
public class DBConfiguration {

//    @Autowired
//    private DataSource dataSource;
}
