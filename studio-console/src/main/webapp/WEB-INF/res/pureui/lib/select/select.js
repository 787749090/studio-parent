/**
 * <pre>
 * 版本号			修改人	修改说明
 * 20121220         Alfie   JS整理
 * 		@explain           sns在tools.js定义  tools.js一般在common JSP中引入
 * 		**************** 下拉框 *************************
 * 		
 * 		@method(param)     sns.selectTag.input.click 		下拉框单机事件  参数为当前事件对象
 * 		@method(param)     sns.selectTag.input.keyup 		下拉框按键监听事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.input.focusout 	下拉框焦点失去事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.list.li.click 		下拉列表元素事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.list.li.mouseover 	下拉列表鼠标移上事件 参数为当前事件对象
 * 		@method(param)     sns.selectTag.documentclick 		下拉列表单机时绑定文本单机事件 参数为当前事件对象 在sns.selectTag.input.click中调用
 * 		**************** 分页 312行开始 ***************************
 *   	
 * 		@how_to_ues   
 * 					1.在<需要>的页面头部引入该JS  如："<script type='text/javascript' src='res/js/sns_tags.js'></script>"
 * </pre>
 */
 /***
  *  定义基本元素类型  及类型的一些基础属性
  */
//整个下拉控件
sns.selectTag = {
	/** 标识 div[controltype=select]*/
	tag:"div[controltype=select]",
	querycondition:"querycondition"
};   
//输入框
sns.selectTag.input = {
	/** 标识 input[type=text][inputtype=select_value]*/
	tag:"input[type=text][inputtype=select_value]"
};  
//下拉列表
sns.selectTag.list = {
	/** 标识 div[divtype=select_list]*/
	tag:"div[divtype=select_list]",
	/** 当前被选择的列表序号*/
	index:0,
	/** 默认显示长度 4*/
	defaultVisibleSize:4
}; 
//下拉列表元素
sns.selectTag.list.li = {
	/** litype*/
	litype:"litype",
	/** select_li*/
	litypevalue:"select_li",
	/** select_li_on*/
	litypeOnvalue:"select_li_on",
	/** sel_con_on*/
	onclass:"sel_con_on",
	/** sel_con_li*/
	normalclass:"sel_con_li",
	/**下拉列表元素高度 25*/
	height:25
}; 
//焦点下拉列表元素
sns.selectTag.list.li.on = {
	/** 标识 li[litype=select_li_on]*/
	tag:"li[litype=select_li_on]"
}
/****************事件定义**********************/
/**
 * 下拉框单击事件   打开或者关闭下拉框，同时指定scrollbar的位置
 * @param {} c
 */
sns.selectTag.input.click = function(e){
	
	var allSelectCon =$(document).find(sns.selectTag.list.tag);
	for(var i=0;i<allSelectCon.length;i++){
		var con = $(allSelectCon[i]);
		con.parents(sns.selectTag.tag).css("z-index",1);
		con.hide();
	}
	
	var selectTag = $(e).parents(sns.selectTag.tag); 
	var selectCon = selectTag.find(sns.selectTag.list.tag);
	//20120904 update by Alfie 只读状态不能进行任何操作
	var selectValueInput = selectTag.find(sns.selectTag.input.tag);
	if(selectValueInput.attr("readonly")=="readonly"){
		//20121114 update by Alfie 改成return true，类似continue关键字，保证不会在each循环中重复绑定事件
		return true;
	}
	 var items = selectCon.find("li");
	 //如果下拉输入框为空，默认所有下来值都属于显示的状态
	if(selectValueInput.val()==''){
		 for(var i=0;i<items.length;i++){
	    	items.eq(i).show();
	    }
	}
	selectTag.css("z-index",1000);
    selectCon.toggle();
    //scrollbar 的设置
	//小于默认值的时候  控制下拉列表的高度
   
    var selectConHeight = 0;
   
  /*  alert(items.length +" items.length");
    alert(sns.selectTag.list.defaultVisibleSize +" sns.selectTag.list.defaultVisibleSize");*/
    for(var i=0;i<items.length && i<5;i++){
		var item = items.eq(i);
		if(item.is(":visible")){
	    	selectConHeight = selectConHeight + sns.selectTag.list.li.height;
	    }
	}
	if( selectConHeight>0){
		selectCon.height(parseInt(selectConHeight+1));//增量3，刚好撑满还是会出现滚动条
	}else{
		selectCon.hide();
	}
    var index = sns.selectTag.input.getOnIndex(items);
    if(index>0){
    	selectCon.scrollTop(index*sns.selectTag.list.li.height);
    }
    //隐藏时
	if(selectCon.is(":visible")){
		//初始化点击方法
    	sns.selectTag.documentclick(selectTag);
    	return false;
    }
    return false;
}
/**
 * scrollbar 位置
 * @param {} tagLiItems
 * @return {}
 */
