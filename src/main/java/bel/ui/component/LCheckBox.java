package bel.ui.component;

import com.vaadin.data.Property;
import com.vaadin.ui.CheckBox;

/**
 * Created by borino on 31.01.2016.
 */
public class LCheckBox extends CheckBox implements LocalizableComponent {

	public LCheckBox(String captionMessageCode) {
		this.captionMessageCode = captionMessageCode;
	}

	public LCheckBox(String caption, String captionMessageCode) {
		super(caption);
		this.captionMessageCode = captionMessageCode;
	}

	public LCheckBox(String caption, boolean initialState, String captionMessageCode) {
		super(caption, initialState);
		this.captionMessageCode = captionMessageCode;
	}

	public LCheckBox(String caption, Property<?> dataSource, String captionMessageCode) {
		super(caption, dataSource);
		this.captionMessageCode = captionMessageCode;
	}

	private String captionMessageCode;

	@Override
	public String getCaptionMessageCode() {
		return null;
	}

	@Override
	public void setCaptionMessageCode(String captionMessageCode) {
		this.captionMessageCode = captionMessageCode;
	}

}
