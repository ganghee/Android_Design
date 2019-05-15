package com.mobitant.myswipebuttonmodule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe_me.setOnStateChangeListener {
            //swipe가 되었을 때
            if(it)
                startActivity<HomeActivity>()

            //swipe가 되지 않았을 때
            else
                finish()
        }

    }
}
