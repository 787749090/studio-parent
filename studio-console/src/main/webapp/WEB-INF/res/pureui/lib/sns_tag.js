/**
 * <pre>
 * 版本号			修改人	修改说明
 * 20120904.1   Alfie	下拉框只读状态不能进行任何操作
 * 20121101 		Alfie 能够给隐藏的下拉框绑定事件
 											单机某个下拉框元素时，增加return，结束function,防止进入下拉框的其它事件。
 * 20121114 update by Alfie 改成return true，类似continue关键字，保证不会在each循环中重复绑定事件
 * 20121124.1   Simon	querycondition与pagepanelId分离
 * </pre>
 */

$(document).ready(function(){
	initSnsTag();  
});
/**
 * 初始化SNS控件
 */
function initSnsTag(){
	var c = $(document);
	initNumberTag(c);
	initSelectTag(c);
	//20120906 add by alfie 增加分页控件初始化方法
	initPagebar(c);
}
/**
 * 初始化数值控件
 * @param {} c
 */
function initNumberTag(c){
	//数值控件
	$("input[controltype=number]", c).each(function(){
		$(this).css("ime-mode",'disabled');
		$(this).bind("keypress", function(e){
		var isie = (document.all) ? true:false;
		 var key;
		 var ev;
		 if (isie) {
		 	key = window.event.keyCode;
		 	ev = window.event;
		 	if (key != 8) {
		 		if (event.keyCode < 48 || event.keyCode > 57) {
		 			if (event.keyCode != 46) {
		 				event.keyCode = 0;
		 			}
		 		}
		 	}
		 }else {
		 	key = e.which;
		 	ev = e;
		 	if (key != 8) {
		 		if (key < 48 || key > 57) {
		 			if (key != 46) {
		 				key == 0
		 				ev.preventDefault(); // Mozilla Firefox
						}
					}
				}
			}
        });
	});
}
/**
 * 初始化下拉框控件
 * @param {} c
 */
