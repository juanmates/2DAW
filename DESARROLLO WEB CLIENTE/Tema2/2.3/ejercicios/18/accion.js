let temp = setInterval(cambiarColor, 1000);

function cambiarColor() {
  let fondo = document.body.style.backgroundColor;

  if (fondo == "orange") {
    document.body.style.backgroundColor = "blue";
  } else {
    document.body.style.backgroundColor = "orange";
  }
}

function detener() {
  clearInterval(temp);
}
