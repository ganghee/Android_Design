package com.mobitant.myhorizentalrecyclermodule.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.mobitant.myhorizentalrecyclermodule.Adapter.EventAdapter;
import com.mobitant.myhorizentalrecyclermodule.Model.EventData;
import com.mobitant.myhorizentalrecyclermodule.R;

import java.util.ArrayList;
import java.util.List;

public class MainJavaActivity extends AppCompatActivity {

    RecyclerView eventsplace;
    EventAdapter eventAdapter;
    List<EventData> eventList ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventList= new ArrayList<>();

        eventsplace = findViewById(R.id.recyclerview);
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));
        eventList.add(
                new EventData("Evoturism with a Master Pank","WORKSHOP",R.drawable.picone));

        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,false);
        eventsplace.setLayoutManager(linearLayoutManager);
        eventsplace.setHasFixedSize(true);

        eventAdapter = new EventAdapter(this, (ArrayList<EventData>) eventList);
        eventsplace.setAdapter(eventAdapter);

        final SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(eventsplace);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolderDefault =
                        eventsplace.findViewHolderForAdapterPosition(0);
                LinearLayout eventparentDefault = viewHolderDefault.itemView.findViewById(R.id.event_parent);
                eventparentDefault.animate().scaleX(1).scaleY(1).setDuration(350).setInterpolator(new
                        AccelerateInterpolator()).start();
                LinearLayout eventbadgeDefault = viewHolderDefault.itemView.findViewById(R.id.eventbadge);
                eventbadgeDefault.animate().alpha(0).setDuration(300).start();









            }
        },100);















        eventsplace.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);

                    RecyclerView.ViewHolder viewHolder =
                            eventsplace.findViewHolderForAdapterPosition(pos);

                    LinearLayout eventparent = viewHolder.itemView.findViewById(R.id.event_parent);
                    eventparent.animate().scaleY(1).scaleX(1).setDuration(350).
                            setInterpolator(new AccelerateInterpolator()).start();

                    LinearLayout eventbadge = viewHolder.itemView.findViewById(R.id.eventbadge);
                    eventbadge.animate().alpha(1).setDuration(300).start();

                }else{

                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);

                    RecyclerView.ViewHolder viewHolder =
                            eventsplace.findViewHolderForAdapterPosition(pos);

                    LinearLayout eventparent = viewHolder.itemView.findViewById(R.id.event_parent);
                    eventparent.animate().scaleY(0.7f).scaleX(0.7f).setDuration(350).
                            setInterpolator(new AccelerateInterpolator()).start();

                    LinearLayout eventbadge = viewHolder.itemView.findViewById(R.id.eventbadge);
                    eventbadge.animate().alpha(0).setDuration(300).start();

                    TextView eventtitle = viewHolder.itemView.findViewById(R.id.eventtitle);
                    eventtitle.animate().scaleY(1).scaleX(1).setDuration(300).start();
                }



            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
