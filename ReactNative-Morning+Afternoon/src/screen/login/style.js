import { StyleSheet } from "react-native";

export default styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#121330',
      alignItems: 'center',
      justifyContent: 'center',
      padding:15,
      paddingTop:40
    },
    logo:{
      marginBottom:50,
      width:150,
      height:150,
      borderRadius:50
    },
    inputView:{
      width:"80%",
      backgroundColor:"#7285b1",
      borderRadius:25,
      height:50,
      marginBottom:15,
      justifyContent:"center",
      padding:20
    },
    inputText:{
        width:150,
      height:50,
      color:"white"
    },
    loginBtn:{
      width:300,
      backgroundColor:"#3eefd8",
      borderRadius:25,
      height:50,
      alignItems:"center",
      justifyContent:"center",
      marginTop:40,
      marginBottom:10
    },
    loginText:{
      color:"#fffafa",
      fontSize:15,
      fontWeight:"bold",
    }
  });