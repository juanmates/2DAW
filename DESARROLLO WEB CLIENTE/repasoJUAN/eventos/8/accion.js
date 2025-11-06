window.addEventListener("DOMContentLoaded", () => {

document.getElementById("formulario").addEventListener("submit", (e) => {
  e.preventDefault();
  const nom = nombre.value.trim();
  const ape = apellidos.value.trim();
  const ed = edad.value.trim();
  const prov = provincia.value;
  const res = document.getElementById("resultado");
  res.textContent = "";

  if (!nom) return res.textContent = "Nombre vacío";
  if (!ape) return res.textContent = "Apellidos vacíos";
  if (!ed) return res.textContent = "Edad vacía";
  if (isNaN(ed) || ed < 0 || ed > 105) return res.textContent = "Edad no válida";
  if (prov === "0") return res.textContent = "Seleccione una provincia";

  if (confirm("¿Deseas enviar el formulario?")) e.target.submit();
});
});