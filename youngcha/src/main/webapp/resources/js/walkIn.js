$(document).ready(function(){

    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth()+1;
    var year = date.getFullYear();

    if(month<10) month = "0"+month;
    if (day<10) day = "0"+day;

    var today = year+"-"+month+'-'+day;
    $('#walkInDate').attr("value",today);
})
$(function(){
    $('#submit').click(function(){
        var numberOfPeople = $('#numberOfPeople').val();
        var guestCount = {"guestCount":numberOfPeople}
        $.ajax({
            url:'/walkIn/validTables',
            type:'post',
            contentType:'application/json; charset=utf8',
            dataType:'json',
            data:JSON.stringify(guestCount),

            success:function(data){
                var selector = '<select name=\'tableOption\' id=\'tableOption\'>';
                data.forEach(function(bool,idx){
                    if(bool){
                        var tableNo = idx+1
                        selector += '<option value=\''+tableNo+'\'>'+tableNo+'</option>';
                    }
                })
                selector += '</select>'
                $('.tableSelector').append('<img id="image" src=\"../../resources/image/structure.jpg\"/>');
                $('.tableSelector').append(selector);
            }
        })
    })
})