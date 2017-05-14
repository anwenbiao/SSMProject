/* 
* @Author: Marte
* @Date:   2016-04-22 16:29:17
* @Last Modified by:   Marte
* @Last Modified time: 2016-05-03 09:40:55
*/
$(function(){
    $(".option ul li a" ).click(function(event) {
        $(this).addClass('current').parent('li').siblings().children('a').removeClass('current');
    });
})
var flag = 1 ;
var flag2 = 1;
function orderBy(){
    flag2  = 1;
    $("#arr_top2").removeClass().addClass('arr_top');
    $('#arr_bottom2').removeClass().addClass('arr_bottom');
    $('#pad1').addClass('current').parent('li').siblings().children('a').removeClass('current');
    if(flag == 1){
        flag = 2;
        $("#arr_top").removeClass().addClass('upOrde');
        $('#arr_bottom').removeClass().addClass('arr_bottom_');
       
    }else{
         flag = 1;
         $("#arr_top").removeClass().addClass('downOrde');
        $('#arr_bottom').removeClass().addClass('arr_top_');
    }
   
}


function orderBy2(){
    flag = 1;
    $("#arr_top").removeClass().addClass('arr_top');
    $('#arr_bottom').removeClass().addClass('arr_bottom');

    $('#pad2').addClass('current').parent('li').siblings().children('a').removeClass('current');
    if(flag2 == 1){
        flag2 = 2;
        $("#arr_top2").removeClass().addClass('upOrde');
        $('#arr_bottom2').removeClass().addClass('arr_bottom_');
       
    }else{
         flag2 = 1;
         $("#arr_top2").removeClass().addClass('downOrde');
        $('#arr_bottom2').removeClass().addClass('arr_top_');
    }
   
}

function orderBya (){
    flag = 1;
    flag2 = 1;
    $("#arr_top").removeClass().addClass('arr_top');
    $('#arr_bottom').removeClass().addClass('arr_bottom');
    $("#arr_top2").removeClass().addClass('arr_top');
    $('#arr_bottom2').removeClass().addClass('arr_bottom');
    $('#current').addClass('current').parent('li').siblings().children('a').removeClass('current');
}