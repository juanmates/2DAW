window.addEventListener("DOMContentLoaded", () => {

document.getElementById("boton").onclick = function() {
    let nuevoNombre = prompt("Introduce tu nombre:");
    document.getElementById("nombre").value = nuevoNombre;
    this.textContent = "Pulsado";
    }
    
});