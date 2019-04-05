package cale146.com.incognitodroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import static cale146.com.incognitodroid.MainActivity.f808a;

public class CallReceiver extends BroadcastReceiver {
    /* renamed from: a */
    static boolean flag = true;

    public void onReceive(Context context, Intent intent) {
        Log.d("A call been received", "true");
        if (!intent.getStringExtra("state").equals(TelephonyManager.EXTRA_STATE_OFFHOOK)
                && intent.getStringExtra("state").equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            Log.d("Call is disconnected", "true");
            Intent intent2;
            if (f808a) {
                flag = true;
                intent2 = new Intent();
                intent2.setClass(context, MainActivity.class);
                intent2.putExtra("value", f808a);
                //intent2.setFlags(Intent.);
                context.startActivity(intent2);
                return;
            }
            flag = false;
            intent2 = new Intent();
            intent2.setClass(context, MainActivity.class);
            intent2.putExtra("value", flag);
            //intent2.setFlags(268435456);
            context.startActivity(intent2);
        }
    }
}
