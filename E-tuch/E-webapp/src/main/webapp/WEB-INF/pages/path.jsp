<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%
String contextPath = application.getContextPath();
String resources = contextPath + "/resources";
request.setAttribute("contextPath", contextPath);
request.setAttribute("resources", resources );
request.setAttribute("resScripts", resources + "/scripts");
request.setAttribute("resStyles", resources + "/styles");
request.setAttribute("resImages", resources + "/images");

String jsResources = "<script>var resources = \"" + resources + "\";</script>";
out.print(jsResources);



%>
