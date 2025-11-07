window.addEventListener("DOMContentLoaded", () => {

    for(var i= 0; i < 2000; i++){

        var rojo = Math.floor(Math.random()*(255 - 0 + 1)) + 0;
        var azul = Math.floor(Math.random()*(255 - 0 + 1)) + 0;
        var green = Math.floor(Math.random()*(255 - 0 + 1)) + 0;

        let l = parseInt(Math.random() * 1280);
        let t = parseInt(Math.random() * 1024);


        var div = `<div style="width:50px; height:50px; background-color:rgb(${rojo}, ${green}, ${azul}); top:${t}px;left:${l}px;position:absolute"></div>`

        document.body.innerHTML += div;

    }

});