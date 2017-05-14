/* 
* @Author: Marte
* @Date:   2016-04-22 16:29:17
* @Last Modified by:   Marte
* @Last Modified time: 2016-05-05 23:31:19
*/
$(function(){
    //$(".option ul li a" ).click(function(event) {
      //  $(this).addClass('current').parent('li').siblings().children('a').removeClass();
   // });
    $(".turn_option_Wrap .turn_option ul li a").click(function(event) {
        $(this).addClass('current').parent('li').siblings().children('a').removeClass();
    });
})
var flag = 1 ;
var flag2 = 1;
var flag3 = 1;
function orderBy(){
    flag2  = 1;
    flag3 = 1;
    $("#arr_top2").removeClass().addClass('arr_top');
    $('#arr_bottom2').removeClass().addClass('arr_bottom');

    $("#arr_top3").removeClass().addClass('arr_top');
    $('#arr_bottom3').removeClass().addClass('arr_bottom');

    $('#pad1').addClass('current').parent('li').siblings().children('a').removeClass

('current');
    $('#pad2').removeClass().addClass('pad sort_time01');
    $('#pad3').removeClass().addClass('pad sort_benjin');
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
    flag3 = 1;
    $("#arr_top").removeClass().addClass('arr_top');
    $('#arr_bottom').removeClass().addClass('arr_bottom');

    $("#arr_top3").removeClass().addClass('arr_top');
    $('#arr_bottom3').removeClass().addClass('arr_bottom');

    $('#pad2').addClass('current').parent('li').siblings().children('a').removeClass

('current');
    $('#pad1').removeClass().addClass('pad');
    $('#pad3').removeClass().addClass('pad sort_benjin');
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

function orderBy3(){
    flag = 1;
    flag2 = 1;
    $("#arr_top").removeClass().addClass('arr_top');
    $('#arr_bottom').removeClass().addClass('arr_bottom');

    $("#arr_top2").removeClass().addClass('arr_top');
    $('#arr_bottom2').removeClass().addClass('arr_bottom');

    $('#pad3').addClass('current').parent('li').siblings().children('a').removeClass

('current');

    $('#pad1').removeClass().addClass('pad');
     $('#pad2').removeClass().addClass('pad sort_time01');
    if(flag3 == 1){
        flag3 = 2;
        $("#arr_top3").removeClass().addClass('upOrde');
        $('#arr_bottom3').removeClass().addClass('arr_bottom_');
       
    }else{
         flag3 = 1;
         $("#arr_top3").removeClass().addClass('downOrde');
        $('#arr_bottom3').removeClass().addClass('arr_top_');
    }
   
}

function orderBya (){
    flag = 1;
    flag2 = 1;
    flag3 = 1;
    $("#arr_top").removeClass().addClass('arr_top');
    $('#arr_bottom').removeClass().addClass('arr_bottom');
    $("#arr_top2").removeClass().addClass('arr_top');
    $('#arr_bottom2').removeClass().addClass('arr_bottom');
    $("#arr_top3").removeClass().addClass('arr_top');
    $('#arr_bottom3').removeClass().addClass('arr_bottom');
    $('#pad1').removeClass().addClass('pad');
    $('#pad2').removeClass().addClass('pad');
    $('#pad3').removeClass().addClass('pad');
}

