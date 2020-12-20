fetch("/noticia")
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
            <td class="id">${ info.idNoticia }</td>
            <td class="nombre">${ info.tituloN }</td>
            <td class="fecha">${ info.infoN }</td>
        </tr>
	`;	
}