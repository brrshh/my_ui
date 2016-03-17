package bel.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
@SpringBootApplication
@PropertySource("classpath:main/application.properties")
public class BootConfig extends SpringBootServletInitializer {


    // needs for creating WAR
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootConfig.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootConfig.class, args);
    }


}
