const main = document.querySelector('main');

let htmlString = "";

/**
 * Genera tots el divs d'informació depenent de l'api
 */
axios.get("https://mhw-db.com/weapons/")
    .then(response => {
        for ( let i = 0; i < (response.data.length-220); i++ ) {
            htmlString += `<div onclick="guardarId(${response.data[i].id})">
            ${response.data[i].name}<br>
            <img src=${response.data[i].assets.icon}>
            </div>`;
        }
        main.innerHTML = htmlString; 
        console.log(htmlString);
    })
    .catch(error => {
        alert(error);
    }); 