<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<!-- 触发ajax -->
	<button>json</button>
	<script type="text/javascript">
		//创建ajax关键对象
		xmlObject = new XMLHttpRequest(); //实例化一个XMLHttpRequest
		//绑定json单击事件
		document.getElementsByTagName("button")[0].onclick = function() {
			//打开ajax
			xmlObject.open("post", "hello");
			//绑定回调函数
			xmlObject.onreadystatechange = function() {
				/* ajax的网页状态码,如200,404,500等 */
				console.log(xmlObject.status);
				/* ajax的状态码,包括0，1,2,3,4 */
				console.log(xmlObject.readyState)
				/* ajax返回的内容 */
				var text = xmlObject.responseText;
				console.log(text);
				if (text != null && text != undefined && text != "")
					/* 将json字符串转换为json对象 */
					console.log(JSON.parse(text).msg);
			};
	
			//post方式ajax需要定义头
			xmlObject.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
			//传送转换为json字符串的json对象
			xmlObject.send(JSON.stringify({
				ab : 234,
				cd : "abc"
			}));
		}
	</script>
</body>
</html>
