# Simple Search View for Android  [![](https://jitpack.io/v/pramonow/android-simplesearchview.svg)](https://jitpack.io/#pramonow/android-simplesearchview)

Simple and friendly search view, easy to use and implement with back button and auto clear button
Implemented fully with Kotlin

![alt text](https://raw.githubusercontent.com/pramonow/just_images/master/SearchPreview.PNG)

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Dependency

	dependencies {
	        implementation 'com.github.pramonow:android-simplesearchview:-SNAPSHOT'
	}
  

# How to use

In your xml layout file put in this block

    <pramonow.com.searchviewmodule.SimpleSearchView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/simple_search_view"/>

For the Android Activity

        //Simply build the view this way
        var simpleSearchView = findViewById<SimpleSearchView>(R.id.simple_search_view)

        //Set Callback for search and back button
        simpleSearchView.setButtonsCallback(object : ButtonCallback {
            override fun onSearch(text: String) {
                //DO SEARCH
            }

            override fun onBack() {
                //DO BACK
            }
        })

As for now, search view only support two simple modification:

    fun setTextHint(text:String)
    fun setFocused(focus:Boolean)
