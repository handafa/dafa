Ext.onReady(function() {

	var node = '';
	var nodeName = '';
	var roleId = '-1';
	var list = [];
	Ext.QuickTips.init();
	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【页面初始】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	// 创建数据模型
	Ext.regModel("Role", {
				fields : [{
							name : 'id'
						}, {
							name : 'roleName'
						}, {
							name : 'node'
						}]
			});
	// 创建数据源
	var roleStore = new Ext.data.Store({
				remoteSort : false,
				autoLoad : true,
				model : 'Role',
				proxy : {
					type : 'ajax',
					url : 'rolemenu/gridroles',
					reader : {
						type : 'json',
						root : 'items',
						totalProperty : 'results'
					}
				}
			});

	// 单选列表
	var sm = new Ext.selection.CheckboxModel({
				checkOnly : true,
				mode : 'single',
				listeners : {
					select : {
						fn : function() {
							var recs = roleGrid.getSelectionModel()
									.getSelection();
							var rec = recs[0].get('id');
							roleId = rec;
							treeStore.proxy.extraParams.roleId = rec;
							treeStore.load();
						}
					}
				}
			});
	// 列表区
	var roleGrid = new Ext.grid.Panel({
				layout : 'fit',
				title : '角色列表',
				frame : true,
				height : 500,
				store : roleStore,
				renderTo : 'role',
				selModel : sm,
				columns : [// 配置表格列
				new Ext.grid.RowNumberer(), {
							hidden : true,
							dataIndex : 'id'
						}, {
							header : "角色名称",
							width : 90,
							dataIndex : 'roleName',
							sortable : false
						}, {
							header : "角色备注",
							dataIndex : 'node',
							width : 150,
							sortable : false
						}]
			});

	// 定义树形菜单
	var treeStore = Ext.create('Ext.data.TreeStore', {
				autoLoad : true,
				proxy : {
					type : 'ajax',
					extraParams : {
						roleId : roleId
					},
					url : 'rolemenu/treemenus'
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
				frame : true,
				title : '菜单功能列表',
				viewConfig : {
					plugins : {
						ptype : 'treeviewdragdrop'
					}
				},
				renderTo : 'menu',
				width : '100%',
				height : 500,
				lines : true,
				useArrows : true,
				dockedItems : [{
							xtype : 'toolbar',
							items : [{
										text : '授权',
										iconCls : 'authorize',
										handler : authorize
									}, {
										text : '重置',
										iconCls : 'unauthorize',
										handler : function() {
											treeStore.load();
											// treePanel.expandAll();
										}
									}]
						}],
				listeners : {
					load : function() {
						// treePanel.expandAll();
					}
				}

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

	// 选中子节点
	// treePanel.on('checkchange', function(node, checked) {
	// node.expand();
	// node.checked = checked;
	// node.eachChild(function(child) {
	// child.set('checked', checked);
	// child.fireEvent('checkchange', child, checked);
	// });
	// }, treePanel);

	treePanel.on('checkchange', function(node, checked) {
		if (checked == true) {
			node.checked = checked;
			// console.dir(node.parentNode);
			// alert(node.get("leaf"));

			// 获得父节点
			pNode = node.parentNode;

			// 当checked == true通过循环将所有父节点选中
			for (; pNode != null; pNode = pNode.parentNode) {
				if (pNode.get("id") != "-1") {
					pNode.set("checked", true);
					if (!pNode.get("leaf")) {

					}
				}
			}
		}

		// 当该节点有子节点时，将所有子节点选中删除
		if (!node.get("leaf") && !checked)
			node.cascade(function(node) {
						node.set('checked', false);

					});

			// 表示选中父节点的时候孩子节点全部选中
			// if (!node.get("leaf") && checked) {
			// node.eachChild(function(child) {
			// child.set('checked', checked);
			// child.fireEvent('checkchange', child, checked);
			// });
			// }
		});

	// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【页面初始】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【定义函数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	// 授权
	function authorize() {
		// 获取选中的菜单
		var recs = treePanel.getChecked();
		list = [];
		if (roleId == '-1') {
			Ext.MessageBox.alert('提示', '<h5 align="center">请先选择角色！</h5>');
			return;
		} else {
			if (recs.length == 0) {
				Ext.MessageBox
						.alert('提示', '<h5 align="center">请为该角色选择菜单！</h5>');
				return;
			} else {
				for (var i = 0; i < recs.length; i++) {
					var rec = recs[i];
					list.push(rec.get('id'));
				}
			}
		}

		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '<h5 align="center">正在操作,请稍后......</h5>'
				});

		Ext.Ajax.request({
					url : 'rolemenu/authorize',
					params : {
						roleId : roleId,
						menuIds : list
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.hide();
						treeStore.load();
						Ext.Msg.alert('提示', action.result.msg);
					},
					failure : function(form, action) {
						msgTip.hide();
						Ext.Msg.alert('提示', action.result.msg);
					}
				});
	}
		// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【定义函数】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	});