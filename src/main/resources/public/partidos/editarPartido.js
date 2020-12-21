let actualizar = document.querySelector('.actualizar');
let volver = document.querySelector('.volver');

actualizar.addEventListener('click', (e) => {

	  e.preventDefault();

    let info = new FormData();
    info.append("idPartido", document.getElementById("idPartido").value);
    info.append("equipoL", document.getElementById("equipoL").value);
    info.append("equipoV", document.getElementById("equipoV").value);
    info.append("fechaP", document.getElementById("fechaP").value);
    info.append("horaP", document.getElementById("horaP").value);

    let object = {};

    info.forEach(function(value, key){
        object[key] = value;
    });

    let json = JSON.stringify(object);

  	fetch('/partido', {
  		method: 'PUT',
      body: json
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