package com.jerehedu.imagebrowse;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.jerehedu.adapter.PhotoBrowseAdapter;
import com.jerehedu.entity.ImageInfo;

public class MainActivity extends Activity {
 
	private ViewPager vpImagePager;
	private PhotoBrowseAdapter adapter;
	private List<ImageInfo> viewList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vpImagePager=(ViewPager)super.findViewById(R.id.vpImgBrowse);
		viewList=new ArrayList<ImageInfo>();
		adapter=new PhotoBrowseAdapter(this,viewList);
		vpImagePager.setAdapter(adapter);
		PhotoBrowseTask task=new PhotoBrowseTask();
		task.execute("");
		
	} 
	

	private void loadData(){
		ImageInfo img1=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131001_0.jpg","代表中国的东风队，加油！","2月6日，三亚半山半岛帆船港，海风清爽、船艇栉比，其中六艘色彩各异的帆船格外夺目。他们是刚从阿布扎比成功驶到三亚的沃帆赛船队。来自中国的东风队作为首支真正意义上的中国参赛队在这一赛段中首次夺冠，总积分排名第一，标志着中国队正式跻身世界环球帆船运动之列。");
		ImageInfo img2=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131432_0.jpg","三亚沃帆赛体验之旅","2月6日，三亚半山半岛帆船港，海风清爽、船艇栉比，其中六艘色彩各异的帆船格外夺目。他们是刚从阿布扎比成功驶到三亚的沃帆赛船队。来自中国的东风队作为首支真正意义上的中国参赛队在这一赛段中首次夺冠，总积分排名第一，标志着中国队正式跻身世界环球帆船运动之列。");
		ImageInfo img3=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131157_0.jpg","沃尔沃集团总裁兼首席执行官欧罗夫·佩森与沃尔沃集团中国总裁陈然峰晚宴致辞","　2月6日，三亚半山半岛帆船港，海风清爽、船艇栉比，其中六艘色彩各异的帆船格外夺目。他们是刚从阿布扎比成功驶到三亚的沃帆赛船队。来自中国的东风队作为首支真正意义上的中国参赛队在这一赛段中首次夺冠，总积分排名第一，标志着中国队正式跻身世界环球帆船运动之列。");
		ImageInfo img4=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131111_0.jpg","整装待发，奔赴下一赛段！","2月6日，三亚半山半岛帆船港，海风清爽、船艇栉比，其中六艘色彩各异的帆船格外夺目。他们是刚从阿布扎比成功驶到三亚的沃帆赛船队。来自中国的东风队作为首支真正意义上的中国参赛队在这一赛段中首次夺冠，总积分排名第一，标志着中国队正式跻身世界环球帆船运动之列。");
		viewList.add(img1);
		viewList.add(img2);
	}
	
	
	class PhotoBrowseTask extends AsyncTask<String, Void, Integer>{

		@Override
		protected Integer doInBackground(String... params) {
			// TODO Auto-generated method stub
			loadData();
			return 1;
			
		}
		@Override
		protected void onPostExecute(Integer i){
			adapter.notifyDataSetChanged();
		}
		
		
	}
	
	


}
