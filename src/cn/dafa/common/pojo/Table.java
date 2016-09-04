package cn.dafa.common.pojo;

/**
 * @ClassName: Table
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-4 上午11:23:17
 * @version 【V1.0】 
 * @Description: TODO
 */
public class Table {

	/**
	 * @Title: toClumn
	 * @Description: 把pojo字段转为数据库字段
	 * @datetime 2013-1-4 下午12:54:24  
	 * @param
	 * @return
	 * @throws
	 */
	public static String toClumn(String field) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (Character.isUpperCase(c) && i > 0) {
				sb.append("_").append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		return sb.toString();
	}
}
