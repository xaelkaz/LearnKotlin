package kotlin.classObject

interface EmailProvider {

    val email: String

    val nickname: String
        get() = email.substringBefore("@")

    fun validateEmail() = nickname.isNotEmpty()
}

class User(override val email: String) : EmailProvider

//usage
val user = User("joey@test.com")
print(user.validateEmail()) // Prints: true
print(user.nickname) // Prints: joey