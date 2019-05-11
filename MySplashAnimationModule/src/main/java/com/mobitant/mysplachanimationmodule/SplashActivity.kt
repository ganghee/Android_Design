package com.mobitant.mysplachanimationmodule

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //폰트 지정하기
        var logo = Typeface.createFromAsset(assets,"fonts/Fredoka.ttf")
        var mlight = Typeface.createFromAsset(assets,"fonts/MontserratLight.ttf")
        var mmedium = Typeface.createFromAsset(assets,"fonts/MontserratMedium.ttf")
        //var mregular = Typeface.createFromAsset(assets,"fonts/MontserratRegular.ttf")

        ivLogo.typeface = logo
        ivSubtitle.typeface = mlight
        ivBtn.typeface = mmedium

        //애니메이션 지정하기
        var smalltobig= AnimationUtils.loadAnimation(this,R.anim.smalltobig)

        ivSplash.startAnimation(smalltobig)

        //초기 view 위치 지정
        //원래의 위치보다 400px 이동되어 있다.
        ivLogo.translationX = 400F
        ivSubtitle.translationX = 400F
        ivBtn.translationX = 400F

        //초기 view가 투명하다
        ivLogo.alpha = 0F
        ivSubtitle.alpha = 0F
        ivBtn.alpha = 0F

        //view들이 지정된 시간동안 투명도와 x축으로 이동한다. translationX(0f)은 제자리로 이동합니다.
        ivLogo.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1500).start()
        ivSubtitle.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1700).start()
        ivBtn.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1900).start()

        //intent
        ivBtn.onClick { startActivity<MainActivity>() }

    }
}