sns.selectTag.input.getOnIndex = function(tagLiItems){
	var index = 0;
    for(var i=0;i<tagLiItems.length;i++){
    	var liTag = tagLiItems.eq(i);
    	//当前被选择的下拉列表
    	if(liTag.attr(sns.selectTag.list.li.litype).indexOf(sns.selectTag.list.li.litypeOnvalue)>=0){
    		index = i;
    		//sns.selectTag.list.li.height = liTag.height();
    	}
    }
    return index;
}
/**
 * 下拉输入框  上下及回车按键事件
 * @param {} c
 */
sns.selectTag.input.keyup = function(event,e){
	
	var selectTag = $(e).parents(sns.selectTag.tag); 
	var selectCon = selectTag.find(sns.selectTag.list.tag);
	var selectValueInput = $(e);
	if(selectValueInput.attr("readonly")=="readonly"){
		//20121114 update by Alfie 改成return true，类似continue关键字，保证不会在each循环中重复绑定事件
		return true;
	}
	var keypressnow = event.keyCode; 
	//keycode   13 = Enter keycode   38 = Up keycode   40 = Down
  	var height = 0;
  	//下拉框显示高度  小于4
  	var selectConHeight = 0;
  	//所有的li对象
   	var li = selectCon.find("li");
	
	if(keypressnow==38 || keypressnow ==40){
		//只获取当前显示的li
		var showli = selectCon.find("li:visible");
		var index = 0;
		//单击向下按键，显示下拉框
		if(keypressnow==40 && !selectCon.is(":visible")){
			selectValueInput.trigger("click");
			return;
		}
		//先获取当前位置
	    for(var i=0;i<showli.length;i++){
	    	var liTag = $(showli.eq(i));
	    	if(liTag.attr(sns.selectTag.list.li.litype).indexOf("select_li_on")>=0){
	    		index = i;
	    		height = liTag.height();
	    		break;
	    	}
	    }
	    //根据按键 改变当前位置
	    if(keypressnow==38){
	    	if(index>0){
	    		index--;
	    	}
	    }else if(keypressnow==40){
	    	if(index<showli.length-1){
	    		index++;
	    	}
	    }
	    //当前可能部分显示的情况下 需要从全部的下拉列表中找到当前选择下拉值，然后设置index
	    var linow = showli.eq(index);
	    for(var i=0;i<li.length;i++){
	    	var liitem = li.eq(i);
	    	if(liitem.html()==linow.html()){
	    		sns.selectTag.list.index = i;
	    		selectValueInput.val(liitem.text());
				selectValueInput.next().val(liitem.children().eq(0).val());
	    		break;
	    	}
	    }
	    sns.selectTag.list.li.mouseover(linow);
		if(index>0){
		  	selectCon.scrollTop((index-1)*height);
		}else{
			selectCon.scrollTop(index*height);
		}
		//设置下拉框打开高度
		if(showli.length>0){
			selectCon.height(parseInt(showli.length*sns.selectTag.list.li.height+1));
		}else{
			selectCon.hide();
		}
	}else if(keypressnow==13){
		sns.selectTag.validateValue(selectValueInput,li);
		selectCon.hide();
		selectTag.css("z-index",1);
	}else{
		//20120909 add by alfie下拉框过滤 增加对拼音的支持 
		var thisVal = selectValueInput.val().toLowerCase();
		for(var i=0;i<li.length;i++){
			var item = li.eq(i);
			var itemPy = sns.selectTag.toPinyinShengmu(item.text()).toLowerCase();
			if(itemPy.indexOf(thisVal)!=0){
				item.hide();
				selectConHeight =selectConHeight - li.height;
			}else{
				item.show();
				selectConHeight =selectConHeight +li.height;
			}
		}
		if(selectConHeight && selectConHeight>0){
			selectCon.height(parseInt(selectConHeight+1));
		}else{
			selectCon.hide();
		}
	}
}

