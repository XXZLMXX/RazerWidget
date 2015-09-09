package com.lucifer.razerlib.test.Xfermode;

import com.lucifer.razerlib.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;




/**
 * LayerView
 * 
 * @author Aige
 * @since 2014/12/15
 */
public class LayerView extends View
{
	private Bitmap mBitmap;// λͼ����

	private int mViewWidth, mViewHeight;// �ؼ����

	public LayerView(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		// ����Դ�л�ȡλͼ����
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		/*
		 * ��ȡ�ؼ����
		 */
		mViewWidth = w;
		mViewHeight = h;

		// ����λͼ��ؼ�һ��
		mBitmap = Bitmap.createScaledBitmap(mBitmap, mViewWidth, mViewHeight,
				true);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		Matrix matrix = new Matrix();
		matrix.setScale(0.8F, 0.35F);
		matrix.postTranslate(100, 100);
		canvas.setMatrix(matrix);
		canvas.drawBitmap(mBitmap, 0, 0, null);
		canvas.restore();
	}
}
