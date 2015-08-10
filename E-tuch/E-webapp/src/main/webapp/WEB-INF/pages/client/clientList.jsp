<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<%@ include file="../common.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	
		$('#tbList').datagrid({
		idField : 'sampleInfoSheetId',
		treeField : 'text',
			url : '<%=basePath%>client/list',
			fit:false,
		pageSize : 20,
		pagination : true,
		title:'list' ,
		remoteSort : true ,
		rownumbers : true,
		singleSelect : false,
			striped : true,
		toolbar : [ {
			text : 'add',
			iconCls : 'icon-add',
			handler : ''
		} 
		] 
	});
});


</script>
</head>
<body>
	
<div style="width:100%;height:100%;display:block;margin:-2px 0 0 -4px;">
	<!-- 布局 -->
	<div class="easyui-layout" fit="true">
		<!-- 搜索条件 -->
		<div data-options="region:'north',border:true,iconCls:'icon-search'" style="height:132px;padding:5px 0px 0px 0px;" title="<spring:message code='base.search.param'/>">
			<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
			 <form  id="searchForm">
		    	<table  class="searchTable" style="font-size:12px;" border="0">
		    		<tr>
						<td class="label_td"><label><spring:message code="logistics.trackingNo"/>：</label><td/>
		    			<td class="input_td"><input class="easyui-textbox" id="trackingNo_search"  /> </td>
						
		     		</tr>
		    		<tr>
		    			<td align="right">
			    			<a class="easyui-linkbutton" icon="icon-search"  onclick="">查询</a> 
							<a class="easyui-linkbutton" icon="icon-clear"  onclick="">刷新</a>
		    			</td>
		      		</tr>
	      	 </table>
       	  </form> 
		</div>
		
		<!-- 查询结果 -->
		<div data-options="region:'center',border:false" style="padding-top:4px;">
			<!------------------ 在这里填写你的datagrid -------------------->
			<table id="tbList" height="100%" style="overflow-x: scroll;"  iconCls="icon-list">
				<thead>
					<tr> 
						<th field="ck" checkbox="true"></th>
						<th width="100" data-options="sortable:true , field:'id',align:'center'"  >id</th>
						<th width="100" data-options="sortable:true , field:'clientName',align:'center'" >clientName</th>
						<th width="100" data-options="sortable:true , field:'address',align:'center'" >address</th>
						<th width="100" data-options="sortable:true , field:'linkMan' ,align:'center'" >linkMan</th>
						<th width="200" data-options="sortable:true , field:'code',align:'center'"  >code</th>
						<th width="120" data-options="sortable:true , field:'status'  , align:'center'">status</th>
					</tr>
				</thead>
		   </table>
			
		</div>			
	</div>
</div>
	
</body>
</html>
