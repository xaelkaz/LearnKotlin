package kotlin.extensions

/*The only difference in the general structure between an extension function and a standard
 function is that there is a receiver type specified before the function name. A less visible
 change is inside the body--there, we can access the receiver object (the object on which an
 extension is called) with the this keyword, or directly call its functions or properties.
With such a definition, the toast function acts like a method defined in Context: */

fun Context.toast(text: String) { // 1
    Toast.makeText(this, text, LENGTH_LONG).show() //2
}

// Usage
context.toast("Some toast")


context.toast("Some toast")

//Alternatively:
class MainActivity :Activity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        toast("Some text")
    }
}


/* Error Usage */

fun Any?.logError(error: Throwable, message: String = "error") {
    Log.e(this?.javaClass?.simpleName ?: "null", message, error)
}

user.logError(e, "NameError") // Logs: User: NameError ...
"String".logError(e) // String: error ...
logError(e) // 1, MainActivity: error ...



// Some interesting examples

/* The first is useful when you are inflating a view inside an adapter.
 Normally you would use something like this: */

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
    return ViewHolder(v)
}


 // With Extension function

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
    return ViewHolder(v)
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
    return ViewHolder(v)
}



// Other Example

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) { 
    Toast.makeText(this, message, duration) .show()
}

override fun onCreate(savedInstanceState: Bundle?) {
    super<BaseActivity>.onCreate(savedInstanceState) 
    toast("This is onCreate!!") 
}

inline fun <reified T : Activity> Activity.navigate(id: String) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("id", id)
    startActivity(intent)
}

navigate<DetailActivity>("2")

/*
Las funciones en línea son un poco diferentes de las funciones regulares. Las funciones 
en línea se sustituirán por su código durante la compilación, en lugar de llamar a una función. 
Simplificará algunas situaciones. Por ejemplo, si tenemos una función como argumento, una función 
regular creará internamente un objeto que contenga esa función. Por otro lado, las funciones en línea
sustituirán el código de la función en el lugar donde se llama, por lo que no requerirá un objeto interno para eso. */


// Optional parameters and default values

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){ 
    Toast.makeText(this, message, duration) .show()
}

toast("Short Toast!!")
toast("Long Toast!!", Toast.LENGTH_LONG)


// Other

inline fun <reified T : Activity> Activity.navigate(
         id: String, 
        sharedView: View? = null,
         transitionName: String? = null) {          
    ...
 }

navigate<DetailActivity>("2")
navigate<DetailActivity>("2", sharedView, TRANSITION_NAME)
navigate<DetailActivity>(id = "2", transitionName = TRANSITION_NAME)


fun View.show() { visibility = View.VISIBLE }
fun View.hide() { visibility = View.GONE }