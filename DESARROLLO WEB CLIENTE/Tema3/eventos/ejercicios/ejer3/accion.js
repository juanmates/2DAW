window.addEventListener("DOMContentLoaded", () => {

    var boton = document.getElementById("boton");
    var formulario = document.getElementById("formulario");
    var conteo = 0;



    boton.addEventListener('click', (e) => {
        //e.preventDefault(); ===> esto sirve para que el formulario no se refresque 
        if (! formulario) return false;

        for (var i=0; i< formulario.elements.length; i++){

            if (formulario.elements[i].type == "checkbox" && formulario.elements[i].checked){
                conteo++;
            }
        }

        if (conteo >= 3) {
            alert("Hay 3 o más checkbox marcados")
        } else {
            alert("Hay menos de 3 checkbox marcados")
        }
    });
});