/**
 * 下拉输入框  焦点失去事件  关闭下拉列表
 * @param {} c
 */
sns.selectTag.input.focusout = function(e){
	var selectTag = $(e).parents(sns.selectTag.tag); 
	var selectCon = selectTag.find(sns.selectTag.list.tag);	
	var selectValueInput = selectTag.find(sns.selectTag.input.tag);
	var selectItems = selectCon.find("li");
	if(selectItems.length<1){
		selectValueInput.val("");
		selectValueInput.next().val("");
	}
	//不能调用 sns.selectTag.validateValue方法，触发click事件将会冲突
	var isTrick = false;
	var selectTextValueNow = selectValueInput.val();
	for(var i=0;i<selectItems.length;i++){
			var item = selectItems.eq(i);
			//20130317 update by Hugo 修改 手动删空input中的值时,value的值没清空 问题
			if(item.text()==selectTextValueNow & selectTextValueNow!=''){
				selectTextValue=item.text();
				selectKeyValue=item.children().eq(0).val();
				isTrick = true;
				break;
			}
		}
		//没有触发，及没有在下拉列表里面找到匹配项 那么清空值
		if(!isTrick){
			selectValueInput.val('');
			selectValueInput.next().val('');
		}
	if(selectCon.is(":visible")){
    	sns.selectTag.documentclick(selectTag);
		return false;
    }
    return false;
}
/**
 *下拉框值验证，如果值在下拉列表中有匹配，那么设置匹配值，否则清空
 */
sns.selectTag.validateValue = function(selectValueInput,itemList){
		var selectTextValueNow = selectValueInput.val();
		//如果输入的value值存在，那么设置，否则清空
		var isTrick = false;
		for(var i=0;i<itemList.length;i++){
			var item = itemList.eq(i);
			//20130317 update by Hugo 修改 手动删空input中的值时,value的值没清空 问题
			if(item.text()==selectTextValueNow & selectTextValueNow!=''){
				item.trigger("click");
				isTrick = true;
				break;
			}
		}
		//没有触发，及没有在下拉列表里面找到匹配项 那么清空值
		if(!isTrick){
			selectValueInput.val('');
			selectValueInput.next().val('');
		}
}
/**
 * 下拉列表中 单击每一个下拉元素事件   设置下拉框的值同时关闭下拉列表
 * @param {} c
 */
sns.selectTag.list.li.click = function(e,callbackFunction){
	var li = $(e);
	var selectTag = li.parents(sns.selectTag.tag); 
	var selectValueInput = selectTag.find(sns.selectTag.input.tag);
	var selectCon = selectTag.find(sns.selectTag.list.tag);	
	selectValueInput.val(li.text());
	selectValueInput.next().val(li.children().eq(0).val());
	selectCon.hide();
    selectTag.css("z-index",1);
    if(callbackFunction){
    	//执行回调方法
    	callbackFunction(selectValueInput.attr(sns.selectTag.querycondition));
    }
    return false;
}

//下拉列表项  鼠标移上样式控制
sns.selectTag.list.li.mouseover = function(e){
	var li = $(e);
	var selectList = li.parents(sns.selectTag.list.tag); 
    var emenon = selectList.find(sns.selectTag.list.li.on.tag);
    emenon.attr(sns.selectTag.list.li.litype,sns.selectTag.list.li.litypevalue);
	emenon.removeClass(sns.selectTag.list.li.onclass);
	emenon.addClass(sns.selectTag.list.li.normalclass);
	li.removeClass(sns.selectTag.list.li.normalclass);
	li.addClass(sns.selectTag.list.li.onclass);
	li.attr(sns.selectTag.list.li.litype,sns.selectTag.list.li.litypeOnvalue);
}
 //文本其它处点击事件  关闭下拉列表
sns.selectTag.documentclick = function(selectTag){
	$(document).click(function(e){
		var selectCon = selectTag.find(sns.selectTag.list.tag);	
		var clickElemParentSelectTag = $(e.target).parents(sns.selectTag.tag);
		if(clickElemParentSelectTag.html() ==null){
			selectCon.hide();
	    	selectTag.css("z-index",1);
			$(this).unbind();
	    	return false;
		}
	});
}

