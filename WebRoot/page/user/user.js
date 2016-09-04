// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【变量参数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【变量参数】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【变量参数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【变量参数】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

Ext.onReady(function() {
	Ext.QuickTips.init();
	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【用户列表】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	// 创建数据模型
	Ext.regModel("User", {
				fields : [{
							name : 'id'
						}, {
							name : 'number'
						}, {
							name : 'userName'
						}, {
							name : 'loginName'
						}, {
							name : 'sex'
						}, {
							name : 'age'
						}, {
							name : 'mobile'
						}, {
							name : 'email'
						}, {
							name : 'entryTime'
						}]
			});

	// 定义菜单数据源对象
	var userStore = Ext.create('Ext.data.Store', {
				remoteSort : false,
				autoLoad : true,
				baseParams : {
					start : 0,
					limit : itemsPerPage
				},
				pageSize : itemsPerPage,
				model : 'User',
				proxy : {
					type : 'ajax',
					url : 'user/query',
					reader : {
						type : 'json',
						root : 'items',
						totalProperty : 'results'
					}
				}

			});
	// 第一次只加载第一页
	userStore.loadPage(1);

	// 组织树形结构
	var groupitem = new Ext.ux.TreeGroupComboBox({
				labelSeparator : ":",
				labelWidth : 70,
				style : 'margin-left: 10px',
				fieldLabel : '所属组织',
				id : 'groupId',
				name : 'groupId',
				emptyText : '请选择所属组织',
				allowBlank : false,
				msgTarget : 'qtip',
				emptyText : '请选择所属组织'
			});
	// 搜索条件
	var searchfield = new Ext.ux.form.SearchField({
				store : userStore,
				paramName : 'keyword',
				width : 200,
				emptyText : '请输入用户姓名搜索',
				style : 'margin-left: 10px;'
			});
	// 创建工具栏组件
	var toolBar = [{
				text : '新增',
				iconCls : 'user_add',
				handler : showAdd
			}, '-', {
				text : '修改',
				iconCls : 'user_modify',
				handler : showModify
			}, '-', {
				text : '删除',
				iconCls : 'user_remove',
				handler : showDelete
			}, '-', {
				text : '密码重置',
				iconCls : 'user_reset',
				handler : showReset
			}, '-', searchfield];

	// 创建新增或修改信息的form表单
	var userForm = new Ext.form.Panel({
				defaults : {
					labelSeparator : ":",
					labelWidth : 70,
					style : 'margin-left: 10px'
				},
				layout : {
					type : 'table',
					columns : 2
				},
				autoScroll : true,
				bodyPadding : 5,
				frame : true,
				defaultType : 'textfield',
				items : [{
							id : 'number',
							name : 'number',
							fieldLabel : '用户编码',
							allowBlank : false,
							blankText : "用户编码不能为空",
							msgTarget : 'qtip',
							emptyText : '请输入用户编码'
						}, {
							id : 'userName',
							name : 'userName',
							fieldLabel : '用户姓名',
							allowBlank : false,
							blankText : "用户姓名不能为空",
							msgTarget : 'qtip',
							emptyText : '请输入用户姓名'
						}, {
							id : 'loginName',
							name : 'loginName',
							fieldLabel : '登陆账户',
							allowBlank : false,
							blankText : "登陆账户不能为空",
							msgTarget : 'qtip',
							emptyText : '请输入登陆账户'
						}, {
							id : 'password',
							name : 'password',
							fieldLabel : '登陆密码',
							inputType : 'password',
							value : '111111',
							allowBlank : false,
							msgTarget : 'qtip',
							emptyText : '请输入登陆密码'
						}, {
							xtype : 'combo',
							id : 'roleId',
							name : 'roleId',
							editable : false,
							store : new Ext.data.Store({
										fields : ['value', 'text'],
										data : [{
													'value' : '0',
													'text' : '男'
												}, {
													'value' : '1',
													'text' : '女'
												}]
									}),
							fieldLabel : '所属角色',
							valueField : 'value',
							emptyText : '请选择角色',
							allowBlank : false,
							msgTarget : 'qtip',
							emptyText : '请选择角色'
						}, groupitem, {
							xtype : 'numberfield',
							id : 'age',
							name : 'age',
							maxValue : 100,
							minValue : 1,
							fieldLabel : '年龄',
							emptyText : '请输入年龄'
						}, {
							xtype : 'datefield',
							id : 'birthday',
							name : 'birthday',
							format : 'Y-m-d',
							fieldLabel : '出生日期',
							emptyText : '请选择出生日期'
						}, {
							xtype : 'combo',
							id : 'sex',
							name : 'sex',
							editable : false,
							store : new Ext.data.Store({
										fields : ['value', 'text'],
										data : [{
													'value' : 'boy',
													'text' : '男'
												}, {
													'value' : 'girl',
													'text' : '女'
												}]
									}),
							fieldLabel : '性别',
							valueField : 'value',
							emptyText : '请选择性别'
						}, {
							xtype : 'combo',
							id : 'degree',
							name : 'degree',
							editable : false,
							store : new Ext.data.Store({
										fields : ['value', 'text'],
										data : [{
													'value' : '',
													'text' : ''
												}, {
													'value' : '1001',
													'text' : '高中'
												}, {
													'value' : '1002',
													'text' : '专科'
												}, {
													'value' : '1003',
													'text' : '本科'
												}, {
													'value' : '1004',
													'text' : '研究生'
												}, {
													'value' : '1005',
													'text' : '博士'
												}, {
													'value' : '1006',
													'text' : '其他'
												}]
									}),
							fieldLabel : '最高学历',
							valueField : 'value',
							emptyText : '请选择学历'
						}, {
							id : 'mobile',
							name : 'mobile',
							fieldLabel : '手机号',
							emptyText : '请输入手机号'
						}, {
							id : 'tel',
							name : 'tel',
							regex : regex_tel,
							fieldLabel : '电话号码',
							emptyText : '请输入电话号码'
						}, {
							xtype : 'numberfield',
							id : 'qq',
							name : 'qq',
							vtype : 'alphanum',
							fieldLabel : 'QQ号码',
							emptyText : '请输入QQ号码'
						}, {
							id : 'email',
							name : 'email',
							vtype : 'email',
							fieldLabel : '电子邮箱',
							emptyText : '请输入电子邮箱'
						}, {
							xtype : 'datefield',
							id : 'entryTime',
							name : 'entryTime',
							colspan : 2,
							format : 'Y-m-d',
							fieldLabel : '入职时间',
							emptyText : '请选择入职时间'
						}, {
							xtype : 'textarea',
							id : 'note',
							name : 'note',
							colspan : 4,
							width : 400,
							fieldLabel : '备注信息',
							emptyText : '请输入备注信息'
						}, {
							xtype : 'hidden',
							id : 'id',
							name : 'id'
						}],
				buttons : [{
							text : '提交',
							handler : submitForm
						}, {
							text : '重置',
							handler : function() {
								userForm.getForm().reset();
							}
						}, '->'],
				buttonAlign : 'center'
			});

	// 创建窗口
	var win = new Ext.window.Window({
				layout : 'fit',
				width : 500,
				closeAction : 'close',
				maximizable : true,
				minimizable : true,
				closable : true, // 是否可以关闭
				modal : false, // 是否为模态窗口
				resizable : true, // 是否可以改变窗口大小
				items : userForm,
				listeners : {
					// 最小化窗口事件
					minimize : function() {
						if (this.minimizable) {
							this.colse();
						}
					}
				}
			});

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
						userStore.baseParams.limit = itemsPerPage;
						userStore.baseParams.start = 0;
						userStore.load();
					}

				}
			});

	// 底部分页显示区
	var bbar = new Ext.PagingToolbar({
				pageSize : itemsPerPage,
				store : userStore,
				displayInfo : true,
				displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
				emptyMsg : "没有数据",
				items : ['-', '&nbsp;', pageSizeCombo]
			});

	// 创建Grid表格组件
	var userGrid = new Ext.grid.Panel({
				layout : 'fit',
				title : '用户管理',
				// height : 500,
				frame : true,
				tbar : toolBar,
				bbar : bbar,
				store : userStore,
				renderTo : Ext.getBody(),
				selModel : new Ext.selection.CheckboxModel(),
				columns : [// 配置表格列
				new Ext.grid.RowNumberer(), {
							hidden : true,
							dataIndex : 'id'
						}, {
							header : "用户编码",
							width : 80,
							dataIndex : 'number',
							sortable : true
						}, {
							header : "登陆账户",
							dataIndex : 'loginName',
							sortable : true
						}, {
							header : "用户姓名",
							dataIndex : 'userName',
							sortable : true
						}, {
							header : "性别",
							dataIndex : 'sex',
							sortable : true
						}, {
							header : "年龄",
							dataIndex : 'age',
							sortable : true
						}, {
							header : "手机号",
							dataIndex : 'mobile',
							sortable : false
						}, {
							header : "电子邮箱",
							dataIndex : 'email',
							width : 150,
							sortable : false
						}, {
							header : "入职时间",
							dataIndex : 'entryTime',
							sortable : true
						}]
			});

	// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【用户列表】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【自定义函数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	// 搜索
	function query() {
		userStore.load({
					params : {
						keyword : searchfield.getValue()
					}
				});

	}

	// 弹出增加窗口
	function showAdd() {
		userForm.getForm().reset();
		userForm.isAdd = true;
		var p = userForm.getForm().findField('password');
		p.setVisible(true);
		p.setDisabled(false);
		win.setTitle('添加用户信息');
		win.show();
	}

	// 弹出修改窗口
	function showModify() {
		var list = getUserList();
		if (list.length > 1) {
			//  
			Ext.Msg.alert('提示', '<h5 align="center">一次只能操作一个用户！</h5>');
		} else {
			var id = list[0];
			userForm.getForm().reset();
			var p = userForm.getForm().findField('password');
			p.setVisible(false);
			p.setDisabled(true);
			userForm.isAdd = false;
			loadForm(id);
			win.setTitle('编辑用户信息');
			win.show();
		}
	}

	// 弹出删除窗口
	function showDelete() {
		var list = getUserList();
		var l = list.length;
		if (l > 0) {
			Ext.MessageBox.confirm("提示", "<h5>确定删除该数据?</h5>", function(id) {
						if (id == 'yes') {
							deleteUser(list);
						} else {
							return;
						}
					});
		}
	}

	// 密码重置提示框
	function showReset() {
		var list = getUserList();
		if (list.length > 1) {
			Ext.MessageBox.alert('提示', '<h5 align="center">一次只能重置一个用户！</h5>');
		} else {
			Ext.MessageBox.confirm("提示", "<h5>确定重置该用户的密码?</h5>", function() {
						if (btnId = 'yes') {
							resetPassword(list[0]);
						} else {
							return;
						}
					});
		}
	}

	// 密码重置
	function resetPassword(id) {
		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '正在操作,请稍后......'
				});
		Ext.Ajax.request({
					url : 'user/resetPassword',
					params : {
						id : id
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.close();
						Ext.Msg.alert('提示', '<h5 align="center">密码重置成功</h5>');
					},
					failure : function(form, action) {
						msgTip.close();
						Ext.Msg.alert('提示', '<h5 align="center">密码重置失败</h5>');
					}
				});
	}
	// 加载表单数据
	function loadForm(id) {
		userForm.getForm().load({
			waitMsg : '正在加载数据请稍后',// 提示信息
			waitTitle : '提示',// 标题
			url : 'user/select', // 请求的url地址
			params : {
				id : id
			},
			method : 'GET',// 请求方式
			success : function(form, action) {
				groupitem.setLocalValue(action.result.data.groupName,
						action.result.data.groupId);
			},
			failure : function(form, action) {// 加载失败的处理函数
				Ext.Msg.alert('提示', action.result.msg);
			}
		});
	}

	// 删除
	function deleteUser(ids) {
		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '正在操作,请稍后......'
				});
		Ext.Ajax.request({
					url : 'user/delete',
					params : {
						ids : ids
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.hide();
						userStore.load();
						Ext.Msg.alert('提示', action.result.msg);
					},
					failure : function(form, action) {
						msgTip.hide();
						Ext.Msg.alert('提示', action.result.msg);
					}
				});
	}

	// 提交表单
	function submitForm() {
		if (userForm.isAdd) {
			// 添加信息
			userForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						submitEmptyText : false,
						url : 'user/save',// 请求的url地址
						success : function(form, action) {
							// 加载成功的处理函数
							node = '';
							userForm.getForm().reset();
							win.close();
							userStore.load();
							Ext.Msg.alert('提示', action.result.msg);
						},
						failure : function(form, action) {
							// 加载失败的处理函数
							// node = '';
							Ext.Msg.alert('提示', action.result.msg);
						}
					});
		} else {
			// 修改信息
			userForm.getForm().submit({
						clientValidation : true,// 进行客户端验证
						waitMsg : '正在提交数据请稍后',// 提示信息
						waitTitle : '提示',// 标题
						method : 'POST',// 请求方式
						submitEmptyText : false,
						url : 'user/modify',// 请求的url地址
						success : function(form, action) {// 加载成功的处理函数
							win.close();
							userStore.load();
							Ext.Msg.alert('提示', action.result.msg);
						},
						failure : function(form, action) {// 加载失败的处理函数
							Ext.Msg.alert('提示', action.result.msg);
						}
					});
		}
	}

	// 取得所选菜单id
	function getUserList() {
		var recs = userGrid.getSelectionModel().getSelection();
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
		// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【自定义函数】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	});