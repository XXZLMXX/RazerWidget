package com.lucifer.razerlib.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class VerticalLinearLayout extends ViewGroup
{

	int mScreenWidth;
	int mScreenHeight;

	/**
	 * @param context
	 */
	public VerticalLinearLayout(Context context)
	{
		this(context, null, 0);
	}

	
	/**
	 * @param context
	 * @param attrs
	 */
	public VerticalLinearLayout(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	
	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public VerticalLinearLayout(Context context, AttributeSet attrs,
			int defStyle)
	{
		super(context, attrs, defStyle);

		mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
		mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
	}

	
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{

		//
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		//
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

		int width = 0;
		int height = 0;
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++)
		{
			View child = getChildAt(i);
			if (child.getVisibility() != View.GONE)
			{
				// 丈量child的尺寸
				measureChildWithMargins(child, widthMeasureSpec, 0,
						heightMeasureSpec, 0);
				// 这里的LayoutParams就是我们自定义的LayoutParams
				LayoutParams layoutParams = (LayoutParams) child
						.getLayoutParams();
				if (widthSpecMode == MeasureSpec.AT_MOST)
				{
					width = Math.max(width, child.getMeasuredWidth()
							+ layoutParams.leftMargin
							+ layoutParams.rightMargin);
				}
				//
				height += child.getMeasuredHeight() + layoutParams.topMargin
						+ layoutParams.bottomMargin;
			}
		}

		width += getPaddingLeft() + getPaddingRight();
		height += getPaddingBottom() + getPaddingTop();

		width = Math.min(width, mScreenWidth);
		height = Math.min(height, mScreenHeight);

		// 如果都是宽高设置为wrap_content，那么都使用文本的宽高
		if (widthSpecMode == MeasureSpec.AT_MOST
				&& heightSpecMode == MeasureSpec.AT_MOST)
		{
			setMeasuredDimension(width, height);
		} else if (widthSpecMode == MeasureSpec.AT_MOST)
		{
			// 如果只是宽度是wrap_content，那么宽度使用文本的宽度，高度使用widthMeasureSpec中的高度
			setMeasuredDimension(width, heightSpecSize);
		} else if (heightSpecMode == MeasureSpec.AT_MOST)
		{
			// 如果只是高度是wrap_content，那么高度使用文本的高度，宽度使用heightMeasureSpec中的宽度
			setMeasuredDimension(widthSpecSize, height);
		}

	}

	
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		int left = getPaddingLeft();
		int top = getPaddingTop();

		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++)
		{
			View childView = getChildAt(i);
			if (childView.getVisibility() != View.GONE)
			{
				// 对child进行布局
				childView.layout(left, top,
						left + childView.getMeasuredWidth(),
						top + childView.getMeasuredHeight());
				// 下一次的top为这次的top 加上 当前childView的高度， 因此下一个child会放到这个child的下面.
				top += childView.getMeasuredHeight();
			}
		}
	}

	
	
	/**
	 * 注意覆写这几个方法，否则在进行measureChildWithMargins或者将child的LayoutParams进行转换时会出现转换异常
	 */
	@Override
	protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
	{
		return new VerticalLinearLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
	}

	
	
	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(
			AttributeSet attrs)
	{
		return new VerticalLinearLayout.LayoutParams(getContext(), attrs);
	}

	
	
	@Override
	protected android.view.ViewGroup.LayoutParams generateLayoutParams(
			android.view.ViewGroup.LayoutParams p)
	{
		return new VerticalLinearLayout.LayoutParams(p);
	}

	
	
	/**
	 * 自定义LayoutParams，从而使你的Layout支持Margin等
	 * 
	 * @author mrsimple
	 */
	public static class LayoutParams extends ViewGroup.MarginLayoutParams
	{

		public LayoutParams(Context c, AttributeSet attrs)
		{
			super(c, attrs);
		}

		public LayoutParams(int width, int height)
		{
			super(width, height);
		}

		/**
		 * Copy constructor. Clones the width, height and margin values of the
		 * source.
		 * 
		 * @param source
		 *            The layout params to copy from.
		 */
		public LayoutParams(MarginLayoutParams source)
		{
			super(source);
		}

		public LayoutParams(ViewGroup.LayoutParams p)
		{
			super(p);
		}
	}

	
	
}
