let actualizar = document.querySelector('.actualizar');
let volver = document.querySelector('.volver');

actualizar.addEventListener('click', (e) => {

	  e.preventDefault();

    let info = new FormData();
    info.append("idTorneo", document.getElementById("idTorneo").value);
    info.append("tipoTorneo", document.getElementById("tipoTorneo").value);
    info.append("nmTorneo", document.getElementById("nmTorneo").value);

    let object = {};

    info.forEach(function(value, key){
        object[key] = value;
    });

    let json = JSON.stringify(object);

  	fetch('/torneo', {
  		method: 'PUT',
      body: json
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