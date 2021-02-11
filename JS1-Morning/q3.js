function numChecker(num){
    var first=num%10;
    num=Math.floor(num/10);
    while(num>0){
        if(num%10!=first){
            return false;
        }
        num=Math.floor(num/10);
    }
    return true;
}

console.log(numChecker(111));
console.log(numChecker(1234));