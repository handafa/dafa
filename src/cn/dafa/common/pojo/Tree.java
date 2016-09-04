package cn.dafa.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Tree
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-1-4 上午11:23:27
 * @version 【V1.0】
 * @Description: ext树菜单
 */
public class Tree implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String iconCls;
	private boolean expanded;
	private boolean leaf;
	private String url;
	private List<Tree> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

}
