import React, { useState, useEffect } from "react";
import { Text, TextInput, View, Button ,TouchableOpacity, Image,StatusBar} from "react-native";
import AsyncStorage from '@react-native-async-storage/async-storage';
import styles from './style';

const Login=({navigation})=>{
    const [username, setUserName] = useState("");

    useEffect(() => {
        checkAuth()
    }, [])

    const checkAuth = async () => {
        const userName = await AsyncStorage.getItem("username");
        if (userName) {
            navigation.navigate("AllNotes");
        }
        return;
    }

    const login = async () => {
        console.log(username);
        await AsyncStorage.setItem("username", username);
        navigation.navigate("AllNotes");
    }

    return(
        <View style={styles.container}>
            <StatusBar backgroundColor="#3eefd8" barStyle='dark-content' />
            <Image style={styles.logo} source={require('../../../assets/logo3.png')} />
            
            <View style={styles.inputView} >
            <TextInput  
                style={styles.inputText}
                placeholder="Enter UserName..." 
                placeholderTextColor="#003f5c"
                selectionColor={'white'}
                onChangeText={(text) => setUserName(text)}
                />
            </View>
            <View style={styles.inputView} >
            <TextInput  
                secureTextEntry
                style={styles.inputText}
                placeholder="Enter Password..." 
                placeholderTextColor="#003f5c"
                selectionColor={'white'}
                />
            </View>
            <TouchableOpacity style={styles.loginBtn} onPress={login}>
                <Text style={styles.loginText}>LOGIN</Text>
            </TouchableOpacity>
        </View>
        
    )
};

export default Login;
