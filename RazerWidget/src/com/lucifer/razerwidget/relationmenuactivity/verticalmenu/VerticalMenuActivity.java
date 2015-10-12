package com.lucifer.razerwidget.relationmenuactivity.verticalmenu;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.razerwidget.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;



public class VerticalMenuActivity extends Activity implements OnItemSelectedListener
{
	/** 一级Spinner */
	private Spinner oneSpinner;

	/** 二级Spinner */
	private Spinner twoSpinner;

	/** 三级Spinner */
	private Spinner threeSpinner;

	/** 结果显示 */
	private EditText result;

	/** 一级集合 */
	private List<String> oneList = new ArrayList<String>();

	/** 二级集合 */
	private List<TwoEntity> twoList = new ArrayList<TwoEntity>();

	/** 三级集合 */
	private List<ThreeEntity> threeList = new ArrayList<ThreeEntity>();

	/** 默认集合 */
	private List<String> indexList;

	/** 适配器 */
	private ArrayAdapter<String> adapter;

	/** 一级名称 */
	private String oneName;

	/** 二级名称 */
	private String twoName;

	/** 三级名称 */
	private String threeName;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_verticalmenu);
		// 初始化控件
		this.getWight();

		// 添加数据
		this.addData();

		// 初始化数据
		adapterData(oneList, oneSpinner);
	}

	
	
	
	/**
	 * 根据控件ID获取控件
	 */
	private void getWight()
	{
		// Spinner
		oneSpinner = (Spinner) findViewById(R.id.one_spinner);
		oneSpinner.setPrompt("省");
		oneSpinner.setOnItemSelectedListener(this);
		twoSpinner = (Spinner) findViewById(R.id.two_spinner);
		twoSpinner.setPrompt("市");
		twoSpinner.setOnItemSelectedListener(this);
		threeSpinner = (Spinner) findViewById(R.id.three_spinner);
		threeSpinner.setPrompt("区");
		threeSpinner.setOnItemSelectedListener(this);

		// EditText
		result = (EditText) findViewById(R.id.display_edit);
	}

	
	
	
	/**
	 * Spinner处理方法
	 * 
	 * @param adapterView
	 * @param view
	 * @param position
	 * @param id
	 */
	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view,
			int position, long id)
	{
		switch (adapterView.getId())
		{
		case R.id.one_spinner:// 一级数据
			// 获取一级名称
			oneName = oneSpinner.getItemAtPosition(position).toString();

			// 找到相应的二级数据
			selectTwoData(oneName);

			// 适配二级数据
			adapterData(indexList, twoSpinner);
			break;
			
			
		case R.id.two_spinner:// 二级数据
			// 获取二级名称
			twoName = twoSpinner.getItemAtPosition(position).toString();

			// 找到相应的三级数据
			selectThreeData(twoName);

			// 适配三级数据
			adapterData(indexList, threeSpinner);
			break;
			
			
		case R.id.three_spinner:// 三级数据
			threeName = threeSpinner.getItemAtPosition(position).toString();
			result.setText(oneName + "-" + twoName + "-" + threeName);
			break;
			
		}
	}

	
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
		oneSpinner.setSelection(0);
		twoSpinner.setSelection(0);
		threeSpinner.setSelection(0);
	}

	
	
	/**
	 * 初始化数据
	 */
	private void adapterData(List<String> list, Spinner spin)
	{

		// 车辆类型内如与arrayAdapter连接
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);

		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		spin.setAdapter(adapter);
		// //车辆号码默认值
		// spin.setVisibility(View.VISIBLE);
	}

	
	
	/**
	 * 二级数据查询
	 */
	private void selectTwoData(String name)
	{
		indexList = new ArrayList<String>();
		// 循环二级数据集合，找到符合条件的数据
		for (int i = 0; i < twoList.size(); i++)
		{
			if (name.equals(twoList.get(i).getParentName()))
			{
				indexList.add(twoList.get(i).getTwoName());
			}
		}
	}

	
	
	/**
	 * 三级数据查询
	 */
	private void selectThreeData(String name)
	{
		indexList = new ArrayList<String>();
		// 循环三级数据集合，找到符合条件的数据
		for (int i = 0; i < threeList.size(); i++)
		{
			if (name.equals(threeList.get(i).getParentName()))
			{
				indexList.add(threeList.get(i).getThreeName());
			}
		}
	}

	
	
	/**
	 * 临时数据区域
	 */
	private void addData()
	{

		// 添加一级数据
		oneList.add("山东");
		oneList.add("河北");
		oneList.add("河南");

		// 添加二级数据
		TwoEntity two = new TwoEntity();

		two.setTwoName("济南");
		two.setParentName("山东");

		TwoEntity two3 = new TwoEntity();

		two3.setTwoName("青岛");
		two3.setParentName("山东");

		TwoEntity two4 = new TwoEntity();

		two4.setTwoName("德州");
		two4.setParentName("山东");

		TwoEntity two1 = new TwoEntity();

		two1.setTwoName("石家庄");
		two1.setParentName("河北");

		TwoEntity two5 = new TwoEntity();

		two5.setTwoName("保定");
		two5.setParentName("河北");

		TwoEntity two2 = new TwoEntity();

		two2.setTwoName("郑州");
		two2.setParentName("河南");

		twoList.add(two);
		twoList.add(two1);
		twoList.add(two2);
		twoList.add(two3);
		twoList.add(two4);
		twoList.add(two5);

		// 添加三级数据
		ThreeEntity three = new ThreeEntity();

		three.setThreeName("章丘");
		three.setParentName("济南");

		ThreeEntity three1 = new ThreeEntity();

		three1.setThreeName("城阳");
		three1.setParentName("青岛");

		ThreeEntity three2 = new ThreeEntity();
		three2.setThreeName("齐河");
		three2.setParentName("德州");

		ThreeEntity three3 = new ThreeEntity();
		three3.setThreeName("长安");
		three3.setParentName("石家庄");

		ThreeEntity three4 = new ThreeEntity();
		three4.setThreeName("清苑");
		three4.setParentName("保定");

		ThreeEntity three5 = new ThreeEntity();
		three5.setThreeName("登封");
		three5.setParentName("郑州");

		threeList.add(three);
		threeList.add(three1);
		threeList.add(three2);
		threeList.add(three3);
		threeList.add(three4);
		threeList.add(three5);
	}

}	
