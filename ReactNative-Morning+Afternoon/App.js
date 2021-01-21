import { StyleSheet, Text, View } from 'react-native';
import React from 'react';
import Login from './src/screen/login/index';
import NewNote from './src/screen/addNote/index';
import AllNotes from './src/screen/notesList/index';

import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator  screenOptions={{
        headerShown: true,
        headerTransparent:true,
        headerTintColor:'white'
    }}>
        <Stack.Screen name="Login" component={Login} backgroundColor="black"/>
        <Stack.Screen name="AllNotes" component={AllNotes} />
        <Stack.Screen name="NewNote" component={NewNote} />
      </Stack.Navigator>
  </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#10112c',
    alignItems: 'center',
    justifyContent: 'center',
  },
});


