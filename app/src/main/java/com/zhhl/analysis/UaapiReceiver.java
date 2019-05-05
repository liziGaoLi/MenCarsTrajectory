
package com.zhhl.analysis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.xdja.uaac.api.UaacApi;
import com.zhhl.analysis.app.App;

public class UaapiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "Receive" + action, Toast.LENGTH_SHORT).show();
        Log.e("onReceive: ", action);
        if ("com.xdja.unifyauthorize.ACTION_LOGOUT".equals(action)) {
            String packageName = intent.getStringExtra("packageName");
            if (packageName.equals(context.getPackageName())) {
                System.out.println("是我");
            } else {
                System.out.println("不是我");
            }
            Process.killProcess(Process.myPid());
        } else if (context.getPackageName().equals(action)) {
            Log.e("onReceive: ", "统一认证说你可以去拿token了");
            if (App.app() != null) {
//                Suu.getToken(context, App.app().getCallback());
//                UaacApi.getToken(context, App.app().getCallback());
            }
        }


    }
}
