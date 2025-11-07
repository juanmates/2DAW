window.addEventListener("DOMContentLoaded", () => {

    var contador = document.getElementById("temporizador");
    var btonInicio = document.getElementById("iniciar");
    var btonPausa = document.getElementById("pausar");
    var btonReinicio = document.getElementById("reiniciar");
    var tiempo = parseInt(temporizador.textContent);
    var intervalo;

    btonInicio.addEventListener("click", function() {

        intervalo = setInterval(() => {
            tiempo--;
            contador.textContent = tiempo;
        
        if(tiempo <= 0){
            clearInterval(intervalo);
            alert("El tiempo ha finalizado");
        }
        }, 1000);
    })
        
    btonPausa.addEventListener("click", function(){

        clearInterval(intervalo);        

    });

    btonReinicio.addEventListener("click", function () {

        clearInterval(intervalo);
        tiempo = 30;
        temporizador.textContent = tiempo;

      });

});