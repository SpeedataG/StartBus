package com.spd.startbus;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * Created by 张明_ on 2019/4/29.
 * Email 741183142@qq.com
 */
public class InstallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //新的应用安装
        if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_ADDED)) {
            String packageName = intent.getData().getSchemeSpecificPart();
            Toast.makeText(context, "安装成功" + packageName, Toast.LENGTH_LONG).show();
            if (packageName.equals("com.spd.bus")) {
                Intent intent2 = new Intent(Intent.ACTION_MAIN);
                /*知道要跳转应用的包命与目标Activity*/
                ComponentName componentName = new ComponentName("com.spd.bus", "com.spd.bus.spdata.configcheck.ConfigCheckActivity");
                intent2.setComponent(componentName);
                context.startActivity(intent2);
            }

        } else if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_REPLACED)) {
            //应用替换成功
            String packageName = intent.getData().getSchemeSpecificPart();
            if (packageName.equals("com.spd.bus")) {
                Intent intent2 = new Intent(Intent.ACTION_MAIN);
                /*知道要跳转应用的包命与目标Activity*/
                ComponentName componentName = new ComponentName("com.spd.bus", "com.spd.bus.spdata.configcheck.ConfigCheckActivity");
                intent2.setComponent(componentName);
                context.startActivity(intent2);
            }

        } else if (TextUtils.equals(intent.getAction(), Intent.ACTION_PACKAGE_REMOVED)) {
            //应用被卸载
            String packageName = intent.getData().getSchemeSpecificPart();
        }

    }
}
