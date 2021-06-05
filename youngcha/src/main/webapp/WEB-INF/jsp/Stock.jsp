<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>재고관리</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/carousel/">

<!-- Bootstrap core CSS -->
<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Favicons -->
<%@ include file="NAVbar.jsp"%>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#login_wrapper {
	width: 100%;
	max-width: 1500px;
	padding-left: 380px;
	margin: auto;
}
</style>
</head>

<div class="py-5 text-center" style="user-select: auto;">
	<img class="d-block mx-auto mb-4"
		src="../../resources/image/jisung.jpg" alt="" width="100" height="125"
		style="user-select: auto;">
	<h2 style="user-select: auto;">재고관리</h2>
</div>
<body class="bg-light">
	<div class="container" style="user-select: auto;" id="login_wrapper">
		<main style="user-select: auto;">
			<div class="col-md-7 col-lg-8" style="user-select: auto;">
				<h4 class="mb-3" style="user-select: auto;">
					Stock <span style="margin-left: 520px"> <input
						class="btn btn-info btn-default btn-sm" id="addForm" type="button"
						value="항목 추가">
					</span>
				</h4>
				<form action="/reservations/new" method="POST"
					class="needs-validation" novalidate="" style="user-select: auto;">
					<div class="select" style="user-select: auto;">
						<div class="row g-3" style="padding-top:20px; user-select: auto;">
							<div class="col-md-4" style="user-select: auto;">
								<label for="numberOfPeople" class="form-label"
									style="user-select: auto;">메뉴</label> <select
									class="form-select" name="numberOfPeople" id="numberOfPeople"
									required="" style="user-select: auto;">
									<option value="" style="user-select: auto;">선택</option>
									<option style="user-select: auto;">1</option>
									<option style="user-select: auto;">2</option>
									<option style="user-select: auto;">3</option>
									<option style="user-select: auto;">4</option>
								</select>
								<div class="invalid-feedback" style="user-select: auto;"></div>
							</div>

							<div class="col-md-4" style="user-select: auto;">
                                <label for="numberOfPeople" class="form-label"
                            	    style="user-select: auto;">수량</label> <select
                            		class="form-select" name="numberOfPeople" id="numberOfPeople"
                            		required="" style="user-select: auto;">
                            		<option value="" style="user-select: auto;">선택</option>
                            		<option style="user-select: auto;">1</option>
                            		<option style="user-select: auto;">2</option>
                            	</select>
                            	<div class="invalid-feedback" style="user-select: auto;"></div>
                            </div>
						</div>
					</div>
					<div class="addResv"></div>
					<script>
						document.getElementById("addForm").addEventListener("click",function(e) {
							    var target = document.querySelector(".select").cloneNode(true);
							    document.querySelector(".addResv").innerHTML += target.innerHTML;
						});
				   </script>
                       </div>
				</form>
			</div>
		</main>
	</div>

	<%@ include file="Footer.jsp"%>
	<script src="form-validation.js" style="user-select: auto;"></script>
	<div class="liner-scroll-points-container" style="user-select: auto;"></div>
</body>
</html>