import * as React from 'react';
import { Text, View, StyleSheet, Button } from 'react-native';
import Constants from 'expo-constants';

// You can import from local files
import AssetExample from './components/AssetExample';

// or any pure javascript modules available in npm
import { Card } from 'react-native-paper';
import { useState } from 'react';
import { Square, Circle, Triangle, QuarterCircle } from './components/Figures.js';


export default function App() {
  const [color, setColor] = useState("green");
  const [size, setSize] = useState(0);
  const [backColor, setBack] = useState("lightblue");

  const parametros = [
    {
      width: 100,
      height: 100,
      backgroundColor: "green"
    }
  ]
  const square = parametros.map((props) =>
    <Square
      width={props.width}
      height={props.height}
      backgroundColor={color}
    />
  )
  

  function handleOnPress(){
    // Ej1
    /*setColor('red');
    if(color == 'red'){
      setColor('yellow');
    }*/

    // Ej2
    /*setColor('red')
    if(color == 'red' || color == 'green'){
      setColor('yellow');
    }
    if(color == 'yellow'){
      setColor('green');
    }*/

    // Ej3
    /*setColor(backColor)
    setBack(color)*/

    // Ej4 Cambiando la propiedad del backgroundColor
    /*setColor(backColor)
    setBack(color)*/

    // Ej5
    /*if(size >= 50){
      setSize(size - 10)
    }
    setColor('green')*/

    // Ej6 
    /*if(size <= 250){
      setSize(size + 10)
    }
    setColor('green')*/

    // Ej7
    /*if(size == 250){
      setSize(100)
    }else{
      setSize(size + 10)
    }
    setColor('green')*/

    // Ej8
    /*if(size == 50){
      setSize(100)
    }else{
      setSize(size - 10)
    }
    setColor('green')*/

    // Ej9
    //setSize(100)

    // Ej10
    /*if(size == 100){
      setSize(0);
    }else{
      setSize(100);
    }*/

    // Ej11
    if(size == 100){
    setSize(0);
    }else{
      setSize(100);
    }

  }

  return (
    <View style={{flex: 1, backgroundColor: backColor, alignItems:'center', justifyContent:'center'}}>
      {square}
      <Square
        width={size}
        height={size}
        backgroundColor={"black"}
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
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ecf0f1',
    padding: 8,
    alignItems: 'center',
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});

