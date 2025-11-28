        window.addEventListener("DOMContentLoaded", () => {

        var boton = document.getElementById("btnTodas");

        async function mostrarTabla() {
            try {
                const response = await fetch('http://localhost:8082/peliculas');
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json(); // Espera y procesa el JSON
            var html = `<h1>Películas encontradas</h1>
            <table>
                <tr><th>ID</th><th>Título</th><th>Director</th><th>Fecha</th><th>Duracion</th><th>Actores</th></tr>`
            data.forEach(p => {
                const actores = p.actores.map(a => a.nombre).join(", ");
                html += `
            <tr>
                <td>${p.id}</td>
                <td>${p.titulo}</td>
                <td>${p.director}</td>
                <td>${p.fechaLanzamiento}</td>
                <td>${p.duracion}</td>
                <td>${actores}</td>
            </tr>`;
            });
            html += `</table>`;
            document.getElementById("resultado").innerHTML = html;
            } catch (error) {
                console.error('Error al realizar la solicitud:', error); // Manejo de errores
            }
        }
        boton.addEventListener("click", mostrarTabla());
    })