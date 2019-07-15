package com.spd.startbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            context.startForegroundService(new Intent(context, MyService.class));
//            Toast.makeText(context, "监控程序启动", Toast.LENGTH_SHORT).show();
            System.out.println("监控程序启动");
        }
    }
}
