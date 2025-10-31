window.addEventListener("DOMContentLoaded", () => {

    document.getElementById("botonformulario").onclick = function() {

        var array = document.getElementsByName("valor");

        var res = 0;

        for (let index = 0; index < array.length; index++) {
            const element = array[index];
            if(element.checked){
                res++;
            }
        }

        if(res >= 3) {
            alert("Hay 3 o más checkboxs marcados");
        } else {
            alert("Hay menos de 3 checkboxs marcados");
        }
    }







    document.getElementById("marcar").onclick = function() {
        var valor = document.getElementById("aparte");
        if(!valor.checked) {
            valor.checked = true;
        }
    }

    document.getElementById("desmarcar").onclick = function() {
        var valor = document.getElementById("aparte");
        if(valor.checked) {
            valor.checked = false;
        }
    }


});