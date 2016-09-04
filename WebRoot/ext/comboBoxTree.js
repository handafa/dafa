/**
 * @author 韩大发
 * @version v1.0
 * @description 下拉框树形结构
 */
Ext.define("Ext.ux.comboboxtree", {
			extend : "Ext.form.field.Picker",
			requires : ["Ext.tree.Panel"],
			initComponent : function() {
				var self = this;
				Ext.apply(self, {
							fieldLabel : self.fieldLabel,
							labelWidth : self.labelWidth
						});
				self.callParent();
			},
			createPicker : function() {
				var self = this;
				var store = Ext.create('Ext.data.TreeStore', {
							autoLoad : true,
							proxy : {
								type : 'ajax',
								url : self.storeUrl
							},
							root : {
								id : '-1',
								text : '组织目录',
								expanded : true
							}
						});

				self.picker = new Ext.tree.Panel({
							height : 270,
							width : 220,
							autoScroll : true,
							lines : true,
							useArrows : true,
							floating : true,
							focusOnToFront : false,
							shadow : true,
							ownerCt : this.ownerCt,
							useArrows : true,
							store : store,
							rootVisible : false,
							listeners : {
								load : function() {
									self.picker.expandAll();
								}
							}
						});

				if (self.checkboxFlag) {
					// 复选框的情况下
					self.picker.on({
								checkchange : function() {
									var records = self.picker.getChecked();
									var names = [];
									var values = [];

									Ext.Array.each(records, function(rec) {
												names.push(rec.get('text'));
												values.push(rec.get('id'));
											});
									self.setRawValue(values.join(';'));// 隐藏值
									self.setValue(names.join(';'));// 显示值
								}
							});
				} else {
					// 单选框的请款下
					self.picker.on({
								checkchange : function() {
									// var records = self.picker.getView()
									// .getChecked();
									var records = self.picker.getChecked();
									if (records.length > 1) {
										Ext.Msg.alert('提示', '一次只能选择一个组织');
										return;
									}
									var names = [];
									var values = [];
									Ext.Array.each(records, function(rec) {
												names.push(rec.get('text'));
												values.push(rec.get('id'));
											});
									self.setRawValue(values.join(';'));// 隐藏值
									self.setValue(names.join(';'));// 显示值
								}
							});
				}

				return self.picker;
			},
			alignPicker : function() {
				var me = this, picker, isAbove, aboveSfx = '-above';
				if (this.isExpanded) {
					picker = me.getPicker();
					if (me.matchFieldWidth) {
						picker.setWidth(me.bodyEl.getWidth());
					}
					if (picker.isFloating()) {
						picker.alignTo(me.inputEl, "", me.pickerOffset);// ""->tl
						isAbove = picker.el.getY() < me.inputEl.getY();
						me.bodyEl[isAbove ? 'addCls' : 'removeCls'](me.openCls
								+ aboveSfx);
						picker.el[isAbove ? 'addCls' : 'removeCls'](picker.baseCls
								+ aboveSfx);
					}
				}
			}
		});

// ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼【调用例子】▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
// Ext.onReady(function() {
// var com = Ext.create("Ext.ux.comboboxtree", {
// id : 'name',
// name : 'name',
// storeUrl : Resource.regionNodesUrl,
// width : 270,
// fieldLabel : '行政区划',
// labelWidth : 60,
// rootId : '44000000000000',
// rootText : '广东省',
// renderTo : 'tree-div'
// });
// });
// ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲【调用例子】▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
