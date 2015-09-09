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
	private static final int ORIENTATION_HORIZONTAL = 0,
			ORIENTATION_VERTICAL = 1;// ���з���ĳ�����ʶֵ
	private static final int DEFAULT_MAX_ROW = Integer.MAX_VALUE,
			DEFAULT_MAX_COLUMN = Integer.MAX_VALUE;// �������Ĭ��ֵ

	private int mMaxRow = DEFAULT_MAX_ROW;// �������
	private int mMaxColumn = DEFAULT_MAX_COLUMN;// �������

	private int mOrientation = ORIENTATION_VERTICAL;// ���з���Ĭ�Ϻ���

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
		 * ������ʱ�����洢������������ֵ
		 * ��ֵӦ�õ��ڸ��������ڱ߾����������Ԫ�صĲ�����ߺ���߾�
		 */
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;

		// ������ʱ�����洢��Ԫ�صĲ���״̬
		int childMeasureState = 0;

		/*
		 * �������������Ԫ��
		 */
		if (getChildCount() > 0)
		{
			// ��������һά����洢��Ԫ�ؿ�����
			int[] childWidths = new int[getChildCount()];
			int[] childHeights = new int[getChildCount()];

			/*
			 * ��ô�ͱ�����Ԫ��
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

					// ������Ԫ�ز���������߾�
					measureChildWithMargins(child, widthMeasureSpec, 0,
							heightMeasureSpec, 0);

					// �Ƚ���Ԫ�ز�����߲��Ƚ�ȡ��ϴ�ֵ
					int childMeasureSize = Math.max(child.getMeasuredWidth(),
							child.getMeasuredHeight());

					// ���·�װ��Ԫ�ز������
					int childMeasureSpec = MeasureSpec.makeMeasureSpec(
							childMeasureSize, MeasureSpec.EXACTLY);

					// ���²�����Ԫ��
					child.measure(childMeasureSpec, childMeasureSpec);

					// ��ȡ��Ԫ�ز��ֲ���
					MarginLayoutParams mlp = (MarginLayoutParams) child
							.getLayoutParams();

					/*
					 * ������߾������Ԫ��ʵ�ʿ�߲�����ݴ�������
					 */
					childWidths[i] = child.getMeasuredWidth() + mlp.leftMargin
							+ mlp.rightMargin;
					childHeights[i] = child.getMeasuredHeight() + mlp.topMargin
							+ mlp.bottomMargin;

					// �ϲ���Ԫ�صĲ���״̬
					childMeasureState = combineMeasuredStates(
							childMeasureState, child.getMeasuredState());
				}
			}

			// ������ʱ�����洢��/�п��
			int indexMultiWidth = 0, indexMultiHeight = 0;

			/*
			 * ���Ϊ��������
			 */
			if (mOrientation == ORIENTATION_HORIZONTAL)
			{
				/*
				 * �����Ԫ�����������޶�ֵ��������м���
				 */
				if (getChildCount() > mMaxColumn)
				{

					// ������������
					int row = getChildCount() / mMaxColumn;

					// ��������
					int remainder = getChildCount() % mMaxColumn;

					// ������ʱ�����洢��Ԫ�ؿ�������±�ֵ
					int index = 0;

					/*
					 * ����������㸸����������ֵ
					 */
					for (int x = 0; x < row; x++)
					{
						for (int y = 0; y < mMaxColumn; y++)
						{
							// ���п���ۼ�
							indexMultiWidth += childWidths[index];

							// ���и߶�ȡ���ֵ
							indexMultiHeight = Math.max(indexMultiHeight,
									childHeights[index++]);
						}
						// ÿһ�б�����󽫸��п������һ�п�ȱȽ�ȡ���ֵ
						parentDesireWidth = Math.max(parentDesireWidth,
								indexMultiWidth);

						// ÿһ�б�������ۼӸ��и߶�
						parentDesireHeight += indexMultiHeight;

						// ���ò���
						indexMultiWidth = indexMultiHeight = 0;
					}

					/*
					 * ����������ʾ����Ԫ��δ��ռ��һ��
					 */
					if (remainder != 0)
					{
						/*
						 * ����ʣ�µ���Щ��Ԫ�ؽ����߼��㵽����������ֵ
						 */
						for (int i = getChildCount() - remainder; i < getChildCount(); i++)
						{
							indexMultiWidth += childWidths[i];
							indexMultiHeight = Math.max(indexMultiHeight,
									childHeights[i]);
						}
						parentDesireWidth = Math.max(parentDesireWidth,
								indexMultiWidth);
						parentDesireHeight += indexMultiHeight;
						indexMultiWidth = indexMultiHeight = 0;
					}
				}

				/*
				 * �����Ԫ��������û������ֵ����ôֱ�Ӽ��㼴�ɲ�������
				 */
				else
				{
					for (int i = 0; i < getChildCount(); i++)
					{
						// �ۼ���Ԫ�ص�ʵ�ʸ߶�
						parentDesireHeight += childHeights[i];

						// ��ȡ��Ԫ���п�����ֵ
						parentDesireWidth = Math.max(parentDesireWidth,
								childWidths[i]);
					}
				}
			}

			/*
			 * ���Ϊ��������
			 */
			else if (mOrientation == ORIENTATION_VERTICAL)
			{
				if (getChildCount() > mMaxRow)
				{
					int column = getChildCount() / mMaxRow;
					int remainder = getChildCount() % mMaxRow;
					int index = 0;

					for (int x = 0; x < column; x++)
					{
						for (int y = 0; y < mMaxRow; y++)
						{
							indexMultiHeight += childHeights[index];
							indexMultiWidth = Math.max(indexMultiWidth,
									childWidths[index++]);
						}
						parentDesireHeight = Math.max(parentDesireHeight,
								indexMultiHeight);
						parentDesireWidth += indexMultiWidth;
						indexMultiWidth = indexMultiHeight = 0;
					}

					if (remainder != 0)
					{
						for (int i = getChildCount() - remainder; i < getChildCount(); i++)
						{
							indexMultiHeight += childHeights[i];
							indexMultiWidth = Math.max(indexMultiHeight,
									childWidths[i]);
						}
						parentDesireHeight = Math.max(parentDesireHeight,
								indexMultiHeight);
						parentDesireWidth += indexMultiWidth;
						indexMultiWidth = indexMultiHeight = 0;
					}
				} else
				{
					for (int i = 0; i < getChildCount(); i++)
					{
						// �ۼ���Ԫ�ص�ʵ�ʿ��
						parentDesireWidth += childWidths[i];

						// ��ȡ��Ԫ���и߶����ֵ
						parentDesireHeight = Math.max(parentDesireHeight,
								childHeights[i]);
					}
				}
			}

			/*
			 * �����������ڱ߾ཫ���ۼӵ�����ֵ
			 */
			parentDesireWidth += getPaddingLeft() + getPaddingRight();
			parentDesireHeight += getPaddingTop() + getPaddingBottom();

			/*
			 * ���ԱȽϸ���������ֵ��Android�������Сֵ��С��ȡ�ϴ�ֵ
			 */
			parentDesireWidth = Math.max(parentDesireWidth,
					getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight,
					getSuggestedMinimumHeight());
		}

		// ȷ���������Ĳ������
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
