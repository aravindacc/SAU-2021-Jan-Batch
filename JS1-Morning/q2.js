function caseChanger(txt) {
    var str1 = "";
    for (var i = 0; i < txt.length; i++) {
        if ('ZXCVBNMASDFGHJKLPOIUYTREWQ'.includes(txt[i])) str1 += txt[i].toLowerCase();
        else str1 += txt[i].toUpperCase();
    }
    return str1;
}

console.log(caseChanger("Tranforming tHe futurE"));
console.log(caseChanger("AccolIte"));