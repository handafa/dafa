Ext.onReady(function() {
	var node = '';
	var nodeName = '';
	Ext.QuickTips.init();
	var itemsPerPage = 10; // 设置分页大小
	// 创建菜单模型
	Ext.regModel("Menu", {
				fields : [{
							name : 'id'
						}, {
							name : 'name'
						}, {
							name : 'url'
						}]
			});
	// 定义菜单数据源对象
	var menuStore = Ext.create('Ext.data.Store', {
				remoteSort : false,
				autoLoad : {
					start : 0,
					limit : itemsPerPage
				},
				pageSize : itemsPerPage,
				model : 'Menu',
				proxy : {
					type : 'ajax',
					url : 'menu/query',
					reader : {
						type : 'json',
						root : 'items',
						totalProperty : 'results'
					}
				}

			});
	menuStore.loadPage(1);

	// 创建工具栏组件
	var toolBar = [{
				text : '新增',
				iconCls : 'add',
				handler : showAddMenu
			}, {
				text : '修改',
				iconCls : 'modify',
				handler : showModifyMenu
			}, {
				text : '删除',
				iconCls : 'remove',
				handler : showDeleteMenu
			}];

	var bbar = new Ext.PagingToolbar({
				store : menuStore,
				displayInfo : true,
				displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
				emptyMsg : "没有数据"
			});
	// 创建Grid表格组件
	var menuGrid = new Ext.grid.Panel({
				layout : 'fit',
				title : '菜单管理',
				// height : 500,
				frame : true,
				tbar : toolBar,
				bbar : bbar,
				store : menuStore,
				renderTo : document.getElementById('content'),
				selModel : new Ext.selection.CheckboxModel(),
				columns : [// 配置表格列
				{
							header : "菜单编码",
							width : 80,
							dataIndex : 'id',
							sortable : true
						}, {
							header : "菜单名称",
							dataIndex : 'name',
							sortable : true
						}, {
							header : "菜单连接",
							dataIndex : 'url',
							sortable : false
						}]
			});

	// 创建新增或修改菜单信息的form表单
	var menuForm = new Ext.form.Panel({
				defaults : {
					// autoFitErrors : "false",
					labelSeparator : ":",
					labelWidth : 70,
					width : 200
				},
				// renderTo: Ext.getBody(),
				bodyPadding : 5,
				frame : true,
				items : [{
							xtype : 'textfield',
							id : 'name',
							name : 'name',
							fieldLabel : '菜单名称',
							allowBlank : false,
							blankText : "菜单名称不能为空",
							msgTarget : "qtip"
						}, {
							xtype : 'textfield',
							allowBlank : true,
							id : 'url',
							name : 'url',
							fieldLabel : '菜单连接'
						}, {
							xtype : 'hidden',
							id : 'id',
							name : 'id'
						}, {
							xtype : 'hidden',
							id : 'fatherNode',
							name : 'fatherNode'
						}],
				buttons : [{
							text : '提交',
							handler : submitForm
						}, {
							text : '关闭',
							handler : function() {
								win.hide();
								node = '';// 初始化
							}
						}, '->'],
				buttonAlign : 'center'
			});

	// 创建窗口
	var win = new Ext.window.Window({
				layout : 'fit',
				width : 280,
				closeAction : 'hide',
				// height : 280,
				plain : true,
				resizable : false,
				shadow : true,
				modal : true,
				closable : true,
				items : menuForm
			});

	// 弹出增加菜单窗口
	function showAddMenu() {
		if (node == '') {
			Ext.Msg.alert('提示', '请选择节点');
		} else {

			menuForm.getForm().reset();
			menuForm.isAdd = true;
			var fatherNode = menuForm.getForm().findField('fatherNode');
			fatherNode.setValue(node);
			win.setTitle('新增菜单信息');
			win.show();
		}
	}
	// 弹出修改菜单窗口
	function showModifyMenu() {
		var menuList = getMenuIdList();
		var num = menuList.length;
		if (num > 1) {
			Ext.MessageBox.alert("提示", "每次只能修改一条菜单信息。");
		} else if (num == 1) {
			menuForm.getForm().reset();
			menuForm.isAdd = false;
			win.setTitle('修改菜单信息');
			win.show();
			var id = menuList[0];
			loadForm(id);
		}

	}
	// 弹出删除确认对话框
	function showDeleteMenu() {
		if (node == '') {
			return;
		}
		Ext.MessageBox.confirm("提示", "确定删除连接:【" + nodeName + "】?", function() {
					if (btnId = 'yes') {
						deleteMenu();
					} else {
						return;
					}
				});
	}

	// 删除菜单
	function deleteMenu() {
		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '正在删除菜单信息请稍后......'
				});
		Ext.Ajax.request({
					url : 'menu/delete',
					params : {
						id : node
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.hide();
						node = '';
						treeStore.load();
						Ext.Msg.alert('提示', action.result.msg);
						
					},
					failure : function(form, action) {
						msgTip.hide();
						node = '';
						Ext.Msg.alert('提示', action.result.msg);
					}
				});
	}
	// 加载表单数据
	function loadForm(id) {
		menuForm.getForm().load({
					waitMsg : '正在加载数据请稍后',// 提示信息
					waitTitle : '提示',// 标题
					url : 'menu/select', // 请求的url地址
					params : {
						id : id
					},
					method : 'GET',// 请求方式
					failure : function(form, action) {// 加载失败的处理函数
						Ext.Msg.alert('提示', '数据加载失败');
					}
				});
	}
	// 提交表单
	function submitForm() {
		if (menuForm.isAdd) {
			menuForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						params : {
							id : 9
						},
						url : 'menu/save',// 请求的url地址
						success : function(form, action) {// 加载成功的处理函数
							win.hide();
							// updateMenuGrid(action.result.menuId);
							treeStore.load();
							Ext.Msg.alert('提示', '新增菜单成功');
						},
						failure : function(form, action) {// 加载失败的处理函数
							Ext.Msg.alert('提示', '新增菜单失败');
						}
					});
		} else {
			menuForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						url : 'menu/modify',// 请求的url地址
						success : function(form, action) {// 加载成功的处理函数
							win.hide();
							treeStore.load();
							Ext.Msg.alert('提示', '修改菜单成功');
						},
						failure : function(form, action) {// 加载失败的处理函数
							Ext.Msg.alert('提示', '修改菜单失败');
						}
					});
		}
	}

	// 取得所选菜单id
	function getMenuIdList() {
		var recs = menuGrid.getSelectionModel().getSelection();
		var list = [];
		if (recs.length == 0) {
			Ext.MessageBox.alert('提示', '请选择要进行操作的菜单！');
		} else {
			for (var i = 0; i < recs.length; i++) {
				var rec = recs[i];
				list.push(rec.get('id'));
			}
		}
		return list;
	}

	// ===============================================================================================================

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
				frame : true,
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
											treeStore.load();
											treePanel.expandAll();
										}
									}]
						}]
			});

	// 获取单击事件
	treePanel.on("itemclick", function(view, record, item, index, e) {
				node = record.raw.id;
				nodeName = record.raw.text;
			});
		// ===============================================================================================================
	});