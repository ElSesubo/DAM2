import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Article from './components/Article.js'
import DisplayAnImage from './components/Image.js';

export default function App() {
  
  let word = "USA"
  let content = {
    paragraphOne: "Oh boy is swell to say, good morning USA",
    paragraphTwo: "(Good morning USA)",
    title: "GOOD MORNING USA (lyrics)"
  }

  /*function Article(){
    return(
    <View style={styles.container}>
      <Text style={styles.title}>{content.title}</Text>
      <Text>Good morning {word}, I've got a feeling that is gonna be a wonderful day </Text>
      <Text>The sun in the sky has a smile on his face, and he's shining a salute to the American race.</Text>
      <Text>{content.paragraphOne}</Text>
      <Text>{content.paragraphTwo}</Text>
    </View>
    );
  }*/

  function Articles(){
    const array = [];
    for (let index = 0; index < 4; index++) {
      array.push(<Article key={index}/>)
    } 
    return(
      <View>
        <>{array.map(article =>
          <>{article}</>
        )}</>     
      </View>
    )
  }
  return(
    <View style={styles.container}>
      <Article/>
      <Article/>
      <Articles/>
      <Text style={styles.photoTitle}>Stan Smith</Text>
      <DisplayAnImage/>
      <Text style={styles.title}>Character from American Dad TV show</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
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
  },
  photoTitle:{
    paddingTop: 30,
    fontSize: 30,
  }
});