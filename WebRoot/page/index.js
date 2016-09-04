// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【参数区】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
var node = '';
var nodeName = '';
var url = '';
Ext.Loader.setConfig({
			enabled : true
		});

Ext.Loader.setPath('Ext.ux', '../ux/');
// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【参数区】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【树形菜单】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
// 定义树形菜单
var treeStore = Ext.create('Ext.data.TreeStore', {
			autoLoad : true,
			proxy : {
				type : 'ajax',
				url : 'menu/treeMenus'
			},
			root : {
				text : '系统菜单',
				expanded : true,
				id : '-1'
			}
		});

// 创建树形菜单
var treePanel = new Ext.tree.Panel({
			store : treeStore,
			height : '99%',
			lines : true,
			useArrows : true
		});

// 获取单击事件
treePanel.on("itemclick", function(view, record, item, index, e) {
			node = record.raw.id;
			nodeName = record.raw.text;
			url = record.raw.url;
			if (record.raw.leaf) {
				addTabPage('tab-' + node, url);
			}
		});
// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【树形菜单】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【tab页】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
var tabPanel = new Ext.tab.Panel({
	activeTab : 0,// 默认激活第一个页面
	region : 'center',
	layout : 'fit',
	height : '100%',
	margins : '0 0 0 0',
	minTabWidth : 115,
	maxTabWidth : 135,
	enableTabScroll : true,
	deferredRender : false,
	items : [{
		id : 'main',
		title : '<b>首 页</b>',
		html : '<iframe id="main" src="page/main.jsp" style="border:0px;margin-left:0px" width="100%" height="100%"></iframe>',
		closable : false
	}],
	plugins : Ext.create('Ext.ux.TabCloseMenu', {
				closeTabText : '关闭当前',
				closeOthersTabsText : '关闭其他',
				closeAllTabsText : '关闭所有'
			})
});

// 增加一个tab页面
function addTabPage(node, url) {
	var num = tabPanel.items.length + 1;
	if (num > 10) {
		Ext.Msg.alert('提示', '最多只能打开9个页面');
		return;
	}
	// 判断该菜单是否已经打开
	var flag = Ext.getCmp(node);
	if (flag) {
		// 如果该菜单已经被打开，则要激活该菜单
		tabPanel.setActiveTab(node);
		return;
	}

	tabPanel.add({
		id : node,
		title : '<b>' + nodeName + '</b>',
		html : '<iframe src="'
				+ url
				+ '" style="border:0px;margin-left:0px;margin-right:-20;width:100%;height:100%;"></iframe>',
		closable : true,
		autoWidth : true,
		autoScroll : false
	}).show().setActive();

	// tabPanel.setActiveTab(tabPage);
}
// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【tab页】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【页面布局】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
// 上部标识
var north = new Ext.Panel({
			title : '大发系统',
			region : 'north',
			split : true,
			border : true,
			height : 0
		});

// 底部标识
var sourth = new Ext.Panel({
			region : 'south',
			split : true,
			border : true,
			height : 0
		});

// 左侧区域
var west = new Ext.Panel({
			collapsible : true, // 自动收缩按钮
			split : true,
			border : false,
			width : 250,
			layout : "accordion",
			layoutConfig : {
				animate : true
			},
			region : "west",
			title : '系统导航',
			items : [{
						title : "<b>菜单导航</b>",
						autoScroll : true,
						items : [treePanel]
					}, {
						title : "<b>在线人员</b>",
						autoScroll : true
					}, {
						title : "<b>快捷方式</b>",
						autoScroll : true
					}]
		});
// 面板
var main = new Ext.Panel({
			region : 'center',
			split : true,
			border : true,
			frame : true,
			height : '100%',
			width : '100%',
			items : [tabPanel]
		});
// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【页面布局】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

Ext.onReady(function() {
			Ext.QuickTips.init();
			var view = new Ext.Viewport({
						renderTo : Ext.getBody(),
						layout : 'border',
						items : [north, west, main]
					});
		});