<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="path.jsp"%>
 <script type="text/javascript" src="${resScripts}/jqueryEasyUI/jquery.min.js"> </script> 
 <script type="text/javascript" src="${resScripts}/jqueryEasyUI/jquery.easyui.min.js"> </script> 
 <script type="text/javascript" src="${resScripts}/jqueryEasyUI/locale/easyui-lang-zh_CN.js"></script> 
 <link rel="stylesheet" type="text/css" href="${resScripts}/jqueryEasyUI/themes/default/easyui.css">
 <link rel="stylesheet" type="text/css" href="${resScripts}/jqueryEasyUI/themes/icon.css">
 <link rel="stylesheet" type="text/css" href="${resStyles}/common.css">
 
<script type="text/javascript">
Date.prototype.format = function(format) {  
    var o = {  
        "M+" : this.getMonth() + 1, // month  
        "d+" : this.getDate(), // day  
        "h+" : this.getHours(), // hour  
        "m+" : this.getMinutes(), // minute  
        "s+" : this.getSeconds(), // second  
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter  
        "S" : this.getMilliseconds()  
        // millisecond  
    };  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4  
                        - RegExp.$1.length));  
    }  
  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1  
                            ? o[k]  
                            : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;  
};
</script>