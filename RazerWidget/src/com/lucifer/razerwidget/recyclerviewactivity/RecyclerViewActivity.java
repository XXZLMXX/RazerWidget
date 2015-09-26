package com.lucifer.razerwidget.recyclerviewactivity;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.DragRecyclerViewActivity;
import com.lucifer.razerwidget.recyclerviewactivity.fragmentexamplerecyclerview.FragmentExampleActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class RecyclerViewActivity extends Activity implements OnClickListener
{
	Button btn_dragtop_recyclerview, btn_viewpager_recyclerview, 
	btn_fragmentexample_recyclerview, btn_animrefresh_recyclerview;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.aty_recyclerview);
		
		btn_dragtop_recyclerview = (Button) findViewById(R.id.btn_dragtop_recyclerview);
		btn_viewpager_recyclerview = (Button) findViewById(R.id.btn_viewpager_recyclerview);
		btn_fragmentexample_recyclerview = (Button) findViewById(R.id.btn_fragmentexample_recyclerview);
		btn_animrefresh_recyclerview = (Button) findViewById(R.id.btn_animrefresh_recyclerview);
		
		btn_dragtop_recyclerview.setOnClickListener(this);
		btn_viewpager_recyclerview.setOnClickListener(this);
		btn_fragmentexample_recyclerview.setOnClickListener(this);
		btn_animrefresh_recyclerview.setOnClickListener(this);
	}



	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		case R.id.btn_dragtop_recyclerview:
			Intent intent = new Intent(RecyclerViewActivity.this, DragRecyclerViewActivity.class);
			startActivity(intent);
			break;
			
		case R.id.btn_viewpager_recyclerview:
			Toast.makeText(getApplicationContext(), "还没做", 1000).show();
			break;
			
		case R.id.btn_fragmentexample_recyclerview:
			Intent intent3 = new Intent(RecyclerViewActivity.this, FragmentExampleActivity.class);
			startActivity(intent3);
			break;
			
		case R.id.btn_animrefresh_recyclerview:
			/*Intent intent4 = new Intent(RecyclerViewActivity.this, ItemTouchActivity.class);
			startActivity(intent4);*/
			break;

		default:
			break;
		}
	}
	
}
