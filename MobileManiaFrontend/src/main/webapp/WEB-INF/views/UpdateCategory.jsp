<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>

<div class="container">
	<br />
	<br />
	
	<div class="row">
		<div style="width: 20%"></div>
		<div>
			<form action="<c:url value="/UpdateCategory"/>" method="post">
				<table width="50%" align="center" class="table table-bordered">
					<tr>
						<td colspan="2">Manage Category</td>
					</tr>
					<tr>
						<td>Category Id</td>
						<td><input type="text" name="catId" value="${category.categoryId}" readonly/></td>
					</tr>
					<tr>
						<td>Category Name</td>
						<td><input type="text" name="catName" value="${category.categoryName}"/></td>
					</tr>
					<tr>
						<td>Category Desc</td>
						<td><input type="text" name="catDesc" value="${category.categoryDesc}"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<input type="submit" value="Update Category" class="btn btn-success" />
							</center>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div></div>
	</div>
</div>
</body>
</html>