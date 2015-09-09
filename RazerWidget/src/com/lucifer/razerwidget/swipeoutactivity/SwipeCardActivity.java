package com.lucifer.razerwidget.swipeoutactivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

import com.lucifer.razerlib.cardview.swipecardview.SwipeFlingAdapterView;
import com.lucifer.razerwidget.R;



public class SwipeCardActivity extends Activity implements OnClickListener
{

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;

    SwipeFlingAdapterView sfav_swipecard;
    Button left_swipecard, right_swipecard;
    

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_swipecard);

        sfav_swipecard = (SwipeFlingAdapterView) findViewById(R.id.sfav_swipecard);
        
        left_swipecard = (Button) findViewById(R.id.left_swipecard);
        right_swipecard = (Button) findViewById(R.id.right_swipecard);
        
        
        al = new ArrayList<String>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_swipecard, R.id.helloText, al);

        sfav_swipecard.setAdapter(arrayAdapter);
        sfav_swipecard.setFlingListener(new SwipeFlingAdapterView.onFlingListener()
        {
            @Override
            public void removeFirstObjectInAdapter()
            {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject)
            {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(SwipeCardActivity.this, "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject)
            {
                makeToast(SwipeCardActivity.this, "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter)
            {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @SuppressLint("NewApi")
			@Override
            public void onScroll(float scrollProgressPercent)
            {
                View view = sfav_swipecard.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        sfav_swipecard.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject)
            {
                makeToast(SwipeCardActivity.this, "Clicked!");
            }
        });

        
        left_swipecard.setOnClickListener(this);
        right_swipecard.setOnClickListener(this);
        
    }

    
    
    static void makeToast(Context ctx, String s)
    {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }





    
    
    @Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.left_swipecard:
			sfav_swipecard.getTopCardListener().selectLeft();
			break;
		
		case R.id.right_swipecard:
			sfav_swipecard.getTopCardListener().selectRight();
			break;

		default:
			break;
		}
	}


}
