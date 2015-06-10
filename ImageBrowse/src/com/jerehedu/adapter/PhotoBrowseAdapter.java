package com.jerehedu.adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jerehedu.cache.FileUtils;
import com.jerehedu.entity.ImageInfo;
import com.jerehedu.imagebrowse.R;
import com.lidroid.xutils.BitmapUtils;

public class PhotoBrowseAdapter extends PagerAdapter {

	private Activity mActivity;
	private List<ImageInfo> imageList;
	private LayoutInflater inflate;
	private BitmapUtils utils;
	
	public PhotoBrowseAdapter(Activity mActivity, List<ImageInfo> imageList) {
		super();
		this.mActivity = mActivity;
		this.imageList = imageList;
		inflate=LayoutInflater.from(mActivity);
		// 获取应用程序最大可用内存
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int cacheSize = maxMemory / 8;
		FileUtils fileUtils=new FileUtils(mActivity, "jereh");
		utils=new BitmapUtils(mActivity,fileUtils.getCacheDir(),cacheSize);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	@Override
	public Object instantiateItem(View container,int position){
	//	((ViewPager)container).addView(imageList.get(position%imageList.size()),0);
		ImageInfo info=imageList.get(position%imageList.size());
		LinearLayout view=(LinearLayout)inflate.inflate(R.layout.phone_item, null);
		((TextView)view.findViewById(R.id.tvTitle)).setText(info.getTitle());
		((TextView)view.findViewById(R.id.tvContent)).setText(info.getContent());
		ImageView img=(ImageView)view.findViewById(R.id.vpImgBrowse);
		img.setTag(info.getUrl());
		//ImageLoadTask task=new ImageLoadTask(img);
		//task.execute(info.getUrl());
		return view;
	}
	@Override
	public void  destroyItem(View container,int position,Object obj){
		//((ViewPager)container).removeView(imageList.get(position%imageList.size()));
	}
	
	class ImageLoadTask extends AsyncTask<String, Void, Bitmap>{
		
	
		private ImageView img;
		
		public ImageLoadTask(ImageView img) {
			this.img=img;
		}
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			img.setImageBitmap(result);
			
		}

	
		
	}

}
