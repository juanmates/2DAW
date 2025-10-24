
function inicio (){

    let $boton1 = document.getElementById('input1');
    let $boton2 = document.getElementById('input2');
    let $pulsame = document.getElementById('pulsame');    
    let $cambia = document.getElementById('cambia');




    $boton1.addEventListener('focus', rojo = () =>{
       $boton1.style.color = "red";
    })

    $boton1.addEventListener('blur', negro = () =>{
       $boton1.style.color = "black";
    })

    $boton2.addEventListener('focus', rojo = () =>{
       $boton2.style.color = "red";
    })

    $boton2.addEventListener('blur', negro = () =>{
       $boton2.style.color = "black";
    })

     $pulsame.addEventListener('click', azul = () =>{
       $pulsame.style.color = "blue";
    })

    $cambia.addEventListener('mouseover', naranja = () =>{
       $cambia.style.borderColor = "orange";
    })

}

window.addEventListener("DOMContentLoaded", inicio);