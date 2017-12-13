package kotlin.classObject

/* Some classes in the Android platform use Telescoping constructors, which is considered an anti-pattern. A good example of such a class is the android.view.View class. There may be a case when only a single constructor is used (inflating the custom view from Kotlin code), but it is much safer to override all three constructors when the subclassing android.view.View, because the class will work correctly in all scenarios. Normally, our CustomView class would look like this: */

    class CustomView : View { 
 
        constructor(context: Context?) : this(context, null) 
 
        constructor(context: Context?, attrs: AttributeSet?) : 
                    this(context, attrs, 0) 
 
        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { 
            //... 
        } 
     } 

/* This case introduces a lot of boilerplate code just for constructors that delegate calls to other constructors. Kotlin's solution to this problem is to use the @JvmOverload annotation:*

    class KotlinView @JvmOverloads constructor( 
        context: Context,  
        attrs: AttributeSet? = null,  
        defStyleAttr: Int = 0 
    ) : View(context, attrs, defStyleAttr) 