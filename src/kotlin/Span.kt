package kotlin

class Span {

    //In kotlin the thing get even easier

    inline fun SpannableStringBuilder.withSpan(span: Any, action: SpannableStringBuilder.() -> Unit): SpannableStringBuilder {
        val from = length
        action()
        setSpan(span, from, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    //Which just lets you use what's already there:

    SpannableStringBuilder("Thanks Jetbrains, ")
    .withSpan(StyleSpan(android.graphics.Typeface.BOLD)) { append("Kotlin saves time") }
    .append(" and is great.")

}