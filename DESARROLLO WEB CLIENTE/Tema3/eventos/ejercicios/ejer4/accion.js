window.addEventListener("DOMContentLoaded", () => {
    
        const sumarBtn = document.getElementById('sumar');
        const restarBtn = document.getElementById('restar');
        const contadorDiv = document.getElementById('contador');
        const mensajeDiv = document.getElementById('mensaje');
        
        let contador = 5;
        
        function actualizarContador() {
            contadorDiv.textContent = contador;
            
            if(contador === 3) {
                mensajeDiv.style.display = 'block';
            } else {
                mensajeDiv.style.display = 'none';
            }
        }
        
        sumarBtn.addEventListener('click', () => {
            contador++;
            actualizarContador();
        });
        
        restarBtn.addEventListener('click', () => {
            contador--;
            actualizarContador();
        });







});