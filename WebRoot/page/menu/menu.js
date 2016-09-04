Ext.onReady(function() {
			var node = '';
			var nodeName = '';
			Ext.QuickTips.init();

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
													treeStore.load();
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

			// 创建工具栏组件
			var toolBar = [{
						text : '新增',
						iconCls : 'add',
						handler : showAddMenu
					}, '-', {
						text : '修改',
						iconCls : 'modify',
						handler : showModifyMenu
					}, '-', {
						text : '删除',
						iconCls : 'remove',
						handler : showDeleteMenu
					}];

			// 弹出新增对话框
			function showAddMenu() {
				if (node == '') {
					Ext.Msg.alert('提示', '请选择父节点');
					return;
				} else {
					menuForm.getForm().reset();
					menuForm.isAdd = true;
					var fatherNode = menuForm.getForm().findField('fatherNode');
					fatherNode.setValue(node);
				}
			}

			// 弹出修改对话框
			function showModifyMenu() {
				if (node == '') {
					Ext.Msg.alert('提示', '请选择要修改的菜单');
				} else {
					menuForm.getForm().reset();
					menuForm.isAdd = false;
					loadForm();
				}
			}
			// 加载表单数据
			function loadForm() {
				menuForm.getForm().load({
							waitMsg : '正在加载数据请稍后',// 提示信息
							waitTitle : '提示',// 标题
							url : 'menu/select', // 请求的url地址
							params : {
								id : node
							},
							method : 'GET',// 请求方式
							failure : function(form, action) {// 加载失败的处理函数
								Ext.Msg.alert('提示', '数据加载失败');
							}
						});
			}
			// 弹出删除确认对话框
			function showDeleteMenu() {
				if (node == '') {
					return;
				}
				Ext.MessageBox.confirm("提示", "确定删除连接:【" + nodeName + "】?",
						function() {
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
			// 表单
			var menuForm = new Ext.form.FormPanel({
						defaults : {
							labelSeparator : ":",
							labelWidth : 70,
							width : 220
						},
						layout : {
							type : 'table',
							columns : 2
						},
						tbar : toolBar,
						height : 300,
						frame : true,
						renderTo : 'content',
						title : '菜单详情',
						items : [{
									xtype : 'textfield',
									id : 'name',
									style : 'margin-top:10',
									name : 'name',
									fieldLabel : '菜单名称',
									allowBlank : false,
									blankText : "菜单名称不能为空",
									msgTarget : "qtip"
								}, {
									xtype : 'textfield',
									allowBlank : true,
									style : 'margin-top:10;margin-left:10',
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
									text : '确定',
									handler : submitForm
								}, {
									text : '重置',
									handler : function() {
										menuForm.getForm().reset();
										node = '';// 初始化
									}
								}, '->'],
						buttonAlign : 'left'
					});

			// 提交表单函数
			function submitForm() {
				if (menuForm.isAdd) {
					menuForm.getForm().submit({
								clientValidation : true,// 进行客户端验证
								waitMsg : '正在提交数据请稍后',// 提示信息
								waitTitle : '提示',// 标题
								method : 'POST',// 请求方式
								url : 'menu/save',// 请求的url地址
								submitEmptyText : false,
								success : function(form, action) {
									// 加载成功的处理函数
									node = '';
									menuForm.getForm().reset();
									treeStore.load();
									Ext.Msg.alert('提示', action.result.msg);
								},
								failure : function(form, action) {
									// 加载失败的处理函数
									// node = '';
									Ext.Msg.alert('提示', action.result.msg);
								}
							});
				} else {
					menuForm.getForm().submit({
								clientValidation : true,// 进行客户端验证
								waitMsg : '正在提交数据请稍后',// 提示信息
								waitTitle : '提示',// 标题
								method : 'POST',// 请求方式
								submitEmptyText : false,
								url : 'menu/modify',// 请求的url地址
								success : function(form, action) {
									// 加载成功的处理函数
									node = '';
									treeStore.load();
									menuForm.getForm().reset();
									Ext.Msg.alert('提示', action.result.msg);
								},
								failure : function(form, action) {
									// 加载失败的处理函数
									// node = '';
									Ext.Msg.alert('提示', action.result.msg);
								}
							});
				}

			}

		});