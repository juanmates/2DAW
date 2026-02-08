$(document).ready(function() {
    $('.skip-link').on('click', function(e) {
        e.preventDefault();
        var target = $(this).attr('href');
        $('html, body').animate({
            scrollTop: $(target).offset().top
        }, 100, function() {
            $(target).focus();
            console.log("Foco movido al contenido principal vía jQuery");
        });
    });
});