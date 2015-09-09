package com.lucifer.razerlib.test.Xfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * CanvasView
 * 
 * @author Aige
 * @since 2014/12/12
 */
public class CanvasView extends View {
	private Region mRegion;// �������
	private Rect mRect;// ���ζ���
	private Paint mPaint;// ���Ʊ߿��Paint

	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// ʵ��ʲ���������
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.DKGRAY);
		mPaint.setStrokeWidth(2);

		// ʵ����ζ���
		mRect = new Rect(0, 0, 200, 200);

		// ʵ���������
		mRegion = new Region(200, 200, 400, 400);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// ���Ż���
		canvas.scale(0.75F, 0.75F);

		canvas.save();

		// �ü�����
		canvas.clipRect(mRect);
		canvas.drawColor(Color.RED);

		canvas.restore();

		canvas.save();

		// �ü�����
		canvas.clipRegion(mRegion);
		canvas.drawColor(Color.RED);

		canvas.restore();

		// Ϊ��������һ���߿���ڹ۲�
		canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mPaint);
	}
}
