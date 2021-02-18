<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	/* http://localhost:8080/BookTest2/ */
	String basePath=request.getScheme()
	+"://"
	+request.getServerName()
	+":"
	+request.getServerPort()
	+request.getContextPath()
	+"/";

	pageContext.setAttribute("basePath", basePath);
	
	 
%>
<base href="<%=basePath %>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/css/jquery.js"></script>