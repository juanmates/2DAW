const API_BASE = "http://localhost:8080/api/entradas";

const mostrarEntrada = function (data) {
  return `
        <div class="card">
            <strong>Comprador: ${data.nombreComprador}</strong>
            <strong>Pelicula: ${data.pelicula}</strong>
            <strong>Horario: ${data.horario}</strong>
            <strong>Numero de entradas: ${data.numeroEntradas}</strong>
            <strong>Precio por entrada: ${data.precioPorEntrada}</strong>
            <strong>Taquilla: ${data.taquilla}</strong>
        </div>
    `;
};

document.getElementById("formCrear").addEventListener("submit", async (e) => {
  e.preventDefault();
  const f = e.target;

  const body = {
    nombreComprador: f.nombreComprador.value,
    pelicula: f.pelicula.value,
    horario: f.horario.value,
    numeroEntradas: Number(f.numeroEntradas.value),
    precioPorEntrada: Number(f.precioPorEntrada.value),
    taquilla: f.taquilla.checked,
  };

  try {
    const response = await fetch(API_BASE, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await response.json();
    document.getElementById("crearResultado").innerHTML = mostrarEntrada(data);
    e.reset();
  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});


document.getElementById("btnListar").addEventListener("click", async (e) => {
  try {
    const response = await fetch(API_BASE, {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    });
    const data = await response.json();
    document.getElementById("listaEntradas").innerHTML = "";

    data.forEach((element) => {
      document.getElementById("listaEntradas").innerHTML +=
        mostrarEntrada(element);
    });

  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});


