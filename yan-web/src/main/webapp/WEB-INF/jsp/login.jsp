<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
var basePath="${pageContext.request.contextPath}"
$(function(){
	var p={"userName":"安文彪","password":"123456"};
	//alert(typeof JSON.stringify(p));
	$.ajax({
		url:basePath+"/queryAll.action",
		data:{"userName":"安文彪","password":"123456"},
		//contentType:'application/json',
		type:"post",
		success:function(json){
			$("#h2").html(json.userName);
		}
	})
})
</script>
</head>
<body>
<h1>hell word</h1>
<h2 id="h2"></h2>
<a href="http://localhost:8080/yan-web/login.action">测试路径</a>

<form action="http://localhost:8080/yan-web/uploadAction/upload.action" enctype="multipart/form-data" method="post">
	<input type="file" name="file" value="上传文件">
	<input type="submit" value="提交">
</form>
<form action="http://localhost:8080/yan-web/uploadAction/mvcUpload.action" enctype="multipart/form-data" method="post">
	<input type="file" name="mvcfile" value="上传文件">
	<input type="submit" value="提交">
</form>
</body>
</html>