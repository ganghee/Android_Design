package com.mobitant.mysplachanimationmodule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout1.translationX = 400F
        linearLayout2.translationX = 400F
        linearLayout3.translationX = 400F

        linearLayout1.alpha = 0F
        linearLayout2.alpha = 0F
        linearLayout3.alpha = 0F

        linearLayout1.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1500).start()
        linearLayout2.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1700).start()
        linearLayout3.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(1900).start()

    }
}
