package kotlin.foundation

fun main(args: Array<String>) {

    val str = "abcd"
    println(str.reversed()) // Prints: dcba
    println(str.takeLast(2)) // Prints: cd
    println("john@test.com".substringBefore("@")) // Prints: john
    println("john@test.com".startsWith("@")) // Prints: false


// String templates

    val name = "Eva"
    val age = 27
    val message = "My name is $name and I am $age years old"
    println(message)
//Prints: My name is Eva  and I am 27 years old

// Ranges
    val intRange = 1..4 // 1
    val charRange = 'b'..'g' // 2

    for (i in 1..5) print(i) // Prints: 1234
    for (i in 'b'..'g') print(i) // Prints: bcdefg

    val c = 'k'      // Inferred type is Char
    val alphabet = 'a'..'z'

    if (c in alphabet)
        println("$c is character") //Prints: k is a character

    for (i in 3..6 step 2) print(i) // Prints: 35


}