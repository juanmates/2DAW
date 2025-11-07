window.addEventListener("DOMContentLoaded", () => {

    var boton = document.getElementById("abrirPagina");
    var ventana = null;

    boton.addEventListener("click", () => {

         ventana = window.open("datos.html", "ventana1", "height=300, width=400");

         var nombre = ventana.document.getElementById("nombre");
         console.log(nombre);


    });


});