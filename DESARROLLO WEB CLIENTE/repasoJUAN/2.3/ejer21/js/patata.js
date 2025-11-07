function inicio() {

    var botonAbrir = document.getElementById("botonAbrir");

    botonAbrir.addEventListener('click', () => {

       var v1 = window.open("ventana1.html","Ventana1","width=300,height=200,left=100,top=300");

      function abrirV2() {
        if(window.opener){
          var v2 = window.open("ventana2.html","Ventana2","width=300,height=200,left=500,top=300");
        }
      }
      v2 = abrirV2();


      v1.focus();
      v2.focus();


    })
}
window.addEventListener("DOMContentLoaded", inicio);