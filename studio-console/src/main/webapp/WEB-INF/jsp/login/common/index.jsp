<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="common.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>首页</title>
  		<script src="/js/login/common/index.js" type="text/javascript"></script>
	</head>
	<body>
	
		<!-- 头部 -->
		<jsp:include page="top.jsp"></jsp:include>
		
		<!-- 中部 -->
		<div class="main-container container-fluid">
			<!-- menu菜单begin -->
            <a href="#" id="menu-toggler" class="menu-toggler">
                <span class="menu-text"></span>
            </a>                
            <div id="sidebar" class="sidebar" style=""></div>
            <!-- menu菜单end -->
            
			<!-- 局刷区域begin  -->
			<div class="main-content">
				<div id="breadcrumbs" class="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i><a href="#">首页</a> <span class="divider"><i class="icon-angle-right arrow-icon"></i></span></li>
						<li class="active"></li>
					</ul>
				</div>
				<!-- 主页 -->
				<div class="page-content" id="MainPanel">
				</div>
			</div>
			<!-- 局刷区域end  -->
		</div>
		
		<!-- 底部 -->
		<jsp:include page="bottom.jsp"></jsp:include>
		
	</body>
</html>
