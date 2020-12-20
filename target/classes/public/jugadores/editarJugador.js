let actualizar = document.querySelector('.actualizar');
let volver = document.querySelector('.volver');

actualizar.addEventListener('click', (e) => {

	  e.preventDefault();

    let info = new FormData();
    info.append("nmEquipo", document.getElementById("nmEquipo").value);
    info.append("slogan", document.getElementById("slogan").value);
    info.append("dt", document.getElementById("dt").value);
    info.append("torneo", document.getElementById("torneo").value);
    info.append("idEquipo", document.getElementById("idEquipo").value);

    let object = {};

    info.forEach(function(value, key){
        object[key] = value;
    });

    let json = JSON.stringify(object);

  	fetch('/equipo', {
  		method: 'PUT',
      body: json
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