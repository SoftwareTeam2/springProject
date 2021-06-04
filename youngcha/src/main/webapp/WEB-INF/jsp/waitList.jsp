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
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>boardList</title>
    <script>

        $(document).ready(function(){
            $(document).on("click","button",function(){
                var button = $(this);
                var tr = $(this).parent().parent();
                var td = tr.children();
                var cid = td.eq(0).text();
                var resDate = td.eq(6).text();
                var dishes = td.eq(7).text();
                var dishCounts = td.eq(8).text();
                var resInfo={"customerID":cid,"reservationDate":resDate,"dishes":dishes,"dishCounts":dishCounts};
                $.ajax({
                    url:"/waitList",
                    type:'post',
                    contentType:'application/json; charset=utf8',
                    dataType:'json',
                    data:JSON.stringify(resInfo),
                    success:function(data){
                        console.log(data)
                        if(data){
                            alert("도착이 확인되었습니다.");
                            button.prop("disabled",true);
                        }else{
                            alert("오류가 발생하였습니다. 다시 시도하여 주십시오.");
                        }
                    }
                })
               
    
                    console.log(cid+' '+resDate+' '+dishes+' '+dishCounts);
                
            })
        })

        $(function(){
            $.ajax({
                url:'/waitList/getList',
                type:'get',

                success:function(data){
                    var targetTable = $('#tableBody');
                    data.forEach(function(item,idx){
                        var add_data='';
                        add_data +='<tr id="tr_'+idx+"\">"
                        
                        add_data +='<td>';
                        add_data += item['customerID']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['tableNo']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['numberOfPeople']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['customerName']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['customerEmail']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['hasCar']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['reservationDate']
                        add_data +='</td>';

                        add_data +='<td style="display:none">';
                        add_data += item['dishes']
                        add_data +='</td>';

                        add_data +='<td style="display:none">';
                        add_data += item['dishCounts']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += '<button class=\"tr-button\" id="tr_'+idx+"_button\"style=\"width=100%\">도착 확인</button>";
                        add_data +='</td>';

                        targetTable.append(add_data);

                        console.log(item['dishes']);
                    })
                }
            
            })
        })
        
    </script>
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
                            <th>예약 시간</th>
                            <th>도착 기록</th>
                        </tr>
                        </thead>
                        <tbody id="tableBody">
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>