var Top = function(){
	var forward = function(url, params) {
		$.post(url, params, function(data) {
			$("#MainPanel").empty();
			$("#MainPanel").append(data);
		});
	};
	return {
		init: function() {
			$("#changePasswordBtn").bind("click", function() {
				Top.changePassword();
			});
			
			$("#logoutBtn").bind("click", function() {
				Top.logout();
			});
		},
		changePassword: function() {
			$("#breadcrumbs > ul.breadcrumb > li:eq(1)").nextAll().empty();
			$("#breadcrumbs > ul.breadcrumb > li:eq(1)").empty().append("修改密码");
			forward("/jsp/login/common/pwd-update.jsp");
		},
		logout: function() {
			if (confirm('是否退出本系统?')) {
				$("#loginOut").submit();
			}
		}
	};
}();
$().ready(function() {
	Top.init();
});