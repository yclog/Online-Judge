package com.graduation.appletree.onlinejudge.application.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;

import com.graduation.appletree.onlinejudge.application.DemoApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomCrashHandler implements Thread.UncaughtExceptionHandler{

    private Context mContext;
    private static CustomCrashHandler mCustomCrashHandlerInstance = new CustomCrashHandler();
    private static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().toString();

    public static CustomCrashHandler getInstance() {
        return mCustomCrashHandlerInstance;
    }

    public CustomCrashHandler() {
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        saveInfoToSD(mContext,ex);

        showToast(mContext,"很抱歉，程序遭遇异常，即将退出！");
        try {
            thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        DemoApplication.getInstance().exitApplication();
    }

    public void setCustomCrashHandler(Context context){
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void showToast(final Context context , final String msg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        });
    }

    private HashMap<String,String> obtainSimpleInfo(Context context){
        HashMap<String,String> map = new HashMap<String,String>();
        PackageManager mPackageManager = context.getPackageManager();
        PackageInfo mPackageInfo = null;

        try {
            mPackageInfo = mPackageManager.getPackageInfo(context.getPackageName(),PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        map.put("versionName",mPackageInfo.versionName);
        map.put("versionCode",mPackageInfo.versionCode+"");
        map.put("MODEL", Build.MODEL);
        map.put("SDK_INT",Build.VERSION.SDK_INT+"");
        map.put("PRODUCT",Build.PRODUCT);

        return map;
    }

    public String obtainExceptionInfo(Throwable throwable){
        StringWriter mStringWriter = new StringWriter();
        PrintWriter mPrintWriter = new PrintWriter(mStringWriter);
        throwable.printStackTrace(mPrintWriter);
        mPrintWriter.close();

        return mStringWriter.toString();
    }

    private String saveInfoToSD(Context context,Throwable ex){
        String filename = null;
        StringBuffer sb = new StringBuffer();

        for (Map.Entry<String,String> entry: obtainSimpleInfo(context).entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append(" = ").append(value).append("\n");
        }

        sb.append(obtainExceptionInfo(ex));

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File dir = new File(SDCARD_ROOT + File.separator);
            if (!dir.exists()){
                dir.mkdir();
            }

            try {
                filename = dir.toString() + File.separator + "crash"+".log";
                FileOutputStream fos = new FileOutputStream(filename);
                fos.write(sb.toString().getBytes());
                fos.flush();
                fos.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return filename;
    }

}
