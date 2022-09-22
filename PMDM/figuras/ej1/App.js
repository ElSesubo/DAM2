import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { Square, Rectangle, Triangle, Circle, QuarterCircle } from './components/Figures.js'

export default function App() {
  return (
    <View style={styles.container}>
      <Square style={styles.square}/>
      <Rectangle style={styles.rect}/>
      <Triangle style={styles.triangle}/>
      <Circle style={styles.circle}/>
      <QuarterCircle style={styles.degree}/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  square: {
    width: 100,
    height: 100,
    backgroundColor: 'blue',
  },
  rect:{
    width: 200,
    height: 100,
    backgroundColor: 'red',
  },
  triangle: {
    width: 0,
    height: 0,
    borderLeftWidth: 60,
    borderRightWidth: 60,
    borderBottomWidth: 120,
    borderStyle: 'solid',
    backgroundColor: 'transparent',
    borderLeftColor: 'transparent',
    borderRightColor: 'transparent',
    borderBottomColor: 'blue'
  },
  circle: {
    width: 100,
    height: 100,
    borderRadius: 100/2,
    backgroundColor: 'red',
  },
  degree: {
    width: 100,
    height: 100,
    borderTopLeftRadius: 90,
    backgroundColor: 'blue'
  }
});
