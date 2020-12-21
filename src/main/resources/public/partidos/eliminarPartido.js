let eliminar = document.querySelector('.eliminar');
let volver = document.querySelector('.volver');

eliminar.addEventListener('click', (e) => {
	e.preventDefault();

    let id = document.getElementById('idPartido').value;

  	fetch(`/partido/${id}`, {
  		method: 'DELETE'
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/partidos/partidos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/partidos/partidos.html";
});