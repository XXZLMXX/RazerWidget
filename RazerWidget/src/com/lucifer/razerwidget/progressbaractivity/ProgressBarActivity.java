package com.lucifer.razerwidget.progressbaractivity;

import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.progressbaractivity.circularprogressbaractivity.CircularProgressActivity;
import com.lucifer.razerwidget.progressbaractivity.numberprogressbaractivity.NumberProgressBarActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressBarActivity extends Activity implements OnClickListener
{
	Button btn_numberprogress_progressbar, btn_circularprogress_progressbar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_progressbar);
		
		btn_numberprogress_progressbar = (Button) findViewById(R.id.btn_numberprogress_progressbar);
		btn_circularprogress_progressbar = (Button) findViewById(R.id.btn_circularprogress_progressbar);
		
		btn_numberprogress_progressbar.setOnClickListener(this);
		btn_circularprogress_progressbar.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.btn_numberprogress_progressbar:
			Intent intent = new Intent(ProgressBarActivity.this, NumberProgressBarActivity.class);
			startActivity(intent);
			break;

		case R.id.btn_circularprogress_progressbar:
			Intent intent2 = new Intent(ProgressBarActivity.this, CircularProgressActivity.class);
			startActivity(intent2);
			break;
			
		default:
			break;
		}
	}

}
