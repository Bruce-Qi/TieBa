<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>指令汇科技贴吧</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"> 
</head>
<body>
	
	<!-- 菜单 -->
	<div class="menubar">
		<a href="TieBa/topicAction_findAll">主题列表</a>
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red"><s:property value="#ftopic.replySet.size() + 1"/> </font>篇帖子
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num">1</td>
	        <td><s:property value="#ftopic.title"/> </td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre><s:property value="#ftopic.topicContent"/></pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者：<font color="blue"><s:property value="#ftopic.ipAddr"/></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999">发帖时间：<s:date name="#ftopic.createDate"/> </font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->
	<s:iterator value="#ftopic.replySet" var="reply">
	<table class="postList" cellspacing="0">
        <tr class="title">
            <td width="20" class="num">2</td>
            <td></td>
        </tr>
        <tr class="content">
            <td></td>
            <td><pre><s:property value="#reply.replayContent"/> </pre></td>
        </tr>
        <tr class="info">
            <td></td>
            <td>
				作者：<font color="blue"><s:property value="#reply.ipAddr"/></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="#999999">回帖时间：<s:date name="#reply.createDate"/> </font>
            </td>
        </tr>
    </table>
	</s:iterator>

    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<s:form action="replyAction_add" cssClass="addNewTopicForm">
		<%--确定当前主题 --%>
		<s:hidden name="topic.id" value="%{#ftopic.id}"></s:hidden>
		<table class="publishArticleForm">
	        <tr>
	            <td class="label">内　容:</td>
	            <td><s:textarea name="replayContent" cssClass="content"></s:textarea></td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><s:submit value="回　贴"></s:submit></td>
	        </tr>
	    </table>
	</s:form>
</body>
</html>