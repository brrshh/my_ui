package bel.ui.component;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * Created by borino on 30.01.2016.
 */

/**
 * Each message has four properties: a short caption, the actual message, a URL to which to redirect after displaying the message, and property indicating whether the notification is enabled.
 */
@SpringComponent
public class SystemMessagesLocalaizable implements SystemMessagesProvider {

	private static final String MESSAGES_SET_COMMUNICATION_ERROR_MESSAGE = "messages.setCommunicationErrorMessage";
	public static final String MESSAGES_SET_COMMUNICATION_ERROR_CAPTION = "messages.setCommunicationErrorCaption";


	@Autowired
	private MessageSource messageSource;


	@Override
	public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {

		CustomizedSystemMessages messages = new CustomizedSystemMessages();

		messages.setCommunicationErrorCaption(messageSource.getMessage(MESSAGES_SET_COMMUNICATION_ERROR_CAPTION, null, systemMessagesInfo.getLocale()));
		messages.setCommunicationErrorMessage(messageSource.getMessage(MESSAGES_SET_COMMUNICATION_ERROR_MESSAGE, null, systemMessagesInfo.getLocale()));
		messages.setCommunicationErrorNotificationEnabled(true);

		return messages;
	}
}
