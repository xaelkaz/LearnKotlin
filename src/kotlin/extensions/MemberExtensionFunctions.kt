package kotlin.extensions

class UsersItemAdapter : ItemAdapter() {
    lateinit var usersNames: List<String>

    fun processList() {
        usersNames = getUsersList()
                .map { it.name }
                .dropOneEvery(3)
    }

    fun List<String>.dropOneEvery(i: Int) =
            filterIndexed { index, _ -> index % i == (i - 1) }

    // ...
}


class UsersItemAdapter(
        private val category: Category
) : ItemAdapter() {

    lateinit var usersNames: List<String>

    fun processList() {
        usersNames = getUsersList()
                .fromSameCategory()
                .map { it.name }
    }

    fun List<User>.fromSameCategory() =
            filter { u -> u.category.id == category.id }

    private fun getUsersList() = emptyList<User>()
}


// Types of receivers


class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val buttonView = findViewById(R.id.button_view) as Button
        buttonView.setUp()
    }

    private fun Button.setUp() {
        setText("Click me!") // 1, 2
        setOnClickListener { showText("Hello") } // 2
    }

    private fun showText(text: String) {
        toast(text)
    }
}

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val buttonView = findViewById(R.id.button_view) as Button
        buttonView.setUp()
    }

    private fun Button.setUp() {
        setText("Click me!")
        setOnClickListener {this@MainActivity.setText("Hello")   } // 1
    }

    private fun setText(text: String) {
        textView.setText(text)
    }
}