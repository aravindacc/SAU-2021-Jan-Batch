import { StyleSheet } from "react-native";

export default styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#121330',
      alignItems: 'center',
      padding:20,
      paddingTop:50
    },
    logo:{
      fontWeight:"bold",
      fontSize:50,
      color:"#3eefd8",
      marginTop:60,
      marginBottom:40,
      borderRadius:50
    },
    inputTextView:{
        width:"100%",
        backgroundColor:"#95a7cf",
        borderRadius:20,
        marginBottom:20,
        height:60,
        padding:15

    },
    inputDescView:{
      width:"100%",
      backgroundColor:"#95a7cf",
      borderRadius:20,
      height:200,
      marginBottom:20,
      padding:20,
      justifyContent: "flex-start"
    },
    inputText:{
        width:250,
      color:"white",
      justifyContent:"center",
      fontSize:17
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