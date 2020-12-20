var pass = document.getElementById('password');
var username = document.getElementById('user');
var btnSesion = document.getElementById('btnLogin');

btnSesion.addEventListener('click',function(e){
    e.preventDefault();
    let url = "/admin?" + new URLSearchParams({
        user: username.value,
        pass: pass.value
    });
    fetch(url)
    .then(function (response) {
       	if(response.ok) {
       		window.location = response.url;
        }
        else {
        	alert("datos incorrectos");
        }
    })
    .catch(function (error) {
		alert("Algo salio mal");
 	});
})