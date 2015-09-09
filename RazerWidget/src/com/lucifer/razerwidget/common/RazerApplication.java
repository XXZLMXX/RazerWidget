package com.lucifer.razerwidget.common;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;



public class RazerApplication extends Application
{

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		
		initImageLoader(getApplicationContext());
		
	}
	
	
	
	@SuppressLint("NewApi")
	public void initImageLoader(Context context)
	{
		File cacheDir = StorageUtils.getCacheDirectory(context);
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
        .memoryCacheExtraOptions(600, 800)
        .discCacheExtraOptions(600, 800, CompressFormat.JPEG, 75, null)
        .taskExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        .taskExecutorForCachedImages(AsyncTask.THREAD_POOL_EXECUTOR)
        .threadPoolSize(3).threadPriority(Thread.NORM_PRIORITY - 1).tasksProcessingOrder(QueueProcessingType.FIFO)
        .denyCacheImageMultipleSizesInMemory().memoryCache(new LruMemoryCache(2 * 1024 * 1024))
        .memoryCacheSize(1 * 1024 * 1024).discCache(new UnlimitedDiscCache(cacheDir))
        .discCacheSize(10 * 1024 * 1024).discCacheFileCount(500)
        .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
        .imageDownloader(new BaseImageDownloader(context,5 * 1000, 30 * 1000)) 
        .imageDecoder(new BaseImageDecoder(true)) 
        .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) 
        .writeDebugLogs().build();
		
		ImageLoader.getInstance().init(config);

	}
	
	
	
}
