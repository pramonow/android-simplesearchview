package pramonow.com.simplesearchview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_test.*
import pramonow.com.searchviewmodule.ButtonCallback
import pramonow.com.searchviewmodule.SimpleSearchView

class TestActivity : AppCompatActivity(),ButtonCallback {

    lateinit var simpleSearchView : SimpleSearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        simpleSearchView = findViewById(R.id.simple_search_view)
        simpleSearchView.setButtonsCallback(this)
    }

    override fun onSearch(text: String) {
        Toast.makeText(this,"Search " + text,Toast.LENGTH_SHORT).show()
    }

    override fun onBack() {
        Toast.makeText(this,"Back button pressed",Toast.LENGTH_SHORT).show()
    }

}
