<%@ page language="java" contentType="text/html"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ include file="CommonHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function showalert() {
	alert("User is created");	
}

</script>
<style>
body {
    background-image: url("https://static.careers360.mobi/media/article_images/2018/05/14/SAT_Registration.jpeg");
    background-repeat: no-repeat;
   background-size: 100% 100%;
}

</style>
</head>
<body>
<div class="row">
		<div style="width: 20%"></div>
		<div>
<form action="adduser" method="post">
				<table width="50%" align="center" class="table table-bordered">
					<tr>
						<td colspan="2" align="center">add user</td>
					</tr>
					<tr>
						<td>username</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>name</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input type="text" name="password" /></td>
					</tr>
					
					<tr>
						<td>eamil id</td>
						<td><input type="text" name="emailId" /></td>
					</tr>
					
					<tr>
						<td>address</td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td>mobile</td>
						<td><input type="text" name="mobile" /></td>
					</tr>
					<tr>
					
						<td colspan="2">
							<center>
								<input type="submit" value="Insert user" class="btn btn-success" />
							</center>
						</td>
					</tr>
				</table>
			</form>
</div>
		<div></div>
	</div>
	
</body>
</html>