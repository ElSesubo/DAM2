import { useState } from 'react';
import { Text, TextInput, View, StyleSheet, Button } from 'react-native';
export default function App() {
  const [text, setText] = useState('');

  function handleOnPress() {
    // EJ1
    /*if(text == ""){
        alert("No contiene nada")
      }else if(isNaN(text)){
        alert("TEXTO")
      }else{
        alert("NÚMEROS")
      }*/

    // EJ2
    /*if(text == ""){
        alert("No contiene nada")
      }else if(isNaN(text)){
        alert("Contiene texto")
      }else{
        kilometros = parseInt(text);
        millas = kilometros/1.609;
        alert(kilometros + " kilometros, son " + millas + " millas")
      }*/

    // EJ3
    /*if(text == ""){
        alert("No contiene nada")
      }else if(isNaN(text)){
        alert("Contiene texto")
        setText("");
      }else{
        euros = parseInt(text);
        dolares = euros/0.99669136;
        alert(euros + " euros, son " + dolares+ " dolares")
      }*/

    // EJ4

    /*number = isNaN(text.substring(0,8));
      conasd = isNaN(text.substring(8));

      if(text == ""){
        alert("No contiene nada")
      }else if(text.length < 9 || text.length > 9){
        alert("La longitud del DNI es incorrecta")
        setText("")
      }else if(number == true){
        alert("Los primeros 8 caracteres contiene letras")
        setText("")
      }else if(conasd == false){
        alert("La letra no está bien")
        setText("")
      }else{
        alert("El DNI está bien")
        setText("")
      }*/

    // EJ5
    /*arroba = text.substring(1, text.length).includes("@")
    punto = text.substring((text.length-4), text.length).includes(".")

    if(text == ""){
      alert("No contiene nada")
    }else if(text.substring(0) == "@"){
      alert("No puede empezar por @")
    }else if(arroba == false){
      alert("No contiene @")
    }else if(punto == false){
      alert("No contiene .")
    }else{
      alert("El correo está bien")
    }*/
  }

  return (
    <View style={styles.container}>
      <Text style={{ padding: 10, fontSize: 20 }}>Validar correo</Text>
      <TextInput
        style={{ height: 40 }}
        placeholder="Inserta tu texto..."
        onChangeText={(newText) => setText(newText)}
        defaultValue={text}
      />
      <Button
        onPress={handleOnPress}
        title="Pulsame culero"
        accessibilityLabel="CALLATE!"
      />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
