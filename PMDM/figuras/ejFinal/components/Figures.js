import { Component } from 'react';
import { StyleSheet, Text, View, ViewBase } from 'react-native'; 

function Square(props) {
    return (
      <View size="100" mt="-2" marginTop={-6}
        width={props.width}
        height={props.height}
        backgroundColor={props.backgroundColor} />
    );
  }

    function Triangle(props) {
        return (
            <View size="100" mt="-2" marginTop={-6}
                width={0}
                height={0}
                backgroundColor={"transparent"}
                borderStyle={"solid"}
                rotateZ={props.rotateZ}
                borderLeftWidth={props.borderLeftWidth}
                borderRightWidth={props.borderRightWidth}
                borderBottomWidth={props.borderBottomWidth}
                borderLeftColor="transparent"
                borderRightColor="transparent"
                borderBottomColor="blue"
            />
        );
    }

    function Circle(props) {
        return (
            <View size="100" mt="-2" marginTop={-6}
                width={props.width}
                height={props.height}
                borderRadius={100 / 2}
                backgroundColor={props.backgroundColor} />
        );
    }


    function QuarterCircle(props) {

        return (
            <View size="100" mt="-2" marginTop={-6}
                width={props.width}
                height={props.height}
                borderTopLeftRadius={props.borderTopLeftRadius}
                borderTopRightRadius={props.borderTopRightRadius}
                borderBottomLeftRadius={props.borderBottomLeftRadius}
                borderBottomRightRadius={props.borderBottomRightRadius}
                backgroundColor={props.backgroundColor} />
        );
    }

 export { Square, Rectangle, Triangle, Circle, QuarterCircle };