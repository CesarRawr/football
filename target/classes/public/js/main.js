var botonEE = document.getElementById('editarEquipo');
var idDel = document.getElementById('idEquipo');
var botonDel = document.getElementById('btnDelete');

idDel.addEventListener('click',function(){    
    var id=document.getElementById('idDel').value;
    const parametros=new URLSearchParams();
    parametros.append('PrmID', id);
    
    axios.post('http://localhost:4567/equipo', {
    id : document.getElementById('idEquipo').value
}).then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        document.getElementById('idEquipo').value = response.data.cuenta
    })
    .catch(function (error) {
        console.log(error)
    })
})

botonDel.addEventListener('click',function(){
    
    axios.post('http://localhost:4567/equipoBorrar',{
    id : document.getElementById('idEquipo').value,

}).then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
    })
    .catch(function (error) {
        console.log(error)
    })
})
