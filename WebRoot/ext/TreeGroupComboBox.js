/**
 * @author 韩大发
 * @description 下拉树
 * @time 2013-1-11 下午2:02:46
 */
Ext.define('keel.TreeGroupComboBox', {
			extend : 'Ext.form.field.ComboBox',
			alias : 'widget.dafagroupcombo',
			alternateClassName : 'Ext.ux.TreeGroupComboBox',
			store : new Ext.data.ArrayStore({
						fields : [],
						data : [[]]
					}),
			editable : false,
			listConfig : {
				// resizable : true,
				minWidth : 100,
				maxWidth : 350
			},
			_idValue : null,
			_txtValue : null,
			treeObj : new Ext.tree.Panel({
						border : false,
						height : 250,
						width : 350,
						autoScroll : true,
						rootVisible : false,
						// animate : true,
						frame : true,
						lines : true,
						// shadow : true,
						store : Ext.create('Ext.data.TreeStore', {
									fields : ['id', 'text', 'leaf', 'cls'],
									autoLoad : true,
									proxy : {
										type : 'ajax',
										url : 'group/treeGroups'
									},
									root : {
										id : '-1',
										text : '组织目录',
										expanded : true
									},
									rootVisible : false
								}),
						listeners : {
							load : function() {
								treeObj.expandAll();
							},
							click : function() {
								treeObj.expandAll();
							}
						}

					}),
			initComponent : function() {
				this.treeRenderId = Ext.id();
				this.tpl = "<tpl><div id='" + this.treeRenderId
						+ "'></div></tpl>";
				this.callParent(arguments);
				this.on({
							'expand' : function() {
								if (!this.treeObj.rendered && this.treeObj
										&& !this.readOnly) {
									Ext.defer(function() {
												this.treeObj
														.render(this.treeRenderId);
											}, 300, this);
								}
							}
						});
				this.treeObj.on('itemclick', function(view, rec) {
							if (rec) {
								// if (rec.get('leaf')) {
								// 表示只有是叶子节点才能被选中
								this.setValue(this._txtValue = rec.get('text'));
								this._idValue = rec.get('id');
								this.collapse();
								// } else {
								// return;
								// }
							}
						}, this);
			},
			getValue : function() {// 获取id值
				return this._idValue;
			},
			getTextValue : function() {// 获取text值
				return this._txtValue;
			},
			setLocalValue : function(txt, id) {// 设值
				this._idValue = id;
				this.setValue(this._txtValue = txt);
			}
		});