<%@ include file="/commons/init.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><bean:message key="system.name" /></title>
<link href="<%= ContextUtil.getCtxPath(request)%>/commons/styles/style.css" rel="stylesheet" type="text/css" />
<link href="<%= ContextUtil.getCtxPath(request)%>/commons/styles/ele.css" rel="stylesheet" type="text/css" />
<link href="<%= ContextUtil.getCtxPath(request)%>/commons/styles/frame.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%= ContextUtil.getCtxPath(request)%>/js/util.js"></script>
</head>
<script language="JavaScript" src="/advquery/js/tree_nobox.js"></script>
<%@ page import="com.kingstargroup.advquery.hibernate.util.ShopUtil" %>
<table width="100%" height="5" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td></td>
  </tr>
</table>
<table>
<tr>
<td width=2%>&nbsp;</td>
<td>
<table width="598" height="27" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="14">&nbsp;</td>
    <td width="584">&nbsp;</td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
    	
      <tr> 
      	<td>
       
<%
	List shopList = ShopUtil.createShopJSList("0");
%>
<script language="JavaScript">
	var dlIcons	= new Array();

	// Basic icons

	dlIcons[0] = "/advquery/images/trees/root.gif";
	dlIcons[1] = "/advquery/images/trees/spacer.gif";
	dlIcons[2] = "/advquery/images/trees/line.gif";
	dlIcons[3] = "/advquery/images/trees/join.gif";
	dlIcons[4] = "/advquery/images/trees/join_bottom.gif";
	dlIcons[5] = "/advquery/images/trees/minus.gif";
	dlIcons[6] = "/advquery/images/trees/minus_bottom.gif";
	dlIcons[7] = "/advquery/images/trees/plus.gif";
	dlIcons[8] = "/advquery/images/trees/plus_bottom.gif";
	dlIcons[9] = "/advquery/images/trees/folder.gif";
	dlIcons[10] = "/advquery/images/trees/folder_open.gif";
	dlIcons[11] = "/advquery/images/trees/page.gif";

	// More icons
	dlIcons[12] = "/advquery/images/trees/checked.gif";
	dlIcons[13] = "/advquery/images/trees/unchecked.gif";
	// id | parentId | ls | path | name | img | href

	var dlArray = new Array();

	//dlArray[0] = "1||0||<bean:message key="eadvquery.funclist" />|0|#";
	
	<%for (int i = 0; i < shopList.size(); i++) {%>
	dlArray[<%= i %>] = "<%= (String) shopList.get(i)%>";
	<%}%>
</script>

<div>
	<script language="JavaScript">
		var dlTree = new Tree("dlTree", dlArray, dlIcons, "topmenu_link_12", "");
		dlTree.create("dlTree");
	</script>
</div>

      </tr>
    </table>
    </td></tr></table>
	