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