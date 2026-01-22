document.addEventListener('DOMContentLoaded', function() {
    var carrusel = document.getElementById('carouselExampleCaptions');
    var carruselAux = new bootstrap.Carousel(carrusel, {
        interval: 3000,
        wrap: true
    });

    // Opcional: Pausar al pasar el mouse por encima
    carrusel.addEventListener('mouseenter', function() {
        carruselAux.pause();
    });

    // Reanudar al quitar el mouse
    carrusel.addEventListener('mouseleave', function() {
        carruselAux.cycle();
    });
});