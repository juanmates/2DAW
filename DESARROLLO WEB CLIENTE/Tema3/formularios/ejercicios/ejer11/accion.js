
window.addEventListener("DOMContentLoaded", () => {


    document.getElementById("btnComprobar").onclick = function() {

        let edad = document.getElementById("edad").value;

        let div = document.getElementById("resultado");

        if(isNaN(edad) || edad === "") {
            div.textContent = "Introduce un número válido";
            div.style.color = "red";
        } else if (edad >= 18) {
            div.textContent = "Eres mayor de edad";
            div.style.color = "green";
        }else {
            div.textContent = "Eres menor de edad";
            div.style.color = "red";
        }
    }

    
});