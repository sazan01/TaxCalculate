package com.sajan.taxcalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_tax;
    EditText value;
    TextView result;
    String getMonthlySalary, firsttax, secondtax, thirdtax, finaltaxamount,
            yearlysalary, secondamount, thirdamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    public void initializeViews() {
        value = findViewById(R.id.et_salary);
        btn_tax = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.tv_result);
        btn_tax.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calculate:
                getMonthlySalary = value.getText().toString();
                yearlysalary = Double.parseDouble(getMonthlySalary) * 12 + "";
                if (Double.parseDouble(yearlysalary) > 1 && Double.parseDouble(yearlysalary) < 200000) {
                    finaltaxamount = (1 * (Double.parseDouble(yearlysalary)) / 100) + "";
                } else if (Double.parseDouble(yearlysalary) >= 200000 && Double.parseDouble(yearlysalary) < 350000) {
                    secondamount = Double.parseDouble(yearlysalary) - 200000 + "";
                    firsttax = (1 * 200000) / 100 + "";
                    secondtax = ((15 * Double.parseDouble(secondamount)) / 100) + "";
                    finaltaxamount = Double.parseDouble(firsttax) + Double.parseDouble(secondtax) + "";
                } else if (Double.parseDouble(yearlysalary) >= 350000) {
                    thirdamount = Double.parseDouble(yearlysalary) - 350000 + "";
                    firsttax = (1 * 200000) / 100 + "";
                    secondtax = (15 * 150000) / 100 + "";
                    thirdtax = ((25 * Double.parseDouble(thirdamount)) / 100) + "";
                    finaltaxamount = Double.parseDouble(firsttax) + Double.parseDouble(secondtax) +
                            Double.parseDouble(thirdtax) + "";
                    System.out.println(firsttax);
                    System.out.println(secondtax);
                    System.out.println(thirdtax);
                    System.out.println(finaltaxamount);
                }
                result.setText("The final Tax amount is" + " " + finaltaxamount);
        }


    }
}


