package com.jerehedu.cache;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.content.Context;
/**
 * ͼƬ�ļ�����
 * 
 *
 */
public class FileUtils {
    
	/** �����ļ�Ŀ¼ */
    private File mCacheDir;
    
    /**
     * ���������ļ�Ŀ¼�������SD������ʹ��SD�����û����ʹ��ϵͳ�Դ�����Ŀ¼
     * 
     * @param context
     * @param cacheDir ͼƬ�����һ��Ŀ¼
     * @param dir
     */
    public FileUtils(Context context, String cacheDir){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            mCacheDir = new File(cacheDir);
        else
            mCacheDir = context.getCacheDir();// ��λ�ȡϵͳ���õĻ���洢·��
        if(!mCacheDir.exists())
            mCacheDir.mkdirs();
    }
    
    public String getCacheDir(){
    	return mCacheDir.getAbsolutePath();
        
    }
    
  
}