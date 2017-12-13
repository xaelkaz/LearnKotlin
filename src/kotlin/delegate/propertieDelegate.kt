package kotlin.delegate

class MainActivity : Activity() {

    var questionLabelView: TextView by bindView(R.id.main_question_label)  // 1
    var answerLabelView: TextView by bindView(R.id.main_answer_label)   // 1
    var confirmButtonView: Button by bindView(R.id.main_button_confirm) // 1

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    fun <T: View> Activity.bindView(viewId: Int) = lazy { findViewById(viewId) as T }
}

/* The lazy function
Sometimes we need to initialize an object, but we want to make sure that the object will be initialized only once,
when it is used for the first time. In Java, we could solve this problem in the following way:
*/


/* Thanks to the lazy delegate, the initialization, of the property is delayed until the value is needed. 
Usage of the lazy delegate provides several benefits: */


/*     Faster class initialization leading to faster application startup time, 
because value initialization is delayed until they are used for the first time
    Some values may never be used for certain flows, so they will never be initialized--we 
    save resources (memory, processor time, and battery) */


// Property Example

//Java 
class SettingsActivity extends Activity { 
 
  final Doctor DOCTOR_KEY = "doctorKey" 
  final String TITLE_KEY = "titleKey" 
 
  Doctor doctor 
  Address address 
  String title 
 
  public static void start ( Context context, Doctor doctor, 
  String title ) { 
    Intent intent = new Intent(context, SettingsActivity.class ) 
    intent.putExtra(DOCTOR_KEY, doctor) 
    intent.putExtra(TITLE_KEY, title) 
    context.startActivity(intent) 
  } 
  
  @Override 
  public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_main); 
 
    doctor = getExtras().getParcelable(DOCTOR_KEY)   
    title = getExtras().getString(TITLE_KEY)   
 
    ToastHelper.toast(this, doctor.id) 
    ToastHelper.toast(this, title) 
  } 
}

/* Kotlin */

fun <T : Parcelable> Activity.extra(key: String) = lazy 
    { intent.extras.getParcelable<T>(key) } 

fun Activity.extraString(key: String) = lazy 
    { intent.extras.getString(key) }


class SettingsActivity : Activity() { 
 
    private val doctor by extra<Doctor>(DOCTOR_KEY) // 1 
    private val title by extraString(TITLE_KEY) // 1 
 
    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.settings_activity) 
        toast(doctor.id) // 2 
        toast(title) // 2 
    } 
 
    companion object { // 3 
        const val DOCTOR_KEY = "doctorKey" 
        const val TITLE_KEY = "titleKey" 
 
    fun start(context: Context, doctor: Doctor, title: String) { // 3 
        ontext.startActivity(getIntent<SettingsActivity>().apply { // 4 
            putExtra(DOCTOR_KEY, doctor) // 5 
            putExtra(TITLE_KEY, title) // 5 
        }) 
    } 
  } 
}