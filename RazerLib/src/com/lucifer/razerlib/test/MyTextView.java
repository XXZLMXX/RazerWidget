package com.lucifer.razerlib.test;

import com.lucifer.razerlib.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;



public class MyTextView extends View
{
	/**
	 * 要绘制的文本内容
	 */
	private String mText = "";
	/**
	 * 文字大小
	 */
	private int mTextSize = 60;
	/**
	 * 画笔
	 */
	private Paint mPaint = new Paint();

	/**
	 * 文本的区域，主要是宽度和高度
	 */
	Rect mTextRect = new Rect();

	
	public MyTextView(Context context)
	{
		this(context, null, 0);
	}

	
	public MyTextView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	
	public MyTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		initAttrs(attrs);

		// 反锯齿
		mPaint.setAntiAlias(true);
		// 设置画笔的文字大小
		mPaint.setTextSize(mTextSize);
	}

	
	
	
	public void setText(String text)
	{
		mText = text;
	}

	
	
	
	private void initAttrs(AttributeSet attrs)
	{
		// 获取自定义的属性
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
		// 获得要绘制的文本内容
		mText = typedArray.getString(R.styleable.MyTextView_text);
		// 设置字体的大小
		mTextSize = typedArray.getDimensionPixelSize(R.styleable.MyTextView_textSize, 60);
		typedArray.recycle();
	}

	
	
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		int width = getWidth();
		int height = getHeight();
		// 获取要绘制文本的宽度和高度，存储在mTextRect中
		mPaint.getTextBounds(mText, 0, mText.length(), mTextRect);
		// 在view的中心绘制文本
		canvas.drawText(mText, width / 2 - mTextRect.width() / 2, height / 2
				+ mTextRect.height() / 2, mPaint);
	}
	
	
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// 获得文本的宽度和高度
		mPaint.getTextBounds(mText, 0, mText.length(), mTextRect);

		// 默认支持的是match_parent
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// 获取由widthMeasureSpec提供的模式和宽度
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		// 获取由heightMeasureSpec提供的模式和高度
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
		// 如果都是宽高设置为wrap_content，那么都使用文本的宽高
		if (widthSpecMode == MeasureSpec.AT_MOST
				&& heightSpecMode == MeasureSpec.AT_MOST)
		{
			setMeasuredDimension(mTextRect.width(), mTextRect.height());
		} else if (widthSpecMode == MeasureSpec.AT_MOST)
		{
			// 如果只是宽度是wrap_content，那么宽度使用文本的宽度，高度使用widthMeasureSpec中的高度
			setMeasuredDimension(mTextRect.width(), heightSpecSize);
		} else if (heightSpecMode == MeasureSpec.AT_MOST)
		{
			// 如果只是高度是wrap_content，那么高度使用文本的高度，宽度使用heightMeasureSpec中的宽度
			setMeasuredDimension(widthSpecSize, mTextRect.height());
		}
	}



}
