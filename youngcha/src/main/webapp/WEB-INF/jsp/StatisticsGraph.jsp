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
<title>통계</title>

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

.chartjs-render-monitor {
	animation: chartjs-render-animation 1ms;
	animation-duration: 1ms;
	animation-timing-function: ease;
	animation-delay: 0s;
	animation-iteration-count: 1;
	animation-direction: normal;
	animation-fill-mode: none;
	animation-play-state: running;
	animation-name: chartjs-render-animation;
}

.my-4 {
	margin-top: 2.0rem !important;
	margin-bottom: 2.0rem !important;
}

.w-100 {
	width: 100% !important;
}

canvas[Attributes Style] {
	aspect-ratio: auto 621/262;
}
#login_wrapper { 
width: 100%;
  max-width: 1500px;
  padding-top : 30px;
  padding-right: 150px;
  margin: auto;
  }
</style>

<link href="../../resources/css/carousel.css" rel="stylesheet">

</head>

<body >

	<div class="container-fluid" style="margin-top: 15px" id="login_wrapper">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="chartjs-size-monitor">
					<div class="chartjs-size-monitor-expand">
						<div class=""></div>
					</div>
					<div class="chartjs-size-monitor-shrink">
						<div class=""></div>
					</div>
				</div>
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">매출량</h1>
				</div>
				<canvas class="my-4 w-100 chartjs-render-monitor" id="myChart"
					width="1075" height="453"
					style="display: block; width: 1075px; height: 453px;"></canvas>

				<h2>재고량</h2>
				<div class="table-responsive" style="margin-bottom: 40px;">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th>이름</th>
								<th>재고량</th>
								<th>유통기한</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>재료1</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료2</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료3</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료4</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료5</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료6</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료7</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료8</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료9</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
							<tr>
								<td>재료10</td>
								<td>100</td>
								<td>2021-05-20</td>
							</tr>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
	<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="../../resources/js/dashboard.js"></script>

	<%@ include file="Footer.jsp"%>
</body>
</html>