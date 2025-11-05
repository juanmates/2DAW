window.addEventListener("DOMContentLoaded", () => {


    document.getElementById("boton").onclick = function() {

        const check1 = document.getElementById("1");
        const check2 = document.getElementById("2");
        const check3 = document.getElementById("3");
        const check4 = document.getElementById("4");

        let array = [check1, check2, check3, check4];

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