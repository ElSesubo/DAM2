<?php

if(isset($_POST["id"]) ){
	$id = $_POST["id"];
	$name = $_POST["name"];
	$type = $_POST["type"];
	$rarity = $_POST["rarity"];
	$damageType = $_POST["damageType"];
	$elderSeal = $_POST["elderSeal"];
	$image = $_POST["image"];
	
	$servidor = "localhost";
	$usuario = "root";
	$password = "";
	$dbname = "mhwapi";
	$conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
	if (!$conexion) {
	echo "Error en la conexion a MySQL: ".mysqli_connect_error();
	exit();
	}
	$sql = "INSERT INTO weapons (ident, nameW, typeW, rarity, damageType, elderSeal, image) VALUES ('".$id."','".$name."','".$type."','".$rarity."','".$damageType."','".$elderSeal."','".$image."')";
	if (mysqli_query($conexion, $sql)) {
	echo "Registro insertado correctamente.";
	} else {
	echo "El registro ya existe";
	}
}

?>