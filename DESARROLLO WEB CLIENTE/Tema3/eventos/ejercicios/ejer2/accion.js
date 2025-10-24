function inicio() {

    const $input1 = document.getElementById("input1");
    const $input2 = document.getElementById("input2");
    const $boton1 = document.getElementById("pulsame");
    const $boton2 = document.getElementById("cambia");


    $input1.addEventListener('focus', rojo = () => {
        $input1.style.color = "red";
    })
    $input1.addEventListener('blur', negro = () =>{
       $input1.style.color = "black";
    })

    $input2.addEventListener('focus', rojo = () => {
        $input2.style.color = "red";
    })
    $input2.addEventListener('blur', negro = () =>{
       $input2.style.color = "black";
    })

    $boton1.addEventListener('click', azul = () =>{
       $boton1.style.color = "blue";
    })

    $boton2.addEventListener('mouseover', naranja = () =>{
       $boton2.style.borderColor = "orange";
    })


}
window.addEventListener("DOMContentLoaded", inicio);