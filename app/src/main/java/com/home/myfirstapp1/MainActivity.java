package com.home.myfirstapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {


    private Button button;
    private CheckBox checkBox;
    private TextView finalText;
    private RadioButton radioButtonMan;
    private RadioButton radioButtonWoman;
    private EditText editName;
    private RadioGroup genderGroup;
    private Switch switchLight;
    private ToggleButton toggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.second_activity);



        button = findViewById(R.id.accept_button);
        checkBox = findViewById(R.id.check_agree);
        finalText = findViewById(R.id.final_text);
        radioButtonMan = findViewById(R.id.radio_button_man);
        radioButtonWoman = findViewById(R.id.radio_button_woman);
        editName = findViewById(R.id.edit_name);
        genderGroup = findViewById(R.id.radio_group_gender);
        switchLight = findViewById(R.id.switch_light);
        toggleButton = findViewById(R.id.toggle_light);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if
                ((checkBox.isChecked()) && (genderGroup.getCheckedRadioButtonId() != -1)) {
                    if (checkBox.isChecked() && (radioButtonMan.isChecked())) {
                        finalText.setText(getString(R.string.hello_mr) + " " + editName.getText());
                        finalText.setVisibility(View.VISIBLE);
                    }
                    if (checkBox.isChecked() && (radioButtonWoman.isChecked())) {
                        finalText.setText(getString(R.string.hello_ms) + " " + editName.getText());
                        finalText.setVisibility(View.VISIBLE);
                    }
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.warning_message,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        switchLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchLight.isChecked()) {
                    toggleButton.setEnabled(true);
                } else {
                    toggleButton.setEnabled(false);
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggleButton.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.on_message,
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.off_message,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });


    }
}
