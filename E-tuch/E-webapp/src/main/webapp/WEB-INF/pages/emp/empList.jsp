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
<%@ include file="../common.jsp"  %>
<script type="text/javascript">

var emp ={
		
		//刷新
		reloadTable : function(){
			$("#tbList").datagrid('reload');
		},
		// 页面条件搜索。
		search : function(){
	   		$('#tbList').datagrid('clearSelections');   //清空选中的 
	 		var queryParams = $('#tbList').datagrid('options').queryParams;
	   		
			queryParams.eName = $('#eName').val();
			queryParams.id = $.trim($('#empNo').val());
			queryParams.job = $.trim($('#job').combobox('getValue'));
			queryParams.mgr = $.trim($('#mgr').val());
			
			$('#tbList').datagrid('options').queryParams = queryParams;
			$('#tbList').datagrid('load');
		},// 添加。
		add : function(){
			$('#wintest').panel('open') ;
	 	},
		// 查看详情。
		detail : function(){
	    	var detailURL = "<%=basePath%>sampleInfoSheet/toDetail";
			defaultDetail("sampleInfoSheet_win","【样品信息单】"+'<spring:message code="base.detail"/>',1200,600,detailURL,"tbList");
	 	},
	 	//关闭窗口
	 	closeWin : function(){
	 		closeDialog('sampleInfoSheet_win');
	  	},
	  //关闭窗口
	 	closeWin : function(){
	 		closeDialog('sampleInfoSheet_win');
	  	},
	  	toAddPage : function(){
	  		$('#wintest').window('close');
	  		var typeValue=$("#typeCombobox").combobox('getValue');
	   		var addUrl = '<%=basePath%>sampleInfoSheet/toAdd?typeValue='+typeValue ;
			defaultAdd("sampleInfoSheet_win",'<spring:message code="base.add"/><spring:message code="sampleInfoSheet.sampleInfoSheet"/>',"1200","600",addUrl );
	   	},
	   	//清除
	   	clear : function (){
			$('#searchForm').form('clear');
	   	}
};



$(document).ready(function() {
	
		$('#tbList').datagrid({
		idField : 'id',
		treeField : 'text',
		url : '<%=basePath%>emp/list',
		fit:false,
		pageSize : 20,
		pagination : true,
		title:'emp列表' ,
		remoteSort : true ,
		rownumbers : true,
		singleSelect : false,
		striped : true,
		toolbar : [ {
			text : '添 加',
			iconCls : 'icon-add',
			handler : 'emp.add'
		}, '-', {
			text : '修 改',
			iconCls : 'icon-edit',
			handler : emp.edit
		}, '-', {
			text : '查 看',
			iconCls : 'icon-detail',
			handler : emp.detail
		} , '-', {
			text : '删 除',
			iconCls : 'icon-remove',
			handler : emp.delete
		}
		] 
	});
		
		$('#job').combobox({    
			valueField: 'value',
			textField: 'text',
			data: [{
				value: 'CLERK',
				text: 'CLERK'
			},{
				value: 'ANALYST',
				text: 'ANALYST'
			},{
				value: 'SALESMAN',
				text: 'SALESMAN'
			},{
				value: 'PRESIDENT',
				text: 'PRESIDENT'
			},{
				value: 'MANAGER',
				text: 'MANAGER'
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
		<div data-options="region:'north',border:true,iconCls:'icon-search'" style="height:100px;padding:5px 0px 0px 0px;" title="查询">
			<!------------------ 在这里填写你的搜索条件（FORM） -------------------->
			 <form  id="searchForm">
		    	<table  class="searchTable" style="font-size:12px;" border="0">
		    		<tr>
						<td class="label_td">empNo：</label><td/>
		    			<td class="input_td"><input class="easyui-textbox" id="empNo"  /> </td>
		    			
						<td class="label_td">eName：</label><td/>
		    			<td class="input_td"><input class="easyui-textbox" id="eName"  /> </td>
		    			
						<td class="label_td">job：</label><td/>
		    			<td class="input_td"><input class="easyui-textbox" id="job"  /> </td>
		    			
						<td class="label_td">mgr：</label><td/>
		    			<td class="input_td"><input class="easyui-textbox" id="mgr"  /> </td>
		     		</tr>
		    		<tr>
		    			 <td align="right" colspan="8">
			    			<a class="easyui-linkbutton" icon="icon-search"  onclick="emp.search()">查询</a> 
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
						<th width="100" data-options="sortable:true , field:'id',align:'center'"  >empNo</th>
						<th width="100" data-options="sortable:true , field:'eName',align:'center'" >eName</th>
						<th width="100" data-options="sortable:true , field:'job',align:'center'" >job</th>
						<th width="100" data-options="sortable:true , field:'mgr' ,align:'center'" >mgr</th>
						<th width="200" data-options="sortable:true , field:'hireDate',align:'center'"  >hireDate</th>
						<th width="120" data-options="sortable:true , field:'sal'  , align:'center'">sal</th>
						<th width="120" data-options="sortable:true , field:'comm'  , align:'center'">comm</th>
						<th width="120" data-options="sortable:true , field:'deptNo'  , align:'center'">deptNo</th>
					</tr>
				</thead>
		   </table>
			
		</div>			
	</div>
</div>
	
</body>
</html>