function initSelectTag(c){ 

		$("div[controltype=select]", c).each(function(){
			var isShow = false; 
			var selectTag = $(this);
			//20121101 update by alfie 能够给隐藏的下拉框绑定事件
			/*if(selectTag.is(":hidden")) { 
				return false;
			}*/
			//下拉框
			var selectValueInput = selectTag.find("input[type=text][inputtype=select_value]");
			//20120904 update by Alfie 只读状态不能进行任何操作
			if(selectValueInput.attr("readonly")=="readonly"){
				//20121114 update by Alfie 改成return true，类似continue关键字，保证不会在each循环中重复绑定事件
				return true;
			}
			
			//20120909 update by Alfie 防止重复绑定事件
			if(selectValueInput.data("events")){
				if(selectValueInput.data("events")["click"] ){
					//20121114 update by Alfie 改成return true，类似continue关键字，保证不会在each循环中重复绑定事件
					return true;
				}
			}
			//alert(selectValueInput.parent().parent().html());
			//下拉列表
			var selectCon = selectTag.find("div[divtype=select_list]");	
			var selectItem = selectTag.find("div[divtype=select_list] ul li");	
			//下拉框单击事件   打开或者关闭下拉框，同时指定scrollbar的位置
			selectValueInput.bind("click",function(){
				selectTag.css("z-index",1000);
	            selectCon.toggle();
	            //scrollbar 的设置
	            var index = 0;
	            var height = 0;
	            var li = selectCon.find("li");
	            for(var i=0;i<li.length;i++){
	            	var liTag = $(li[i]);
	            	if(liTag.attr("litype").indexOf("select_li_on")>=0){
	            		index = i;
	            		height = liTag.height();
	            	}
	            }
	            selectCon.scrollTop(index*height);
	             if(isShow){
	             	isShow = false;
	             }else{
	             		isShow = true;
	             		for(var i=0;i<selectItem.length;i++){
	             			$(selectItem[i]).show();
	             		}
	             }
	        });	
	            
	       //下拉列表中 单击每一个下拉元素事件   设置下拉框的值同时关闭下拉列表
	        selectTag.find("div[divtype=select_list] ul li").click(function(){
	        	selectValueInput.val($(this).text());
	        	selectTag.find("input[type=hidden][inputtype=select_key]").val($(this).find("input[type=hidden]").val());
	            selectCon.hide();
	            selectTag.css("z-index",1);
	            isShow = false;
	            //20121101 update by alfie 增加return，结束function,防止进入下拉框的其它事件。
	            return false;
	        });
	        //下拉输入框  焦点失去事件  关闭下拉列表
	         selectValueInput.focusout(function() {
	         		//下拉列表 20120909 update by alfie 失去焦点自动设置第一个下拉列表中的值
	         		//update 20121029 update by alfie selectItem取值条件去掉visible
							var selectItem = selectTag.find("div[divtype=select_list] ul li");
							if(selectItem.length>0){
								var selectVal = selectValueInput.val();
								//20121029 update by alfie 如果下拉框有值存在，那么不做清空操作
								if(selectVal==null || selectVal==''){
									selectValueInput.val($(selectItem[0]).text());
									selectTag.find("input[type=hidden][inputtype=select_key]").val($(selectItem[0]).find("input[type=hidden]").val());
								}
							}else{
								selectValueInput.val("");
	        			selectTag.find("input[type=hidden][inputtype=select_key]").val("");
							}
							
	            if(selectTag.find("div[divtype=select_list] :visible").html() == null){
	            	selectCon.hide();
	            	selectTag.css("z-index",1);
	            }
			});
	        //下拉列表项  鼠标移上样式控制
	        selectTag.find("div[divtype=select_list] ul li").mouseover(function(){
				    var emenon = selectTag.find("li[litype=select_li_on]");
						emenon.removeClass("sel_con_on");
						emenon.attr('litype','select_li');
						emenon.addClass("sel_con_li");
						$(this).removeClass("sel_con_li");
						$(this).addClass("sel_con_on");
						$(this).attr('litype','select_li_on'); 
	        });
	       //文本其它处点击事件  关闭下拉列表
	        $(document).click(function(){
	        	if(selectTag.find("div[divtype=select_list] :visible").html()!=null && !isShow){
	       			selectCon.hide();
	       			selectTag.css("z-index",1);
	       		}else if(isShow){
	       			isShow = false;
	       		}
	        });
	       var index = 0;
	       selectValueInput.keyup(function(){
	        //update 20121029 update by alfie 增加上下及回车按键事件
	        var keypressnow = event.keyCode; 
	    		//keycode   13 = Enter keycode   38 = Up keycode   40 = Down
	          var height = 0;
	           var li = selectCon.find("li");
	    			if(keypressnow==38 || keypressnow ==40){
	    				//单击向下按键，显示下拉框
	    				if(keypressnow==40 && !selectTag.find("div[divtype=select_list]").is(":visible")){
	    					selectValueInput.trigger("click");
	    					isShow = true;
	    					return;
	    				}
	    				//先获取当前位置
	            for(var i=0;i<li.length;i++){
	            	var liTag = $(li[i]);
	            	if(liTag.attr("litype").indexOf("select_li_on")>=0){
	            		index = i;
	            		height = liTag.height();
	            	}
	            }
	            //根据按键 改变当前位置
	            if(keypressnow==38){
	            	if(index>0){
	            		index--;
	            	}
	            }else if(keypressnow==40){
	            	if(index<li.length-1){
	            		index++;
	            	}
	            }
	            //设置样式及scroll
	             var emenon = selectTag.find("li[litype=select_li_on]");
							 emenon.removeClass("sel_con_on");
							 emenon.attr('litype','select_li');
							 emenon.addClass("sel_con_li");
							 $(li[index]).removeClass("sel_con_li");
							 $(li[index]).addClass("sel_con_on");
							 $(li[index]).attr('litype','select_li_on'); 
							 if(index>0){
							  selectCon.scrollTop((index-1)*height);
							}else{
								selectCon.scrollTop(index*height);
							}
	    			}else if(keypressnow==13){
	    				selectValueInput.val($(li[index]).text());
	    				selectTag.find("input[type=hidden][inputtype=select_key]").val($(li[index]).find("input[type=hidden]").val());
	            selectCon.hide();
	            selectTag.css("z-index",1);
	            isShow = false;
	    			}else{
						//20120909 add by alfie下拉框过滤 增加对拼音的支持  
							var thisVal = $(this).val().toLowerCase();
							for(var i=0;i<selectItem.length;i++){
								var item = $(selectItem[i]);
								var itemPy = toPinyinShengmu(item.text()).toLowerCase();
								if(itemPy.indexOf(thisVal)!=0){
									item.hide();
								}else{
									item.show();
								}
							}
						}
				});
		});
}
//20120909 add by alfie增加对拼音的支持  start*******************************
var key2code = {65:"a",66:"b",67:"c",68:"d",69:"e",70:"f",71:"g",72:"h",73:"i",74:"j", 
75:"k",76:"l",77:"m",78:"n",79:"o",80:"p",81:"q",82:"r",83:"s",84:"t", 
85:"u",86:"v",87:"w",88:"x",89:"y",90:"z",49:"1",50:"2",51:"3",52:"4", 
53:"5",54:"6",55:"7",56:"8",57:"9",48:"0" 
}; 
var spell = {0xB0A1:"a", 0xB0A3:"ai", 0xB0B0:"an", 0xB0B9:"ang", 0xB0BC:"ao", 0xB0C5:"ba", 0xB0D7:"bai", 0xB0DF:"ban", 0xB0EE:"bang", 0xB0FA:"bao", 0xB1AD:"bei", 0xB1BC:"ben", 0xB1C0:"beng", 0xB1C6:"bi", 0xB1DE:"bian", 0xB1EA:"biao", 0xB1EE:"bie", 0xB1F2:"bin", 0xB1F8:"bing", 0xB2A3:"bo", 0xB2B8:"bu", 0xB2C1:"ca", 0xB2C2:"cai", 0xB2CD:"can", 0xB2D4:"cang", 0xB2D9:"cao", 0xB2DE:"ce", 0xB2E3:"ceng", 0xB2E5:"cha", 0xB2F0:"chai", 0xB2F3:"chan", 0xB2FD:"chang", 0xB3AC:"chao", 0xB3B5:"che", 0xB3BB:"chen", 0xB3C5:"cheng", 0xB3D4:"chi", 0xB3E4:"chong", 0xB3E9:"chou", 0xB3F5:"chu", 0xB4A7:"chuai", 0xB4A8:"chuan", 0xB4AF:"chuang", 0xB4B5:"chui", 0xB4BA:"chun", 0xB4C1:"chuo", 0xB4C3:"ci", 0xB4CF:"cong", 0xB4D5:"cou", 0xB4D6:"cu", 0xB4DA:"cuan", 0xB4DD:"cui", 0xB4E5:"cun", 0xB4E8:"cuo", 0xB4EE:"da", 0xB4F4:"dai", 0xB5A2:"dan", 0xB5B1:"dang", 0xB5B6:"dao", 0xB5C2:"de", 0xB5C5:"deng", 0xB5CC:"di", 0xB5DF:"dian", 0xB5EF:"diao", 0xB5F8:"die", 0xB6A1:"ding", 0xB6AA:"diu", 0xB6AB:"dong", 0xB6B5:"dou", 0xB6BC:"du", 0xB6CB:"duan", 0xB6D1:"dui", 0xB6D5:"dun", 0xB6DE:"duo", 0xB6EA:"e", 0xB6F7:"en", 0xB6F8:"er", 0xB7A2:"fa", 0xB7AA:"fan", 0xB7BB:"fang", 0xB7C6:"fei", 0xB7D2:"fen", 0xB7E1:"feng", 0xB7F0:"fo", 0xB7F1:"fou", 0xB7F2:"fu", 0xB8C1:"ga", 0xB8C3:"gai", 0xB8C9:"gan", 0xB8D4:"gang", 0xB8DD:"gao", 0xB8E7:"ge", 0xB8F8:"gei", 0xB8F9:"gen", 0xB8FB:"geng", 0xB9A4:"gong", 0xB9B3:"gou", 0xB9BC:"gu", 0xB9CE:"gua", 0xB9D4:"guai", 0xB9D7:"guan", 0xB9E2:"guang", 0xB9E5:"gui", 0xB9F5:"gun", 0xB9F8:"guo", 0xB9FE:"ha", 0xBAA1:"hai", 0xBAA8:"han", 0xBABB:"hang", 0xBABE:"hao", 0xBAC7:"he", 0xBAD9:"hei", 0xBADB:"hen", 0xBADF:"heng", 0xBAE4:"hong", 0xBAED:"hou", 0xBAF4:"hu", 0xBBA8:"hua", 0xBBB1:"huai", 0xBBB6:"huan", 0xBBC4:"huang", 0xBBD2:"hui", 0xBBE7:"hun", 0xBBED:"huo", 0xBBF7:"ji", 0xBCCE:"jia", 0xBCDF:"jian", 0xBDA9:"jiang", 0xBDB6:"jiao", 0xBDD2:"jie", 0xBDED:"jin", 0xBEA3:"jing", 0xBEBC:"jiong", 0xBEBE:"jiu", 0xBECF:"ju", 0xBEE8:"juan", 0xBEEF:"jue", 0xBEF9:"jun", 0xBFA6:"ka", 0xBFAA:"kai", 0xBFAF:"kan", 0xBFB5:"kang", 0xBFBC:"kao", 0xBFC0:"ke", 0xBFCF:"ken", 0xBFD3:"keng", 0xBFD5:"kong", 0xBFD9:"kou", 0xBFDD:"ku", 0xBFE4:"kua", 0xBFE9:"kuai", 0xBFED:"kuan", 0xBFEF:"kuang", 0xBFF7:"kui", 0xC0A4:"kun", 0xC0A8:"kuo", 0xC0AC:"la", 0xC0B3:"lai", 0xC0B6:"lan", 0xC0C5:"lang", 0xC0CC:"lao", 0xC0D5:"le", 0xC0D7:"lei", 0xC0E2:"leng", 0xC0E5:"li", 0xC1A9:"lia", 0xC1AA:"lian", 0xC1B8:"liang", 0xC1C3:"liao", 0xC1D0:"lie", 0xC1D5:"lin", 0xC1E1:"ling", 0xC1EF:"liu", 0xC1FA:"long", 0xC2A5:"lou", 0xC2AB:"lu", 0xC2BF:"lv", 0xC2CD:"luan", 0xC2D3:"lue", 0xC2D5:"lun", 0xC2DC:"luo", 0xC2E8:"ma", 0xC2F1:"mai", 0xC2F7:"man", 0xC3A2:"mang", 0xC3A8:"mao", 0xC3B4:"me", 0xC3B5:"mei", 0xC3C5:"men", 0xC3C8:"meng", 0xC3D0:"mi", 0xC3DE:"mian", 0xC3E7:"miao", 0xC3EF:"mie", 0xC3F1:"min", 0xC3F7:"ming", 0xC3FD:"miu", 0xC3FE:"mo", 0xC4B1:"mou", 0xC4B4:"mu", 0xC4C3:"na", 0xC4CA:"nai", 0xC4CF:"nan", 0xC4D2:"nang", 0xC4D3:"nao", 0xC4D8:"ne", 0xC4D9:"nei", 0xC4DB:"nen", 0xC4DC:"neng", 0xC4DD:"ni", 0xC4E8:"nian", 0xC4EF:"niang", 0xC4F1:"niao", 0xC4F3:"nie", 0xC4FA:"nin", 0xC4FB:"ning", 0xC5A3:"niu", 0xC5A7:"nong", 0xC5AB:"nu", 0xC5AE:"nv", 0xC5AF:"nuan", 0xC5B0:"nue", 0xC5B2:"nuo", 0xC5B6:"o", 0xC5B7:"ou", 0xC5BE:"pa", 0xC5C4:"pai", 0xC5CA:"pan", 0xC5D2:"pang", 0xC5D7:"pao", 0xC5DE:"pei", 0xC5E7:"pen", 0xC5E9:"peng", 0xC5F7:"pi", 0xC6AA:"pian", 0xC6AE:"piao", 0xC6B2:"pie", 0xC6B4:"pin", 0xC6B9:"ping", 0xC6C2:"po", 0xC6CB:"pu", 0xC6DA:"qi", 0xC6FE:"qia", 0xC7A3:"qian", 0xC7B9:"qiang", 0xC7C1:"qiao", 0xC7D0:"qie", 0xC7D5:"qin", 0xC7E0:"qing", 0xC7ED:"qiong", 0xC7EF:"qiu", 0xC7F7:"qu", 0xC8A6:"quan", 0xC8B1:"que", 0xC8B9:"qun", 0xC8BB:"ran", 0xC8BF:"rang", 0xC8C4:"rao", 0xC8C7:"re", 0xC8C9:"ren", 0xC8D3:"reng", 0xC8D5:"ri", 0xC8D6:"rong", 0xC8E0:"rou", 0xC8E3:"ru", 0xC8ED:"ruan", 0xC8EF:"rui", 0xC8F2:"run", 0xC8F4:"ruo", 0xC8F6:"sa", 0xC8F9:"sai", 0xC8FD:"san", 0xC9A3:"sang", 0xC9A6:"sao", 0xC9AA:"se", 0xC9AD:"sen", 0xC9AE:"seng", 0xC9AF:"sha", 0xC9B8:"shai", 0xC9BA:"shan", 0xC9CA:"shang", 0xC9D2:"shao", 0xC9DD:"she", 0xC9E9:"shen", 0xC9F9:"sheng", 0xCAA6:"shi", 0xCAD5:"shou", 0xCADF:"shu", 0xCBA2:"shua", 0xCBA4:"shuai", 0xCBA8:"shuan", 0xCBAA:"shuang", 0xCBAD:"shui", 0xCBB1:"shun", 0xCBB5:"shuo", 0xCBB9:"si", 0xCBC9:"song", 0xCBD1:"sou", 0xCBD4:"su", 0xCBE1:"suan", 0xCBE4:"sui", 0xCBEF:"sun", 0xCBF2:"suo", 0xCBFA:"ta", 0xCCA5:"tai", 0xCCAE:"tan", 0xCCC0:"tang", 0xCCCD:"tao", 0xCCD8:"te", 0xCCD9:"teng", 0xCCDD:"ti", 0xCCEC:"tian", 0xCCF4:"tiao", 0xCCF9:"tie", 0xCCFC:"ting", 0xCDA8:"tong", 0xCDB5:"tou", 0xCDB9:"tu", 0xCDC4:"tuan", 0xCDC6:"tui", 0xCDCC:"tun", 0xCDCF:"tuo", 0xCDDA:"wa", 0xCDE1:"wai", 0xCDE3:"wan", 0xCDF4:"wang", 0xCDFE:"wei", 0xCEC1:"wen", 0xCECB:"weng", 0xCECE:"wo", 0xCED7:"wu", 0xCEF4:"xi", 0xCFB9:"xia", 0xCFC6:"xian", 0xCFE0:"xiang", 0xCFF4:"xiao", 0xD0A8:"xie", 0xD0BD:"xin", 0xD0C7:"xing", 0xD0D6:"xiong", 0xD0DD:"xiu", 0xD0E6:"xu", 0xD0F9:"xuan", 0xD1A5:"xue", 0xD1AB:"xun", 0xD1B9:"ya", 0xD1C9:"yan", 0xD1EA:"yang", 0xD1FB:"yao", 0xD2AC:"ye", 0xD2BB:"yi", 0xD2F0:"yin", 0xD3A2:"ying", 0xD3B4:"yo", 0xD3B5:"yong", 0xD3C4:"you", 0xD3D9:"yu", 0xD4A7:"yuan", 0xD4BB:"yue", 0xD4C5:"yun", 0xD4D1:"za", 0xD4D4:"zai", 0xD4DB:"zan", 0xD4DF:"zang", 0xD4E2:"zao", 0xD4F0:"ze", 0xD4F4:"zei", 0xD4F5:"zen", 0xD4F6:"zeng", 0xD4FA:"zha", 0xD5AA:"zhai", 0xD5B0:"zhan", 0xD5C1:"zhang", 0xD5D0:"zhao", 0xD5DA:"zhe", 0xD5E4:"zhen", 0xD5F4:"zheng", 0xD6A5:"zhi", 0xD6D0:"zhong", 0xD6DB:"zhou", 0xD6E9:"zhu", 0xD7A5:"zhua", 0xD7A7:"zhuai", 0xD7A8:"zhuan", 0xD7AE:"zhuang", 0xD7B5:"zhui", 0xD7BB:"zhun", 0xD7BD:"zhuo", 0xD7C8:"zi", 0xD7D7:"zong", 0xD7DE:"zou", 0xD7E2:"zu", 0xD7EA:"zuan", 0xD7EC:"zui", 0xD7F0:"zun", 0xD7F2:"zuo"} 
var spellArray = new Array() 
var pn = "" 
function pinyin(char) 
{ 
if (!char.charCodeAt(0) ||char.charCodeAt(0) < 1328) return char; 
if (spellArray[char.charCodeAt(0)]) return spellArray[char.charCodeAt(0)] 
execScript("ascCode=hex(asc(\""+char+"\"))", "vbscript") 
ascCode = eval("0x"+ascCode) 
if (!(ascCode>0xB0A0 && ascCode<0xD7FC)) return char; 
for (var i=ascCode; (!spell[i] && i>0);) i-- 
return spell[i] 
} 
function toPinyinShengmu(str) 
{ 
var pStr = "" 
for (var i=0; i<str.length; i++) 
{ 
if (str.charAt(i) == "\n") pStr += ""; 
else pStr += pinyin(str.charAt(i)).charAt(0) ; 
} 
return pStr 
} 
//20120909 add by alfie增加对拼音的支持  end*******************************


