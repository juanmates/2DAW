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


// A) CREAR NUEVA ENTRADA
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


// B) LISTAR TODAS LAS ENTRADAS
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


// C) ACTUALIZAR ENTRADA (PUT)
document.getElementById("formActualizar").addEventListener("submit", async (e) => {
  e.preventDefault();
  const f = e.target;

  const body = {
    id: Number(f.id.value),
    nombreComprador: f.nombreComprador.value,
    pelicula: f.pelicula.value,
    horario: f.horario.value,
    numeroEntradas: Number(f.numeroEntradas.value),
    precioPorEntrada: Number(f.precioPorEntrada.value),
    taquilla: f.taquilla.checked,
  };

  try {
    const response = await fetch(API_BASE, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body)
    });
    document.getElementById("actualizarResultado").innerHTML = 
      "LA ENTRADA HA SIDO ACTUALIZADA CORRECTAMENTE.";
    e.reset();
  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});


// D) ENTRADAS NO COMPRADAS EN TAQUILLA
document.getElementById("btnNoTaquilla").addEventListener("click", async (e) => {
  try {
    const response = await fetch(API_BASE+"/NoTaquilla", {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    });
    const data = await response.json();
    document.getElementById("noTaquillaResultado").innerHTML = "";

    data.forEach((element) => {
      document.getElementById("noTaquillaResultado").innerHTML +=
        mostrarEntrada(element);
    });

  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});

// E) Modificar número de entradas (PATCH)
document.getElementById("formPatchNumero").addEventListener("submit", async (e) => {
   e.preventDefault();
  const f = e.target;

  const body = {
    id: Number(f.id.value),
    numeroEntradas: Number(f.numeroEntradas.value),
  };
  
  try {
    const response = await fetch(API_BASE+`/nuevasEntradas/${body.id}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body)
    });
    const data = await response.json();
    document.getElementById("patchNumeroResultado").innerHTML = mostrarEntrada(data);

  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});

// F) DELETE POR NOMBRE
document.getElementById("formDelete").addEventListener("submit", async (e) => {
   e.preventDefault();
  const f = e.target;

  const body = {
    nombreComprador: f.nombreComprador.value,
  };
  
  try {
    const response = await fetch(API_BASE+`/${body.nombreComprador}`, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body)
    });
    const data = await response.json();
    document.getElementById("deleteResultado").innerHTML = `SE HAN BORRADO ${data} ENTRADAS`;

  } catch (error) {
    console.log("ERROR NO HA CARGADO");
  }
});
