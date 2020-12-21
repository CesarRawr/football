fetch("/partido")
.then((res) => {
	return res.json();
})
.then((datos) => {
	let tableContainer = document.querySelector('.table-container');
	let partidos = datos.map((info) => {
		return fila(info);
	});

	tableContainer.innerHTML = partidos.join("");
});

function fila(info) {
	return `
		<tr>
            <td class="idPartido">${ info.idPartido }</td>
            <td class="equipoL">${ info.equipoL }</td>
            <td class="equipoV">${ info.equipoV }</td>
            <td class="fechaP">${ info.fechaP }</td>
            <td class="horaP">${ info.horaP }</td>
        </tr>
	`;	
}