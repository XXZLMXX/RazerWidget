package com.lucifer.razerwidget.relationmenuactivity;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.relationmenuactivity.horizontalmenu.HorizontalMenuActivity;
import com.lucifer.razerwidget.relationmenuactivity.verticalmenu.VerticalMenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class RelationMenuActivity extends Activity implements OnClickListener
{
	Button btn_vertical_relationmenu, btn_horizontal_relationmenu;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_relationmenu);
		
		btn_vertical_relationmenu = (Button) findViewById(R.id.btn_vertical_relationmenu);
		btn_horizontal_relationmenu = (Button) findViewById(R.id.btn_horizontal_relationmenu);
		
		btn_vertical_relationmenu.setOnClickListener(this);
		btn_horizontal_relationmenu.setOnClickListener(this);
	}



	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_vertical_relationmenu:
			Intent intent1 = new Intent(RelationMenuActivity.this, VerticalMenuActivity.class);
			startActivity(intent1);
			break;
			
			
		case R.id.btn_horizontal_relationmenu:
			Intent intent2 = new Intent(RelationMenuActivity.this, HorizontalMenuActivity.class);
			startActivity(intent2);
		    break;

		default:
			break;
		}
	}
	
}
