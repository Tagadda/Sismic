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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preset[] presets = {
            new Preset(getString(R.string.vibe_infinite), new long[]{0, 1000, 0}, 0),
            new Preset(getString(R.string.vibe_burst), new long[]{0, 50, 50}, 1)
        };

        RadioGroup rg = (RadioGroup) this.findViewById(R.id.radiogroup);
        for(int i = 0; i < presets.length; i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(presets[i].name);
            rg.addView(rb);
        };

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        Button first = findViewById(R.id.first_button);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId() - 1;
                if(id < 0) {
                    Toast.makeText(getApplicationContext(), getString(R.string.select_reminder), Toast.LENGTH_SHORT).show();
                } else {
                    vibrator.vibrate(presets[id].timings, presets[id].repeat);
                }
            }
        });

        Button second = findViewById(R.id.cancel_button);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
            }
        });
    }
}