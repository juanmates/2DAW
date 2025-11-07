window.addEventListener("DOMContentLoaded", () => {

    const formulario = document.getElementById("miFormulario");

    const elementos = formulario.elements;

    console.log(elementos);

    var res = "Los 'name' de los elementos del formulario son: "

    for(let i = 0; i < elementos.length; i++) {
        var elemento = elementos[i];
        if(i == elementos.length-1){
            res = res + `${elemento.name}`;
        } else {
            res = res + `${elemento.name}, `;
        }
    }

    alert(res);
    
    ///////////////////////////////////////////////////////////

    var res1 = "Los 'name' de los elementos que son text son: "

    for(let i = 0; i < elementos.length; i++) {
        var elemento = elementos[i];
        if(elemento.type == "text"){
            if(i == elementos.length-1){
                res1 = res1 + `${elemento.name}`;
            } else {
                res1 = res1 + `${elemento.name}, `;
            }   
        }
    }
    alert(res1);

    ///////////////////////////////////////////////////////////

    const nombre2 = document.getElementById("nombre").value;
    const apellido1 = document.getElementById("apellido1").value;
    const apellido2 = document.getElementById("apellido2").value;

    var res2 = `${nombre2} ${apellido1} ${apellido2}`;

    alert(res2);

    ///////////////////////////////////////////////////////////

    const formulario1 = document.getElementsByName("miFormulario");

    const nombre1 = document.formulario1.nombre;
    const apellido11 = document.formulario1.apellido1;
    const apellido21 = document.formulario1.apellido1;


    var res3 = `${nombre1.value} ${apellido11.value} ${apellido21.value} 2º res`;

    alert(res3);

    

});