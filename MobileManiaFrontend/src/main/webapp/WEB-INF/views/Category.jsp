<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp"%>

<style>
body {
    background-image: url("https://media.gettyimages.com/photos/smartphone-on-desk-top-view-white-background-with-fitness-tracker-picture-id928212706?s=612x612");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}

</style>
<div class="container">

	<br />
	<br />
	
	<div class="row">
		<div style="width: 20%"></div>
		<div>
			<form action="InsertCategory" method="post">
				<table width="50%" align="center" class="table table-bordered">
					<tr>
						<td colspan="2">Manage Category</td>
					</tr>
					<tr>
						<td>Category Name</td>
						<td><input type="text" name="catName" /></td>
					</tr>
					<tr>
						<td>Category Desc</td>
						<td><input type="text" name="catDesc" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<input type="submit" value="Insert Category" class="btn btn-success" />
							</center>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div></div>
	</div>

	<table class="table table-bordered">
		<tr bgcolor="orange">
			<td colspan="4">
				<center>
					<h3>Category Information</h3>
				</center>
			</td>
		</tr>
		<tr>
			<td>Category Id</td>
			<td>Category Name</td>
			<td>Category Desc</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.categoryDesc}</td>
				<td>
					<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">DELETE</a>
					&nbsp;&nbsp;/&nbsp;&nbsp;
					<a href="<c:url value="/editCategory/${category.categoryId}"/>">EDIT</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</div>


</body>
</html>