window.addEventListener("DOMContentLoaded", () => {

    document.getElementById("boton").onclick = function() {

    const array = document.getElementsByName('valor');

    for (let index = 0; index < array.length; index++) {
        var element = array[index];
        if(element.checked == true) {
            var res = `Has seleccionado el valor ${element.value}`;
        }            
    }
    console.log(res);
    }
});