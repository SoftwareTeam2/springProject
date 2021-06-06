<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script src="../../resources/js/walkIn.js"></script>
    <title>워크인 등록</title>
    <!-- Favicons -->
    <%@ include file="NAVbar.jsp"%>

</head>
<body style="padding-top: px;">
    <main style="margin-top: 50px;">
        <div>
            <div class="walkInDate">
                <label for="walkInDate">워크인 날짜</label>
                <input type="date" name="walkInDate" id="walkInDate">
            </div>
            <div class="ui-timepicker-wrapper">
                <label for="time1">워크인 시간</label>
                <input type="text" id="time1" name="time" class="timepicker" style="width:200px;">
                <script>
                    $(function() {
                        $("#time1").timepicker({
                            timeFormat: 'HH:mm',
                            interval: 30,
                            minTime: '10',
                            maxTime: '18:00',
                            defaultTime: '11',
                            startTime: '10:00',
                            dynamic: false,
                            dropdown: true,
                            scrollbar: true        
                        });
                    });
                    </script>
            </div>
            <div class="walkInPeople">
                <label for="numberOfPeople">인원 수</label>
                <select name="numberOfPeople" id="numberOfPeople">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
            </div>
            <div class="submit">
                <button id="submit">테이블 확인</button>
            </div>
            <div class="tableSelector">
            </div>
        </div>
    </main>
    <%@ include file="Footer.jsp"%>
</body>
</html>