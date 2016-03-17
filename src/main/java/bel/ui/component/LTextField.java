package bel.ui.component;


import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

/**
 * Created by borino on 31.01.2016.
 */
public class LTextField extends TextField implements LocalizableComponent {
	public LTextField(String captionMessageCode) {
		this.captionMessageCode = captionMessageCode;
	}

	public LTextField(String caption, String captionMessageCode) {
		super(caption);
		this.captionMessageCode = captionMessageCode;
	}

	public LTextField(Property dataSource, String captionMessageCode) {
		super(dataSource);
		this.captionMessageCode = captionMessageCode;
	}

	public LTextField(String caption, Property dataSource, String captionMessageCode) {
		super(caption, dataSource);
		this.captionMessageCode = captionMessageCode;
	}

	public LTextField(String caption, String value, String captionMessageCode) {
		super(caption, value);
		this.captionMessageCode = captionMessageCode;
	}

	private String captionMessageCode;

	@Override
	public String getCaptionMessageCode() {
		return captionMessageCode;
	}

	@Override
	public void setCaptionMessageCode(String captionMessageCode) {
		this.captionMessageCode = captionMessageCode;
	}
}
