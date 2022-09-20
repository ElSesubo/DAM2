import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

export default function Article() {
    let word = "USA"
    let content = {
        paragraphOne: "Oh boy is swell to say, good morning USA",
        paragraphTwo: "(Good morning USA)",
        title: "GOOD MORNING USA (lyrics)"
    }
    return (
        <View style={styles.container}>
            <Text style={styles.title}>{content.title}</Text>
            <Text>Good morning {word}, I've got a feeling that is gonna be a wonderful day </Text>
            <Text>The sun in the sky has a smile on his face, and he's shining a salute to the American race.</Text>
            <Text>{content.paragraphOne}</Text>
            <Text>{content.paragraphTwo}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        paddingTop: 20,
        flex: 1,
        backgroundColor: 'red',
        alignItems: 'center',
        justifyContent: 'center',
    },
    title: {
        fontSize: 12,
        fontWeight: 'bold',
        fontStyle: 'italic',
        textDecorationLine: 'underline',
    }
});


