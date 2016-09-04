Ext.onReady(function() {
	Ext.QuickTips.init();
	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【树形菜单】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	// 定义树形菜单
	var treeMenuStore = Ext.create('Ext.data.TreeStore', {
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
				store : treeMenuStore,
				frame : true,
				title : '菜单列表',
				viewConfig : {
					plugins : {
						ptype : 'treeviewdragdrop'
					}
				},
				renderTo : 'tree',
				width : 250,
				height : 500,
				lines : true,
				useArrows : true,
				dockedItems : [{
							xtype : 'toolbar',
							items : [{
										text : '展 开',
										handler : function() {
											treePanel.expandAll();
										}
									}, {
										text : '收 缩',
										handler : function() {
											treePanel.collapseAll();
										}
									}, {
										text : '刷 新',
										handler : function() {
											treeMenuStore.load();
											treePanel.expandAll();
										}
									}]
						}]
			});

	// 获取单击事件
	treePanel.on("itemclick", function(view, record, item, index, e) {
				if (index == 0) {
					// 表示点击的是根目录
					node = '-1';
					nodeName = '系统菜单';
				} else {
					node = record.raw.id;
					nodeName = record.raw.text;
				}

			});
		// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【树形菜单】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

	});