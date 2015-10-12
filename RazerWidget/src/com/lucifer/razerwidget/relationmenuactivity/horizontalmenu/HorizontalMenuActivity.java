package com.lucifer.razerwidget.relationmenuactivity.horizontalmenu;


import com.lucifer.razerwidget.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;



public class HorizontalMenuActivity extends Activity
{
	public String category1[] = new String[]
	{ "   餐饮   ", "  交通  ", "  购物  ", "  娱乐  ", "  医疗  ", "  教育  ", "  居家  ",
			"  投资  ", "  人情  " };

	
	public String category2[][] = new String[][]
	{
			new String[]
			{ "  早餐   ", " 午餐  ", " 晚餐  ", " 夜宵  ", "饮料水果", " 零食  ", "蔬菜原料",
					"油盐酱醋", "其他.." },
			new String[]
			{ "地铁", "公交", "打的", "加油", "停车", "过路过桥", "罚款", "包养维修", "火车", "车款车贷",
					"车险", "航空", "船舶", "自行车", "其他.." },
			new String[]
			{ "服装鞋帽", "日用百货", "婴幼用品", "数码产品", "化妆护肤", "首饰", "烟酒", "电器", "家具",
					"书籍", "玩具", "摄影文印", "其他.." },
			new String[]
			{ "看电影", "KTV", "网游电玩", "运动健身", "洗浴足浴", "茶酒咖啡", "旅游度假", "演出",
					"其他.." },
			new String[]
			{ "求医", "买药", "体检", "化验", "医疗器材", "其他.." },
			new String[]
			{ "培训", "考试", "书籍", "学杂费", "家教", "补习", "助学贷款", "其他.." },
			new String[]
			{ "美容美发", "手机电话", "宽带", "房贷", "水电燃气", "物业", "住宿租房", "保险费", "贷款",
					"材料建材", "家政服务", "快递邮政", "漏记款", "其他.." },
			new String[]
			{ "证券期货", "保险", "外汇", "出资", "黄金实物", "书画艺术", "投资贷款", "利息支出", "其他.." },
			new String[]
			{ "礼金", "物品", "慈善捐款", "代付款", "其他.." }, };

	
	Button btn_showdialog;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_horizontalmenu);
		
		btn_showdialog = (Button) findViewById(R.id.btn_showdialog);
		btn_showdialog.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				showSelectDialog(HorizontalMenuActivity.this, category1,
						category2);
			}
		});
		
	}
	
	
	
	
	private void showSelectDialog(Context context,
			final String[] left, final String[][] right)
	{
		Dialog dialog = new Dialog(context);
		
		LayoutInflater inflater = LayoutInflater.from(HorizontalMenuActivity.this);
		View layout = inflater.inflate(R.layout.aty_horizontaldialog, null);
		
		final WheelView wheelLeft = (WheelView) layout.findViewById(R.id.wv_left);
		wheelLeft.setVisibleItems(5);
		wheelLeft.setCyclic(false);
		wheelLeft.setAdapter(new ArrayWheelAdapter<String>(left));
		
		final WheelView wheelRight = (WheelView) layout.findViewById(R.id.wv_right);
		wheelRight.setVisibleItems(5);
		wheelRight.setCyclic(true);
		wheelRight.setAdapter(new ArrayWheelAdapter<String>(right[0]));
		
		
		wheelLeft.addChangingListener(new OnWheelChangedListener()
		{
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue)
			{
				wheelRight.setAdapter(new ArrayWheelAdapter<String>(
						right[newValue]));
				wheelRight.setCurrentItem(right[newValue].length / 2);
			}
		});
		
		
		setDialogSize(dialog);
		
	
		dialog.setContentView(layout);
		
		if (!dialog.isShowing())
		{
			dialog.show();
		}
	}

	
	
	private void setDialogSize(Dialog dg)
	{
		Window dialogWindow = dg.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		dialogWindow.setGravity(Gravity.BOTTOM);
		// 显示的坐标
		lp.x = 0;
		lp.y = 0;
		int width = WindowManager.LayoutParams.MATCH_PARENT;
		int height = WindowManager.LayoutParams.WRAP_CONTENT;
		// dialog的大小
		lp.width = width;
		lp.height = height;

		dialogWindow.setAttributes(lp);

	}
	
	
	
	
	
}
