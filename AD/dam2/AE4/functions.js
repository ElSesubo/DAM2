/**
 * Fa una petició de post 
 */
function guardarInfo() {
    let id = document.getElementById("id").textContent;
    let name = document.getElementById("name").textContent;
    let image = document.getElementById("image").src;
    let type = document.getElementById("type").textContent;
    let rarity = document.getElementById("rarity").textContent;
    let elderSeal = document.getElementById("elderSeal").textContent;
    let dmgType = document.getElementById("dmgType").textContent;

    var postForm = { 
        id: id,
        name: name,
        type: type,
        rarity: rarity,
        elderSeal: elderSeal, 
        damageType: dmgType,
        image: image,
    };

    $.ajax({
    type: "POST", 
    url: "index1.php", 
    data: postForm,
    success: function (response) { 
        alert(response);
    },
    error: function () {
        alert("Error");
    }
    });
}

/**
 * Guarda la id de cada arma
 * @param {*} num 
 */
function guardarId(num) {
    localStorage.setItem("ident", num-1);
    window.location.href = 'weapon.html';
}

/**
 * Carrega l'informació de l'arma seleccionada per la seua id
 */
function cargarArma() {
    let ident = localStorage.getItem("ident");
    axios.get("https://mhw-db.com/weapons/").then(response => {
        document.getElementById("id_name").textContent = response.data[ident].id + ".  " + response.data[ident].name;
        document.getElementById("id").textContent = response.data[ident].id;
        document.getElementById("name").textContent = response.data[ident].name;
        document.getElementById("image").src = response.data[ident].assets.image;
        document.getElementById("type").textContent = response.data[ident].type;
        document.getElementById("rarity").textContent = response.data[ident].rarity;
        if(response.data[ident].elderseal == null){
            document.getElementById("elderSeal").textContent = "null";
        }else{
            document.getElementById("elderSeal").textContent = response.data[ident].elderseal;
        }
        document.getElementById("dmgType").textContent = response.data[ident].damageType;
    }).catch(error => {
        alert(error);
    }); 
}