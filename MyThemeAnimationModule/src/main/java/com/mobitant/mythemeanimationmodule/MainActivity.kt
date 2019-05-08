package com.mobitant.mythemeanimationmodule

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val SHARED_PREFS : String = "codeTheme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_save.onClick { startActivity<ConThemeActivity>() }

        //아래 배경의 색을 지정합니다.
        holderbg.setBackgroundResource(R.drawable.background_green)
        holderbg.animate().scaleX(3f).start()
        holderbg.animate().scaleY(3f).start()

        //button의 크기를 지정합니다.
        btn_green.animate().scaleX(1.5f)
        btn_green.animate().scaleY(1.5f)

        //파란원의 버튼을 클릭하였을 때의 이벤트 입니다.
        btn_blue.onClick{

            //버튼들의 크기를 조절합니다.
            btn_blue.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(800).start()
            btn_green.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_purple.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_orange.animate().scaleX(1f).scaleY(1f).setDuration(350).start()

            //윗 배경의 크기와 배경색을 지정합니다.
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()
            dynamicbg.setBackgroundResource(R.drawable.background_blue)

            //버튼의 글자색을 지정합니다.
            btn_save.setTextColor(Color.parseColor("#3498db"))

            //save to local storage
            //SHARED_PREFS 라는 파일을 가져온다.
            //파일을 가져와 편집을 실행한다. Key는 themeString 값은 blue
            var themeString = ""
            var sharedPreferences:SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(themeString,"blue").apply()

            //핸들러를 이용하여 아래층의 크기와 윗층의 크기를 지정합니다.
            //이는 배경색이 가운데에서 바깥쪽으로 변하는 animation을 구현한 것 입니다.
            Handler().postDelayed({
                holderbg.animate().scaleX(3f).start()
                holderbg.animate().scaleY(3f).start()
                holderbg.setBackgroundResource(R.drawable.background_blue)
                dynamicbg.animate().scaleX(0f).setDuration(0).start()
                dynamicbg.animate().scaleY(0f).setDuration(0).start()

            },800)
        }
        btn_purple.onClick{
            btn_purple.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(800).start()

            btn_green.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_blue.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_orange.animate().scaleX(1f).scaleY(1f).setDuration(350).start()

            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()
            dynamicbg.setBackgroundResource(R.drawable.background_purple)

            btn_save.setTextColor(Color.parseColor("#9f37d6"))

            var themeString = ""
            var sharedPreferences:SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(themeString,"purple").apply()

            Handler().postDelayed({
                holderbg.animate().scaleX(3f).start()
                holderbg.animate().scaleY(3f).start()
                holderbg.setBackgroundResource(R.drawable.background_purple)
                dynamicbg.animate().scaleX(0f).setDuration(0).start()
                dynamicbg.animate().scaleY(0f).setDuration(0).start()

            },800)
        }
        btn_orange.onClick{
            btn_orange.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(800).start()

            btn_green.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_purple.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_blue.animate().scaleX(1f).scaleY(1f).setDuration(350).start()

            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()
            dynamicbg.setBackgroundResource(R.drawable.background_orange)

            btn_save.setTextColor(Color.parseColor("#ff8d7e"))

            var themeString = ""
            var sharedPreferences:SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(themeString,"orange").apply()

            Handler().postDelayed({
                holderbg.animate().scaleX(3f).start()
                holderbg.animate().scaleY(3f).start()
                holderbg.setBackgroundResource(R.drawable.background_orange)
                dynamicbg.animate().scaleX(0f).setDuration(0).start()
                dynamicbg.animate().scaleY(0f).setDuration(0).start()

            },800)
        }
        btn_green.onClick{
            btn_green.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(800).start()

            btn_blue.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_purple.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
            btn_orange.animate().scaleX(1f).scaleY(1f).setDuration(350).start()

            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()
            dynamicbg.setBackgroundResource(R.drawable.background_green)

            btn_save.setTextColor(Color.parseColor("#1abc9c"))

            var themeString = ""
            var sharedPreferences:SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(themeString,"green").apply()

            Handler().postDelayed({
                holderbg.animate().scaleX(3f).start()
                holderbg.animate().scaleY(3f).start()
                holderbg.setBackgroundResource(R.drawable.background_green)
                dynamicbg.animate().scaleX(0f).setDuration(0).start()
                dynamicbg.animate().scaleY(0f).setDuration(0).start()

            },800)
        }
    }
}
