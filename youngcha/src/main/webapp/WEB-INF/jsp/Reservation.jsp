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
<title>메인 페이지</title>

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
	<img class="d-block mx-auto mb-4" src="../../resources/image/jisung.jpg" alt=""
		width="100" height="125" style="user-select: auto;">
	<h2 style="user-select: auto;">예약</h2>
</div>
<body class="bg-light">
	<div class="container" style="user-select: auto;" id="login_wrapper">
	<main style="user-select: auto;">
			<div class="col-md-7 col-lg-8" style="user-select: auto;">
				<h4 class="mb-3" style="user-select: auto;">Reservation</h4>
				<form action="/reservations/new" method="POST" class="needs-validation" novalidate=""
					style="user-select: auto;">
					<div class="row g-3" style="user-select: auto;">
						<div class="col-md-5" style="user-select: auto;">
							<label for="tableNo" class="form-label" style="user-select: auto;">테이블
								위치</label> <select class="form-select" id="tableNo" name="tableNo" required=""
								style="user-select: auto;">
								<option value="" style="user-select: auto;">선택</option>
								<option style="user-select: auto;">1</option>
								<option style="user-select: auto;">2</option>
								<option style="user-select: auto;">...</option>
							</select>
							<div class="invalid-feedback" style="user-select: auto;">
								Please select a valid country.</div>
						</div>

						<div class="col-md-4" style="user-select: auto;">
							<label for="numberOfPeople" class="form-label"
								style="user-select: auto;">인원 수</label> <select
								class="form-select" name="numberOfPeople" id="numberOfPeople" required=""
								style="user-select: auto;">
								<option value="" style="user-select: auto;">선택</option>
								<option style="user-select: auto;">1</option>
								<option style="user-select: auto;">2</option>
								<option style="user-select: auto;">3</option>
								<option style="user-select: auto;">4</option>
							</select>
							<div class="invalid-feedback" style="user-select: auto;"></div>
						</div>

						<div class="col-md-3" style="user-select: auto;">
							<label for="hasCar" class="form-label">자차여부</label>
							<div class="col-lg-10">
								<label class="radio-inline y-1"> <input type="radio"
									id="hasCar" name="hasCar" value="Y" checked>
									Y
								</label> <label class="radio-inline"> <input type="radio"
									id="hasCar" name="hasCar" value="N"> N
								</label>
							</div>
						</div>
						<div>
							<input type="text" id="datePicker" class="form-control" value="종료시간선택" name="reservationDate">
						</div>
					</div>

					<button class="my-4 w-100 btn btn-warning btn-primary btn-lg"
						type="submit" style="user-select: auto;">Continue to
						checkout</button>
				</form>
			</div>
				</main>
	</div>

	<%@ include file="Footer.jsp"%>

	<script src="form-validation.js" style="user-select: auto;"></script>
	<div class="liner-scroll-points-container" style="user-select: auto;"></div>
</body>
</html>