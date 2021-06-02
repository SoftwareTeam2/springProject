<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="Team2.youngcha.hellospring.domain.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>boardList</title>
</head>
<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">공지사항 관리</h1>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-outline btn-primary pull-right">
                        <i class="fa fa-edit fa-fw"></i> 공지사항 작성
                    </button>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">공지사항 </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>아이디</th>
                            <th>테이블 번호</th>
                            <th>인원수</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>자차여부</th>
                            <th>도착시간</th>
                            <th>도착기록</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="Reservation">
                          <form action="/waitList" method="POST">
                            <tr>
                                <td>${Reservation.customerID}</td>
                                <td>${Reservation.tableNo}</td>
                                <td>${Reservation.numberOfPeople}</td>
                                <td>${Reservation.customerName}</td>
                                <td>${Reservation.customerEmail}</td>
                                <td>${Reservation.hasCar}</td>
                                <td>${Reservation.reservationDate}</td>
                                <td><button>도착시간 기록하기</button></td>
                             </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>