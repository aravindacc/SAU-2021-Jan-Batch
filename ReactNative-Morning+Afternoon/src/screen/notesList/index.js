import React, { Component } from 'react';
import { Text, TextInput, View, StyleSheet, Button ,StatusBar} from "react-native";
import { ScrollView } from 'react-native-gesture-handler';
import AsyncStorage from '@react-native-async-storage/async-storage';
import styles from './style';

class AllNotes extends Component {
  constructor(props) {
    super(props)
    this.state = {
      notes: [],
    };
  }
  addNote = () => {
    this.props.navigation.navigate("NewNote");
  }
  deleteNote = async (id) => {
    var newNotes = this.state.notes.filter(elm => {
      return elm.id != id;
    })
    this.setState({
      notes: newNotes
    })
    await AsyncStorage.setItem('notes', JSON.stringify(newNotes));
  }

  componentDidMount = async () => {
    try {
      var notes = await AsyncStorage.getItem('notes');
      if (notes == null || notes == undefined)
        notes = [];
      else
        notes = JSON.parse(notes);
      this.setState({
        notes
      })
    } catch (e) {
      this.setState({ notes: [] })
    }
  }
  componentDidUpdate=async()=>{
    try {
      var notes = await AsyncStorage.getItem('notes');
      if (notes == null || notes == undefined)
        notes = [];
      else
        notes = JSON.parse(notes);
      this.setState({
        notes
      })
    } catch (e) {
      this.setState({ notes: [] })
    }
  }


  render() {
    return (
      <View style={styles.container}>
      <StatusBar backgroundColor="#3eefd8" barStyle='dark-content' />
        <View style={styles.btnView}>
          <View style={{flex:1}}></View>
          <Button title="Add" color="#3eefd8" onPress={this.addNote} style={styles.addBtn}/>
        </View>
          <ScrollView>
            {
              this.state.notes.length == 0 ? <View style={styles.emptyListContainer}>
                      <Text style={styles.emptyList}>No Notes to show</Text></View> :
                this.state.notes.map(elm => {
                  return <View elevation={9} style={styles.Note} key={elm.id}>
                    <Text style={{color:"white"}}>{elm.title}</Text>
                    <Text style={{color:"white",paddingBottom:5}}>{elm.desc}</Text>
                    <View style={styles.btnView}>
                        <View style={{flex:1}}></View>
                        <Button title="Delete" color="#3eefd8" onPress={() => this.deleteNote(elm.id)} style={styles.delBtn}/>
                    </View>
                  </View>
                })
            }
          </ScrollView>

      </View>
    )
  }
}

export default AllNotes;
