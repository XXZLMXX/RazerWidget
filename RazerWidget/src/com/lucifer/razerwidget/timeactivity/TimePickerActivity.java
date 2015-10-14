package com.lucifer.razerwidget.timeactivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.lucifer.razerlib.timepickerview.TimePickerView;
import com.lucifer.razerlib.timepickerview.TimePickerView.onSelectListener;
import com.lucifer.razerwidget.R;

/**
 * 更多详解见博客http://blog.csdn.net/zhongkejingwang/article/details/38513301
 * 
 * @author chenjing
 * 
 */
public class TimePickerActivity extends Activity
{

	TimePickerView minute_pv;
	TimePickerView second_pv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_timepicker);
		minute_pv = (TimePickerView) findViewById(R.id.minute_pv);
		second_pv = (TimePickerView) findViewById(R.id.second_pv);
		List<String> data = new ArrayList<String>();
		List<String> seconds = new ArrayList<String>();
		for (int i = 0; i < 10; i++)
		{
			data.add("0" + i);
		}
		for (int i = 0; i < 60; i++)
		{
			seconds.add(i < 10 ? "0" + i : "" + i);
		}
		minute_pv.setData(data);
		minute_pv.setOnSelectListener(new onSelectListener()
		{

			@Override
			public void onSelect(String text)
			{
				Toast.makeText(TimePickerActivity.this, "选择了 " + text + " 分",
						Toast.LENGTH_SHORT).show();
			}
		});
		second_pv.setData(seconds);
		second_pv.setOnSelectListener(new onSelectListener()
		{

			@Override
			public void onSelect(String text)
			{
				Toast.makeText(TimePickerActivity.this, "选择了 " + text + " 秒",
						Toast.LENGTH_SHORT).show();
			}
		});
		minute_pv.setSelected(0);
	}


}
