package com.mobitant.ui_design

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //폰트 지정하기
        var font = Typeface.createFromAsset(assets,"fonts/MRegular.ttf")
        btn_get.typeface = font

        //애니메이션 지정하기
        img_Splach.startAnimation(AnimationUtils.loadAnimation(this,R.anim.atg))

        btn_get.onClick { startActivity<StopWatchActivity>() }
    }
}
