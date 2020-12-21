fetch("/torneo")
.then((res) => {
	return res.json();
})
.then((datos) => {
	let tableContainer = document.querySelector('.table-container');
	let torneos = datos.map((info) => {
		return fila(info);
	});

	tableContainer.innerHTML = torneos.join("");
});

function fila(info) {
	console.log(info)
	return `
		<tr>
            <td class="idTorneo">${ info.idTorneo }</td>
            <td class="nmTorneo">${ info.nmTorneo }</td>
            <td class="tipoTorneo">${ info.tipoTorneo }</td>
        </tr>
	`;	
}