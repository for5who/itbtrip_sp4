<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.userid ne null}">
<%response.sendRedirect("${pageContext.request.contextPath}'/>/main.do"); %>
</c:if> 


<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>BellringCMS</title>
		<link rel="stylesheet" type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/login.css">
		
		<!-- jQuery -->
		<script lang="javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/jquery-1.11.3.min.js"></script>
		<!-- sha256 -->
		<script lang="javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/sha256.js"></script>
		<style>
			.centerline {margin:20px auto;height:1px; border-top:1px solid #ddd; border-bottom:1px solid #fff; width:280px;border-width:1px !important;}
		</style>
	</head>

	<body>	
		<div id="top">
	
		<p class="add_text">Sample<span> CMS</span></p>
		<p class="logo"></p>
		</div>
		<form id="form" name="loginForm" id="loginForm" action="<c:out value='${pageContext.request.contextPath}'/>/login_check" method="post">
			<div id="content">	
				 <section class="container">
				    <div class="login">	    
				        <p><input type="text" name="user_id" id="user_id" value="" placeholder="Username" onkeypress="if(event.keyCode == 13){ send(); return; }"  maxlength="12" ><br>
				        <input type="password"  id="user_pwd" name="user_pwd"  value="" placeholder="Password"  autocomplete="off" onkeypress="if(event.keyCode == 13){ send(); return; }" maxlength="15"></p>
				        <p class="remember_me" style="margin-top:10px;margin-left:5px">
				          <label>
				            <input type="checkbox" name=idRemember id="idRemember">
				          	Remember me on this computer
				          </label>
				        </p>
				        <p class="button" style="margin-top:10px;margin-right:24px;"><input type="button" value="Login" onclick="send()"></p>    
					   
				    </div>  
				  </section>
			</div><!--content-->
			<div style="clear:both"></div>

		</form>
	
    </body>
<script>

$(document).ready(function(){
	//
});

function send(){	
	var varFrom = document.loginForm;
	$("#user_pwd").val(sha256($("#user_pwd").val()));
	varFrom.submit();
}
</script>
</html>