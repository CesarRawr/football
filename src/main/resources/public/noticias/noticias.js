fetch("/jugador")
.then((res) => {
	return res.json();
})
.then((datos) => {
	let tableContainer = document.querySelector('.table-container');
	let equipos = datos.map((info) => {
		return fila(info);
	});

	tableContainer.innerHTML = equipos.join("");
});

function fila(info) {
	return `
		<tr>
            <td class="id">${ info.id }</td>
            <td class="nombre">${ info.nombre }</td>
            <td class="fecha">${ info.fecha }</td>
            <td class="numero">${ info.numero }</td>
            <td class="equipo">${ info.equipo }</td>
            <td class="torneo">${ info.torneo }</td>
        </tr>
	`;	
}