import { Component } from 'react';
import { StyleSheet, Text, View, ViewBase } from 'react-native';
import { Square, Circle, Rectangle, Triangle, QuarterCircle } from './components/Figures';


export default function App() {


  return (
    <View style={styles.container}>
        <Square 
        width={100}
        height={100}
        backgroundColor={'red'}
        />
        <Square 
        width={200}
        height={200}
        backgroundColor={'blue'}
        />
        <br></br>
        <Square
        width={200}
        height={100}
        backgroundColor={'red'}
        />
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <Square 
          width={100}
          height={100}
          backgroundColor={'red'}
          />
          <Square 
          width={100}
          height={100}
          backgroundColor={'blue'}
          />
        </View>
        <Square
          width={200}
          height={100}
          backgroundColor={'blue'}
        />
        <br></br>
        <Triangle
          rotateZ={0}
          borderLeftWidth={50}
          borderRightWidth={50}
          borderBottomWidth={100}
        />
        <Square
          width={100}
          height={100}
          backgroundColor={'blue'}
        />
        <Square
          width={200}
          height={100}
          backgroundColor={'blue'}
        />
        <br></br>
        <Triangle
          rotateZ={"0deg"}
          borderLeftWidth={50}
          borderRightWidth={50}
          borderBottomWidth={100}
        />
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <Triangle
            rotateZ={"270deg"}
            borderLeftWidth={50}
            borderRightWidth={50}
            borderBottomWidth={100}
          />
          <Square
          width={100}
          height={100}
          backgroundColor={'blue'}
          />
          <Triangle
            rotateZ={"90deg"}
            borderLeftWidth={50}
            borderRightWidth={50}
            borderBottomWidth={100}
          />
        </View>
        <Triangle
            rotateZ={"180deg"}
            borderLeftWidth={50}
            borderRightWidth={50}
            borderBottomWidth={100}
          />
        <br></br>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'blue'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
          <Circle 
            width={100}
            height={100}
            backgroundColor={'red'}
          />
        </View>
        <br></br>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <QuarterCircle
            width={100}
            height={100}
            borderTopLeftRadius={100}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'blue'}
          />
          <QuarterCircle
            width={100}
            height={100}
            borderTopLeftRadius={0}
            borderTopRightRadius={100}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <QuarterCircle
            width={100}
            height={100}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={100}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
          <QuarterCircle
            width={100}
            height={100}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={100}
            backgroundColor={'blue'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <QuarterCircle
            width={80}
            height={80}
            borderTopLeftRadius={100}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'blue'}
          />
          <QuarterCircle
            width={80}
            height={80}
            borderTopLeftRadius={0}
            borderTopRightRadius={100}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <QuarterCircle
            width={80}
            height={80}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={100}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
          <QuarterCircle
            width={80}
            height={80}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={100}
            backgroundColor={'blue'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
          <QuarterCircle
            width={60}
            height={60}
            borderTopLeftRadius={100}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'blue'}
          />
          <QuarterCircle
            width={60}
            height={60}
            borderTopLeftRadius={0}
            borderTopRightRadius={100}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
        </View>
        <View style={{ flexWrap: 'wrap', alignItems: 'flex-start', flexDirection: 'row',}}>
        <QuarterCircle
            width={60}
            height={60}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={100}
            borderBottomRightRadius={0}
            backgroundColor={'red'}
          />
          <QuarterCircle
            width={60}
            height={60}
            borderTopLeftRadius={0}
            borderTopRightRadius={0}
            borderBottomLeftRadius={0}
            borderBottomRightRadius={100}
            backgroundColor={'blue'}
          />
        </View>
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
