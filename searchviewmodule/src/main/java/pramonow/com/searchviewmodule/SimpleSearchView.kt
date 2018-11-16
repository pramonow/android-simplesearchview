package pramonow.com.searchviewmodule

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout

class SimpleSearchView: RelativeLayout {

    lateinit var queryText: EditText
    lateinit var backButton: ImageButton
    lateinit var clearButton: ImageButton

    constructor(context: Context, attr: AttributeSet) : super(context,attr) {
        init(context)
    }

    private fun init(context: Context)
    {
        View.inflate(context, R.layout.layout_search_view,this)

        //INIT EVERY VIEW
        queryText = findViewById(R.id.query_text)
        backButton = findViewById(R.id.text_back_button)
        clearButton = findViewById(R.id.text_clear_button)

        setTextWatcher()
    }

    private fun setTextWatcher()
    {
        queryText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //NOT IMPLEMENTED
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //NOT IMPLEMENTED
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.isNullOrEmpty())
                    clearButton.visibility = View.INVISIBLE
                else
                    clearButton.visibility = View.VISIBLE
            }
        })
    }

    public fun setButtonsCallback(buttonCallback: ButtonCallback){
        clearButton.setOnClickListener { v -> queryText.text.clear() }

        queryText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                buttonCallback.onSearch(queryText.text.toString())
                return@OnKeyListener true
            }
            false
        })

        backButton.setOnClickListener{v -> buttonCallback.onBack()}
    }

    public fun setTextHint(text:String)
    {
        queryText.setHint(text)
    }

    public fun setFocused(focus:Boolean)
    {
        queryText.isFocusable = focus
    }

    public fun setSearchTextWatcher(textWatcher: TextWatcher)
    {
        queryText.addTextChangedListener(textWatcher)
    }
}