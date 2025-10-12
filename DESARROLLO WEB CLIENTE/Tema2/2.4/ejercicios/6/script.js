

let esFinDeSemana = () => {
    var hoy = new Date().getDay();
    console.log(hoy);
    if(hoy == 0 || hoy == 6){
        return true;
    }
    return false;
}

function mostrarVentana() {
    var ventana = window.open('secundaria.html', 'secundaria', 'width=400,height=400');
    var foto;
    if(esFinDeSemana()){
        ventana.document.writeln(`<p>contento</p>`);
        foto = 'contento.jpg';
    } else  {
        foto = 'triste.jpg';
        ventana.document.writeln(`<p>triste</p>`);
    }
    ventana.document.writeln(`<img src="imagenes/${foto}" alt="">`);
}