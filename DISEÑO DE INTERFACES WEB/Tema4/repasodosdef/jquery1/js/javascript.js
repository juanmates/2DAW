jQuery(document).ready(function ($) {

});

$(function () {
    $(".contenido").hide()
    let interruptor = false;
    let interruptor2 = false;

    $("#botoncontenido").on("click", function () {
        $(".contenido").toggle()
    })

    $(".parrafo").on("click", function () {

        interruptor = !interruptor;

        if (interruptor) {

            $(".parrafo").css("position", "absolute");
            $(".parrafo").css("left", "50px");
            $(".parrafo").css("top", "200px");
            $(".parrafo").css("width", "50%");
            $(".parrafo").css("background-color", "red");
            $(".parrafo").css("color", "white");

        } else {

            $(".parrafo").css("position", "");
            $(".parrafo").css("left", "");
            $(".parrafo").css("top", "");
            $(".parrafo").css("width", "");
            $(".parrafo").css("background-color", "");
            $(".parrafo").css("color", "");

        }

    })

    $(".parrafo2").on("click", function () {

        interruptor2 = !interruptor2;
        if (interruptor2) {
            $(".parrafo2").slideUp("slow", function () {
                $(".parrafo2").css("position", "absolute");
                $(".parrafo2").css("left", "50px");
                $(".parrafo2").css("top", "90px");
                $(".parrafo2").css("width", "50%");
                $(".parrafo2").css("background-color", "yellow");
                $(".parrafo2").css("color", "black");
            })
            $(".parrafo2").slideDown("slow");
        } else {
            $(".parrafo2").slideUp("slow", function () {
                $(".parrafo2").css("position", "");
                $(".parrafo2").css("left", "");
                $(".parrafo2").css("top", "");
                $(".parrafo2").css("width", "");
                $(".parrafo2").css("background-color", "");
                $(".parrafo2").css("color", "");
            })
            $(".parrafo2").slideDown("slow");
        }

    })

    $('.ojo').click(function () {
        let boton = $(this);
        let input = boton.siblings('input');
        let icono = boton.find('i');

        icono.toggleClass('bi-eye bi-eye-slash');

        if (input.attr('type') === 'password') {
            input.attr('type', 'text');
        } else {
            input.attr('type', 'password');
        }
    });
});

