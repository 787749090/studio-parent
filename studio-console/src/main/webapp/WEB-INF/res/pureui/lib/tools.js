var sns={};

/**
 * 使用jQuery对content进行包裹，否则js相应引入或代码将失效
 */
art.fn.html = function(content){
	var elem = this[0];

	if (content === undefined) return elem.innerHTML;
    $.cleanData(elem.getElementsByTagName('*'));
    jQuery(elem).html(content);
    elem.innerHTML = content;
    
    return this;
}

/** 
 * 弹出框
 * @param {} title  	标题
 * @param {} content    内容
 * @param {} type	  	类型   error/
 */
sns.alert = function(title,content){ 
	art.dialog({
			  id: 'alert',
		    title: title,
		    content: content,
		    width: '18em',
		    height: '5em',
			  okValue: '确定',
		    ok: function () {
		        this.closed;
		    }
		});
}
sns.openWindow = function(title,content){
	var el = $('#'+content).html();
	art.dialog({
			id: 'window',
		    title: title,
		    content: el,
		    initialize: function () {
		        $(el).show();
		    },
			  okValue: '确定',
		    ok: function () {
		        this.closed;
		    },
		    cancelValue: '取消',
		    cancel: function () {}
		});
}
/**
* 传需要显示的窗体ID 或直接传显示的内容（内容可为HTML对象，也可以为HTML String） 
* 用法： sns.openPanel("showDivPanalId","title", "content");
*/
sns.openPanel = function(dialogId,title,el){
	var html = "";
	//非String类型直接取
	if(typeof(el) != "string"){
		html = el.html();
	}else{
		//20120727.1 By  Simon 先判断是不是ID。如果非ID则当做内容。
		//是否为HTML标签字符串 $(elem).html()==null 不是标签字符串
		var _e = document.getElementById(el);
		if( _e != undefined && _e != null ){
			html = $('#'+el).html();
		}else{
			html = el;
		}
	}
	return art.dialog({
			id: dialogId,
	    title: title,
	    content: html,
	    initialize: function () {
	    		if($(html)){
	        	$(html).show();
	      	}
	    }
	});
}
/**
 * @param {} content panel的内容,为字符串，如果非字符串，请在调用前转换为字符串
 * @param {} dialogId 要刷新的panel的Id
 */
sns.refreshPanel = function(dialogId,content){
	//自动去掉最外层的div
	//alert($(content).html());
	art.dialog.list[dialogId].content(content);
}
/**
 * 返回指定Id的dialog对象
 * @param {} dialogId 对话框id
 * @return {} dialog对象
 */
sns.getPanel = function(dialogId){
	return art.dialog.list[dialogId];
}
/**
 * 关闭指定弹出框
 * @param {} dialogId 弹出框Id
 * 20120824.1 By  Alfie 添加窗口id判断，解决null异常
 */
sns.closePanel = function(dialogId){
	if(art.dialog.list[dialogId]){
		art.dialog.list[dialogId].close();
	}
}
/**
 * 关闭当前页面所有弹出框
 */
sns.closeAllPanel = function(){
	var dialogs = art.dialog.list;
	for (var i in list) {
	    list[i].close();
	};
}

/**
 * 日期控件
 * @param {} formart  日期格式
 */
calendar = function(formart){
	WdatePicker({dateFmt:formart});
}
sns.calendar = function(){
	defaultDateFormat:'yyyy-MM-dd HH:mm:ss'
	return{
		/**
		 * el：表示当前元素
		 * format：日期格式，如果为空，则使用默认格式
		 */
		showCalendar : function(el,dateFormat){
			var format = dateFormat || this.defaultDateFormat;
			var input = $(el).parent().find(":input:first");
			WdatePicker({
				el : input[0],
				dateFmt : format
			});
		}
	}
}();

/**
20120909 
* 重置指定区域下拉控件内容 默认整个document， elemId区域不存在不做任何操作 
* elemId  :  指定区域
*/
sns.combox={};
sns.combox.reset = function(elemId){
	designated_area = $("#"+elemId);
	if(elemId==null||elemId==''){
			if(!designated_area){
				return false;
			}
			designated_area = $(document);
	}
	$("div[controltype=select]", designated_area).each(function(){
		var selectValueInput = $(this).find("input[type=text][inputtype=select_value]"); 
		var selectkeyInput = $(this).find("input[type=text][inputtype=select_key]"); 
		selectValueInput.val("");
		selectkeyInput.val("");
	});
}