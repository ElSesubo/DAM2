import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

function Square(prop) {
    return (
        <View style={styles.container}>
            <View style={prop.style}></View>
        </View>
    );
}

function Rectangle(prop) {
    return (
        <View style={styles.container}>
            <View style={prop.style}></View>
        </View>
    );
}

function Triangle(prop) {
    return (
        <View style={styles.container}>
            <View style={prop.style}></View>
        </View>
    );
}

function Circle(prop) {
    return (
        <View style={styles.container}>
            <View style={prop.style}></View>
        </View>
    );
}

function QuarterCircle(prop) {
    return (
        <View style={styles.container}>
            <View style={prop.style}></View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: 'white',
        alignItems: 'center',
        justifyContent: 'center',
    },
    title: {
        fontSize: 12,
        fontWeight: 'bold',
        fontStyle: 'italic',
        textDecorationLine: 'underline',
    },
    bigImg: {
        width: 400,
        height: 300,
      },
});

export { Square, Rectangle, Triangle, Circle, QuarterCircle }
