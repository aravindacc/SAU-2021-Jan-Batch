import { StyleSheet } from "react-native";

export default styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#121330',
        padding:15,
        paddingTop:50,
      },
      emptyListContainer: {
        alignItems: 'center',
      },
      emptyList: {
          marginTop:300,
        color:"white",
        fontSize:20
      },
      btnView:{
          display:'flex',
        flexDirection:'row',

      },
    addBtn:{
        marginTop:100,
        width:1,
        position: 'absolute',
        right: 5,
        top: 5,
        backgroundColor:"#3eefd8"
    },
    Note:{
        borderColor:'white',
        borderRadius:12,
        padding:20,
        backgroundColor:'#95a7cf',
        width:'100%',
        color:'#666666',
        fontSize:20,
        marginTop:15
    },
    delBtn:{
        alignSelf:'flex-end',
        width:5,
        padding:30

    }
});
