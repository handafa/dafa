Ext.onReady(function() {
	Ext.QuickTips.init();

	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【页面初始】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	// 创建数据模型
	Ext.regModel("Role", {
				fields : [{
							name : 'id'
						}, {
							name : 'roleName'
						}, {
							name : 'weight'
						}, {
							name : 'node'
						}]
			});

	// 创建数据源
	var roleStore = new Ext.data.Store({
				remoteSort : false,
				autoLoad : true,
				baseParams : {
					start : 0,
					limit : itemsPerPage
				},
				pageSize : itemsPerPage,
				model : 'Role',
				proxy : {
					type : 'ajax',
					url : 'role/query',
					reader : {
						type : 'json',
						root : 'items',
						totalProperty : 'results'
					}
				}
			});

	// 第一次只加载第一页
	roleStore.loadPage(1);

	// 搜索输入框
	var searchfield = new Ext.ux.form.SearchField({
				store : roleStore,
				paramName : 'keyword',
				width : 200,
				emptyText : '请输入角色名称搜索',
				style : 'margin-left: 10px;'
			});

	// 创建工具栏组件
	var toolBar = [{
				text : '新增',
				iconCls : 'add',
				handler : showAdd
			}, '-', {
				text : '修改',
				iconCls : 'modify',
				handler : showModify
			}, '-', {
				text : '删除',
				iconCls : 'remove',
				handler : showDelete
			}, '-', searchfield];

	// 分页组件
	var pageSizeCombo = new Ext.form.ComboBox({
				name : 'pagesize',
				// fieldLabel:'选择分页',
				triggerAction : 'all',
				mode : 'local',
				store : new Ext.data.Store({
							fields : ['value', 'text'],
							data : [{
										'value' : '10',
										'text' : '每页10条'
									}, {
										'value' : '20',
										'text' : '每页20条'
									}, {
										'value' : '50',
										'text' : '每页50条'
									}]
						}),
				valueField : 'value',
				displayField : 'text',
				value : '10',
				typeAhead : true,
				editable : false,
				width : 100,
				listeners : {
					select : function(pageSizeCombo) {
						itemsPerPage = parseInt(pageSizeCombo.getValue());
						bbar.pageSize = parseInt(pageSizeCombo.getValue());
						roleStore.baseParams.limit = itemsPerPage;
						roleStore.baseParams.start = 0;
						roleStore.load();
					}

				}
			});

	// 底部分页显示区
	var bbar = new Ext.PagingToolbar({
				pageSize : itemsPerPage,
				store : roleStore,
				displayInfo : true,
				displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
				emptyMsg : "没有数据",
				items : ['-', '&nbsp;', pageSizeCombo]
			});

	// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【页面初始】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	// 表单区
	var roleForm = new Ext.form.Panel({
				defaults : {
					labelSeparator : ":",
					labelWidth : 60,
					style : 'margin-left: 10px;margin-top:0;'
				},
				layout : {
					type : 'table',
					columns : 1
				},
				autoScroll : true,
				bodyPadding : 5,
				frame : true,
				defaultType : 'textfield',
				items : [{
							id : 'roleName',
							name : 'roleName',
							fieldLabel : '角色名称',
							allowBlank : false,
							blankText : "角色名称不能为空",
							msgTarget : 'qtip',
							emptyText : '请输入角色名称'
						}, {
							id : 'weight',
							name : 'weight',
							xtype : 'numberfield',
							minValue : 1,
							value : 1,
							fieldLabel : '排序',
							emptyText : '请该角色的排序'
						}, {
							xtype : 'textarea',
							id : 'node',
							name : 'node',
							fieldLabel : '备注信息',
							emptyText : '请输入备注信息'
						}, {
							id : 'id',
							name : 'id',
							xtype : 'hidden'
						}],
				buttons : [{
							text : '保存',
							handler : submitForm
						}, {
							text : '重置',
							handler : function() {
								roleForm.getForm().reset();
							}
						}, '->'],
				buttonAlign : 'center'
			});

	// 创建窗口
	var win = new Ext.window.Window({
				layout : 'fit',
				width : 350,
				closeAction : 'close',
				maximizable : true,
				minimizable : true,
				closable : true, // 是否可以关闭
				modal : true, // 是否为模态窗口
				resizable : true, // 是否可以改变窗口大小
				items : roleForm,
				listeners : {
					// 最小化窗口事件
					minimize : function() {
						if (this.minimizable) {
							this.colse();
						}
					}
				}
			});

	// 列表区
	var roleGrid = new Ext.grid.Panel({
				layout : 'fit',
				title : '角色列表',
				frame : true,
				tbar : toolBar,
				bbar : bbar,
				store : roleStore,
				renderTo : Ext.getBody(),
				selModel : new Ext.selection.CheckboxModel(),
				columns : [// 配置表格列
				new Ext.grid.RowNumberer(), {
							hidden : true,
							dataIndex : 'id'
						}, {
							header : "角色名称",
							width : 80,
							dataIndex : 'roleName',
							sortable : false
						}, {
							header : "角色备注",
							dataIndex : 'node',
							width : 120,
							sortable : false
						}, {
							header : "排序",
							dataIndex : 'weight',
							sortable : true
						}]
			});

	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【定义函数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	// 弹出增加窗口
	function showAdd() {
		roleForm.getForm().reset();
		roleForm.isAdd = true;
		win.setTitle('增加角色信息');
		win.show();
	}

	// 弹出修改窗口
	function showModify() {
		var list = getCheckedList();
		if (list.length > 1) {
			Ext.Msg.alert('提示', '<h5 align="center">一次只能修改一个角色！</h5>');
		} else {
			var id = list[0];
			roleForm.getForm().reset();
			roleForm.isAdd = false;
			loadForm(id);
			win.setTitle('编辑角色信息');
			win.show();
		}
	}

	// 弹出删除窗口
	function showDelete() {
		var list = getCheckedList();
		var l = list.length;
		if (l > 0) {
			Ext.MessageBox.confirm("提示", "<h5>确定删除该数据?</h5>", function(id) {
						if (id == 'yes') {
							deleteChecked(list);
						} else {
							return;
						}
					});
		}
	}
	function submitForm() {

		if (roleForm.isAdd) {
			// 添加信息
			roleForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						submitEmptyText : false,
						url : 'role/save',// 请求的url地址
						success : function(form, action) {
							// 加载成功的处理函数
							roleForm.getForm().reset();
							win.close();
							roleStore.load();
							Ext.Msg.alert('提示', action.result.msg);
						},
						failure : function(form, action) {
							// 加载失败的处理函数
							Ext.Msg.alert('提示', action.result.msg);
						}
					});
		} else {
			// 修改信息
			roleForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						submitEmptyText : false,
						url : 'role/modify',// 请求的url地址
						success : function(form, action) {// 加载成功的处理函数
							win.close();
							roleStore.load();
							Ext.Msg.alert('提示', action.result.msg);
						},
						failure : function(form, action) {// 加载失败的处理函数
							Ext.Msg.alert('提示', action.result.msg);
						}
					});
		}

	}
	// 取得所选菜单id
	function getCheckedList() {
		var recs = roleGrid.getSelectionModel().getSelection();
		var list = [];
		if (recs.length == 0) {
			Ext.MessageBox.alert('提示', '<h5 align="center">请选择要进行操作的列表！</h5>');
			return;
		} else {
			for (var i = 0; i < recs.length; i++) {
				var rec = recs[i];
				list.push(rec.get('id'));
			}
		}
		return list;
	}

	// 加载表单数据
	function loadForm(id) {
		roleForm.getForm().load({
					waitMsg : '正在加载数据请稍后',// 提示信息
					waitTitle : '提示',// 标题
					url : 'role/select', // 请求的url地址
					params : {
						id : id
					},
					method : 'GET',// 请求方式
					failure : function(form, action) {// 加载失败的处理函数
						Ext.Msg.alert('提示', action.result.msg);
					}
				});
	}

	// 删除
	function deleteChecked(ids) {
		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '正在操作,请稍后......'
				});
		Ext.Ajax.request({
					url : 'role/delete',
					params : {
						ids : ids
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.hide();
						roleStore.load();
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
