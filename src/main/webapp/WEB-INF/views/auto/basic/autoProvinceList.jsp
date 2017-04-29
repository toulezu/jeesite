<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>省份管理</title>
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
		<li class="active"><a href="${ctx}/basic/autoProvince/">省份列表</a></li>
		<shiro:hasPermission name="basic:autoProvince:edit"><li><a href="${ctx}/basic/autoProvince/form">省份添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="autoProvince" action="${ctx}/basic/autoProvince/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>省份：</label>
				<form:input path="pName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>省份代码：</label>
				<form:input path="pCode" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>省份描述：</label>
				<form:input path="pDesc" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>所属区域：</label>
				<form:select path="aid" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
				<th>省份</th>
				<th>省份代码</th>
				<th>省份描述</th>
				<th>所属区域</th>
				<th>备注</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="basic:autoProvince:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="autoProvince">
			<tr>
				<td><a href="${ctx}/basic/autoProvince/form?id=${autoProvince.pid}  ">
					${autoProvince.pid}
				</a></td>
				<td>
					${autoProvince.pName}
				</td>
				<td>
					${autoProvince.pCode}
				</td>
				<td>
					${autoProvince.pDesc}
				</td>
				<td>
					${fns:getDictLabel(autoProvince.aid, '', '')}
				</td>
				<td>
					${autoProvince.remarks}
				</td>
				<td>
					<fmt:formatDate value="${autoProvince.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoProvince.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="basic:autoProvince:edit"><td>
    				<a href="${ctx}/basic/autoProvince/form?id=${autoProvince.pid}">修改</a>
					<a href="${ctx}/basic/autoProvince/delete?id=${autoProvince.pid}" onclick="return confirmx('确认要删除该省份吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>