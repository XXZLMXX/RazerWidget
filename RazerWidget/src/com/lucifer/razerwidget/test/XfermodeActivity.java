package com.lucifer.razerwidget.test;

import com.lucifer.razerlib.test.Xfermode.AnimListView;
import com.lucifer.razerlib.test.Xfermode.BlurMaskFilterView;
import com.lucifer.razerlib.test.Xfermode.BrickView;
import com.lucifer.razerlib.test.Xfermode.DisInView;
import com.lucifer.razerlib.test.Xfermode.DisOutView;
import com.lucifer.razerlib.test.Xfermode.DreamEffectView;
import com.lucifer.razerlib.test.Xfermode.ECGView;
import com.lucifer.razerlib.test.Xfermode.EmbossMaskFilterView;
import com.lucifer.razerlib.test.Xfermode.EraserView;
import com.lucifer.razerlib.test.Xfermode.FontView;
import com.lucifer.razerlib.test.Xfermode.MatrixImageView;
import com.lucifer.razerlib.test.Xfermode.MatrixView;
import com.lucifer.razerlib.test.Xfermode.MultiCricleView;
import com.lucifer.razerlib.test.Xfermode.PathEffectView;
import com.lucifer.razerlib.test.Xfermode.PorterDuffView;
import com.lucifer.razerlib.test.Xfermode.ReflectView;
import com.lucifer.razerlib.test.Xfermode.ScreenView;
import com.lucifer.razerlib.test.Xfermode.ShaderView;
import com.lucifer.razerlib.test.Xfermode.ShadowView;
import com.lucifer.razerlib.test.Xfermode.StaticLayoutView;
import com.lucifer.razerlib.test.Xfermode.XfermodeView;
import com.lucifer.razerwidget.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;



public class XfermodeActivity extends Activity
{
	AnimListView alv_xfermode;
	BlurMaskFilterView bmfv_xfermode;
	BrickView bv_xfermode;
	
	DisInView div_xfermode;
	DisOutView dov_xfermode;
	DreamEffectView dev_xfermode;
	
	ECGView ecgv_xfermode;
	EmbossMaskFilterView emfv_xfermode;
	EraserView ev_xfermode;
	
	FontView fv_xfermode;
	
	MatrixImageView miv_xfermode;
	MatrixView mv_xfermode;
	MultiCricleView mcv_xfermode;
	
	PathEffectView pev_xfermode;
	PorterDuffView pdv_xfermode;
	
	ReflectView rv_xfermode;
	ScreenView sv_xfermode;
	ShaderView sdv_xfermode;
	ShadowView sdwv_xfermode;
	StaticLayoutView slv_xfermode;
	XfermodeView xfv_xfermode;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty_xfermode);
		
		
		alv_xfermode = (AnimListView) findViewById(R.id.alv_xfermode);
		bmfv_xfermode = (BlurMaskFilterView) findViewById(R.id.bmfv_xfermode);
		bv_xfermode = (BrickView) findViewById(R.id.bv_xfermode);
		
		div_xfermode = (DisInView) findViewById(R.id.div_xfermode);
		dov_xfermode = (DisOutView) findViewById(R.id.dov_xfermode);
		dev_xfermode = (DreamEffectView) findViewById(R.id.dev_xfermode);
		
		ecgv_xfermode = (ECGView) findViewById(R.id.ecgv_xfermode);
		emfv_xfermode = (EmbossMaskFilterView) findViewById(R.id.emfv_xfermode);
		ev_xfermode = (EraserView) findViewById(R.id.ev_xfermode);
		
		fv_xfermode = (FontView) findViewById(R.id.fv_xfermode);
		
		miv_xfermode = (MatrixImageView) findViewById(R.id.miv_xfermode);
		mv_xfermode = (MatrixView) findViewById(R.id.mv_xfermode);
		mcv_xfermode = (MultiCricleView) findViewById(R.id.mcv_xfermode);
		
		pev_xfermode = (PathEffectView) findViewById(R.id.pev_xfermode);
		pdv_xfermode = (PorterDuffView) findViewById(R.id.pdv_xfermode);
		
		rv_xfermode = (ReflectView) findViewById(R.id.rv_xfermode);
		sv_xfermode = (ScreenView) findViewById(R.id.sv_xfermode);
		sdv_xfermode = (ShaderView) findViewById(R.id.sdv_xfermode);
		sdwv_xfermode = (ShadowView) findViewById(R.id.sdwv_xfermode);
		slv_xfermode = (StaticLayoutView) findViewById(R.id.slv_xfermode);
		xfv_xfermode = (XfermodeView) findViewById(R.id.xfv_xfermode);
		
		
	}
	
	
	
	private void switchMode(int i)
	{
		switch (i)
		{
		case 0:
			alv_xfermode.setVisibility(View.VISIBLE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 1:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.VISIBLE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
					
		case 2:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.VISIBLE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 3:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.VISIBLE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);			
			break;
			
		case 4:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.VISIBLE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 5:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.VISIBLE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 6:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.VISIBLE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 7:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.VISIBLE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 8:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.VISIBLE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 9:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.VISIBLE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 10:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.VISIBLE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 11:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.VISIBLE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 12:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.VISIBLE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 13:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.VISIBLE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 14:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.VISIBLE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 15:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.VISIBLE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 16:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.VISIBLE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 17:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.VISIBLE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 18:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.VISIBLE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 19:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.VISIBLE);
			xfv_xfermode.setVisibility(View.GONE);
			break;
			
		case 20:
			alv_xfermode.setVisibility(View.GONE);
			bmfv_xfermode.setVisibility(View.GONE);
			bv_xfermode.setVisibility(View.GONE);
			
			div_xfermode.setVisibility(View.GONE);
			dov_xfermode.setVisibility(View.GONE);
			dev_xfermode.setVisibility(View.GONE);
			
			ecgv_xfermode.setVisibility(View.GONE);
			emfv_xfermode.setVisibility(View.GONE);
			ev_xfermode.setVisibility(View.GONE);
			
			fv_xfermode.setVisibility(View.GONE);
			
			miv_xfermode.setVisibility(View.GONE);
			mv_xfermode.setVisibility(View.GONE);
			mcv_xfermode.setVisibility(View.GONE);
			
			pev_xfermode.setVisibility(View.GONE);
			pdv_xfermode.setVisibility(View.GONE);
			
			rv_xfermode.setVisibility(View.GONE);
			sv_xfermode.setVisibility(View.GONE);
			sdv_xfermode.setVisibility(View.GONE);
			sdwv_xfermode.setVisibility(View.GONE);
			slv_xfermode.setVisibility(View.GONE);
			xfv_xfermode.setVisibility(View.VISIBLE);
			break;
			
		default:
			break;
		}
	}
	
	
}
