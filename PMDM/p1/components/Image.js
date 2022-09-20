import React from 'react';
import { View, Image, StyleSheet } from 'react-native';

const styles = StyleSheet.create({
  container: {
    paddingTop: 10,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'red',
  },
  bigImg: {
    width: 400,
    height: 300,
  },
});

const DisplayAnImage = () => {
  return (
    <View style={styles.container}>
      <Image
        style={styles.bigImg}
        source={{
          uri: 'https://i.3djuegos.com/juegos/16778/american_dad_apocalypse_soon/fotos/ficha/american_dad_apocalypse_soon-4923119.jpg',
        }}
      />
    </View>
  );
}

export default DisplayAnImage;