package com.lucifer.razerwidget.textview;

import com.lucifer.razerlib.textview.shimmertextview.Shimmer;
import com.lucifer.razerlib.textview.shimmertextview.ShimmerTextView;
import com.lucifer.razerlib.textview.titanictextview.Titanic;
import com.lucifer.razerlib.textview.titanictextview.TitanicTextView;
import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.os.Bundle;

public class TextViewActivity extends Activity
{
	ShimmerTextView stv;
	Shimmer shimmer;
	
	TitanicTextView titanicTextView; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_textview);
		
		//ShimmerTextView
		stv = (ShimmerTextView) findViewById(R.id.stv_shimmertextview);
		if (shimmer != null && shimmer.isAnimating())
		{
			shimmer.cancel();
		} else
		{
			shimmer = new Shimmer();
			shimmer.start(stv);
		}
		
		
		
		//TitanicTextView
		titanicTextView = (TitanicTextView) findViewById(R.id.ttv_titanic);
		
		titanicTextView.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        new Titanic().start(titanicTextView);
		
		
	}
}
