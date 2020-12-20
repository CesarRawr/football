let eliminar = document.querySelector('.eliminar');
let volver = document.querySelector('.volver');

eliminar.addEventListener('click', (e) => {
	e.preventDefault();

    let id = document.getElementById('idEquipo').value;

  	fetch(`/equipo/${id}`, {
  		method: 'DELETE'
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/equipos/equipos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/equipos/equipos.html";
});