/****************  SELECT 其它支撑方法******************/
sns.selectTag.spellArray = {}; 
sns.selectTag.pinyin = function(char) { 
	if (!char.charCodeAt(0) ||char.charCodeAt(0) < 1328) return char; 
	if (sns.selectTag.spellArray[char.charCodeAt(0)]) return sns.selectTag.spellArray[char.charCodeAt(0)] 
	execScript("ascCode=hex(asc(\""+char+"\"))", "vbscript") 
	ascCode = eval("0x"+ascCode) 
	if (!(ascCode>0xB0A0 && ascCode<0xD7FC)) return char; 
	for (var i=ascCode; (!sns.selectTag.spell[i] && i>0);) i-- 
		return sns.selectTag.spell[i] 
	} 
sns.selectTag.toPinyinShengmu = function(str) { 
	var pStr = "" 
	for (var i=0; i<str.length; i++) { 
		if (str.charAt(i) == "\n") pStr += ""; 
		else pStr += sns.selectTag.pinyin(str.charAt(i)).charAt(0) ; 
	} 
	return pStr 
}

//20120909 add by alfie增加对拼音的支持  start*******************************
sns.selectTag.spell = {0xB0A1:"a", 0xB0A3:"ai", 0xB0B0:"an", 0xB0B9:"ang", 0xB0BC:"ao", 0xB0C5:"ba", 0xB0D7:"bai", 
0xB0DF:"ban", 0xB0EE:"bang", 0xB0FA:"bao", 0xB1AD:"bei", 0xB1BC:"ben", 0xB1C0:"beng", 0xB1C6:"bi", 0xB1DE:"bian", 
0xB1EA:"biao", 0xB1EE:"bie", 0xB1F2:"bin", 0xB1F8:"bing", 0xB2A3:"bo", 0xB2B8:"bu", 0xB2C1:"ca", 0xB2C2:"cai", 
0xB2CD:"can", 0xB2D4:"cang", 0xB2D9:"cao", 0xB2DE:"ce", 0xB2E3:"ceng", 0xB2E5:"cha", 0xB2F0:"chai", 0xB2F3:"chan", 
0xB2FD:"chang", 0xB3AC:"chao", 0xB3B5:"che", 0xB3BB:"chen", 0xB3C5:"cheng", 0xB3D4:"chi", 0xB3E4:"chong", 
0xB3E9:"chou", 0xB3F5:"chu", 0xB4A7:"chuai", 0xB4A8:"chuan", 0xB4AF:"chuang", 0xB4B5:"chui", 0xB4BA:"chun", 
0xB4C1:"chuo", 0xB4C3:"ci", 0xB4CF:"cong", 0xB4D5:"cou", 0xB4D6:"cu", 0xB4DA:"cuan", 0xB4DD:"cui", 0xB4E5:"cun", 
0xB4E8:"cuo", 0xB4EE:"da", 0xB4F4:"dai", 0xB5A2:"dan", 0xB5B1:"dang", 0xB5B6:"dao", 0xB5C2:"de", 0xB5C5:"deng", 
0xB5CC:"di", 0xB5DF:"dian", 0xB5EF:"diao", 0xB5F8:"die", 0xB6A1:"ding", 0xB6AA:"diu", 0xB6AB:"dong", 0xB6B5:"dou", 
0xB6BC:"du", 0xB6CB:"duan", 0xB6D1:"dui", 0xB6D5:"dun", 0xB6DE:"duo", 0xB6EA:"e", 0xB6F7:"en", 0xB6F8:"er", 0xB7A2:"fa", 
0xB7AA:"fan", 0xB7BB:"fang", 0xB7C6:"fei", 0xB7D2:"fen", 0xB7E1:"feng", 0xB7F0:"fo", 0xB7F1:"fou", 0xB7F2:"fu", 
0xB8C1:"ga", 0xB8C3:"gai", 0xB8C9:"gan", 0xB8D4:"gang", 0xB8DD:"gao", 0xB8E7:"ge", 0xB8F8:"gei", 0xB8F9:"gen", 
0xB8FB:"geng", 0xB9A4:"gong", 0xB9B3:"gou", 0xB9BC:"gu", 0xB9CE:"gua", 0xB9D4:"guai", 0xB9D7:"guan", 0xB9E2:"guang", 
0xB9E5:"gui", 0xB9F5:"gun", 0xB9F8:"guo", 0xB9FE:"ha", 0xBAA1:"hai", 0xBAA8:"han", 0xBABB:"hang", 0xBABE:"hao", 
0xBAC7:"he", 0xBAD9:"hei", 0xBADB:"hen", 0xBADF:"heng", 0xBAE4:"hong", 0xBAED:"hou", 0xBAF4:"hu", 0xBBA8:"hua", 
0xBBB1:"huai", 0xBBB6:"huan", 0xBBC4:"huang", 0xBBD2:"hui", 0xBBE7:"hun", 0xBBED:"huo", 0xBBF7:"ji", 0xBCCE:"jia", 
0xBCDF:"jian", 0xBDA9:"jiang", 0xBDB6:"jiao", 0xBDD2:"jie", 0xBDED:"jin", 0xBEA3:"jing", 0xBEBC:"jiong", 0xBEBE:"jiu", 
0xBECF:"ju", 0xBEE8:"juan", 0xBEEF:"jue", 0xBEF9:"jun", 0xBFA6:"ka", 0xBFAA:"kai", 0xBFAF:"kan", 0xBFB5:"kang", 
0xBFBC:"kao", 0xBFC0:"ke", 0xBFCF:"ken", 0xBFD3:"keng", 0xBFD5:"kong", 0xBFD9:"kou", 0xBFDD:"ku", 0xBFE4:"kua", 
0xBFE9:"kuai", 0xBFED:"kuan", 0xBFEF:"kuang", 0xBFF7:"kui", 0xC0A4:"kun", 0xC0A8:"kuo", 0xC0AC:"la", 0xC0B3:"lai", 
0xC0B6:"lan", 0xC0C5:"lang", 0xC0CC:"lao", 0xC0D5:"le", 0xC0D7:"lei", 0xC0E2:"leng", 0xC0E5:"li", 0xC1A9:"lia", 
0xC1AA:"lian", 0xC1B8:"liang", 0xC1C3:"liao", 0xC1D0:"lie", 0xC1D5:"lin", 0xC1E1:"ling", 0xC1EF:"liu", 0xC1FA:"long", 
0xC2A5:"lou", 0xC2AB:"lu", 0xC2BF:"lv", 0xC2CD:"luan", 0xC2D3:"lue", 0xC2D5:"lun", 0xC2DC:"luo", 0xC2E8:"ma", 
0xC2F1:"mai", 0xC2F7:"man", 0xC3A2:"mang", 0xC3A8:"mao", 0xC3B4:"me", 0xC3B5:"mei", 0xC3C5:"men", 0xC3C8:"meng", 
0xC3D0:"mi", 0xC3DE:"mian", 0xC3E7:"miao", 0xC3EF:"mie", 0xC3F1:"min", 0xC3F7:"ming", 0xC3FD:"miu", 0xC3FE:"mo", 
0xC4B1:"mou", 0xC4B4:"mu", 0xC4C3:"na", 0xC4CA:"nai", 0xC4CF:"nan", 0xC4D2:"nang", 0xC4D3:"nao", 0xC4D8:"ne", 0xC4D9:"nei", 
0xC4DB:"nen", 0xC4DC:"neng", 0xC4DD:"ni", 0xC4E8:"nian", 0xC4EF:"niang", 0xC4F1:"niao", 0xC4F3:"nie", 0xC4FA:"nin", 0xC4FB:"ning", 
0xC5A3:"niu", 0xC5A7:"nong", 0xC5AB:"nu", 0xC5AE:"nv", 0xC5AF:"nuan", 0xC5B0:"nue", 0xC5B2:"nuo", 0xC5B6:"o", 0xC5B7:"ou", 
0xC5BE:"pa", 0xC5C4:"pai", 0xC5CA:"pan", 0xC5D2:"pang", 0xC5D7:"pao", 0xC5DE:"pei", 0xC5E7:"pen", 0xC5E9:"peng", 0xC5F7:"pi", 
0xC6AA:"pian", 0xC6AE:"piao", 0xC6B2:"pie", 0xC6B4:"pin", 0xC6B9:"ping", 0xC6C2:"po", 0xC6CB:"pu", 0xC6DA:"qi", 0xC6FE:"qia", 
0xC7A3:"qian", 0xC7B9:"qiang", 0xC7C1:"qiao", 0xC7D0:"qie", 0xC7D5:"qin", 0xC7E0:"qing", 0xC7ED:"qiong", 0xC7EF:"qiu", 0xC7F7:"qu", 
0xC8A6:"quan", 0xC8B1:"que", 0xC8B9:"qun", 0xC8BB:"ran", 0xC8BF:"rang", 0xC8C4:"rao", 0xC8C7:"re", 0xC8C9:"ren", 0xC8D3:"reng", 
0xC8D5:"ri", 0xC8D6:"rong", 0xC8E0:"rou", 0xC8E3:"ru", 0xC8ED:"ruan", 0xC8EF:"rui", 0xC8F2:"run", 0xC8F4:"ruo", 0xC8F6:"sa", 
0xC8F9:"sai", 0xC8FD:"san", 0xC9A3:"sang", 0xC9A6:"sao", 0xC9AA:"se", 0xC9AD:"sen", 0xC9AE:"seng", 0xC9AF:"sha", 0xC9B8:"shai", 
0xC9BA:"shan", 0xC9CA:"shang", 0xC9D2:"shao", 0xC9DD:"she", 0xC9E9:"shen", 0xC9F9:"sheng", 0xCAA6:"shi", 0xCAD5:"shou", 
0xCADF:"shu", 0xCBA2:"shua", 0xCBA4:"shuai", 0xCBA8:"shuan", 0xCBAA:"shuang", 0xCBAD:"shui", 0xCBB1:"shun", 0xCBB5:"shuo", 
0xCBB9:"si", 0xCBC9:"song", 0xCBD1:"sou", 0xCBD4:"su", 0xCBE1:"suan", 0xCBE4:"sui", 0xCBEF:"sun", 0xCBF2:"suo", 0xCBFA:"ta", 
0xCCA5:"tai", 0xCCAE:"tan", 0xCCC0:"tang", 0xCCCD:"tao", 0xCCD8:"te", 0xCCD9:"teng", 0xCCDD:"ti", 0xCCEC:"tian", 0xCCF4:"tiao", 
0xCCF9:"tie", 0xCCFC:"ting", 0xCDA8:"tong", 0xCDB5:"tou", 0xCDB9:"tu", 0xCDC4:"tuan", 0xCDC6:"tui", 0xCDCC:"tun", 0xCDCF:"tuo", 
0xCDDA:"wa", 0xCDE1:"wai", 0xCDE3:"wan", 0xCDF4:"wang", 0xCDFE:"wei", 0xCEC1:"wen", 0xCECB:"weng", 0xCECE:"wo", 0xCED7:"wu", 
0xCEF4:"xi", 0xCFB9:"xia", 0xCFC6:"xian", 0xCFE0:"xiang", 0xCFF4:"xiao", 0xD0A8:"xie", 0xD0BD:"xin", 0xD0C7:"xing", 0xD0D6:"xiong", 
0xD0DD:"xiu", 0xD0E6:"xu", 0xD0F9:"xuan", 0xD1A5:"xue", 0xD1AB:"xun", 0xD1B9:"ya", 0xD1C9:"yan", 0xD1EA:"yang", 0xD1FB:"yao", 
0xD2AC:"ye", 0xD2BB:"yi", 0xD2F0:"yin", 0xD3A2:"ying", 0xD3B4:"yo", 0xD3B5:"yong", 0xD3C4:"you", 0xD3D9:"yu", 0xD4A7:"yuan", 
0xD4BB:"yue", 0xD4C5:"yun", 0xD4D1:"za", 0xD4D4:"zai", 0xD4DB:"zan", 0xD4DF:"zang", 0xD4E2:"zao", 0xD4F0:"ze", 0xD4F4:"zei", 
0xD4F5:"zen", 0xD4F6:"zeng", 0xD4FA:"zha", 0xD5AA:"zhai", 0xD5B0:"zhan", 0xD5C1:"zhang", 0xD5D0:"zhao", 0xD5DA:"zhe", 0xD5E4:"zhen", 
0xD5F4:"zheng", 0xD6A5:"zhi", 0xD6D0:"zhong", 0xD6DB:"zhou", 0xD6E9:"zhu", 0xD7A5:"zhua", 0xD7A7:"zhuai", 0xD7A8:"zhuan", 0xD7AE:"zhuang", 
0xD7B5:"zhui", 0xD7BB:"zhun", 0xD7BD:"zhuo", 0xD7C8:"zi", 0xD7D7:"zong", 0xD7DE:"zou", 0xD7E2:"zu", 0xD7EA:"zuan", 0xD7EC:"zui", 
0xD7F0:"zun", 0xD7F2:"zuo"} 