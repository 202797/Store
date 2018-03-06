package com.anderson.bryce.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.EditText;
//import android.widget.Toast;
//import android.widget.TextView;
//import android.widget.Button;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    EditText etTemperature;
    TextView tvAnswer;
    ToggleButton swapUnits;
    TextView top;
    TextView bottom;

    String unit;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //TextView message = new TextView(this);
        //message.setText("Hello World"); 
        //setContentView(message);

        //Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();     //display in short period of time 
        //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();   //display in long period of time 
        //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show(); 

        etTemperature = (EditText) findViewById(R.id.etTemperature); // like VB Textbox 
        Button btnCompute = (Button) findViewById(R.id.btnCompute);         // like VB Button 
        Button btnReset = (Button) findViewById(R.id.btnReset);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        top = (TextView) findViewById(R.id.top);
        bottom = (TextView) findViewById(R.id.bottom);
        swapUnits = (ToggleButton) findViewById(R.id.swapUnits);

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

        swapUnits.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    unit = "C";
                    top.setText("Enter Celsius Temperature:");
                    bottom.setText("The equivalent Fahrenheit temperature is:");
                }
                else
                {
                    unit = "F";
                    top.setText("Enter Fahrenheit Temperature:");
                    bottom.setText("The equivalent Celsius temperature is:");
                }
            }
        });

    }// end of onCreate method

    private void calculate()
    {
        if (unit == "F") //convert f to c
        {
            double degreesFahrenheit = Double.parseDouble(etTemperature.getText().toString());
            double degreesCelsius = (degreesFahrenheit - 32) * 5. / 9.;
            tvAnswer.setText(Double.toString(degreesCelsius));
        }
        else if (unit == "C") //convert c to f
        {
            double degreesCelsius = Double.parseDouble(etTemperature.getText().toString());
            double degreesFahrenheit = (degreesCelsius * 9. / 5.)+ 32;
            tvAnswer.setText(Double.toString(degreesFahrenheit));
        }
    }

    private void reset()
    {
        etTemperature.setText("");
        tvAnswer.setText("");
    }

}// end of MainActivity class




