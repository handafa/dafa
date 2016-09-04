/**  
 * @Title: DateConvertEditor.java
 * @Package cn.dafa.common.springmvc
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-14 上午10:28:00
 * @version V1.0  
 */
package cn.dafa.common.springmvc;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: DateConvertEditor
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-14 上午10:28:00
 * @version 【V1.0】
 * @Description: spring中日期转换
 */
public class DateConvertEditor extends PropertyEditorSupport {
	private DateFormat format;

	public DateConvertEditor() {
		this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public DateConvertEditor(String format) {
		this.format = new SimpleDateFormat(format);
	}

	/** Date -> String */
	@Override
	public String getAsText() {
		if (getValue() == null)
			return "";
		return this.format.format(getValue());
	}

	/** String -> Date */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.isNotBlank(text)) {
			setValue(null);
		} else {
			try {
				setValue(this.format.parse(text));
			} catch (ParseException e) {
				throw new IllegalArgumentException("不能被转换的日期字符串，请检查!", e);
			}
		}
	}
}
