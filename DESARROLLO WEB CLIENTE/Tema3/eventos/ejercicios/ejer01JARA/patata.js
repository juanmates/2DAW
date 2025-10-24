window.addEventListener("DOMContentLoaded", inicio);

function inicio(){


    let $boton = document.getElementById('name');

    $boton.addEventListener('blur', validar = () =>{
            $boton.value = $boton.value.toUpperCase();
            $boton.select();
    });

}