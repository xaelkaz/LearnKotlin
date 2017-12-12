package kotlin.foundation

/* Strict null safety */

fun main(args: Array<String>) {


/*If savedInstanceState is null, then null will be returned, otherwise the result of
evaluating a savedInstanceState?.getBoolean("locked") expression will be returned. Keep in mind
that a nullable reference call always returns nullable, so the result of the whole expression is
a nullable Boolean?. If we want to make sure we will get
non-nullable Boolean, we can combine the safe call operator with the elvis operator
 discussed in the next section. */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val locked: Boolean? = savedInstanceState?.getBoolean("locked")
    }


// The let function

/* As mentioned before, the right-hand expression of the safe call operator will be only
evaluated if the left-hand side is not null. In this case, the right-hand side is a let function
that takes another function (lambda) as a parameter. Code defined in the block after let will be
executed if savedInstanceState is not null. */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            println(it.getBoolean("isLocked")) // 1
        }
    }


//Cast

/*we can use the safe cast operator as?. It is sometimes called the nullable cast operator.
This operator tries to cast a value to the specified type, and returns null if the value cannot be cast. Here is an example:
*/
    val fragment: String = "ProductFragment"
    val productFragment: ProductFragment? = fragment as?
            ProductFragment
    val fragment: String = "ProductFragment"
    val productFragment: ProductFragment? = fragment as?
            ProductFragment ?: ProductFragment()


// Smart casts

/* instance */
    if (animal is Fish) {
        animal.isHungry()
    }
}
