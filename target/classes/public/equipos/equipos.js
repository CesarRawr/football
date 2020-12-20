fetch("/equipo")
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
            <td class="id">${ info.idEquipo }</td>
            <td class="nombre">${ info.nmEquipo }</td>
            <td class="slogan">${ info.slogan }</td>
            <td class="director">${ info.dt }</td>
            <td class="torneo">${ info.torneo }</td>
        </tr>
	`;	
}