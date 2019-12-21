<%@ page language="java" contentType="text/html"%>
<%@ include file="CommonHeader.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/MyCSS.css"/>"/>

<style>
body {
    background-image: url("https://cdn.hipwallpaper.com/i/75/53/0cFvKO.jpg");
    
   background-size: 100% 100%;
}
.container
{
   width: 100%;
    margin-left: auto;
    margin-right: auto;
}

</style>
<body>
<div class="container" style="margin: 0 auto;" align="center">
		<div class="row" align="center">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Sign in to continue</strong>
					</div>
					<div class="panel-body">
						<form role="form" action="perform_login" method="POST">
							<fieldset>
								<div class="row">
									<div class="center-block">
										<img class="profile-img"
											src="https://www.w3schools.com/howto/img_avatar2.png" alt="">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<input class="form-control" placeholder="Username" name="username" type="text" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												<input class="form-control" placeholder="Password" name="password" type="password" value="">
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						Don't have an account! <a href="register" onClick=""> Sign Up Here </a>
					</div>
                </div>
			</div>
		</div>
	</div>
</body>
</html>