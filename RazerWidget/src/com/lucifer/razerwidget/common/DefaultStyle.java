package com.lucifer.razerwidget.common;

public class DefaultStyle
{
	 /*Android平台定义的主题样式：

	 android:theme="@android:style/Theme.Dialog"   将一个Activity显示为对话框模式
	 •android:theme="@android:style/Theme.NoTitleBar"  不显示应用程序标题栏
	 •android:theme="@android:style/Theme.NoTitleBar.Fullscreen"  不显示应用程序标题栏，并全屏
	 •android:theme="@android:style/Theme.Light"  背景为白色
	 •android:theme="@android:style/Theme.Light.NoTitleBar"  白色背景并无标题栏
	 •android:theme="@android:style/Theme.Light.NoTitleBar.Fullscreen"  白色背景，无标题栏，全屏
	 •android:theme="@android:style/Theme.Black"  背景黑色
	 •android:theme="@android:style/Theme.Black.NoTitleBar"  黑色背景并无标题栏
	 •android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen"    黑色背景，无标题栏，全屏
	 •android:theme="@android:style/Theme.Wallpaper"  用系统桌面为应用程序背景
	 •android:theme="@android:style/Theme.Wallpaper.NoTitleBar"  用系统桌面为应用程序背景，且无标题栏
	 •android:theme="@android:style/Theme.Wallpaper.NoTitleBar.Fullscreen"  用系统桌面为应用程序背景，无标题栏，全屏
	 •android:theme="@android:style/Translucent" 半透明效果
	 •android:theme="@android:style/Theme.Translucent.NoTitleBar"  半透明并无标题栏
	 •android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen"  半透明效果，无标题栏，全屏
	 •android:theme="@android:style/Theme.Panel"

	 Android平台定义了三种字体大小：

	 "?android:attr/textAppearanceLarge"
	 "?android:attr/textAppearanceMedium"
	 "?android:attr/textAppearanceSmall"

	 Android字体颜色：

	 android:textColor="?android:attr/textColorPrimary"
	 android:textColor="?android:attr/textColorSecondary"
	 android:textColor="?android:attr/textColorTertiary"
	 android:textColor="?android:attr/textColorPrimaryInverse"
	 android:textColor="?android:attr/textColorSecondaryInverse"

	 Android的ProgressBar样式：

	 style="?android:attr/progressBarStyleHorizontal"
	 style="?android:attr/progressBarStyleLarge"
	 style="?android:attr/progressBarStyleSmall"
	 style="?android:attr/progressBarStyleSmallTitle"

	 分隔符

	 横向： <View
	 android:layout_width="fill_parent"
	 android:layout_height="1dip"
	 android:background="?android:attr/listDivider" />
	 纵向： <View android:layout_width="1dip"
	 android:layout_height="fill_parent"
	 android:background="?android:attr/listDivider" /

	 CheckBox样式  

	 style="?android:attr/starStyle"


	 类似标题栏效果的TextView
	 style="?android:attr/listSeparatorTextViewStyle"

	 其它有用的样式
	 android:layout_height="?android:attr/listPreferredItemHeight"
	 android:paddingRight="?android:attr/scrollbarSize"
	 style="?android:attr/windowTitleBackgroundStyle"
	 style="?android:attr/windowTitleStyle"
	 android:layout_height="?android:attr/windowTitleSize"
	 android:background="?android:attr/windowBackground"

	  

	 修改Activity的标题栏样式

	 如在styles.xml中增加
	 <resources> 
	     <style name="AutoWindowTitleBackground"> 
	         <item name="android:background">#778899</item> 
	     </style> 
	     <style name="autoWindowTitlebar" parent="android:Theme"> 
	         <item name="android:windowTitleSize">32dp</item>
	         <item name="android:windowTitleBackgroundStyle">@style/AutoWindowTitleBackground</item>
	     </style> 
	 </resources>
	 接着再修改AndroidManifest.xml文件，找到要自定义标题栏的Activity，添加上android:theme值，比如：
	 <activity android:name=".MainActivity" android:theme="@style/autoWindowTitlebar">

	  

	 去掉所有Activity界面的标题栏
	 修改AndroidManifest.xml

	 在application 标签中添加android:theme=”@android:style/Theme.NoTitleBar”*/
}
