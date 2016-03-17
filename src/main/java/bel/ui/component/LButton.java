package bel.ui.component;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by borino on 30.01.2016.
 */
public class LButton extends Button implements LocalizableComponent {

	public LButton(String caption, String captionMessageCode) {
		super(caption);
		this.captionMessageCode = captionMessageCode;
	}

	public LButton(Resource icon, String captionMessageCode) {
		super(icon);
		this.captionMessageCode = captionMessageCode;
	}

	public LButton(String caption, Resource icon, String captionMessageCode) {
		super(caption, icon);
		this.captionMessageCode = captionMessageCode;
	}

	public LButton(String caption, ClickListener listener, String captionMessageCode) {
		super(caption, listener);
		this.captionMessageCode = captionMessageCode;
	}
	@Override
	public String getCaptionMessageCode() {
		return captionMessageCode;
	}

	private String captionMessageCode;

	@Override
	public void setCaptionMessageCode(String captionMessageCode) {
		this.captionMessageCode = captionMessageCode;
	}

	@Override
	public void changeLocale(MessageSource messageSource, Locale locale) {
		this.setCaption(messageSource.getMessage(captionMessageCode, null, locale));
	}
}
