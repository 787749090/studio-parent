/**
 * <pre>
 * 版本号			修改人	修改说明
 * 20121220         Alfie   JS整理
 * 		
 * 		**************** 分页 *************************
 * 		
 * 		@method(param)     sns.selectTag.input.click 		下拉框单机事件  参数为当前事件对象
 * 		@method(param)     sns.selectTag.input.keyup 		下拉框按键监听事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.input.focusout 	下拉框焦点失去事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.list.li.click 		下拉列表元素事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.list.li.mouseover 	下拉列表鼠标移上事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.documentclick 		下拉列表单机时绑定文本单机事件 参数为当前事件对象 在sns.selectTag.input.click中调用
 * 		****************  ***************************
 *   	
 * 		@how_to_ues   
 * 					1.在<需要>的页面头部引入该JS  如："<script type='text/javascript' src='res/js/sns_tags.js'></script>"
 * </pre>
 */
/** 整个下拉控件*/
sns.pagebar = {
	/** 标识 div[controltype=select]*/
	tag:"div[controltype=pagination]",
	/** 分页条件参数收集*/
	params:{},
	/** URL 分页跳转请求URL*/
	URL:"",
	/** 分页加载结果内容显示面板 pagepanelId*/
	panel:"pagepanelId",
	/** 分页条件数据收集属性名称 queryCondition*/
	querycondition:"queryCondition",
	/** 分页条件数据收集Panel属性名称 queryConditionPanel*/
	queryConditionPanel:"queryConditionPanel",
	/** 是否正在请求中  false*/
	isRequesting : false,
	pageTotalTag : "div[divtype=pageTotal]",
	pageSizeTag : "div[divtype=pageSize]",
	pageNumberTag : "pageNumber",
	pageSizeTag : "pageSize"
	
};
/** 分页 下拉框(页大小)*/
sns.pagebar.select = {
	/** option*/
	option:"option",
	/** option:selected*/
	selected:"option:selected",
	/** select[selectType=pageSelect]*/
	tag : "select[selectType=pageSelect]"
};
/** 分页 按钮*/
sns.pagebar.btn = {
	/** 是否灰置属性名 disabled isdisabled*/
	disabled : "isdisabled",
	/** url跳转属性名*/
	apageurl : "apageurl"
};
/** 分页 首页按钮*/
sns.pagebar.btn.first = {
	/** TAG span[spantype=pageButtonSpan_load]*/
	tag : "a[icon=pagination-first]"

};
/** 分页 上一页*/
sns.pagebar.btn.prev = {};
/** 分页 跳转按钮*/
sns.pagebar.btn.go = {};
/** 分页 下一页*/
sns.pagebar.btn.next = {};
/** 分页 最后一页*/
sns.pagebar.btn.end = {};
/** 分页 刷新按钮*/
sns.pagebar.btn.refresh = {
	/** TAG a[icon=pagination-load]*/
	tag : "a[icon=pagination-load]"
};
/** 分页 页码输入框*/
sns.pagebar.input = {
	/** TAG input[inputtype=pagenumber]*/
	tag : "input[inputtype=pagenumber]"
};


//下拉列表项  鼠标移上样式控制
sns.pagebar.select.change = function(e){
	var refresh = $(e).parents(sns.pagebar.tag).find(sns.pagebar.btn.refresh.tag);
	sns.pagebar.btn.click(refresh,1);
}

sns.pagebar.btn.click = function(e,pageNumber){
	var btn = $(e);
	//按钮是否有禁用
	var disableAttr = btn.attr(sns.pagebar.btn.disabled);
	if(disableAttr=='isdisabled'){
		return false;
	}
	var pagebar = btn.parents(sns.pagebar.tag);
	var pageTotal = parseInt(pagebar.find(sns.pagebar.pageTotalTag).text());
	var conditionPanel = $("#"+pagebar.attr(sns.pagebar.queryConditionPanel));
	var querycondition = pagebar.attr(sns.pagebar.querycondition);
	if(null == pageNumber){
		var pageNumberInput = pagebar.find(sns.pagebar.input.tag);
		pageNumber = parseInt(pageNumberInput.val());
	}
	//输入页码不能小于1，大于最大页码
	if(pageNumber<1 || pageNumber>pageTotal){
		return false;
	}else{
		sns.pagebar.params[sns.pagebar.pageNumberTag]=pageNumber;
	}
	//数据收集
	sns.pagebar.collect(conditionPanel,querycondition);
	sns.pagebar.select.setSelectValue(pagebar);
	var pagepanel = $("#"+pagebar.attr(sns.pagebar.panel));
	if(!sns.pagebar.isRequesting){
		sns.pagebar.isRequesting = true;
		//加载按钮背景图片切换
		sns.pagebar.btn.refresh.pagerLoadBtnCut(pagebar,sns.pagebar.isRequesting);
		var url = btn.attr(sns.pagebar.btn.apageurl);
		$.post(url , sns.pagebar.params ,function(data){
			sns.pagebar.isRequesting = false;
			sns.pagebar.btn.refresh.pagerLoadBtnCut(pagebar,sns.pagebar.isRequesting);
			pagepanel.empty();
			$(data).appendTo(pagepanel);
		}, "html");
	}
}
/**
 * 收集页大小数据到 sns.pagebar.params
 * @param {} pagebar
 */
sns.pagebar.select.setSelectValue = function(pagebar){
	var pageSizeSelect = pagebar.find(sns.pagebar.select.tag);
	var pageSizeValue = parseInt(pageSizeSelect.val());
	if(pageSizeValue == null ){
			pageSizeValue = 10;
	}
	sns.pagebar.params[sns.pagebar.pageSizeTag]=pageSizeValue;
	
}

/** 
 * 查询数据收集 收集数据到 sns.pagebar.params
 * @param {Object} conditionPanel  条件所在的panel 控件
 * @param {String} querycondition  条件属性名称
 */
sns.pagebar.collect = function(conditionPanel,querycondition){
	$("input[querycondition="+querycondition+"]",conditionPanel).each(function(){
		var name = $(this).attr("name");
		var value = $(this).val();
		sns.pagebar.params[name]=value;
	});
}
//加载按钮背景图片切换
sns.pagebar.btn.refresh.pagerLoadBtnCut = function(pagebar,isRequesting){
	var loadBtn = pagebar.find("span[spantype=pageButtonSpan_load]");
	loadBtn.removeClass();
	if(isRequesting){
		loadBtn.addClass("l-btn-empty pagination-loading");
	}else{
		loadBtn.addClass("l-btn-empty pagination-load");
	}
}