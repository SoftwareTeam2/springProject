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
<title>메뉴</title>
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
<body>
	<div class="row featurette" style="margin-top:40px">
	<h1 style="text-align:center" style="margin-top:10px">메뉴판</h1>
      <div class="col-md-7 order-md-2">
        <h2 class="lead" style="margin-top:10px">후라이드 치킨</h2>
        <p class="lead" style="margin-top:10px">
        겉바속촉 깨끗한 해바라기유를 사용한 치킨입니당
        </p>
        <p class="lead" style="margin-top:10px">15000원</p>
      </div>
      <div class="col-md-5 order-md-1">
        <img class="d-block mx-auto mb-4" src="../../resources/image/chicken1.jpg" width="252" height="252">
      </div>
    </div>
    
    <div class="row featurette" style="margin-top:20px">
      <div class="col-md-7 order-md-2">
        <h2 class="lead" style="margin-top:10px">양념치킨</h2>
        <p class="lead" style="margin-top:10px">
        50년 전통의 비법으로 만든 양념을 이용한 치킨입니당
        </p>
        <p class="lead" style="margin-top:10px">16000원</p>
      </div>
      <div class="col-md-5 order-md-1" style="margin-bottom:40px;">
        <img class="d-block mx-auto mb-4" src="../../resources/image/chicken2.png" width="252" height="252">
      </div>
    </div>
    
    <%@ include file="Footer.jsp"%>
</body>
</html>