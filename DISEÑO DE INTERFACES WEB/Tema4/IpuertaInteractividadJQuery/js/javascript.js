jQuery(document).ready(function ($) {

});

$(function () {

    $(".acceso").hide();
    $(".crear").hide();
    $(".formproveedor").hide();
    $(".formcliente").hide();
    $(".agradecimiento").hide();
    $("#ojot").hide();

    $("#sesion").on("click", function () {
        $(".acceso").toggle();
        $(".texto").toggle();
        $(".botones").toggle();
    });

    $("#crear").on("click", function () {
        $(".crear").toggle();
        $(".texto").toggle();
        $(".botones").toggle();
    });

    $("#iniciosesion2").on("click", function () {
        $(".crear").toggle();
        $(".formproveedor").toggle();
    });

    $("#iniciosesion3").on("click", function () {
        $(".crear").toggle();
        $(".formcliente").toggle();
    });

    $("#iniciosesion4").on("click", function () {
        $(".formproveedor").toggle("fast");
        $(".agradecimiento").toggle("slow");
    });

    $("#iniciosesion5").on("click", function () {
        $(".formcliente").toggle("fast");
        $(".agradecimiento").toggle("slow");
    });






    const emailInput = document.getElementById('exampleInputEmail1');
    const passInput = document.getElementById('exampleInputPassword1');
    const boton = document.getElementById('iniciosesion');


    function validarFormulario() {

        if (emailInput.value.trim() !== "" && passInput.value.trim() !== "") {
            boton.disabled = false;
        } else {
            boton.disabled = true;
        }
    }

    emailInput.addEventListener('input', validarFormulario);
    passInput.addEventListener('input', validarFormulario);
    boton.addEventListener('input', validarFormulario);


});

$(document).ready(function () {

    const nombre = document.getElementById('nombre2');
    const email = document.getElementById('correo2');
    const contraseña1 = document.getElementById('inputPassword5');
    const contraseña2 = document.getElementById('inputPassword52');
    const terminos = document.getElementById('exampleCheck1');
    const boton2 = document.getElementById('iniciosesion4');
    const año = document.getElementById('año');
    const mes = document.getElementById('mes');
    const dia = document.getElementById('dia');

    function validarFormulario() {
        if (nombre.value.trim() !== "" && email.value.trim() !== "" && contraseña1.value.trim() !== "" && contraseña2.value.trim() !== "" && año.value.trim() !== "" && mes.value.trim() !== "" && dia.value.trim() !== "" && terminos.checked) {
            boton2.disabled = false;
        } else {
            boton2.disabled = true;
        }
    }

    nombre.addEventListener('input', validarFormulario);
    email.addEventListener('input', validarFormulario);
    contraseña1.addEventListener('input', validarFormulario);
    contraseña2.addEventListener('input', validarFormulario);
    año.addEventListener('change', validarFormulario);
    mes.addEventListener('change', validarFormulario);
    dia.addEventListener('change', validarFormulario);
    terminos.addEventListener('change', validarFormulario);


});

$(document).ready(function () {

    const nombrecli = document.getElementById('nombrecli');
    const emailcli = document.getElementById('correocli');
    const contraseñacli1 = document.getElementById('passwordcli');
    const contraseñacli2 = document.getElementById('passwordcli2');
    const terminoscli = document.getElementById('checkcli');
    const boton3 = document.getElementById('iniciosesion5');


    function validarFormulario() {
        if (nombrecli.value.trim() !== "" && emailcli.value.trim() !== "" && contraseñacli1.value.trim() !== "" && contraseñacli2.value.trim() !== "" && terminoscli.checked) {
            boton3.disabled = false;
        } else {
            boton3.disabled = true;
        }
    }

    nombrecli.addEventListener('input', validarFormulario);
    emailcli.addEventListener('input', validarFormulario);
    contraseñacli1.addEventListener('input', validarFormulario);
    contraseñacli2.addEventListener('input', validarFormulario);
    terminoscli.addEventListener('change', validarFormulario);


});


document.addEventListener('focusout', (e) => {

    if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {

        const input = e.target;
        const siguiente = input.nextElementSibling;
        const existeError = siguiente && siguiente.classList.contains('error-msg');

        if (input.value.trim() === "") {
            input.style.backgroundColor = "#ffe4e4";
            input.style.border = "2px solid red";

            if (!existeError) {
                const mensaje = document.createElement('span');
                mensaje.textContent = "No se puede dejar este campo en blanco";
                mensaje.style.color = "red";
                mensaje.style.fontSize = "12px";
                mensaje.style.display = "block";
                mensaje.classList.add('error-msg');
                input.insertAdjacentElement('afterend', mensaje);
            }
        } else {
            input.style.backgroundColor = "";
            if (existeError) siguiente.remove();
        }
    }
});

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

$('.ojo1').click(function () {
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

$('.ojo2').click(function () {
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

$('.ojo3').click(function () {
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

$('.ojo4').click(function () {
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

