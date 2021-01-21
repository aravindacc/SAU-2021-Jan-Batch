import AsyncStorage from '@react-native-async-storage/async-storage';
import React, { Component } from 'react'
import {
  Text,
  View,
  TextInput,
  BackAndroid,
  StatusBar,
  TouchableOpacity
} from 'react-native';
import styles from './style';

class NewNote extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id:0,
      title: '',
      desc: ''
    }
  }

save=async()=>{
  // AsyncStorage.clear();
  var notes= await AsyncStorage.getItem('notes');
  if(notes==null || notes==undefined)
    notes=[];
  else{
    notes= JSON.parse(notes);
  }
  // Math.round(Math.random(400000))
  var note={id:new Date().getTime(),title:this.state.title,desc:this.state.desc};
  notes=[...notes,note];
  var res= await AsyncStorage.setItem('notes',JSON.stringify(notes));
  this.setState({title:'',desc:''});
  // this.props.navigation.navigate("AllNotes");
  this.props.navigation.goBack(null);
}

  render() {
    return (
    <View style={styles.container}>
      <StatusBar backgroundColor="#3eefd8" barStyle='dark-content' />
    <Text style={styles.logo}>Add Note</Text>
            <View style={styles.inputTextView} >
            <TextInput  
                style={styles.inputText}
                placeholder='Add Title'
                placeholderTextColor="#003f5c"
                selectionColor="white"
                onChangeText={(text) => this.setState({ title: text })}
                value={this.state.title}
                />
            </View>
            <View style={styles.inputDescView} >
            <TextInput  
                style={styles.inputText}
                placeholder='Add Description'
                placeholderTextColor="#003f5c"
                multiline={true}
                selectionColor="white"
                onChangeText={(text) => this.setState({desc: text})}
                value={this.state.desc}
                />
            </View>
            <TouchableOpacity style={styles.loginBtn} onPress={this.save}>
                <Text style={styles.loginText}>ADD</Text>
            </TouchableOpacity>
        </View>
    )
  };
}

export default NewNote;
