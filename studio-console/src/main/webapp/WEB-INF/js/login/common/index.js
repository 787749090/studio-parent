$("#sidebar").ready(function() {
	//刷新菜单
	refreshSidebar();
	 /***内部欢迎主页*/
    $.post("/login/common/welcome.html", function(data){
    	var path = '<li><i class="icon-home home-icon"></i><a href="javascript:void(0)" >主页</a></li>' ;
		$("ul.breadcrumb").html(path);
		$("#MainPanel").empty();
		$("#MainPanel").append(data);
		
	});
});