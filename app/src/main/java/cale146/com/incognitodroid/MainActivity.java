package cale146.com.incognitodroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import cale146.com.incognitodroid.R;

public class MainActivity extends Activity {
    static boolean f808a = true;
    boolean f810c = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        PhoneStateListener phoneStateListener = new PhoneStateListener();
        Button button = findViewById(R.id.buttonOne);
        final TextView textView1 = findViewById(R.id.textView1);

        Context applicationContext = getApplicationContext();
        final AudioManager audioManager = (AudioManager) applicationContext.getSystemService(AUDIO_SERVICE);

        if (audioManager.isMicrophoneMute() || !CallReceiver.flag) {
            Log.d("The mic is off", "off");
            textView1.setText("Mic Is Off");
            getWindow().getDecorView().setBackgroundColor(Color.RED);
            //radioButton.setBackgroundColor(-65536);
            audioManager.setMicrophoneMute(true);
            f808a = false;
        } else if (!audioManager.isMicrophoneMute() || CallReceiver.flag) {
            Log.d("The mic is on", "on");
            textView1.setText("Mic Is On");
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            // radioButton.setBackgroundColor(-16711936);
            audioManager.setMicrophoneMute(false);
            f808a = true;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(audioManager.isMicrophoneMute()) {
                    audioManager.setMicrophoneMute(false);
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    textView1.setText("Mic is On");
                    Log.d("microphone mute", "true");
                }
                else{
                    audioManager.setMicrophoneMute(true);
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    textView1.setText("Mic is off");
                    Log.d("microphone mute", "false");
                }

            }
        });
    }
}
