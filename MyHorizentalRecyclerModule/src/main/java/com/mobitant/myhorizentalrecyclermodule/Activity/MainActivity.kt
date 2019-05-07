//package com.mobitant.myhorizentalrecyclermodule.Activity
//
//import android.os.Bundle
//import android.os.Handler
//import android.support.v7.app.AppCompatActivity
//import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView
//import android.support.v7.widget.SnapHelper
//import android.view.Gravity
//import android.view.animation.AccelerateInterpolator
//import android.widget.LinearLayout
//import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
//import com.mobitant.myhorizentalrecyclermodule.Adapter.EventAdapter
//import com.mobitant.myhorizentalrecyclermodule.Model.EventData
//import com.mobitant.myhorizentalrecyclermodule.R
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.recycler_item.*
//import kotlinx.android.synthetic.main.recycler_item.view.*
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val dataList :ArrayList<EventData> = ArrayList()
//
//        dataList.add(EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone))
//        dataList.add(EventData("Cooking","CLASSES",R.drawable.pictwo))
//        dataList.add(EventData("Learn Gratitude from Monk","SEMIAR",R.drawable.picone))
//        dataList.add(EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone))
//        dataList.add(EventData("Cooking","CLASSES",R.drawable.pictwo))
//        dataList.add(EventData("Learn Gratitude from Monk","SEMIAR",R.drawable.picone))
//
//        recyclerview.adapter = EventAdapter(this,dataList)
//        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
//
//        //RecyclerViewSpannable을 구글에서 검색하여 dependency를 추가 해줍니다.
//        val snapHelper:SnapHelper = GravitySnapHelper(Gravity.START)
//        snapHelper.attachToRecyclerView(recyclerview)
//
//        //Set a timer forirDefault item
//        var handler: Handler = Handler()
//        handler.postDelayed(Runnable {
//            val eventDefault =recyclerview.findViewHolderForAdapterPosition(0)!!.itemView
//            val eventParentDefault = eventDefault.event_parent
//            eventParentDefault.animate().scaleX(1f).scaleY(1f).setDuration(350).start()
//        },100)
//
//
//        //RecyclerView item 의 애니메이션을 설정해줍니다.
//        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//
//                if (newState == RecyclerView.SCROLL_STATE_IDLE){
//                   // val view: View? = snapHelper.findSnapView(recyclerView.layoutManager)
//                    //val pos = recyclerView.layoutManager!!.getPosition(view!!)
//                   // val viewHolder : RecyclerView.ViewHolder? = recyclerView.findViewHolderForAdapterPosition(pos)
//                    event_parent.animate().scaleX(0.7f).scaleY(0.7f).
//                            setInterpolator(AccelerateInterpolator()).setDuration(350).start()
//
//                }
//            }
//        })
//
//
//    }
//}
