package com.lucifer.razerlib.test.Xfermode;

import com.lucifer.razerlib.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;




/**
 * 
 * @author AigeStudio {@link http://blog.csdn.net/aigestudio}
 * @since 2015/1/23
 * 
 */
public class SquareLayout extends ViewGroup
{
	// 排列方向的常量标识值 
	private static final int ORIENTATION_HORIZONTAL = 0, ORIENTATION_VERTICAL = 1;

	// 最大行列默认值  
	private static final int DEFAULT_MAX_ROW = Integer.MAX_VALUE,DEFAULT_MAX_COLUMN = Integer.MAX_VALUE;

	private int mMaxRow = DEFAULT_MAX_ROW;// 最大行数 
	private int mMaxColumn = DEFAULT_MAX_COLUMN;// 最大列数  

	private int mOrientation = ORIENTATION_VERTICAL;// 排列方向

	
	
	public SquareLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		// ��ʼ�����������
		mMaxRow = 2;
		mMaxColumn = 2;
	}

	
	
	@Override
	public boolean shouldDelayChildPressedState()
	{
		return false;
	}

	
	
	@SuppressLint("NewApi")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		/*
		 * 声明临时变量存储父容器的期望值 该值应该等于父容器的内边距加上所有子元素的测量宽高和外边距
		 */
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;

		// 声明临时变量存储子元素的测量状态
		int childMeasureState = 0;

		/*
		 * 如果父容器内有子元素
		 */
		if (getChildCount() > 0)
		{
			/*
			 * 那么就遍历子元素
			 */
			for (int i = 0; i < getChildCount(); i++)
			{
				// 获取对应遍历下标的子元素
				View child = getChildAt(i);

				/*
				 * 如果该子元素没有以“不占用空间”的方式隐藏则表示其需要被测量计算
				 */
				if (child.getVisibility() != View.GONE)
				{

					// 测量子元素并考量其外边距
					measureChildWithMargins(child, widthMeasureSpec, 0,
							heightMeasureSpec, 0);

					// 比较子元素测量宽高并比较取其较大值
					int childMeasureSize = Math.max(child.getMeasuredWidth(),
							child.getMeasuredHeight());

					// 重新封装子元素测量规格
					int childMeasureSpec = MeasureSpec.makeMeasureSpec(
							childMeasureSize, MeasureSpec.EXACTLY);

					// 重新测量子元素
					child.measure(childMeasureSpec, childMeasureSpec);

					// 获取子元素布局参数
					MarginLayoutParams mlp = (MarginLayoutParams) child
							.getLayoutParams();

					/*
					 * 考量外边距计算子元素实际宽高
					 */
					int childActualWidth = child.getMeasuredWidth()
							+ mlp.leftMargin + mlp.rightMargin;
					int childActualHeight = child.getMeasuredHeight()
							+ mlp.topMargin + mlp.bottomMargin;

					/*
					 * 如果为横向排列
					 */
					if (mOrientation == ORIENTATION_HORIZONTAL)
					{
						// 累加子元素的实际宽度
						parentDesireWidth += childActualWidth;

						// 获取子元素中高度最大值
						parentDesireHeight = Math.max(parentDesireHeight,
								childActualHeight);
					}

					/*
					 * 如果为竖向排列
					 */
					else if (mOrientation == ORIENTATION_VERTICAL)
					{
						// 累加子元素的实际高度
						parentDesireHeight += childActualHeight;

						// 获取子元素中宽度最大值
						parentDesireWidth = Math.max(parentDesireWidth,
								childActualWidth);
					}

					// 合并子元素的测量状态
					childMeasureState = combineMeasuredStates(
							childMeasureState, child.getMeasuredState());
				}
			}

			/*
			 * 考量父容器内边距将其累加到期望值
			 */
			parentDesireWidth += getPaddingLeft() + getPaddingRight();
			parentDesireHeight += getPaddingTop() + getPaddingBottom();

			/*
			 * 尝试比较父容器期望值与Android建议的最小值大小并取较大值
			 */
			parentDesireWidth = Math.max(parentDesireWidth,
					getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight,
					getSuggestedMinimumHeight());
		}

		// 确定父容器的测量宽高
		setMeasuredDimension(
				resolveSizeAndState(parentDesireWidth, widthMeasureSpec,
						childMeasureState),
				resolveSizeAndState(parentDesireHeight, heightMeasureSpec,
						childMeasureState << MEASURED_HEIGHT_STATE_SHIFT));
	}

	
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		/*
		 * �������������Ԫ��
		 */
		if (getChildCount() > 0)
		{
			// ������ʱ�����洢��߱���ֵ
			int multi = 0;

			// ָ����ֵ
			int indexMulti = 1;

			// ������ʱ�����洢��/�п��
			int indexMultiWidth = 0, indexMultiHeight = 0;

			// ������ʱ�����洢��/����ʱ���
			int tempHeight = 0, tempWidth = 0;

			/*
			 * ������Ԫ��
			 */
			for (int i = 0; i < getChildCount(); i++)
			{
				// ��ȡ��Ӧ�����±����Ԫ��
				View child = getChildAt(i);

				/*
				 * ������Ԫ��û���ԡ���ռ�ÿռ䡱�ķ�ʽ�������ʾ����Ҫ����������
				 */
				if (child.getVisibility() != View.GONE)
				{
					// ��ȡ��Ԫ�ز��ֲ���
					MarginLayoutParams mlp = (MarginLayoutParams) child
							.getLayoutParams();

					// ��ȡ�ؼ��ߴ�
					int childActualSize = child.getMeasuredWidth();// child.getMeasuredHeight()

					/*
					 * ���Ϊ��������
					 */
					if (mOrientation == ORIENTATION_HORIZONTAL)
					{
						/*
						 * �����Ԫ���������޶�ֵ��
						 */
						if (getChildCount() > mMaxColumn)
						{
							/*
							 * ��ݵ�ǰ��Ԫ�ؽ��в���
							 */
							if (i < mMaxColumn * indexMulti)
							{
								child.layout(getPaddingLeft() + mlp.leftMargin
										+ indexMultiWidth, getPaddingTop()
										+ mlp.topMargin + indexMultiHeight,
										childActualSize + getPaddingLeft()
												+ mlp.leftMargin
												+ indexMultiWidth,
										childActualSize + getPaddingTop()
												+ mlp.topMargin
												+ indexMultiHeight);
								indexMultiWidth += childActualSize
										+ mlp.leftMargin + mlp.rightMargin;
								tempHeight = Math.max(tempHeight,
										childActualSize)
										+ mlp.topMargin
										+ mlp.bottomMargin;

								/*
								 * �����һ�α������Ԫ���±�ֵ�����޶�ֵ
								 */
								if (i + 1 >= mMaxColumn * indexMulti)
								{
									// ��ô�ۼӸ߶ȵ��߶ȱ���ֵ
									indexMultiHeight += tempHeight;

									// ���ÿ�ȱ���ֵ
									indexMultiWidth = 0;

									// ����ָ����ֵ
									indexMulti++;
								}
							}
						} else
						{
							// ȷ����Ԫ�����ϡ��������
							child.layout(getPaddingLeft() + mlp.leftMargin
									+ multi, getPaddingTop() + mlp.topMargin,
									childActualSize + getPaddingLeft()
											+ mlp.leftMargin + multi,
									childActualSize + getPaddingTop()
											+ mlp.topMargin);

							// �ۼӱ���ֵ
							multi += childActualSize + mlp.leftMargin
									+ mlp.rightMargin;
						}
					}

					/*
					 * ���Ϊ��������
					 */
					else if (mOrientation == ORIENTATION_VERTICAL)
					{
						if (getChildCount() > mMaxRow)
						{
							if (i < mMaxRow * indexMulti)
							{
								child.layout(getPaddingLeft() + mlp.leftMargin
										+ indexMultiWidth, getPaddingTop()
										+ mlp.topMargin + indexMultiHeight,
										childActualSize + getPaddingLeft()
												+ mlp.leftMargin
												+ indexMultiWidth,
										childActualSize + getPaddingTop()
												+ mlp.topMargin
												+ indexMultiHeight);
								indexMultiHeight += childActualSize
										+ mlp.topMargin + mlp.bottomMargin;
								tempWidth = Math
										.max(tempWidth, childActualSize)
										+ mlp.leftMargin + mlp.rightMargin;
								if (i + 1 >= mMaxRow * indexMulti)
								{
									indexMultiWidth += tempWidth;
									indexMultiHeight = 0;
									indexMulti++;
								}
							}
						} else
						{
							// ȷ����Ԫ�����ϡ��������
							child.layout(getPaddingLeft() + mlp.leftMargin,
									getPaddingTop() + mlp.topMargin + multi,
									childActualSize + getPaddingLeft()
											+ mlp.leftMargin, childActualSize
											+ getPaddingTop() + mlp.topMargin
											+ multi);

							// �ۼӱ���ֵ
							multi += childActualSize + mlp.topMargin
									+ mlp.bottomMargin;
						}
					}
				}
			}
		}
	}

	
	
	
	
	@Override
	protected LayoutParams generateDefaultLayoutParams()
	{
		return new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
	}

	
	@Override
	protected android.view.ViewGroup.LayoutParams generateLayoutParams(
			android.view.ViewGroup.LayoutParams p)
	{
		return new LayoutParams(p);
	}

	
	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(
			AttributeSet attrs)
	{
		return new LayoutParams(getContext(), attrs);
	}

	
	
	@Override
	protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p)
	{
		return p instanceof LayoutParams;
	}

	
	
	public static class LayoutParams extends MarginLayoutParams
	{
		public int mGravity = Gravity.LEFT | Gravity.RIGHT;// ���뷽ʽ

		
		public LayoutParams(MarginLayoutParams source)
		{
			super(source);
		}

		
		public LayoutParams(android.view.ViewGroup.LayoutParams source)
		{
			super(source);
		}

		
		public LayoutParams(Context c, AttributeSet attrs)
		{
			super(c, attrs);

			/*
			 * ��ȡxml��Ӧ����
			 */
			TypedArray a = c.obtainStyledAttributes(attrs,
					R.styleable.SquareLayout);
			mGravity = a.getInt(R.styleable.SquareLayout_my_gravity, 0);
		}

		
		public LayoutParams(int width, int height)
		{
			super(width, height);
		}
	
	}



}
