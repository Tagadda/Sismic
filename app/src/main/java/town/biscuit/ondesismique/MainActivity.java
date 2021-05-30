package town.biscuit.ondesismique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Vibrator vibrator;
    private Preset[] presets;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presets = new Preset[]{
                new Preset(getString(R.string.vibe_infinite), new long[]{0, 1000, 0}, 0),
                new Preset(getString(R.string.vibe_burst), new long[]{0, 50, 50}, 1),
                new Preset(getString(R.string.vibe_pulse), new long[]{0, 100, 50}, 0),
                new Preset(getString(R.string.vibe_longpulse), new long[]{0, 200, 50}, 0),
                new Preset(getString(R.string.viber_longerpulse), new long[]{0, 300, 50}, 0),
                new Preset(getString(R.string.vibe_1l3s), new long[]{0, 300, 50, 100, 50, 100, 50, 100, 50}, 0),
                new Preset(getString(R.string.vibe_allpulse), new long[]{0, 300, 50, 200, 50, 100, 50}, 0),
        };

        rg = (RadioGroup) this.findViewById(R.id.radiogroup);
        for (Preset preset : presets) {
            RadioButton rb = new RadioButton(this);
            rb.setText(preset.name);
            rg.addView(rb);
        };

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    public void startSismic(View v) {
        int id = (int) rg.getCheckedRadioButtonId() - 1;
        if(id < 0) {
            Toast.makeText(getApplicationContext(), getString(R.string.select_reminder), Toast.LENGTH_SHORT).show();
        } else {
            vibrator.vibrate(presets[id].timings, presets[id].repeat);
        }
    }

    public void stopSismic(View v) { vibrator.cancel(); }


}