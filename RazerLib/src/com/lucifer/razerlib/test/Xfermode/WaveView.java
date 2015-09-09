package com.lucifer.razerlib.test.Xfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * WaveView
 * 
 * @author Aige
 * @since 2014/12/12
 */
public class WaveView extends View {
	private Path mPath;// ·������
	private Paint mPaint;// ���ʶ���

	private int vWidth, vHeight;// �ؼ����
	private float ctrX, ctrY;// ���Ƶ��xy���
	private float waveY;// ���Wave�������˵��Y��꣬���������Ƶ��Y���������һ��

	private boolean isInc;// �жϿ��Ƶ��Ǹ����ƻ�������

	public WaveView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// ʵ��ʲ����ò���
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setColor(0xFFA2D6AE);

		// ʵ��·������
		mPath = new Path();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// ��ȡ�ؼ����
		vWidth = w;
		vHeight = h;

		// ������Ƶ�Y���
		waveY = 1 / 8F * vHeight;

		// ����˵�Y���
		ctrY = -1 / 16F * vHeight;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		/*
		 * ����Path���
		 * ע���ҽ�Path������������˿ؼ����ⲿ������������
		 * ������ǽ���������ڿؼ����x=0��λ�û�ʹ�ñ�������߱����Ӳ
		 * ����Ϊʲô�ղ����Ѿ�˵��
		 * ����������΢��������⡱�ߵ�
		 */
		mPath.moveTo(-1 / 4F * vWidth, waveY);

		/*
		 * �Զ������ߵķ�ʽͨ����Ƶ�����λ�ڿؼ��ұߵ��յ�
		 * �յ��λ��Ҳ���ڿؼ��ⲿ
		 * ����ֻ�費����ctrX�Ĵ�С�仯����ʵ�֡��ˡ���Ч��
		 */
		mPath.quadTo(ctrX, ctrY, vWidth + 1 / 4F * vWidth, waveY);

		// Χ�ƿؼ��պ�����
		mPath.lineTo(vWidth + 1 / 4F * vWidth, vHeight);
		mPath.lineTo(-1 / 4F * vWidth, vHeight);
		mPath.close();

		canvas.drawPath(mPath, mPaint);

		/*
		 * �����Ƶ��x�����ڻ�����յ�x���ʱ��ı�ʶֵ
		 */
		if (ctrX >= vWidth + 1 / 4F * vWidth) {
			isInc = false;
		}
		/*
		 * �����Ƶ��x���С�ڻ�������x���ʱ��ı�ʶֵ
		 */
		else if (ctrX <= -1 / 4F * vWidth) {
			isInc = true;
		}

		// ��ݱ�ʶֵ�жϵ�ǰ�Ŀ��Ƶ�x����Ǹüӻ��Ǽ�
		ctrX = isInc ? ctrX + 20 : ctrX - 20;

		/*
		 * �á�ˮ�����ϼ���
		 */
		if (ctrY <= vHeight) {
			ctrY += 2;
			waveY += 2;
		}

		mPath.reset();

		// �ػ�
		invalidate();
	}
}
