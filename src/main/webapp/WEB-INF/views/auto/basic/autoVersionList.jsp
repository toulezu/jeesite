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
				<form:input path="vName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>版本代码：</label>
				<form:input path="vCode" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>开始时间：</label>
				<input name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${autoVersion.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${autoVersion.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>关联产品id：</label>
				<form:select path="pid" class="input-medium">
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
				<th>版本名称</th>
				<th>版本代码</th>
				<th>描述</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>关联产品id</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="basic:autoVersion:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="autoVersion">
			<tr>
				<td><a href="${ctx}/basic/autoVersion/form?id=${autoVersion.vid}  ">
					${autoVersion.vid}
				</a></td>
				<td>
					${autoVersion.vName}
				</td>
				<td>
					${autoVersion.vCode}
				</td>
				<td>
					${autoVersion.vDesc}
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.beginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(autoVersion.pid, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${autoVersion.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="basic:autoVersion:edit"><td>
    				<a href="${ctx}/basic/autoVersion/form?id=${autoVersion.vid}">修改</a>
					<a href="${ctx}/basic/autoVersion/delete?id=${autoVersion.vid}" onclick="return confirmx('确认要删除该版本吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>