package com.lucifer.razerwidget.broadcastreceiver;import com.lucifer.razerlib.utils.NetUtils;import com.lucifer.razerlib.utils.NotificationUtil;import com.lucifer.razerwidget.MainActivity;import com.lucifer.razerwidget.R;import android.content.BroadcastReceiver;import android.content.Context;import android.content.Intent;import android.widget.RemoteViews;public class NetChangeReceiver extends BroadcastReceiver{	private static final String netACTION = "android.net.conn.CONNECTIVITY_CHANGE";	NotificationUtil notificationUtil;			@Override	public void onReceive(Context context, Intent intent)	{		// TODO Auto-generated method stub		if (intent.getAction().equals(netACTION))		{			notificationUtil = new NotificationUtil(context, 200);						Boolean isConnected = NetUtils.isConnected(context);			if(isConnected)			{				Intent clickIntent = new Intent(context, MainActivity.class);								/*RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);				remoteViews.setImageViewResource(R.id.image, R.drawable.ic_launcher);				remoteViews.setTextViewText(R.id.title, "自定义通知视图");				remoteViews.setTextViewText(R.id.text, "这个自定义通知栏只能这么高了，不能有再多的内容了");*/								notificationUtil.setSmallIcon(R.drawable.ic_launcher)				.setTickerText("notification util")				.setContentTitle("lucifer")				.setContentText("Are you ok, 3q very much")				.setClickIntent(clickIntent)				.sentNotification();			}			else 			{				Intent clickIntent = new Intent(context, MainActivity.class);								/*RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);				remoteViews.setImageViewResource(R.id.image, R.drawable.ic_launcher);				remoteViews.setTextViewText(R.id.title, "自定义通知视图");				remoteViews.setTextViewText(R.id.text, "这个自定义通知栏只能这么高了，不能有再多的内容了");*/								notificationUtil.setSmallIcon(R.drawable.ic_launcher)				.setTickerText("notification util")				.setContentTitle("lucifer")				.setContentText("Are you ok, 3q very much")				.setClickIntent(clickIntent)				.sentNotification();			}					}	}}