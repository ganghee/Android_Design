package com.mobitant.myautodigitupmodule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter1: Int = 0
    private var total1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dollar = findViewById<View>(R.id.textView) as TextView
        TextViewAnimation1(0, "125", dollar)
    }

    private fun TextViewAnimation1(mulai: Int, total_laporan: String, txt_view: TextView) {
        counter1 = mulai
        total1 = Integer.parseInt(total_laporan)

        Thread(Runnable {
            while (counter1 < total1) {
                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                txt_view.post { txt_view.text = "$" + counter1 }
                counter1++
            }
        }).start()
    }

}
