package bel.core.ui.user;

import bel.core.domain.User;
import bel.core.service.IUserService;
import bel.core.ui.UIPath;
import bel.ui.component.CRUDButtonBar;
import bel.ui.component.MainMenuBar;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Shlyaga_BA on 28.01.2016.
 */
@SpringUI(path = UIPath.USER_PAGE)
@Theme("valo")
public class UserUI extends UI {

	private IUserService userService;

	private Grid grid;

	@Autowired
	private CRUDButtonBar crudButtonBar;

	@Autowired
	private MainMenuBar menuBar;


	@Autowired
	UserUI(IUserService userService) {
		this.userService = userService;
		this.grid = new Grid();

	}

	@Override
	protected void init(VaadinRequest request) {
		configureComponents(request);
		buildLayout(request);
//        setContent(new Button("Click me", event -> Notification.show("Hi Niga")));
	}

	private void buildLayout(VaadinRequest request) {
		Layout content = new VerticalLayout();
		content.addComponent(menuBar);
		content.addComponent(crudButtonBar.initComponent(request.getLocale()));
		content.addComponent(grid);

		setContent(content);


	}

	private void configureComponents(VaadinRequest request) {
		grid.setSelectionMode(Grid.SelectionMode.SINGLE);
		listData();

	}


	private void listData() {
		grid.setContainerDataSource(new BeanItemContainer<User>(User.class, StreamSupport.stream(userService.findAll().spliterator(), true).collect(Collectors.toList())));
	}
}
