package com.zht.baseproject;

import android.app.Application;
import android.os.Build;
import android.os.Handler;

import com.zht.baseproject.utils.FileUtils;
import com.zht.baseproject.utils.LogUtils;

/**
 * Created by ZHT on 2017/4/17.
 * 自定义Application
 */

public class App extends Application {

    private static App mContext;

    private static Handler mMainThreadHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        mMainThreadHandler = new Handler();

        //设置是否打印日志
        LogUtils.setIsLog(BuildConfig.LOG_DEBUG);

        //在6.0(M)版本下直接创建应用对应的文件夹
        //在6.0(M)版本以上的需要先进行权限申请
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            FileUtils.init(this);
        }
    }

    public static App getApplication() {
        return mContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }
}
