var StudentLogs={};
class Student {
    constructor(fname, lname, email, age, rollNo, gender, department, occupation) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.age = age;
        this.rollNo = rollNo;
        this.gender = gender;
        this.department = department;
        this.occupation = occupation;
    }
}
function formValidation(){
            const fname=document.getElementById('fname');
            const lname=document.getElementById('lname');
            const email =document.getElementById("email");
            const age =document.getElementById("age");
            const rollno =document.getElementById("RollNo");
            const male=document.getElementById('male');
            const female=document.getElementById('female');
            const gender=(male.value.length>0)?male.value:female.value;
            const department=document.getElementById('department');
            const occupation=document.getElementById('occupation');
            if(occupation.value.length>0){
                alert("Form Submitted Successfully!! Student Details Added Successfully.");
                var student = new Student(fname.value,lname.value,email.value,age.value,rollno.value,gender,department.value,occupation.value);
                // Using Object Array
                // StudentLogs[rollno.value]=student;
                localStorage.setItem(`student${rollno.value}`,JSON.stringify(student));
                console.log("FirstName: "+fname.value+",LastName: "+lname.value);
                console.log("Email: "+email.value);
                console.log("Gender: "+gender+", Age: "+age.value);
                console.log("Department: "+department.value+", RollNo: "+rollno.value);
                console.log(StudentLogs);
            }

}

function newField(){

            let bool=false;
            const fname=document.getElementById('fname');
            const lname=document.getElementById('lname');
            const email =document.getElementById("email");
            const age =document.getElementById("age");
            const rollno =document.getElementById("RollNo");
            const male=document.getElementById('male');
            const female=document.getElementById('female');
            const gender=(male.value.length>0)?male.value:female.value;
            const department=document.getElementById('department');
            if(fname.value!=""){
                if(lname.value!=""){
                    if(/^[a-zA-Z0-9]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*$/.test(email.value)){
                       if(age.value>0){
                           if(rollno.value>0){
                                if(male.checked || female.checked){
                                    if(department.value!="noSelection"){
                                        alert("Please Add Your Occupation");
                                        console.log("FirstName: "+fname.value+",LastName: "+lname.value);
                                        console.log("Email: "+email.value);
                                        console.log("Gender: "+gender+", Age: "+age.value);
                                        console.log("Country: "+department.value+", RollNo: "+rollno.value);
                                        bool=true;
                                    }
                                else{
                                        alert("Please select Department.");
                                    }
                                }
                            else{
                                    alert("Please Select Gender.");
                                }
                           }
                           else{
                               alert("Enter Valid RollNo.")
                           }
                       }
                       else{
                           alert("Enter Valid Age.")
                       }
                       }
                   else{
                           alert("Enter proper email..");
                       }
                   }
               else{
                    alert("Last Name is required!!");
                   }
               }
           else{
                   alert("First Name is required!!");
        }

        if(bool){
            const occupation=document.getElementById('occupation');
            occupation.style.display="flex";
            const addStudent=document.getElementById('addStudent');
            addStudent.style.display="flex";
        }
        
}

// Using Object Array
// getStudent = () => {
//     let rollno = document.getElementById("rollno").value;
//     let res = "";
//     if(rollno=="") alert("Enter Rollno");
//      else if(rollno in StudentLogs){
   
//       res += `First Name: ${StudentLogs[rollno].fname} <br>
//       Last Name: ${StudentLogs[rollno].lname} <br>
//       Gender : ${StudentLogs[rollno].gender} <br>
//       Age : ${StudentLogs[rollno].age} <br>
//       Department: ${StudentLogs[rollno].department}<br>
//       Occupation: ${StudentLogs[rollno].occupation}`;
//          console.log(StudentLogs[rollno]);  

//          document.getElementById("outputData").innerHTML = res;
//      }
//    else {
//     document.getElementById("outputData").innerHTML = "Student not Found";
//    }

// }

// Using LocalStorage
getStudent=()=>{
    var res="";
    let rollno = document.getElementById("rollno").value;
    let show = "";
    if(rollno=="") alert("Enter Rollno");
    if(JSON.parse(localStorage.getItem(`student${rollno}`))){
        var student=JSON.parse(localStorage.getItem(`student${rollno}`));
        res+=`FirstName: ${student.fname}<br>
        LastName: ${student.lname}<br>
        Age: ${student.age}<br>
        Gender: ${student.gender}<br>
        Department: ${student.department}<br>
        Occupation: ${student.occupation}`
        document.getElementById("outputData").innerHTML = res;
    }
    else {
            document.getElementById("outputData").innerHTML = "Student not Found";
       }
    
}
