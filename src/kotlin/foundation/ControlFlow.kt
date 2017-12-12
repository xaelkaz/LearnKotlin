package kotlin.foundation


fun main(args: Array<String>) {

    // IF
    fun ifStatement() {
        println(if (x > 10) "greater" else "smaller")

        val hour = 10
        val greeting = if (hour < 18) {
            //some code
            "Good day"
        } else {
            //some code
            "Good evening"
        }
        println(greeting) // Prints: "Good day"

        val greeting2 = if (hour < 18) "Good day" else "Good evening"

        val age = 18
        val message = "You are ${if (age < 18) "young" else "of age"} person"
        println(message) // Prints: You are of age person


    }

// The when expression

    fun whenExprss() {
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> println("x is neither 1 nor 2")
        }


        val vehicle = "Bike"
        val message = when (vehicle) {
            "Car" -> {
                // Some code
                "Four wheels"
            }
            "Bike" -> {
                // Some code
                "Two wheels"
            }
            else -> {
                //some code
                "Unknown number of wheels"
            }
        }
        println(message) //Prints: Two wheels
    }


    fun castWhen() {
        // Cast When
        val name = when (person) {
            is String -> person.toUpperCase()
            is User -> person.name
        //Code is smart casted to String, so we can
        //call String class methods
        //...
        }

        val riskAssessment = 47
        val risk = when (riskAssessment) {
            in 1..20 -> "negligible risk"
            !in 21..40 -> "minor risk"
            !in 41..60 -> "major risk"
            else -> "undefined risk"
        }

        println(risk) // Prints: major risk
    }


/*  It can be a method call or any other expression.
 Consider the following example where the second when expression is used for the else statement: */
    val riskAssessment = 80
    val handleStrategy = "Warn"

    val risk = when (riskAssessment) {
        in 1..20 -> print("negligible risk")
        !in 21..40 -> print("minor risk")
        !in 41..60 -> print("major risk")
        else -> when (handleStrategy) {
            "Warn" -> "Risk assessment warning"
            "Ignore" -> "Risk ignored"
            else -> "Unknown risk!"
        }
    }
    println(risk) // Prints: Risk assessment warning


    // Function with when
    fun getPasswordErrorId(password: String) = when {
        password.isEmpty() -> R.string.error_field_required
        passwordInvalid(password) -> R.string.error_invalid_password
        else -> null
    }


    /* Array */
    fun array() {
        val range = 1..6

        for (i in range) {
            print("$i ")
        }
        // prints: 1 2 3 4 5 6
    }

    fun BreakArray() {
        // Break Array

        val range = 1..6

        for (i in range) {
            print("$i ")

            if (i == 3)
                break
        }
    }


}