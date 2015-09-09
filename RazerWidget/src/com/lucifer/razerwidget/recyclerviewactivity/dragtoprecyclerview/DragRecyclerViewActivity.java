package com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview;

import java.util.ArrayList;
import java.util.List;
import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerModelManager;
import com.lucifer.razerlib.recyclerview.dragtoprecyclerview.DragTopLayout;
import com.lucifer.razerlib.recyclerview.dragtoprecyclerview.DragTopLayout.PanelListener;
import com.lucifer.razerlib.recyclerview.dragtoprecyclerview.DragTopLayout.PanelState;
import com.lucifer.razerwidget.R;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.GridViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.ListViewRecyclerFragment;
import com.lucifer.razerwidget.recyclerviewactivity.dragtoprecyclerview.fragments.StaggedRecyclerFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;



@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DragRecyclerViewActivity extends FragmentActivity
{
    private DragTopLayout dragLayout;
    
    ImageView image_view;
    
    private ModelPagerAdapter adapter;
    private ViewPager viewPager;
    ArrayList<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    PanelListener panelListener;
    ScaleAnimation scaleAnimation;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_dragrecyclerview);

        dragLayout = (DragTopLayout) findViewById(R.id.drag_layout);
        
        image_view = (ImageView) findViewById(R.id.image_view);
        
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        

        Fragment listViewFragment = new ListViewRecyclerFragment();
        Fragment gridViewFragment = new GridViewRecyclerFragment();
        Fragment recyclerViewFragment = new StaggedRecyclerFragment();
        
        fragments.add(listViewFragment);
        fragments.add(gridViewFragment);
        fragments.add(recyclerViewFragment);
       
        PagerModelManager factory = new PagerModelManager();
        factory.addCommonFragment(fragments);
        adapter = new ModelPagerAdapter(getSupportFragmentManager(), factory);
        viewPager.setAdapter(adapter);
        
        
        
        panelListener = new PanelListener()
		{
			
			@Override
			public void onSliding(float ratio)
			{
				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Ë¢ÐÂÊý¾Ý", 1000).show();
			}
			
			@Override
			public void onRefresh()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPanelStateChanged(PanelState panelState)
			{
				// TODO Auto-generated method stub
//				scaleAnimation.cancel();
			}
		};
		dragLayout.listener(panelListener);
        
    }



}
