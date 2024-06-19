document.getElementById('buscarLibros').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita que la página se recargue

    var titulo = document.getElementById('titulo').value;
    var autor = document.getElementById('autor').value;
    var idioma = document.getElementById('idioma').value;
    var genero = document.getElementById('genero').value;

    // Construye la URL de la API con los parámetros de búsqueda
    var url = '/libros?';
    if (titulo) url += 'titulo=' + titulo + '&';
    if (autor) url += 'autor=' + autor + '&';
    if (idioma) url += 'idioma=' + idioma + '&';
    if (genero) url += 'genero=' + genero;

    // Realiza una solicitud GET al servidor
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // Aquí puedes manejar los datos devueltos por el servidor
            console.log(data);
        })
        .catch(error => {
            // Aquí puedes manejar cualquier error que ocurra durante la solicitud
            console.error('Error:', error);
        });
});