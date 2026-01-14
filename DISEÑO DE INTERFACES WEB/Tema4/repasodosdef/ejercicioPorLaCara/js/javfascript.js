jQuery(document).ready(function ($) {
    $("#radioDefault1").on("click",function(){
        $(".parrafos").toggle();

    })

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
});
