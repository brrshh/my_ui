package bel.core.ui.login;

import bel.core.ui.UIPath;
import bel.ui.component.LCheckBox;
import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by borino on 31.01.2016.
 */
@SpringUI(path = UIPath.LOGIN)
@Theme("valo")
public class LoginView extends UI {


    public LoginView() {
        setSizeFull();

        Component loginForm = buildLoginForm();
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        content.addComponent(loginForm);
        content.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

        showHello();
    }

    private void showHello() {
        Notification notification = new Notification(
                "Welcome to Dashboard Demo");
        notification
                .setDescription("<span>This application is not real, it only demonstrates an application built with the <a href=\"https://vaadin.com\">Vaadin framework</a>.</span> <span>No username or password is required, just click the <b>Sign In</b> button to continue.</span>");
        notification.setHtmlContentAllowed(true);
        notification.setStyleName("tray dark small closable login-help");
        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDelayMsec(20000);
//		notification.show(Page.getCurrent());
        notification.show(this.getPage());
    }

    @Override
    protected void init(VaadinRequest request) {

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=   " + request);

    }

    private Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
//		Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new LCheckBox("Remember me", true, "login.view.remember_me"));
        return loginPanel;
    }

    private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        final TextField username = new TextField("Username");
        username.setIcon(FontAwesome.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final PasswordField password = new PasswordField("Password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = new Button("Sign In");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        signin.focus();

        fields.addComponents(username, password, signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

//		signin.addClickListener(new Button.ClickListener() {
//			@Override
//			public void buttonClick(final Button.ClickEvent event) {
//				DashboardEventBus.post(new UserLoginRequestedEvent(username
//						.getValue(), password.getValue()));
//			}
//		});
        return fields;
    }
    private Component buildLabels() {

        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("QuickTickets Dashboard");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }

}
