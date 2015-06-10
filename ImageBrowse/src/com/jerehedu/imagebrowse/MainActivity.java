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
		ImageInfo img1=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131001_0.jpg","�����й��Ķ���ӣ����ͣ�","2��6�գ����ǰ�ɽ�뵺�����ۣ�������ˬ����ͧ�αȣ���������ɫ�ʸ���ķ��������Ŀ�������ǸմӰ������ȳɹ�ʻ�����ǵ��ַ������ӡ������й��Ķ������Ϊ��֧���������ϵ��й�����������һ�������״ζ�ڣ��ܻ���������һ����־���й�����ʽ�������绷�򷫴��˶�֮�С�");
		ImageInfo img2=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131432_0.jpg","�����ַ�������֮��","2��6�գ����ǰ�ɽ�뵺�����ۣ�������ˬ����ͧ�αȣ���������ɫ�ʸ���ķ��������Ŀ�������ǸմӰ������ȳɹ�ʻ�����ǵ��ַ������ӡ������й��Ķ������Ϊ��֧���������ϵ��й�����������һ�������״ζ�ڣ��ܻ���������һ����־���й�����ʽ�������绷�򷫴��˶�֮�С�");
		ImageInfo img3=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131157_0.jpg","�ֶ��ּ����ܲü���ϯִ�й�ŷ�޷���ɭ���ֶ��ּ����й��ܲó�Ȼ�������´�","��2��6�գ����ǰ�ɽ�뵺�����ۣ�������ˬ����ͧ�αȣ���������ɫ�ʸ���ķ��������Ŀ�������ǸմӰ������ȳɹ�ʻ�����ǵ��ַ������ӡ������й��Ķ������Ϊ��֧���������ϵ��й�����������һ�������״ζ�ڣ��ܻ���������һ����־���й�����ʽ�������绷�򷫴��˶�֮�С�");
		ImageInfo img4=new ImageInfo("http://news.21-sun.com/UserFiles/x_Image/x_20150216131111_0.jpg","��װ������������һ���Σ�","2��6�գ����ǰ�ɽ�뵺�����ۣ�������ˬ����ͧ�αȣ���������ɫ�ʸ���ķ��������Ŀ�������ǸմӰ������ȳɹ�ʻ�����ǵ��ַ������ӡ������й��Ķ������Ϊ��֧���������ϵ��й�����������һ�������״ζ�ڣ��ܻ���������һ����־���й�����ʽ�������绷�򷫴��˶�֮�С�");
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