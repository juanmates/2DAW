const esFinDeSemana = () => {
    let hoy = new Date(2025, 10, 12).getDay();
    if(hoy === 0 || hoy === 6){
        return true;
    }
    return false;
}

function mostrarVentana() {
    var ventana = window.open('secundaria.html', 'secundaria', 'width=400,height=400');
    var foto;
    if(esFinDeSemana()){
        foto = 'sonriente.webp';
    } else  {
        foto = 'triste.jpg';
    }
    ventana.document.writeln(`<img src="imagenes/${foto}" alt="">`);
}