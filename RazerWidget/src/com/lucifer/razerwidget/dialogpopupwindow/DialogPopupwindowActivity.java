package com.lucifer.razerwidget.dialogpopupwindow;import com.lucifer.razerwidget.R;import android.app.Activity;import android.app.Dialog;import android.content.Context;import android.content.DialogInterface;import android.content.Intent;import android.os.Bundle;import android.view.View;import android.view.View.OnClickListener;import android.widget.Button;import android.widget.Toast;/** * Dialog、AlertDialog、PopupWindow、Toast区别： * Dialog: * AlertDialog:非阻塞式对话框，弹出时后台可以做事情；弹出时背景是黑色的，点击背景AlertDialog会消失，说明 * 程序不仅响应AlertDialog操作，也响应其他操作； * PopupWindow:阻塞式对话框，弹出时程序只能等待，只有调用了dismiss后popupwindow退出程序才会继续执行； * 弹出时背景没有变化，点击背景时候程序没有响应 * Toast: */public class DialogPopupwindowActivity extends Activity implements OnClickListener{	Button btn_dialog, btn_popupwindow;		Dialog dialog;			@Override	protected void onCreate(Bundle savedInstanceState)	{		// TODO Auto-generated method stub		super.onCreate(savedInstanceState);		setContentView(R.layout.aty_dialog);				btn_dialog = (Button) findViewById(R.id.btn_dialog);		btn_popupwindow = (Button) findViewById(R.id.btn_popupwindow);				btn_dialog.setOnClickListener(this);		btn_popupwindow.setOnClickListener(this);	}	@Override	public void onClick(View arg0)	{		// TODO Auto-generated method stub		switch (arg0.getId())		{		case R.id.btn_dialog:			showDialog(DialogPopupwindowActivity.this);			break;							case R.id.btn_popupwindow:			SelectPopupWindow.showPopupWindow(DialogPopupwindowActivity.this, arg0);			break;		default:			break;		}	}				public void showDialog(Context context)	{		if (dialog == null)		{			dialog = AllDialog.createLoadingDialog(context, "正在加载中...");			dialog.show();		}	}			public void closeDialog()	{		if (dialog != null)		{			if(dialog.isShowing())			{				dialog.dismiss();				dialog = null;			}					}	}			}