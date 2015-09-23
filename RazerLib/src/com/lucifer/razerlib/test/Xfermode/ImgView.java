package com.lucifer.razerlib.test.Xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/12
 * 
 */
public class ImgView extends View
{
	private Bitmap mBitmap;// λͼ����

	
	
	public ImgView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// ����һ����ʱ�������洢������Ĳ���ֵ
		int resultWidth = 0;

		// ��ȡ��Ȳ�������е�mode
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);

		// ��ȡ��Ȳ�������е�size
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

		/*
		 * ������������
		 */
		if (modeWidth == MeasureSpec.EXACTLY)
		{
			// ��ô����Ҳ��Ҫ�õ�������ȡ���Ĵ�С��
			resultWidth = sizeWidth;
		}
		/*
		 * ��������û��
		 */
		else
		{
			// ��ô���ӿ�Ҫ�Լ������Լ���Ҫ�����
			resultWidth = mBitmap.getWidth() + getPaddingLeft()
					+ getPaddingRight();

			/*
			 * �������ӵ���һ������ֵ
			 */
			if (modeWidth == MeasureSpec.AT_MOST)
			{
				// ��ô�����Լ��������Ҫ�������Ʊȱȿ�˭СҪ˭
				resultWidth = Math.min(resultWidth, sizeWidth);
			}
		}

		int resultHeight = 0;
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

		if (modeHeight == MeasureSpec.EXACTLY)
		{
			resultHeight = sizeHeight;
		} else
		{
			resultHeight = mBitmap.getHeight() + getPaddingTop()
					+ getPaddingBottom();
			if (modeHeight == MeasureSpec.AT_MOST)
			{
				resultHeight = Math.min(resultHeight, sizeHeight);
			}
		}

		// ���ò����ߴ�
		setMeasuredDimension(resultWidth, resultHeight);
	}

	
	
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		// ����λͼ
		canvas.drawBitmap(mBitmap, getPaddingLeft(), getPaddingTop(), null);
	}

	
	
	/**
	 * ����λͼ
	 * 
	 * @param bitmap
	 *            λͼ����
	 */
	public void setBitmap(Bitmap bitmap)
	{
		this.mBitmap = bitmap;
	}



}