/**
 * 20120906 add by alfie
 * 初始化分页控件
 * @param {} c
 */
function initPagebar(c){
	
	//循环页面所有的分页控件
	$("div[divtype=paginationDiv]", c).each(function(){
		//是否 正在请求中
		var isRequesting = false;
		
		var pagebar = $(this);
		//显示分页列表结果的面板ID
		var pagepanelId = pagebar.attr("pagepanelId");
		//显示分页列表结果的面板
		var pagepanel = $('#'+pagepanelId);
		//20121124.1 By  Simon	如果没有此属性，则默认与PanelId相同
		//var querycondition =  pagebar.attr("queryCondition") || pagepanelId;  null属性也可以赋值给querycondition
		var querycondition =  "";
		if(jQuery.isEmptyObject(pagebar.attr("queryCondition"))){
				querycondition = pagebar.attr("queryCondition");
		}else{
				querycondition = pagepanelId;
		}
		
		//总页数和页大小
		var pageTotal = pagebar.find("div[divtype=pageTotal]").text();
		var pageSize = pagebar.find("div[divtype=pageSize]").text();
		//收集当前分页paneId 对应的查询条件
		var params = {};
		$("input[querycondition="+querycondition+"]",c).each(function(){
			var name = $(this).attr("name");
			var value = $(this).val();
			params[name]=value;
		});
		//页大小 参数设置
		var pageSizeSelect = pagebar.find("select[selectType=pageSelect]");
		pageSizeSelect.find("option[value="+pageSize+"]").attr("selected","selected");
		var pageSizeName = pageSizeSelect.attr("name");
		var pageSizeValue = pageSizeSelect.val();
		//给页大小默认值
		if(pageSizeValue==null || pageSizeValue=="" || pageSizeValue==0){
			pageSizeValue = 10;
		}
		if(!pageSizeName || pageSizeName==null || pageSizeName==""){
			pageSizeName = "pageSize";
		}
		params[pageSizeName]=pageSizeValue;
		pageSizeSelect.change(function(){
			var pageSizeValue = pageSizeSelect.find("option:selected").val();
			params[pageSizeName]=pageSizeValue;
			$("a[atype=pageButtonA][icon=pagination-load]", pagebar).click();
		});
		
		//在当前pagebar中 循环所有的分页功能按钮 首页 末页 上一页 下一页 刷新
		$("a[atype=pageButtonA]", pagebar).each(function(){
			//绑定单机事件
			$(this).click(function(pageSize){
				//灰置了 不作操作
				var disableAttr = $(this).attr("disabledthis");
				if(disableAttr=='disabled'){
					return false;
				}
				//如果点击的是跳转按钮，那么需要从页面收集跳转页码
				var aicon = $(this).attr("aicon");
				if(aicon=="pageButtonIconLoad"){
					//页码 参数设置
					var pageNumberInput = pagebar.find("input[inputtype=pagenumber]");
					var pageNumberName = pageNumberInput.attr("name");
					var pageNumberValue = pageNumberInput.val();
					//输入页码不能小于1，大于最大页码
					if(pageNumberValue<1 || pageNumberValue>pageTotal){
						return false;
					}
					params[pageNumberName]=pageNumberValue;
				}
				//做按钮效果
				//var buttonImage = $(this).find("span[spantype=pageButtonSpan]");
				
				//分页请求的URL
				var apageurl = $(this).attr("apageurl");
				//如果没有被请求
				if(!isRequesting){
					isRequesting = true;
					//加载按钮背景图片切换
					pagerLoadBtnCut(pagebar,isRequesting);
					$.post(apageurl, params ,function(data){
						isRequesting = false;
						pagerLoadBtnCut(pagebar,isRequesting);
						pagepanel.empty();
						$(data).appendTo(pagepanel);
					}, "html");
				}
			});
		});
	});
}
//加载按钮背景图片切换
function pagerLoadBtnCut(pagebar,isRequesting){
	var loadBtn = pagebar.find("span[spantype=pageButtonSpan_load]");
	loadBtn.removeClass();
	if(isRequesting){
		loadBtn.addClass("l-btn-empty pagination-loading");
	}else{
		loadBtn.addClass("l-btn-empty pagination-load");
	}
					
}