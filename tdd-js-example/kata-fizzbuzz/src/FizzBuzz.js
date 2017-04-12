
function FizzBuzz() {

}

var BUZZ_STR = "Buzz";
var FIZZ_STR  = "Fizz";
var DIVISOR_THREE = 3;
var DIVISOR_FIVE = 5;
var MINUS_ONE = -1;

FizzBuzz.prototype.ask = function(number) {
    var askNumber = "";
    if(numberIsFizz(number)){
       askNumber = FIZZ_STR;
    }
    if (numberIsBuzz(number)){
        askNumber += BUZZ_STR;
    }
    return askNumber ? askNumber : String(number);
};

var numberIsBuzz = function (number) {
    return isDivisibleBy(number,DIVISOR_FIVE) || containsNumber(number, DIVISOR_FIVE);
}

var numberIsFizz = function (number) {
    return isDivisibleBy(number,DIVISOR_THREE) || containsNumber(number, DIVISOR_THREE);
}


var isDivisibleBy = function(number, factor){
    return number>0 && number%factor==0;
}

var containsNumber = function (number, factor) {
    return String(number).indexOf(String(factor)) > MINUS_ONE;
}




