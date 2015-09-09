package com.lucifer.razerlib.test.Xfermode;

import com.lucifer.razerlib.R;
import com.lucifer.razerlib.utils.DimenUtil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;




/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/13
 * 
 */
public class IconView extends View
{
	private Bitmap mBitmap;// λͼ
	private TextPaint mPaint;// �����ı��Ļ���
	private String mStr;// ���Ƶ��ı�

	private float mTextSize;// ���ʵ��ı��ߴ�

	/**
	 * ���ö����
	 * 
	 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
	 * 
	 */
	private enum Ratio
	{
		WIDTH, HEIGHT
	}

	public IconView(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		// �������
		calArgs(context);

		// ��ʼ��
		init();
	}

	/**
	 * �������
	 * 
	 * @param context
	 *            �����Ļ�������
	 */
	private void calArgs(Context context)
	{
		// ��ȡ��Ļ��
		int sreenW = DimenUtil.getScreenSize((Activity) context)[0];

		// �����ı��ߴ�
		mTextSize = sreenW * 1 / 10F;
	}

	/**
	 * ��ʼ��
	 */
	private void init()
	{
		/*
		 * ��ȡBitmap
		 */
		if (null == mBitmap)
		{
			mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
		}

		/*
		 * ΪmStr��ֵ
		 */
		if (null == mStr || mStr.trim().length() == 0)
		{
			mStr = "AigeStudio";
		}

		/*
		 * ��ʼ�����ʲ����ò���
		 */
		mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG
				| Paint.LINEAR_TEXT_FLAG);
		mPaint.setColor(Color.LTGRAY);
		mPaint.setTextSize(mTextSize);
		mPaint.setTextAlign(Paint.Align.CENTER);
		mPaint.setTypeface(Typeface.DEFAULT_BOLD);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// ���ò�����ĳߴ�
		setMeasuredDimension(getMeasureSize(widthMeasureSpec, Ratio.WIDTH),
				getMeasureSize(heightMeasureSpec, Ratio.HEIGHT));
	}

	/**
	 * ��ȡ������ĳߴ�
	 * 
	 * @param measureSpec
	 *            �������
	 * @param ratio
	 *            ��߱�ʶ
	 * @return ���ߵĲ���ֵ
	 */
	private int getMeasureSize(int measureSpec, Ratio ratio)
	{
		// ������ʱ�����������ֵ
		int result = 0;

		/*
		 * ��ȡmode��size
		 */
		int mode = MeasureSpec.getMode(measureSpec);
		int size = MeasureSpec.getSize(measureSpec);

		/*
		 * �ж�mode�ľ���ֵ
		 */
		switch (mode)
		{
		case MeasureSpec.EXACTLY:// EXACTLYʱֱ�Ӹ�ֵ
			result = size;
			break;
		default:// Ĭ������½�UNSPECIFIED��AT_MOSTһ������
			if (ratio == Ratio.WIDTH)
			{
				float textWidth = mPaint.measureText(mStr);
				result = ((int) (textWidth >= mBitmap.getWidth() ? textWidth
						: mBitmap.getWidth()))
						+ getPaddingLeft()
						+ getPaddingRight();
			} else if (ratio == Ratio.HEIGHT)
			{
				result = ((int) ((mPaint.descent() - mPaint.ascent()) * 2 + mBitmap
						.getHeight())) + getPaddingTop() + getPaddingBottom();
			}

			/*
			 * AT_MOSTʱ�ж�size��result�Ĵ�СȡСֵ
			 */
			if (mode == MeasureSpec.AT_MOST)
			{
				result = Math.min(result, size);
			}
			break;
		}
		return result;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.WHITE);
		/*
		 * ���� ����Ͳ���������������Ϊֻ��Drawһ�β���Ƶ������
		 */
		canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2,
				getHeight() / 2 - mBitmap.getHeight() / 2, null);
		canvas.drawText(mStr, getWidth() / 2, mBitmap.getHeight() + getHeight()
				/ 2 - mBitmap.getHeight() / 2 - mPaint.ascent(), mPaint);
	}
}
