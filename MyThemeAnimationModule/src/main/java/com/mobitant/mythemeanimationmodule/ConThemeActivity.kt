package com.mobitant.mythemeanimationmodule

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_con_theme.*

class ConThemeActivity : AppCompatActivity() {

    var SHARED_PREFS = "codeTheme"
    lateinit var getThemeString:String
    var themeString : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_theme)

        changeOurTheme()
    }

    fun changeOurTheme(){

        //SHARED_PREFS라는 파일을 가져온다.
        var sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        //가져온 파일에 themeString이라는 키의 값이 있는지 확인
        // 있으면 값을 반환 없으면 ""반환
        getThemeString = sharedPreferences.getString(themeString,"")

        if(getThemeString=="blue"){
            image_icon.setImageResource(R.drawable.icmob)
            button_icon.setBackgroundResource(R.drawable.background_blue)
            textView_sub.text = "The water is beautiful of blue"
        }else if(getThemeString == "green"){
            image_icon.setImageResource(R.drawable.icmog)
            button_icon.setBackgroundResource(R.drawable.background_green)
            textView_sub.text = "The water is beautiful of green"
        }else if(getThemeString == "purple"){
            image_icon.setImageResource(R.drawable.icmop)
            button_icon.setBackgroundResource(R.drawable.background_purple)
            textView_sub.text = "The water is beautiful of purple"
        }else if(getThemeString == "orange"){
            image_icon.setImageResource(R.drawable.icmoc)
            button_icon.setBackgroundResource(R.drawable.background_orange)
            textView_sub.text = "The water is beautiful of orange"
        }
    }
}
