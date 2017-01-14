/**
 * Created by arpi on 12.01.2017.
 */
'use  strict';
function date() {
    return "date";
}

function isInteger(number) {
   return +number == (+number^0);
}

function isEcma(standardName) {
    if ("ECMAScript" == standardName) {
        alert("Right!")
    } else {
        alert("NO, it's ECMAScript!")
    }
}

(a + b < 4) ? result = 'Мало' : result = 'Много';


/*var number = prompt("Enter number number");
(isInteger(number)) ? alert("It's Int") : alert("It's Float");
var standardName = prompt("What is JS standard name?");
isEcma(standardName);*/

/*var log = prompt("enter login:",""), pas;

if(log == "admin") {
    pas = prompt("password:","");
    if (pas == "123"){
        alert("Hello!")
    } else if (pas == "") {
        alert("CANCEL")
    } else {alert("WRONG pass")}
} else if (log == "") {
    alert("CANCEL")
} else {
    alert("I don't know you!")
}*/


/*var name = "Vasya", admin;
alert("Я - JavaScript");
admin = name;
alert(admin);*/
/*
 var flag = confirm("Ты понял?");
if (flag){
    var description = prompt("Что ты понял","Ничего он не понял");
};

if (!flag) {alert("Не понял")}
else {alert("Понял, что " + description);};

do {
    var cond = confirm("Do you really want to leave this site?" + date());
} while (!cond);*/
