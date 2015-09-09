package com.lucifer.razerlib.test;

import com.lucifer.razerlib.R;
import com.lucifer.razerlib.utils.DimenUtil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;



public class ColorFilterView extends View
{
	private Context mContext;
	private Paint mPaint;
	private Bitmap bitmap;// 位图 

	private int x,y;// 位图绘制时左上角的起点坐标  
	
	
	public ColorFilterView(Context context)
	{
		this(context, null);
	}

	
	
	public ColorFilterView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mContext = context;

		initPaint();
		
		initRes(context);
	}

	
	
	
	private void initPaint()
	{
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.LTGRAY);
		mPaint.setStrokeWidth(10);
	}

	
	
	private void initRes(Context context)
	{
		// 获取位图
		bitmap = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.a);

		/*
		 * 计算位图绘制时左上角的坐标使其位于屏幕中心 屏幕坐标x轴向左偏移位图一半的宽度 屏幕坐标y轴向上偏移位图一半的高度
		 */
		x = DimenUtil.getScreenSize((Activity) mContext)[0] / 2
				- bitmap.getWidth() / 2;
		y = DimenUtil.getScreenSize((Activity) mContext)[1] / 2
				- bitmap.getHeight() / 2;
	}

	
	
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);

		// 绘制位图
		canvas.drawBitmap(bitmap, x, y, mPaint);
	}

	
	
	
	
	public void setColorFilter(ColorFilter colorFilter)
	{
		mPaint.setColorFilter(colorFilter);
		invalidate();
	}

}
