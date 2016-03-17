package bel.ui.component;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by Shlyaga_BA on 29.01.2016.
 */
public interface LocalizableComponent {

	String getCaptionMessageCode();

	void setCaptionMessageCode(String captionMessageCode);

	public void setCaption(String caption);

	default void changeLocale(MessageSource messageSource, Locale locale) {
		setCaption(messageSource.getMessage(getCaptionMessageCode(), null, locale));
	}

}
