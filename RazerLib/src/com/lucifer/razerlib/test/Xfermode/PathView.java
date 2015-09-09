package com.lucifer.razerlib.test.Xfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * CanvasView
 * 
 * @author Aige
 * @since 2014/12/12
 */
public class PathView extends View {
	private Path mPath;// ·������
	private Paint mPaint;// ·�����ʶ���
	private TextPaint mTextPaint;// �ı����ʶ���

	public PathView(Context context, AttributeSet attrs) {
		super(context, attrs);

		/*
		 * ʵ��ʲ���������
		 */
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.CYAN);
		mPaint.setStrokeWidth(5);

		mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
		mTextPaint.setColor(Color.DKGRAY);
		mTextPaint.setTextSize(20);

		// ʵ��·��
		mPath = new Path();

		// ���һ�����ߵ�Path��
		RectF oval = new RectF(100, 100, 300, 400);
		mPath.addOval(oval, Path.Direction.CCW);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// ����·��
		canvas.drawPath(mPath, mPaint);

		// ����·���ϵ�����
		canvas.drawTextOnPath("ad������㷢��ʿ���˹�ٷ�˹�ٷ�ɭ����ɨ��ɨ��ɨ�﷢��ʡ�����������", mPath, 0, 0, mTextPaint);
	}
}
