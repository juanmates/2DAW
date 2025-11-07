window.addEventListener("DOMContentLoaded", () => {

    var btn = document.getElementById("boton")
    


    btn.addEventListener("click", () =>  {

        var segundos = document.getElementById("segundos").value;

        var segundos1 = segundos;

        var ventanaEmergente = window.open("", "ventana 1", "width=300, height=200, left=300, top=300");

            var contador = setInterval(function(){

                segundos--;

                ventanaEmergente.document.body.innerHTML = `<p>Quedan ${segundos}</p>`;

                if(segundos == 0){
                    clearInterval(contador);
                    ventanaEmergente.close();
                    document.getElementById("resultado").textContent = `Ya han pasado ${segundos1} y se ha cerrado la ventana emergente`
                }
        }, 1000);


    });





});
