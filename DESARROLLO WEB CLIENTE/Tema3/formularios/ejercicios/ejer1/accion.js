

window.addEventListener("DOMContentLoaded", () => {
    
    let cambiarTexto = confirm("¿Quieres cambiar el texto?");

    let parrafo = document.getElementById("texto");

    if (cambiarTexto) {
        parrafo.textContent = "Texto Cambiado";
    } else {
        let cambiarColor = confirm("¿Quieres cambiar el color del texto?");
    if (cambiarColor) {
        parrafo.style.color = "orange";
    }
}

});