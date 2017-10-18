package com.apkbus.bbs;

import com.mob.MobApplication;
import com.mob.MobSDK;
import com.mob.bbssdk.theme1.BBSTheme1;

/**
 * Created by liangd on 2017/10/10.
 */

public class BBSApplication extends MobApplication {

    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
        BBSTheme1.init();

    }
}
