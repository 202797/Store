/*
    Store Project
    Bryce Anderson
    Period 5-6
*/


package com.anderson.bryce.store;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    EditText etTemperature;
    TextView tvAnswer;
    Button btnCompute;
    Button btnReset;
    ToggleButton swapUnits;
    TextView tvEnter;
    TextView tvEquivalent;

    String unit = "F";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etTemperature = (EditText) findViewById(R.id.etTemperature); // like VB Textbox 
        btnCompute = (Button) findViewById(R.id.btnCompute);         // like VB Button 
        btnReset = (Button) findViewById(R.id.btnReset);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        tvEnter = (TextView) findViewById(R.id.tvEnter);
        tvEquivalent = (TextView) findViewById(R.id.tvEquivalent);
        swapUnits = (ToggleButton) findViewById(R.id.swapUnits);

        tvAnswer.setTextSize(18);
        tvAnswer.setTextColor(Color.BLACK);

        btnCompute.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v)
            {
                calculate();
            }

        });

        btnReset.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v)
            {
                reset();
            }

        });

        swapUnits.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    unit = "C";
                    tvEnter.setText("Enter Celsius Temperature:");
                    tvEquivalent.setText("The equivalent Fahrenheit temperature is:");
                    Toast.makeText(MainActivity.this, "Set to Celsius-Fahrenheit conversion", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    unit = "F";
                    tvEnter.setText("Enter Fahrenheit Temperature:");
                    tvEquivalent.setText("The equivalent Celsius temperature is:");
                    Toast.makeText(MainActivity.this, "Set to Fahrenheit-Celsius conversion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }// end of onCreate method

    private void calculate()
    {
        if (unit.equals("F")) //convert F to C
        {
            double degreesFahrenheit = Double.parseDouble(etTemperature.getText().toString());
            double degreesCelsius = (degreesFahrenheit - 32) * 5. / 9.;
            tvAnswer.setText(Double.toString(degreesCelsius) + " ˚C");
        }
        else if (unit.equals("C")) //convert C to F
        {
            double degreesCelsius = Double.parseDouble(etTemperature.getText().toString());
            double degreesFahrenheit = (degreesCelsius * 9. / 5.) + 32;
            tvAnswer.setText(Double.toString(degreesFahrenheit) + " ˚F");
        }
    }

    private void reset()
    {
        etTemperature.setText("");
        tvAnswer.setText("");
    }

}// end of MainActivity class
