window.addEventListener("DOMContentLoaded", () => {


    document.getElementById("boton").onclick = function() {

        const array = document.getElementsByName('valor');

        var suma = 0;

        for (let index = 0; index < array.length; index++) {
            var element = array[index];
            if(element.checked == true) {
            suma = suma + parseInt(element.value);
            }
            element.checked = false;
        }
        console.log(suma);
    }
    
});