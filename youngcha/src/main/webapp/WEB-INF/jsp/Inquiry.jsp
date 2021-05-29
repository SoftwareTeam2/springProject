<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>예약조회</title>

	<link rel="canonical"
		  href="https://getbootstrap.com/docs/5.0/examples/carousel/">

	<!-- Bootstrap core CSS -->
	<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

	<!-- Favicons -->
	<%@ include file="NAVbar.jsp"%>

<style>
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

<link href="../../../../../../../youngcha/src/main/webapp/resources/css/carousel.css" rel="stylesheet">
<head>
	<div class="py-5 text-center" style="user-select: auto;">
		<h2 style="user-select: auto;">예약조회</h2>
	</div>
<body>
<div class="table-responsive" style="margin-bottom: 40px;">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th>테이블 위치</th>
				<th>인원 수</th>
				<th>자차 여부</th>
				<th>예약 시간</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>${reservation.tableNo}</td>
				<td>${reservation.numberOfPeople}</td>
				<td>${reservation.hasCar}</td>
				<td>${reservation.reservationDate}</td>
			</tr>
		</thead>
	</table>
</body>
</html>