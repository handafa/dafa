/**  
 * @Title: MVCDateFormat.java
 * @Package cn.dafa.common.util
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-1-10 下午10:30:23
 * @version V1.0  
 */
package cn.dafa.common.util;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;

/**
 * @ClassName: MVCDateFormat
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-10 下午10:30:23
 * @version 【V1.0】
 * @Description: TODO
 */
public class MVCDateFormat extends CustomDateEditor {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param dateFormat
	 * @param allowEmpty
	 */
	public MVCDateFormat(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		super.setAsText(text);
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(new Date(text));
		}
	}

}
