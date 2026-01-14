jQuery(document).ready(function ($) {

});

$(function () {
    $(".oculto").hide();
    $(".boton").on("click", function () {
        $( ".formulario" ).slideUp( "slow", function() {
            $(".titulo").css("color", "red");
            $(".oculto").show();
        });
        
    })



});