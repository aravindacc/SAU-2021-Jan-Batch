function giveSum(param){
var sum=0,i=0;
let n=param.length
while(i<n){
    if(/\d/.test(param[i])){
        sum+=parseInt(param[i]);
    }
    i+=1
}
return sum;
}

console.log(giveSum('abcd12efg9'));
console.log(giveSum('Tran5for3in9 T46 Fu7u83, N0w'));
