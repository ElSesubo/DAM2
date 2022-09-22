import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { Square, Rectangle, Triangle, Circle, QuarterCircle } from './components/Figures.js'

export default function App() {
  return (
    <View style={styles.container}>
      <Square style={styles.square}/>
      <Square style={styles.bigSquare}/>
      <br></br>
      <Rectangle style={styles.rectangleUp}/>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <Square style={styles.squareRight}/>
        <Square style={styles.squareLeft}/>
      </View>
      <Rectangle style={styles.rectangleDown}/>
      <br></br>
      <Triangle style={styles.triangle}/>
      <Square style={styles.square}/>
      <Rectangle style={styles.rectangleDown}/>
      <br></br>
      <Triangle style={styles.triangle}/>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <Triangle style={styles.triangleLeft}/>
        <Square style={styles.square}/>
        <Triangle style={styles.triangleRight}/>
      </View>
      <Triangle style={styles.triangleDown}/>
      <br></br>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <Circle style={styles.circleRed}></Circle>
        <Circle style={styles.circleRed}></Circle>
        <Circle style={styles.circleRed}></Circle>
      </View>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <Circle style={styles.circleRed}></Circle>
        <Circle style={styles.circleBlue}></Circle>
        <Circle style={styles.circleRed}></Circle>
      </View>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <Circle style={styles.circleRed}></Circle>
        <Circle style={styles.circleRed}></Circle>
        <Circle style={styles.circleRed}></Circle>
      </View>
      <br></br>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <QuarterCircle style={styles.degreeUpL}></QuarterCircle>
        <QuarterCircle style={styles.degreeUpR}></QuarterCircle>
      </View>
      <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <QuarterCircle style={styles.degreeDownL}></QuarterCircle>
        <QuarterCircle style={styles.degreeDownR}></QuarterCircle>
      </View>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  circleRed: {
    width: 100,
    height: 100,
    borderRadius: 100/2,
    backgroundColor: 'red',
  },
  circleBlue: {
    width: 100,
    height: 100,
    borderRadius: 100/2,
    backgroundColor: 'blue',
  },
  square: {
    width: 100,
    height: 100,
    backgroundColor: 'blue',
  },
  bigSquare: {
    width: 200,
    height: 200,
    backgroundColor: 'red',
  },
  rectangleUp: {
    width: 200,
    height: 100,
    backgroundColor: 'red'
  },
  rectangleDown: {
    width: 200,
    height: 100,
    backgroundColor: 'blue'
  },
  squareRight: {
    height: 100,
    width: 100,
    backgroundColor: 'red'
  },
  squareLeft:{
    height: 100,
    width: 100,
    backgroundColor: 'blue'
  },
  triangle: {
    width: 0,
    height: 0,
    borderLeftWidth: 50,
    borderRightWidth: 50,
    borderBottomWidth: 100,
    borderStyle: 'solid',
    backgroundColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderBottomColor: 'blue'
  },
  triangleLeft: {
    width: 0,
    height: 0,
    transform: [
      { rotateZ: "270deg" }
    ],
    borderLeftWidth: 50,
    borderRightWidth: 50,
    borderBottomWidth: 100,
    borderStyle: 'solid',
    backgroundColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderBottomColor: 'blue'
  },
  triangleRight: {
    width: 0,
    height: 0,
    transform: [
      { rotateZ: "90deg" }
    ],
    borderLeftWidth: 50,
    borderRightWidth: 50,
    borderBottomWidth: 100,
    borderStyle: 'solid',
    backgroundColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderBottomColor: 'blue'
  },
  triangleDown: {
    width: 0,
    height: 0,
    transform: [
      { rotateZ: "180deg" }
    ],
    borderLeftWidth: 50,
    borderRightWidth: 50,
    borderBottomWidth: 100,
    borderStyle: 'solid',
    backgroundColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderBottomColor: 'blue'
  },
  degreeUpL: {
    width: 100,
    height: 100,
    borderTopLeftRadius: 100,
    backgroundColor: 'blue'
  },
  degreeUpR: {
    width: 100,
    height: 100,
    borderTopRightRadius: 100,
    backgroundColor: 'red'
  },
  degreeDownL: {
    width: 100,
    height: 100,
    borderBottomLeftRadius: 100,
    backgroundColor: 'red'
  },
  degreeDownR: {
    width: 100,
    height: 100,
    borderBottomRightRadius: 100,
    backgroundColor: 'blue'
  }
});
