Ext.onReady(function() {
			Ext.QuickTips.init();// 初始化提示;
			var loginForm = Ext.create('Ext.form.Panel', {
						title : '<h7 algin="center">大发管理系统</h7>',
						titleAlign : 'center',
						layout : {
							type : 'table',
							columns : 2
						},
						width : 400,
						frame : true,
						draggable : true,
						buttonAlign : 'left',
						style : 'border-bottom:0px;',
						bodyStyle : 'padding:10px;background-color:transparent;',
						fieldDefaults : {// 统一设置表单字段默认属性
							labelSeparator : '：',// 分隔符
							labelWidth : 70,// 标签宽度
							msgTarget : 'side',
							width : 230
						},
						renderTo : 'login',
						bodyPadding : 5,
						defaultType : 'textfield',// 设置表单字段的默认类型
						items : [{
									fieldLabel : '<b>账号<b>',
									id : 'loginName',
									name : 'loginName',
									blankText : "请输入账号",
									style : 'margin-left:5;',
									msgTarget : 'qtip',
									colspan : 2,
									allowBlank : false
								}, {
									fieldLabel : '<b>密码<b>',
									id : 'password',
									name : 'password',
									inputType : 'password',
									blankText : "请输入密码",
									msgTarget : 'qtip',
									colspan : 2,
									style : 'margin-left:5;',
									allowBlank : false
								}, {
									fieldLabel : '<b>验证码<b>',
									id : 'verificationCode',
									name : 'verificationCode',
									blankText : "请输入验证码",
									style : 'margin-left:5;',
									msgTarget : 'qtip',
									allowBlank : false
								}, {
									xtype : 'box', // 或者xtype:
									id : 'verificationCode_image',
									width : 70,
									height : 30,
									style : 'margin-left:5;',
									autoEl : {
										tag : 'img', // 指定为img标签
										alt : '看不清，点击更换图片',
										src : 'captchaImage/captchaImage' // 指定url路径
									}
								}, {
									xtype : 'checkboxgroup',
									itemCls : 'x-check-group-alt',
									colspan : 2,
									columns : 3,
									items : [{
												boxLabel : '记住账号',
												name : 'rememberAccount',
												listeners : {
													check : function() {
														if (!this.getValue()) {
															// var form =
															// login.loginFormPanel.getForm();
															// form.findField('autoLogin').setValue(false);
														}
													}
												}
											}, {
												boxLabel : '记住密码',
												name : 'rememberPassword',
												listeners : {
													check : function() {
														if (!this.getValue()) {
															// var form =
															// login.loginFormPanel.getForm();
															// form.findField('autoLogin').setValue(false);
														}
													}
												}
											}, {
												boxLabel : '自动登录',
												name : 'autoLogin',
												listeners : {
													check : function() {
														if (this.getValue()) {
															// var form =
															// login.loginFormPanel.getForm();
															// form.findField('rememberAccount').setValue(true);
															// form.findField('rememberPassword').setValue(true);
														}
													}
												}
											}]
								}],
						buttons : [{
									text : '登 陆',
									handler : login
								}, {
									text : '重 置',
									handler : function() {
										loginForm.getForm().reset();
									}
								}]
					});

			// 提交登陆表单
			function login() {
				if (Ext.isIE) {
					if (Ext.ieVersion < 8) {
						alert('你的浏览器版本过低');
						return;
					}
				}
				var password = loginForm.getForm().findField('password');
				password.setValue(Ext.MD5(password.value));
				loginForm.getForm().submit({
							clientValidation : true,// 进行客户端验证
							url : 'login',// 请求的url地址
							method : 'POST',// 请求方式
							submitEmptyText : false,
							success : function(form, action) {// 加载成功的处理函数
								location.href = 'page/index.jsp';
							},
							failure : function(form, action) {// 加载失败的处理函数
								alert(1234567890);
								Ext.Msg.alert('提示', '系统登陆失败，原因：'
												+ action.msg.result);
							}
						});
			}
		});