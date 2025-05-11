function getProductList(){
    fetch('http://localhost:8080/Zadanie7NykMichal/products')
        .then(response => response.json())
        .then((products) => 
            {
                displayTable(products);
            }
    );
}

function displayTable(data){
    var out = '<table> ';
    out += '<tr>' + '<th>ID</th>' + '<th>Name</th>' + '<th>Price</th>' + '<th>Updated</th>' + '<th>Description</th>' + '<th>Operacje</th>' + '</tr>';
    var i;
    for(i = 0; i < data.length; i++){
        out += '<tr>' + 
                '<th>'+data[i].id+'</th>' +
                '<th><input type="text" id="name_' +data[i].id+ '" value="' + data[i].name+'" size="20" ></th>' +
                '<th><input type="text" id="price_' +data[i].id+ '" value="' + data[i].price+'" size="20" ></th>' +
                '<th>'+data[i].updated+'</th>' +
                '<th><input type="text" id="description_' +data[i].id+ '" value="' + data[i].description+'" size="40" ></th>' +
                '<th>'+
                    '<button type="button" onclick="updateProduct('+data[i].id+');">Mod</button>' +
                    '<button type="button" onclick="deleteProduct('+data[i].id+');">Del</button>' +
                '</th>' +
                '</tr>';
    }
    out+='</table>';
    document.getElementById("result").innerHTML = out;
}

function createProduct(){
    fetch('http://localhost:8080/Zadanie7NykMichal/products',
        {
            method: 'POST',
            body: JSON.stringify(
                    {
                        name: 'Podaj nazwę',
                        price: 1.0,
                        updated: '2025-04-28T11:07:16.926+00:00',
                        description: 'Podaj Opis'
                    }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}


function updateProduct(id){
    fetch('http://localhost:8080/Zadanie7NykMichal/products/'+id,
        {
            method: 'PUT',
            body: JSON.stringify(
                    {
                        id: id,
                        name: document.getElementById("name_"+id).value,
                        price: document.getElementById("price_"+id).value,
                        updated: '2025-04-28',
                        description: document.getElementById("description_"+id).value
                    }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}

function deleteProduct(id){
    fetch('http://localhost:8080/Zadanie7NykMichal/products/'+id,
        {
            method: 'DELETE'
        })
    .catch(error => console.error('Error:', error));
}

window.addEventListener("load", getProductList, false);