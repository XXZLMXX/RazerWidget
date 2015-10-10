package com.lucifer.razerwidget.scrolllistgridviewactivity.multifragmentsview;

import java.util.ArrayList;
import com.lucifer.razerlib.scrolllistgridview.PhotoWallScrollView;
import com.lucifer.razerwidget.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;



public class PhotoWallFragment extends Fragment
{
	View view;
	PhotoWallScrollView pwsv_photowall;
	ArrayList<String> urls = new ArrayList<String>();
	String url = "http://img1.imgtn.bdimg.com/it/u=4267403590,1425949555&fm=21&gp=0.jpg";
	
	

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.aty_photowall, null);
		pwsv_photowall = (PhotoWallScrollView) view.findViewById(R.id.pwsv_photowall);
		
		pwsv_photowall.setColumnCount(3);
		pwsv_photowall.setPageCount(15);
		pwsv_photowall.setItemOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				int currentPosition = pwsv_photowall.getCurrentPosition();
				Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
				intent.putExtra("position", currentPosition);
				intent.putStringArrayListExtra("list", urls);
				startActivity(intent);
			}
		});

		for(int i=0; i<30; i++)
		{
			urls.add(url);
		}
		pwsv_photowall.setUrlList(urls);
		
		
		return view;
	}
	
}
