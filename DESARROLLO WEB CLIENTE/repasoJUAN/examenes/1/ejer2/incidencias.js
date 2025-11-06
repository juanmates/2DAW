window.addEventListener("DOMContentLoaded", () => {
    // D
    let incidencias = [{
            id: 1,
            estado: "Abierta",
            asunto: "Error en login",
            descripcion: "Error al iniciar sesión con usuario válido",
            detalles: {
                prioridad: "Alta",
                usuario: "Belén"
            }
        },
        {
            id: 2,
            estado: "Cerrada",
            asunto: "Bug interfaz",
            descripcion: "El botón no responde en el panel de control",
            detalles: {
                prioridad: "Media",
                usuario: "Carlos"
            }
        },
        {
            id: 3,
            estado: "Pendiente",
            asunto: "Fallo de conexión",
            descripcion: "No se conecta con el servidor",
            detalles: {
                prioridad: "Alta",
                usuario: "Lucía"
            }
        },
        {
            id: 4,
            estado: "Abierta",
            asunto: "Texto mal traducido",
            descripcion: "Traducción incorrecta en el menú principal",
            detalles: {
                prioridad: "Baja",
                usuario: "Juan"
            }
        },
        {
            id: 5,
            estado: "Abierta",
            asunto: "Icono ausente",
            descripcion: "No aparece el icono de configuración",
            detalles: {
                prioridad: "Media",
                usuario: "María"
            }
        },
        {
            id: 6,
            estado: "Cerrada",
            asunto: "Error en base de datos",
            descripcion: "Inserción duplicada en tabla clientes",
            detalles: {
                prioridad: "Alta",
                usuario: "Pedro"
            }
        },
        {
            id: 7,
            estado: "Pendiente",
            asunto: "Rendimiento bajo",
            descripcion: "La página tarda en cargar",
            detalles: {
                prioridad: "Media",
                usuario: "Ana"
            }
        },
        {
            id: 8,
            estado: "Cerrada",
            asunto: "Problema de permisos",
            descripcion: "Usuario sin permisos para editar",
            detalles: {
                prioridad: "Baja",
                usuario: "Miguel"
            }
        }
    ];

    const btnBuscar = document.getElementById("buscarBtn");
    const divResultado = document.getElementById("resultado");
    const divError = document.getElementById("errorMessage");

    //E
    btnBuscar.addEventListener("click", () => {
        divResultado.innerHTML = "";
        divError.textContent = "";

        const id = document.getElementById("id").value.trim();
        const asunto = document.getElementById("asunto").value.trim().toLowerCase();
        const descripcion = document.getElementById("descripcion").value.trim().toLowerCase();
        const estado = document.getElementById("estado").value;

        /**let resultados = incidencias.filter(inc => {
            const coincideId = !id || inc.id === Number(id);
            const coincideAsunto = !asunto || inc.asunto.toLowerCase().includes(asunto);
            const coincideDescripcion = !descripcion || inc.descripcion.toLowerCase().includes(descripcion);
            const coincideEstado = !estado || inc.estado === estado;



            return coincideId && coincideAsunto && coincideDescripcion && coincideEstado;
        });*/
        let resultados = incidencias.filter(inc => {
            // Si el id está definido y no coincide, descartamos
            if (id && inc.id !== Number(id)) return false;

            // Si el asunto está definido y no contiene el texto, descartamos
            if (asunto && !inc.asunto.toLowerCase().includes(asunto)) return false;

            // Si la descripción está definida y no contiene el texto, descartamos
            if (descripcion && !inc.descripcion.toLowerCase().includes(descripcion)) return false;

            // Si el estado está definido y no coincide, descartamos
            if (estado && inc.estado !== estado) return false;

            // Si llega hasta aquí, significa que cumple todos los criterios
            return true;
        });
        // F
        if (resultados.length === 0) {
            divError.textContent = "No se encontraron incidencias con esos criterios.";
            return;
        }

        // G Crear tabla y mouseover mouseout
        let tabla = document.createElement("table");

        // Crear cabecera
        const thead = document.createElement("thead");
        thead.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Estado</th>
                <th>Asunto</th>
                <th>Prioridad</th>
                <th>Acciones</th>
            </tr>`;
        tabla.appendChild(thead);
        // Crear cuerpo de la tabla
        const tbody = document.createElement("tbody");
        resultados.forEach(inc => {
            const fila = document.createElement("tr");
            fila.dataset.estado = inc.estado;
            // Color de fondo según el estado
            if (inc.estado === "Abierta") fila.style.backgroundColor = "#e6ffea";
            else if (inc.estado === "Pendiente") fila.style.backgroundColor = "#fff8e6";
            else if (inc.estado === "Cerrada") fila.style.backgroundColor = "#f2f2f2";
            fila.innerHTML = `
            <td>${inc.id}</td>
            <td>${inc.estado}</td>
            <td>${inc.asunto}</td>
            <td>${inc.detalles.prioridad}</td>
            <td><img src="ver.jpg" alt="Ver" class="img-ver" data-id="${inc.id}"></td>`;
            tbody.appendChild(fila);
        });

        tabla.appendChild(tbody);
        divResultado.appendChild(tabla);
        tbody.addEventListener("mouseover", ev => {
            const tr = ev.target.closest("tr");
            if (tr) tr.style.backgroundColor = "#fff6cc"; // amarillo claro
        });

        tbody.addEventListener("mouseout", ev => {
            const tr = ev.target.closest("tr");
            if (tr) {
                if (tr.dataset.estado === "Abierta") tr.style.backgroundColor = "#e6ffea";
                else if (tr.dataset.estado === "Pendiente") tr.style.backgroundColor = "#fff8e6";
                else if (tr.dataset.estado === "Cerrada") tr.style.backgroundColor = "#f2f2f2";
            }
        });
    });
});