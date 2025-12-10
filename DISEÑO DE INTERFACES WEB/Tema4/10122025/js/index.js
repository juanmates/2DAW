$(document).ready(function(){

    //alert();
    $("button").on("click", function() {
        inicio($(this));
    });

    $(document).on("keydown", function(e) {
        $('div').empty();
        if (e.which == 38) {
            $("<p>ARRIBA</p>").appendTo("div");
        } else if(e.which == 40) {
            $("<p>ABAJO</p>").appendTo("div");
        } else if(e.which == 39) {
            $("<p>DERECHA</p>").appendTo("div");
        } else if(e.which == 37) {
            $("<p>IZQUIERDA</p>").appendTo("div");
        }   
    });




});




function inicio(boton){
    boton.hide();
}