package com.mobitant.ui_design

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_stop_watch.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class StopWatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        //멈춤 버튼 안보이기
        btn_stop.visibility = INVISIBLE

        //animation객체 만들기
        var rounding_alone=AnimationUtils.loadAnimation(this,R.anim.rounding_alone)

        //start버튼 클릭시 에니메이션 시작
        btn_start.onClick {
            background_anchor.startAnimation(rounding_alone)
            btn_stop.visibility = VISIBLE
            btn_start.animate().alpha(0f).setDuration(300).start()

            //타이머 형식 보여주기
            timerHere.base = SystemClock.elapsedRealtime()
            timerHere.start()
        }

        //stop버튼 클릭 시 animation정지
        btn_stop.onClick {
            background_anchor.clearAnimation()
            timerHere.stop()
        }
    }
}
