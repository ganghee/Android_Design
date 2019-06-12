package com.example.myexpandablelistviewmodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Game of Thrones"

        val season1 : MutableList<String> = ArrayList()
        season1.add("Winter is coming")
        season1.add("The aaa")

        val season2 : MutableList<String> = ArrayList()
        season2.add("Winter is coming")
        season2.add("The bbb")

        val season3 : MutableList<String> = ArrayList()
        season3.add("Winter is coming")
        season3.add("The ccc")

        val season4 : MutableList<String> = ArrayList()
        season4.add("Winter is coming")
        season4.add("The ddd")

        header.add("Season1")
        header.add("Season2")
        header.add("Season3")
        header.add("Season4")

        body.add(season1)
        body.add(season2)
        body.add(season3)
        body.add(season4)

        expandableListView.setAdapter(ExpandableListAdapter(this,expandableListView,header,body))



    }
}
