describe("Kata FizzBuzz", function() {

  var fizzbuzz;
  beforeEach(function() {
      // Arrange
      fizzbuzz = new FizzBuzz();

  });

  it("should return 0 when ask 0", function() {
    // Act
    var result = fizzbuzz.ask(0);
    // Assert
    expect(result).toEqual("0");
  });

    it("should return Fizz when ask divisible by 3", function() {
        // Act
        var result = fizzbuzz.ask(3);
        // Assert
        expect(result).toEqual("Fizz");
    });


    it("should return Buzz when ask divisible by 5", function() {
        // Act
        var result = fizzbuzz.ask(5);
        // Assert
        expect(result).toEqual("Buzz");
    });

    it("should return FizzBuzz when ask divisible by 3 and 5", function() {
        // Act
        var result = fizzbuzz.ask(15);
        // Assert
        expect(result).toEqual("FizzBuzz");
    });

    //Un número es Fizz si es divisible por 3 o si incluye un 3 en el número
    it("Un número es Fizz si es divisible por 3 o si incluye un 3 en el número", function() {
        // Act
        var result = fizzbuzz.ask(13);
        // Assert
        expect(result).toEqual("Fizz");
    });

    it("Un número es Buzz si es divisible por 5 o si incluye un 5 en el número", function() {
        // Act
        var result = fizzbuzz.ask(52);
        // Assert
        expect(result).toEqual("Buzz");
    });

});
