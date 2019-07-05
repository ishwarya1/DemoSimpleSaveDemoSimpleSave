package sg.edu.rp.soi.demosimplesavedemosimplesave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText etWeight;
    EditText etHeight;
    Button reset;
    TextView display;
    TextView tvbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calc_button);
        reset = findViewById(R.id.reset);
        etHeight = findViewById(R.id.height);
        etWeight = findViewById(R.id.weight);
        tvbmi = findViewById(R.id.ET2);
        display=findViewById(R.id.ET);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                float bmi = height / (weight * weight);
                Calendar now = Calendar.getInstance();
                String datetime = now.get(Calendar.DAY_OF_MONTH) + "/" +
                        (now.get(Calendar.MONTH) + 1) + "/" +
                        now.get(Calendar.YEAR) + " " +
                        now.get(Calendar.HOUR_OF_DAY) + " :" +
                        now.get(Calendar.MINUTE);
                display.setText(datetime);



                if (bmi < 18.5) {
                    tvbmi.setText("You are underweight");
                    Toast.makeText(MainActivity.this, "You are underweight", Toast.LENGTH_LONG).show();
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    tvbmi.setText("You BMI is normal");
                    Toast.makeText(MainActivity.this, "Your BMI is normal", Toast.LENGTH_LONG).show();
                } else if (bmi >= 25 && bmi <= 29.9) {
                    tvbmi.setText("You are overweight");
                    Toast.makeText(MainActivity.this, "You are overweight", Toast.LENGTH_LONG).show();
                } else {
                    tvbmi.setText("You are obese");
                    Toast.makeText(MainActivity.this, "You are obese", Toast.LENGTH_LONG).show();
                }


            }


        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String msg = "No greetings!";
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
}
