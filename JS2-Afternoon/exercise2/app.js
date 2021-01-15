var StudentLogs={};
class Student {
    constructor(fname, lname, email, age, rollNo, gender, department, occupation) {
        this.fnirstName = fname;
        this.lname = lname;
        this.email = email;
        this.age = age;
        this.rollNo = rollNo;
        this.gender = gender;
        this.department = department;
        this.occupation = occupation;
    }
}
function formValidation(e){
    const rollno =document.getElementById("RollNo");
            const occupation=document.getElementById('occupation');
            e.preventDefault();
            if(occupation.value.length>0){
                alert("Form Submitted Successfully!! Student Details Added Successfully.");
                var student = new Student(fname.value,lname.value,email.value,age.value,rollno.value,gender,department.value,occupation.value);
                StudentLogs[rollno.value]=student;
                console.log("FirstName: "+fname.value+",LastName: "+lname.value);
                console.log("Email: "+email.value);
                console.log("Gender: "+gender+", Age: "+age.value);
                console.log("Country: "+department.value+", RollNo: "+rollno.value);
                //form.reset();
            }

}

function newField(){

            let bool=false;
            const fname=document.getElementById('fname');
            const lname=document.getElementById('lname');
            const email =document.getElementById("email");
            //const form=document.getElementById('form');
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

getStudent = () => {
    let rollno = document.getElementById("rollno").value;
    let show = "";
    if(rollno=="") alert("Enter Rollno");
     else if(rollno in StudentLogs){
   
      show += `First Name: ${StudentLogs[rollno].fname} <br>
      Last Name: ${StudentLogs[rollno].lname} <br>
      Gender : ${StudentLogs[rollno].gender} <br>
      Age : ${StudentLogs[rollno].age} <br>`;
         console.log(StudentLogs[rollno]);  

         document.getElementById("outputData").innerHTML = show;
     }
   else {
    document.getElementById("outputData").innerHTML = "Student Rollno not Found";
   }

}
