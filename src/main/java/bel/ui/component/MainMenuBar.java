package bel.ui.component;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Locale;

/**
 * Created by Shlyaga_BA on 29.01.2016.
 */
@SpringComponent
@VaadinSessionScope
public class MainMenuBar extends CustomComponent {

    private Button eng = new Button("eng", this::eng);
    private Button rus = new Button("rus", this::rus);

    MainMenuBar() {
        setCompositionRoot(new HorizontalLayout(eng, rus));
    }


    private void eng(Button.ClickEvent event) {
        Notification.show("eng", Notification.Type.TRAY_NOTIFICATION);
        VaadinSession.getCurrent().setLocale(Locale.ENGLISH);
    }

    private void rus(Button.ClickEvent event) {
        Notification.show("rus", Notification.Type.TRAY_NOTIFICATION);
        VaadinSession.getCurrent().setLocale(new Locale("ru"));
    }

    @PostConstruct
    public void post() {
        System.out.println("MainMenuBar construct  hash=" + this.hashCode());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MainMenuBar destroy  hash=" + this.hashCode());
    }


}
