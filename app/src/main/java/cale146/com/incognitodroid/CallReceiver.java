package cale146.com.incognitodroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import static cale146.com.incognitodroid.MainActivity.mainActivityFlag;

public class CallReceiver extends BroadcastReceiver {
    static boolean callReceiverFlag = true;

    public void onReceive(Context context, Intent intent) {
        Log.d("A call been received", "true");

        if (!intent.getStringExtra("state").equals(TelephonyManager.EXTRA_STATE_OFFHOOK)
                && intent.getStringExtra("state").equals(TelephonyManager.EXTRA_STATE_IDLE)) {

            Log.d("Call is disconnected", "true");

            Intent intentForMainActivity;

            if(mainActivityFlag) {
                callReceiverFlag = true;
                intentForMainActivity = new Intent();
                intentForMainActivity.setClass(context, MainActivity.class);
                intentForMainActivity.putExtra("value", mainActivityFlag);
                context.startActivity(intentForMainActivity);
                return;
            }

            callReceiverFlag = false;
            intentForMainActivity = new Intent();
            intentForMainActivity.setClass(context, MainActivity.class);
            intentForMainActivity.putExtra("value", callReceiverFlag);
            context.startActivity(intentForMainActivity);
        }
    }
}
