window.addEventListener("DOMContentLoaded", () => {

    document.getElementById("boton").onclick = function() {

        const res = document.getElementById("res").value;

        if(res.toLowerCase() === "si") {
            console.log("Es mayor de edad");
        } else if(res.toLowerCase() === "no") {
            console.log("No es mayor de edad");
        } else {
            console.log("respuesta incorrecta");
        }
    }




});