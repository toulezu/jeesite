<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>版本管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/basic/autoVersion/">版本列表</a></li>
		<shiro:hasPermission name="basic:autoVersion:edit"><li><a href="${ctx}/basic/autoVersion/form">版本添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="autoVersion" action="${ctx}/basic/autoVersion/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>版本名称：</label>
				<form:input path="versionName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>描述：</label>
				<form:input path="versionDesc" htmlEscape="false" maxlength="1000" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>版本名称</th>
				<th>描述</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="basic:autoVersion:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="autoVersion">
			<tr>
				<td><a href="${ctx}/basic/autoVersion/form?id=${autoVersion.id}">
					${autoVersion.versionName}
				</a></td>
				<td>
					${autoVersion.versionDesc}
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="basic:autoVersion:edit"><td>
    				<a href="${ctx}/basic/autoVersion/form?id=${autoVersion.id}">修改</a>
					<a href="${ctx}/basic/autoVersion/delete?id=${autoVersion.id}" onclick="return confirmx('确认要删除该版本吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>