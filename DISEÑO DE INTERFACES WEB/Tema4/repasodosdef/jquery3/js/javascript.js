jQuery(document).ready(function ($) {

});

$(function (){
    $(".item").hide()

    $("#mostrar").on("click",function(){
        $(".item").show()
        $("#mostrar").hide()
    })

    $("#item").on("click",function(){
        $(".item").hide()
        $("#mostrar").show()
    })
})