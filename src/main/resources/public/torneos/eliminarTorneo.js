let eliminar = document.querySelector('.eliminar');
let volver = document.querySelector('.volver');

eliminar.addEventListener('click', (e) => {
	e.preventDefault();

    let id = document.getElementById('idTorneo').value;

  	fetch(`/torneo/${id}`, {
  		method: 'DELETE'
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/torneos/torneos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/torneos/torneos.html";
});