
function inicio (){

    let $sumar = document.getElementById('sumar');
    let $restar = document.getElementById('restar');
    let $div = document.getElementById('div');    

    $sumar.addEventListener('click', sumar = () =>{

        let numero = parseInt($div.innerHTML);

        numero = numero + 1;

       $div.innerHTML = numero;
    })

     $restar.addEventListener('click', restar = () =>{

       let numero = parseInt($div.innerHTML);

        numero = numero - 1;

        if(numero === 3){
            $div.innerHTML = "Alcanzado valor 3";
        }else{
            $div.innerHTML = numero;
        }

       
    })

}

window.addEventListener("DOMContentLoaded", inicio);