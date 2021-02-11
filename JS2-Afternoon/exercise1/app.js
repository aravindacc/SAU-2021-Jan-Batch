class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        const len=this.input.length;
        console.log(`Length Of the Input: ${len}`);
        return len;
    };
    getUpperCase() {
        var upper=(this.input.length>0)?this.input.toUpperCase():"No String Found";
        console.log(`UpperCase Of the Input: ${upper}`);
        return upper;
    };
    getLowerCase() {
        var lower=(this.input.length>0)?this.input.toLowerCase():"No String Found";
        console.log(`LowerCase Of the Input: ${lower}`);
        return lower;
    };
    getConsonants() {
        var consonants="";
        [...this.input].forEach(c=>{
            if(/^[a-zA-Z]/.test(c) && !"aeiouAEIOU".includes(c)){
                consonants+=c;
            }
        });
        consonants=(consonants.length>0)?consonants:"No Consonants Present"
        console.log(`Consonants in the Input: ${consonants}`);
        return consonants;
    }
    getVowels() {
        var vowels="";
        [...this.input].forEach(c=>{
            if(/^[a-zA-Z]/.test(c) && "aeiouAEIOU".includes(c)){
                vowels+=c;
            }
        });
        vowels=(vowels.length>0)?vowels:"No Vowels Present"
        console.log(`Vowels in the Input: ${vowels}`);
        return vowels;
    }
    checkError=()=>{
        var num="";
        [...this.input].forEach(c=>{
            if(/\d/.test(c)){
                num+=c;
            }
        });
         var error= (/\d/.test(this.input))?`Number is Present (${num})`:"No Number Found";
         console.log(`Error is: ${error}`);
         return error;
    }
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    document.getElementById("ccOp").innerHTML = inputObject.getConsonants();
    document.getElementById("vvOp").innerHTML = inputObject.getVowels();
    document.getElementById("error").innerHTML = inputObject.checkError();
}