window.addEventListener("DOMContentLoaded", () => {



    document.getElementById("boton").onclick = function() {
        
        const nombre = document.getElementById("nombre");

        const pintar = document.getElementById("pintar");
        const pintar1 = document.getElementById("pintar1");

        pintar.textContent = nombre.value;

        pintar1.innerHTML = nombre.value;
    }

    

});
