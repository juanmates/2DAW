let texto = "En un lugar de la Mancha";

// cada 5 segundos lanza el mensaje;
let temp = setInterval(mensaje, 2000);

function mensaje() {
  console.log(` ${texto} `);
}

function para() {
  clearInterval(temp);
}

function lanza() {
  setTimeout(temporizador2, 3000);
}

function temporizador2() {
  console.log("Han pasado 3 segundos");
}

function abreVentana() {
  nuevaVentana = window.open("", "Nueva Página", "width=300,height=300");
  nuevaVentana.document.write("<p>Reloj</p>");

  fin = nuevaVentana.setInterval(escribeHora, 1000);
  setTimeout(pararReloj, 5000);
  setTimeout(cerrarVentana, 10000);
}

function escribeHora() {
  var fecha = new Date();
  var h = (m = s = 0);

  h = fecha.getHours();
  m = fecha.getMinutes();
  s = fecha.getSeconds();
  if (h < 10) h = "0" + h;
  if (m < 10) m = "0" + m;
  if (s < 10) s = "0" + s;

  nuevaVentana.document.write(h + ":" + m + ":" + s + "<br>");
}

function pararReloj() {
  nuevaVentana.clearTimeout(fin);
}

function cerrarVentana() {
  nuevaVentana.close();
}
