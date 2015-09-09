package com.lucifer.razerlib.test.Xfermode;

import com.lucifer.razerlib.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;



/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/22
 * 
 */
public class AttrView extends View
{
	/*
	 * �����Ż��ı�ʶλ��
	 */
	private static final int OPTIMIZE_ANTI = 0x001, OPTIMIZE_DITHER = 0x002,
			OPTIMIZE_LINEAR = 0x004, OPTIMIZE_ANTI_DITHER = 0x003,
			OPTIMIZE_ANTI_LINEAR = 0x005, OPTIMIZE_DITHER_LINEAR = 0x006,
			OPTIMIZE_ALL = 0x007;

	/*
	 * �ı����뷽ʽ�ı�ʶλ��
	 */
	private static final int TEXT_LEFT = 0, TEXT_RIGHT = 1, TEXT_CENTER = 2;

	private Bitmap mBitmap;// λͼ����
	private TextPaint mTextPaint;// �ı����ʶ���

	private boolean isTextDisplay = true;// �Ƿ���ʾ�ı�

	public AttrView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mTextPaint = new TextPaint();

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.AttrView);

		// PS�����������ʾ��ʵ�ʿ������ٻ���ôȥ������Щ����

		/*
		 * ��ȡ��ԴID������
		 */
		int resId = a.getResourceId(R.styleable.AttrView_image, -1);
		if (resId >= 0)
			mBitmap = BitmapFactory.decodeResource(getResources(), resId);

		// ��ȡ�Ƿ���ʾ�ı�����
		isTextDisplay = a.getBoolean(R.styleable.AttrView_text_display, true);

		if (isTextDisplay)
		{
			/*
			 * ��ȡ�����Ż������Բ�����
			 */
			int paintOptimize = a.getInteger(
					R.styleable.AttrView_text_optimize, -1);
			if (paintOptimize >= 0)
			{
				switch (paintOptimize)
				{
				case OPTIMIZE_ANTI:
					System.out.println("OPTIMIZE_ANTI");
					mTextPaint.setAntiAlias(true);
					break;
				case OPTIMIZE_DITHER:
					System.out.println("OPTIMIZE_DITHER");
					mTextPaint.setDither(true);
					break;
				case OPTIMIZE_LINEAR:
					System.out.println("OPTIMIZE_LINEAR");
					mTextPaint.setLinearText(true);
					break;
				case OPTIMIZE_ANTI_DITHER:
					System.out.println("OPTIMIZE_ANTI_DITHER");
					mTextPaint.setAntiAlias(true);
					mTextPaint.setDither(true);
					break;
				case OPTIMIZE_ANTI_LINEAR:
					System.out.println("OPTIMIZE_ANTI_LINEAR");
					mTextPaint.setAntiAlias(true);
					mTextPaint.setLinearText(true);
					break;
				case OPTIMIZE_DITHER_LINEAR:
					System.out.println("OPTIMIZE_DITHER_LINEAR");
					mTextPaint.setDither(true);
					mTextPaint.setLinearText(true);
					break;
				case OPTIMIZE_ALL:
					System.out.println("OPTIMIZE_ALL");
					mTextPaint.setAntiAlias(true);
					mTextPaint.setDither(true);
					mTextPaint.setLinearText(true);
					break;
				}
			}

			/*
			 * ��ȡ��ɫֵ������
			 */
			int textColor = a.getColor(R.styleable.AttrView_text_color,
					0x00000000);
			mTextPaint.setColor(textColor);

			/*
			 * ��ȡ�������Բ�����
			 */
			int textAlign = a.getInteger(R.styleable.AttrView_text_align, -1);
			switch (textAlign)
			{
			case TEXT_LEFT:
				mTextPaint.setTextAlign(Paint.Align.LEFT);
				break;
			case TEXT_RIGHT:
				mTextPaint.setTextAlign(Paint.Align.RIGHT);
				break;
			case TEXT_CENTER:
				mTextPaint.setTextAlign(Paint.Align.CENTER);
				break;
			}

			/*
			 * ��ȡ�ı�͸�������Բ�����
			 */
			float textAlpha = a.getFraction(R.styleable.AttrView_alpha, 1, 1,
					-1);
			mTextPaint.setAlpha((int) textAlpha);
		}

		// �мǻ���
		a.recycle();
	}
}
