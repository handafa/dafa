Ext.onReady(function() {
	Ext.QuickTips.init();
	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【页面初始】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	var node = '';
	var nodeName = '';
	// 创建数据模型
	Ext.regModel("Group", {
				fields : [{
							name : 'id'
						}, {
							name : 'groupName'
						}, {
							name : 'weight'
						}, {
							name : 'note'
						}, {
							name : 'fatherNode'
						}]
			});
	// 定义树形菜单
	var treeStore = Ext.create('Ext.data.TreeStore', {
				autoLoad : true,
				proxy : {
					type : 'ajax',
					url : 'group/treeGroups'
				},

				root : {
					text : '组织目录',
					expanded : true,
					id : '-1'
				}
			});

	// 创建树形组织区
	var treePanel = new Ext.tree.Panel({
				store : treeStore,
				frame : true,
				title : '组织目录',
				viewConfig : {
					plugins : {
						ptype : 'treeviewdragdrop'
					}
				},
				rootVisible : true,
				renderTo : 'tree',
				width : 250,
				height : 500,
				lines : true,
				useArrows : true,
				dockedItems : [{
							xtype : 'toolbar',
							items : [{
										text : '展开',
										iconCls : 'open',
										handler : function() {
											treePanel.expandAll();
										}
									}, {
										text : '收缩',
										iconCls : 'close',
										handler : function() {
											treePanel.collapseAll();
										}
									}, {
										text : '刷新',
										iconCls : 'refresh',
										handler : function() {
											treeStore.load();
											treePanel.expandAll();
										}
									}]
						}],
				listeners : {
					load : function() {
						treePanel.expandAll();
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
					loadForm();
					sureBtn.setDisabled(true);
				}

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
			}];

	// 组织树形结构
	var groupitem = new Ext.ux.TreeGroupComboBox({
				labelSeparator : ":",
				labelWidth : 70,
				width : 220,
				fieldLabel : '所属组织',
				style : 'margin-top:10;margin-left:10',
				id : 'fatherNode',
				name : 'fatherNode',
				emptyText : '请选择父节点',
				allowBlank : false,
				msgTarget : 'qtip',
				emptyText : '请选择父节点'
			});

	var sureBtn = new Ext.Button({
				text : '确定',
				disabled : true,
				handler : submitForm
			});
	// 表单
	var groupForm = new Ext.form.FormPanel({
				defaults : {
					labelSeparator : ":",
					labelWidth : 70,
					width : 220
				},
				// floating : true,
				autoScroll : false,
				layout : {
					type : 'table',
					columns : 3
				},
				tbar : toolBar,
				height : 300,
				frame : true,
				renderTo : 'content',
				title : '组织详情',
				items : [{
							xtype : 'textfield',
							id : 'groupName',
							style : 'margin-top:10',
							name : 'groupName',
							fieldLabel : '组织名称',
							allowBlank : false,
							blankText : "组织名称不能为空",
							msgTarget : "qtip",
							emptyText : '请输入组织名称'
						}, {
							xtype : 'numberfield',
							allowBlank : true,
							style : 'margin-top:10;margin-left:10',
							id : 'weight',
							name : 'weight',
							minValue : 1,
							value : 1,
							fieldLabel : '组织顺序'
						}, groupitem, {
							style : 'margin-top:10;',
							xtype : 'textarea',
							id : 'note',
							cosplan : 2,
							width : 300,
							name : 'note',
							fieldLabel : '备注信息',
							emptyText : '请输入备注信息'
						}, {
							xtype : 'hidden',
							id : 'id',
							name : 'id'
						}],
				buttons : [sureBtn, {
							text : '重置',
							handler : function() {
								groupForm.getForm().reset();
								node = '';// 初始化
							}
						}, '->'],
				buttonAlign : 'left'
			});
	// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【页面初始】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

	// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【自定义函数】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼

	// 新增准备
	function showAdd() {
		groupForm.getForm().reset();
		sureBtn.setDisabled(false);
		groupForm.isAdd = true;
		groupitem.setLocalValue(nodeName, node);
	}

	// 修改准备
	function showModify() {
		if (node == '') {
			Ext.Msg.alert('提示', '<h5 align="center">请选择要修改的菜单</h5>');
		}
		sureBtn.setDisabled(false);
		groupForm.isAdd = false;
	}

	// 加载表单数据
	function loadForm() {
		groupForm.getForm().load({
			waitMsg : '正在加载数据请稍后',// 提示信息
			waitTitle : '提示',// 标题
			url : 'group/select', // 请求的url地址
			params : {
				id : node
			},
			method : 'GET',// 请求方式
			success : function(form, action) {
				// groupitem.setLocalValue( , );
				groupitem.setLocalValue(action.result.data.fatherName,
						action.result.data.fatherNode);
			},
			failure : function(form, action) {// 加载失败的处理函数
				Ext.Msg.alert('提示', '数据加载失败');
			}
		});
	}

	// 删除准备
	function showDelete() {
		if (node == '') {
			return;
		}
		Ext.MessageBox.confirm("提示", "确定删除组织:【" + nodeName + "】?",
				function(id) {
					if (id == 'yes') {
						deleteChecked();
					} else {
						return;
					}
				});

	}

	// 删除
	function deleteChecked() {
		var msgTip = Ext.MessageBox.show({
					title : '提示',
					width : 250,
					msg : '<h5 align="center">正在删除组织信息请稍后......</h5>'
				});
		Ext.Ajax.request({
					url : 'group/delete',
					params : {
						id : node
					},
					method : 'GET',
					success : function(form, action) {
						msgTip.close();
						node = '';
						treeStore.load();
						groupForm.getForm().reset();
						Ext.Msg.alert('提示', '<h5 align="center">'
										+ action.result.msg + '</h5>');

					},
					failure : function(form, action) {
						msgTip.close();
						node = '';
						Ext.Msg.alert('提示', '<h5 align="center">'
										+ action.result.msg + '</h5>');
					}
				});
	}

	// 提交表单
	function submitForm() {
		if (groupForm.isAdd) {
			groupForm.getForm().submit({
				clientValidation : true,// 进行客户端验证
				waitMsg : '正在提交数据请稍后',// 提示信息
				waitTitle : '提示',// 标题
				method : 'POST',// 请求方式
				url : 'group/save',// 请求的url地址
				submitEmptyText : false,
				success : function(form, action) {
					// 加载成功的处理函数
					node = '';
					groupForm.getForm().reset();
					treeStore.load();
					sureBtn.setDisabled(true);
					Ext.Msg.alert('提示', "<h5 align='center'>"
									+ action.result.msg + "</h5>");
				},
				failure : function(form, action) {
					// 加载失败的处理函数
					// node = '';
					Ext.Msg.alert('提示', "<h5 align='center'>"
									+ action.result.msg + "</h5>");
				}
			});
		} else {
			groupForm.getForm().submit({
				clientValidation : true,// 进行客户端验证
				waitMsg : '<h5 align="center">正在提交数据请稍后</h5>',// 提示信息
				waitTitle : '提示',// 标题
				method : 'POST',// 请求方式
				url : 'group/modify',// 请求的url地址
				submitEmptyText : false,
				success : function(form, action) {
					// 加载成功的处理函数
					node = '';
					treeStore.load();
					groupForm.getForm().reset();
					sureBtn.setDisabled(true);
					Ext.Msg.alert('提示', '<h5 align="center">'
									+ action.result.msg + '</h5>');
				},
				failure : function(form, action) {
					// 加载失败的处理函数
					// node = '';
					Ext.Msg.alert('提示', '<h5 align="center">'
									+ action.result.msg + '</h5>');
				}
			});
		}

	}

		// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【自定义函数】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	});