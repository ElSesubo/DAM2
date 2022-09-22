import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { Square } from './components/Figures.js'

export default function App() {
  return (
    <View style={styles.container}>
      <Square style={styles.square}/>
      <Square style={styles.bigSquare}/>
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
  bigSquare: {
    width: 200,
    height: 200,
    backgroundColor: 'red',
  }
});
