package com.lucifer.razerwidget.satelliteactivity;

import com.lucifer.razerlib.satellitemenu.ArcMenu;
import com.lucifer.razerlib.satellitemenu.RayMenu;
import com.lucifer.razerwidget.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;



public class SatelliteActivity extends Activity
{
	private static final int[] ITEM_DRAWABLES =
		{ R.drawable.composer_camera, R.drawable.composer_music,
				R.drawable.composer_place, R.drawable.composer_sleep,
				R.drawable.composer_thought, R.drawable.composer_with };
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/*setContentView(R.layout.aty_satellite);
		
		ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arc_menu);
		ArcMenu arcMenu2 = (ArcMenu) findViewById(R.id.arc_menu_2);

		initArcMenu(arcMenu, ITEM_DRAWABLES);
		initArcMenu(arcMenu2, ITEM_DRAWABLES);

		RayMenu rayMenu = (RayMenu) findViewById(R.id.ray_menu);
		final int itemCount = ITEM_DRAWABLES.length;
		for (int i = 0; i < itemCount; i++)
		{
			ImageView item = new ImageView(this);
			item.setImageResource(ITEM_DRAWABLES[i]);

			final int position = i;
			rayMenu.addItem(item, new OnClickListener()
			{

				@Override
				public void onClick(View v)
				{
					Toast.makeText(SatelliteActivity.this, "position:" + position,
							Toast.LENGTH_SHORT).show();
				}
			});// Add a menu item
		}*/
		
	}
	
	
	private void initArcMenu(ArcMenu menu, int[] itemDrawables)
	{
		final int itemCount = itemDrawables.length;
		for (int i = 0; i < itemCount; i++)
		{
			ImageView item = new ImageView(this);
			item.setImageResource(itemDrawables[i]);

			final int position = i;
			menu.addItem(item, new OnClickListener()
			{

				@Override
				public void onClick(View v)
				{
					Toast.makeText(SatelliteActivity.this, "position:" + position,
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
	
	

}
