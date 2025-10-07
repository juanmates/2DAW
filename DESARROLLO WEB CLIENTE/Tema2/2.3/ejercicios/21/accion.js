var ventana1 = null;
var ventana2 = null;

function abrirVentanas() {
  // Abre las dos ventanas secundarias
  ventana1 = window.open(
    "ventana1.html",
    "Ventana1",
    "width=300,height=200,left=100,top=300"
  );
  ventana2 = window.open(
    "ventana2.html",
    "Ventana2",
    "width=300,height=200,left=500,top=300"
  );

  ventana1.focus();
  ventana2.focus();
}

function cerrarVentanas() {
  if (ventana1 && !ventana1.closed) {
    ventana1.close();
  }
  if (ventana2 && !ventana2.closed) {
    ventana2.close();
  }
}

function cambiarFondoVentana1() {
  if (ventana1 && !ventana1.closed) {
    ventana1.focus();
    ventana1.document.body.style.backgroundColor = "#FFECA1";
  }
}

function cambiarFondoVentana2() {
  if (ventana2 && !ventana2.closed) {
    ventana2.focus();
    ventana2.document.body.style.backgroundColor = "#EFC3CA";
  }
}

function enviarSaludoVentana2() {
  if (window.opener && window.opener.ventana2) {
    window.opener.ventana2.document.body.innerHTML +=
      "<p>La ventana 1 te saluda</p>";
  }
}

function cambiarFondo2() {
  if (window.opener && window.opener.ventana2) {
    window.opener.ventana2.document.body.style.backgroundColor = "#7DDA58";
  }
}

function enviarSaludoVentana1() {
  if (window.opener && window.opener.ventana1) {
    window.opener.ventana1.document.body.innerHTML +=
      "<p>La ventana 2 te saluda</p>";
  }
}

function cambiarFondo1() {
  if (window.opener && window.opener.ventana1) {
    window.opener.ventana1.document.body.style.backgroundColor = "#5DE2E7";
  }
}
