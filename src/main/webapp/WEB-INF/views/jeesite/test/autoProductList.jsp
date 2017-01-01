<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品管理</title>
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
		<li class="active"><a href="${ctx}/test/autoProduct/">产品列表</a></li>
		<shiro:hasPermission name="test:autoProduct:edit"><li><a href="${ctx}/test/autoProduct/form">产品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="autoProduct" action="${ctx}/test/autoProduct/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品名称：</label>
				<form:input path="pname" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>产品代码：</label>
				<form:input path="pcode" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>流水号</th>
				<th>产品名称</th>
				<th>产品代码</th>
				<th>备注</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="test:autoProduct:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="autoProduct">
			<tr>
				<td><a href="${ctx}/test/autoProduct/form?id=${autoProduct.pid}  ">
					${autoProduct.pid}
				</a></td>
				<td>
					${autoProduct.pname}
				</td>
				<td>
					${autoProduct.pcode}
				</td>
				<td>
					${autoProduct.remarks}
				</td>
				<td>
					<fmt:formatDate value="${autoProduct.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoProduct.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="test:autoProduct:edit"><td>
    				<a href="${ctx}/test/autoProduct/form?id=${autoProduct.pid}">修改</a>
					<a href="${ctx}/test/autoProduct/delete?id=${autoProduct.pid}" onclick="return confirmx('确认要删除该产品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>