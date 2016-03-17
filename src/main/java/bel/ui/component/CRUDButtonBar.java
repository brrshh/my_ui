package bel.ui.component;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shlyaga_BA on 29.01.2016.
 */

@SpringComponent
@UIScope
public class CRUDButtonBar extends CustomComponent implements LocalizableComponent {

	@Autowired
	private MessageSource messageSource;

	private Button save = new LButton("save", this::save, "button.crud.save");
	private Button delete = new LButton("delete", this::delete, "button.crud.delete");
	private Button add = new LButton("add", this::add, "button.crud.add");
	private Button copy = new LButton("copy", this::copy, "button.crud.copy");
	private Button cancel = new LButton("cancel", this::cancel, "button.crud.cancel");

	private final List<LocalizableComponent> localizableComponents = Arrays.asList((LocalizableComponent) save, (LocalizableComponent) delete, (LocalizableComponent) add, (LocalizableComponent) copy, (LocalizableComponent) cancel);

	public CRUDButtonBar() {
		setCompositionRoot(new HorizontalLayout(
				save, add, copy, delete, cancel
		));
		initialState();
	}

	private void initialState() {
//
	}

	public void save(Button.ClickEvent event) {
		event.getButton().setCaption("SAVE!");
	}

	public void delete(Button.ClickEvent event) {
		event.getButton().setCaption("DELETE!");
	}

	public void add(Button.ClickEvent event) {
		event.getButton().setCaption("ADD!");
	}

	public void copy(Button.ClickEvent event) {
		event.getButton().setCaption("COPY!");
	}

	public void cancel(Button.ClickEvent event) {
		event.getButton().setCaption("CANCEL!");
	}


	@PostConstruct
	public void post() {
		System.out.println("CRUDButtonBar construct  hash=" + this.hashCode());
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("CRUDButtonBar destroy  hash=" + this.hashCode());
	}

	public com.vaadin.ui.Component initComponent(Locale locale) {
		changeLocale(messageSource, locale);
		return this;
	}


	@Override
	public String getCaptionMessageCode() {
		return null;
	}

	@Override
	public void setCaptionMessageCode(String captionMessageCode) {

	}

	@Override
	public void changeLocale(MessageSource messageSource, Locale locale) {
		localizableComponents.forEach(localizableComponent -> localizableComponent.changeLocale(messageSource, locale));
	}
}
