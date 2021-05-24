<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>

<link href="../../resources/css/carousel.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>

<body style="padding-top: px;">
	<main>
		<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
			<ol class="carousel-indicators">
				<li data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"></li>
				<li data-bs-target="#myCarousel" data-bs-slide-to="1"></li>
				<li data-bs-target="#myCarousel" data-bs-slide-to="2"></li>
			</ol>

			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../../resources/image/food.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption text-start"
							style="margin-bottom: -2rem;">
							<h1>Restaurant</h1>
							<p>저희 레스토랑에 오신 것을 환영합니다.</p>
						</div>
					</div>
				</div>

				<div class="carousel-item">
					<img src="../../resources/image/rooney.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<div class="carousel-item">
					<img src="../../resources/image/jisung.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption text-end">
							<h1>One more for good measure.</h1>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Browse
									gallery</a>
							</p>
						</div>
					</div>
				</div>
			</div>

			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-bs-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-bs-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="visually-hidden">Next</span>
			</a>
		</div>

		<div class="container marketing">
			<div class="row">
				<div class="col-lg-4">
					<div style="cursor: pointer;" onclick="location.href='Route.jsp'">
						<img class="d-block mx-auto mb-4" src="../../resources/image/ronaldo.png" alt=""
							width="252" height="252">
					</div>

					<h2>오시는 길</h2>

				</div>

				<div class="col-lg-4">
					<div style="cursor: pointer;"
						onclick="location.href='Menu.jsp'">
						<img class="d-block mx-auto mb-4" src="../../resources/image/rooney.jpg" alt=""
							width="252" height="252">
					</div>

					<h2>자주 묻는 질문</h2>

				</div>

				<div class="col-lg-4">
					<div style="cursor: pointer;" onclick="location.href='Page.jsp'">
						<img class="d-block mx-auto mb-4" src="../../resources/image/jisung.jpg" alt=""
							width="252" height="252">
					</div>

					<h2>이용 후기</h2>
				</div>
			</div>
			<div class="row featurette" style="user-select: auto;">
				<div class="col-md-7" style="user-select: auto;">
					<h2 class="featurette-heading" style="user-select: auto;">
						First featurette heading. <span class="text-muted"
							style="user-select: auto;">It’ll blow your mind.</span>
					</h2>
					<p class="lead" style="user-select: auto;">Some great
						placeholder content for the first featurette here. Imagine some
						exciting prose here.</p>
				</div>
				<div class="col-md-5" style="user-select: auto;">
					<svg
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" xmlns="http://www.w3.org/2000/svg"
						role="img" aria-label="Placeholder: 500x500"
						preserveAspectRatio="xMidYMid slice" focusable="false"
						style="user-select: auto;">
					<title style="user-select: auto;">Placeholder</title><rect
							width="100%" height="100%" fill="#eee" style="user-select: auto;"></rect>
					<text x="50%" y="50%" fill="#aaa" dy=".3em"
							style="user-select: auto;">500x500</text></svg>

				</div>
			</div>
			<div class="row featurette" style="user-select: auto;">
				<div class="col-md-7 order-md-2" style="user-select: auto;">
					<h2 class="featurette-heading" style="user-select: auto;">
						Oh yeah, it’s that good. <span class="text-muted"
							style="user-select: auto;">See for yourself.</span>
					</h2>
					<p class="lead" style="user-select: auto;">Another featurette?
						Of course. More placeholder content here to give you an idea of
						how this layout would work with some actual real-world content in
						place.</p>
				</div>
				<div class="col-md-5 order-md-1" style="user-select: auto;">
					<svg
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" xmlns="http://www.w3.org/2000/svg"
						role="img" aria-label="Placeholder: 500x500"
						preserveAspectRatio="xMidYMid slice" focusable="false"
						style="user-select: auto;">
					<title style="user-select: auto;">Placeholder</title><rect
							width="100%" height="100%" fill="#eee" style="user-select: auto;"></rect>
					<text x="50%" y="50%" fill="#aaa" dy=".3em"
							style="user-select: auto;">500x500</text></svg>

				</div>
			</div>
		</div>

	</main>
	<%@ include file="Footer.jsp"%>
</body>
</html>