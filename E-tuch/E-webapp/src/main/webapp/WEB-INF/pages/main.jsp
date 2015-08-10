<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	 
</head>
<%@ include file="common.jsp"%>
<body class="easyui-layout" id="index-body">
<noscript>
<div style="position:absolute; z-index:100000; height:246px;top:0px;left:0px; width:100%; background:white; text-align:center;">
	<h3>抱歉，请开启脚本支持！</h3>
</div>
</noscript>
	
	
	<div data-options="region:'north',border:false" style="font-family:微软雅黑, Geneva, sans-serif;">
		<div class="header">
	    	<div class="logo" style="text-align:center">
	            <table width="600" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td width="100" height="50" valign="middle"><a href="http://www.bgisample.com" target="_bank"><img src="<%=basePath%>resources/images/logo.png" /></a></td>
	                <td class="sysname"></td>
	              </tr>
	            </table>
	        </div>
	        
			<div class="info">
                
               	<table border="0" width="100%">
               	</table>
	            <div id="layout_north_kzmbMenu" style="width:70px; display: none;">
	            </div>
	        </div>
	    </div>
    </div>
    
	<div data-options="region:'west',split:true,title:'',iconCls:'icon-memu'" style="width:223px;">
		<div class="easyui-accordion sider" data-options="fit:true,border:false">
			<!--左侧菜单导航-->
			<div title="" data-options="iconCls:'icon-receive'" style="padding:10px;">
				<ul class="easyui-tree index-tree" data-options="animate:true">
					<li data-options="state:'closed'"><span>游金龙学习系统</span>
						<ul>
							<li data-options="attributes:{'url':'sampleInfoSheet/toList'}">待接收样品</li>
							<li data-options="attributes:{'url':'test/toTest'}">已接收样品</li>
						</ul>
					</li>
				</ul>
			</div>
			<!--左侧菜单导航-->
		</div>
		<!--accordion-->

	</div>
	<!--主体内容部分-->
    <div data-options="region:'center'" class="indexcenter" title="">
        <div id="tabs_index" class="easyui-tabs" fit="true" border="false">
           	<div title="Home" style="overflow:hidden;" id="homeTab">
           		<iframe scrolling="auto" frameborder="0"  id="home-iframe" src="<%=basePath %>emp/list" style="width:100%;height:100%;"></iframe>
           	</div>
        </div>
    </div>
    
    <!--center-->
    <!--主体内容部分-->
    <div id="dialog_cms" data-options="iconCls:'icon-save'"></div>
    <!--TAB-->
    <div id="mm" class="easyui-menu" style="width:90px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">关闭所有</div>
		<div id="mm-tabcloseother">关闭其它</div>
		<div id="mm-tabcloseright">关闭右侧</div>
      	<div id="mm-tabcloseleft">关闭左侧</div>
    	<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
	<div id="tree-mm" class="easyui-menu" style="width:120px;">
        <div onclick="obase.expand()">Expand</div>
        <div onclick="obase.collapse()">Collapse</div>
    </div>
	
 
    <!--west-->
	<div data-options="region:'south',border:false" style="height:50px;background:#fff;padding:10px;text-align: center;">
        <div id="footer">
        最终解释权。。。
         </div>
    </div>
</body>
</html>