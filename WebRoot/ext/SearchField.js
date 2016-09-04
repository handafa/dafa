/**
 * @author Seven
 * @time 2013-01-14
 * @summary 查询框
 */
Ext.define('Ext.ux.form.SearchField', {
	extend : 'Ext.form.field.Trigger',

	alias : 'widget.searchfield',

	trigger1Cls : Ext.baseCSSPrefix + 'form-clear-trigger',

	trigger2Cls : Ext.baseCSSPrefix + 'form-search-trigger',

	hasSearch : false,
	paramName : 'query',

	initComponent : function() {
		this.callParent(arguments);
		this.on('specialkey', function(f, e) {
			if (e.getKey() == e.ENTER) {
				this.onTrigger2Click();
			}
		}, this);
	},

	afterRender : function() {
		this.callParent();
		this.triggerEl.item(0).setDisplayed('none');
	},

	onTrigger1Click : function() {
		var me = this, store = me.store, proxy = store.getProxy(), val;

		if (me.hasSearch) {
			me.setValue('');
			proxy.extraParams[me.paramName] = '';
			// 为修复查询之后 点击分页start字段一直为0的bug modify by ** at 2012-05-29
			// proxy.extraParams.start = 0;
			// store.load();
			store.loadPage(1); // 跳转到第1页
			me.hasSearch = false;
			me.triggerEl.item(0).setDisplayed('none');
			me.doComponentLayout();
		}
	},

	onTrigger2Click : function() {
		var me = this, store = me.store, proxy = store.getProxy(), value = me
				.getValue();

		if (value.length < 1) {
			me.onTrigger1Click();
			return;
		}
		proxy.extraParams[me.paramName] = value;
		// 为修复查询之后 点击分页start字段一直为0的bug modify by ** at 2012-05-29
		// proxy.extraParams.start = 0;
		// store.load();
		store.loadPage(1); // 跳转到第1页
		me.hasSearch = true;
		me.triggerEl.item(0).setDisplayed('block');
		me.doComponentLayout();
	}
});