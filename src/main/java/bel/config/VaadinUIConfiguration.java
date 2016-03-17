package bel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
@Configuration
@ComponentScan("bel.ui.component")
public class VaadinUIConfiguration {


	@Profile(UIProfile.USER)
	@Configuration
	@ComponentScan("bel.core.ui.user")
	public static class UIUser {

	}

	@Profile(UIProfile.SCHEDULER)
	@Configuration
	@ComponentScan("bel.core.ui.scheduler")
	public static class UIScheduller {
	}

	@Profile(UIProfile.UI_SECURITY)
	@Configuration
	@ComponentScan("bel.core.ui.login")
	public static class UISecurity {
	}


	class UIProfile {
		public static final String SCHEDULER = "SCHEDULER";
		public static final String USER = "USER";
		public static final String UI_SECURITY = "UI_SECURITY";
	}

}
