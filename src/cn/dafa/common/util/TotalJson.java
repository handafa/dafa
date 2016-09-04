/**
 * 
 */
package cn.dafa.common.util;

import java.util.List;

/**
 * @ClassName: TotalJson
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-3 下午3:33:21
 * @version 【V1.0】 
 * @Description: TODO
 */
@SuppressWarnings("rawtypes")
public class TotalJson {
	private long results;
	private List items;

	public long getResults() {
		return results;
	}

	public void setResults(long results) {
		this.results = results;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

}
