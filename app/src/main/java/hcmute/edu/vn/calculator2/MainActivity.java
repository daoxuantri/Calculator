package hcmute.edu.vn.calculator2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String op = "+";
    String oldNumber = "";
    int [] arr = null;
    boolean isNewOp = true;
    String process;
    TextView ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.result_tv);

    }
    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number =  ed1.getText().toString();
        switch (view.getId()){
            case R.id.button_7:
                number += "7";
                break;
            case R.id.button_8:
                number += "8";
                break;
            case R.id.button_9:
                number += "9";
                break;
            case R.id.button_6:
                number += "6";
                break;
            case R.id.button_5:
                number += "5";
                break;
            case R.id.button_4:
                number += "4";
                break;
            case R.id.button_3:
                number += "3";
                break;
            case R.id.button_2:
                number += "2";
                break;
            case R.id.button_1:
                number += "1";
                break;
            case R.id.button_0:
                number += "0";
                break;
            case R.id.button_dot:
                number += ".";
                break;
            case R.id.button_minus1:
                number += "-";
                break;
        }
        ed1.setText(number);
    }
    // Sự kiện khi nhấn vào nút + - * / thì gán op phép đó để cho sự kiên = và hiện thị phép tính đó
    public  void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        process = ed1.getText().toString();
        switch (view.getId()){
            case R.id.button_divide:
                op = "/";
                ed1.setText(process + "÷");
                break;
            case R.id.button_multiply:
                op = "*";
                ed1.setText(process + "*");
                break;
            case R.id.button_plus:
                op = "+";
                ed1.setText(process + "+");
                break;
            case R.id.button_minus:
                op = "-";
                ed1.setText(process + "-");
                break;
        }
    }
    public void  equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0;
        try {


            switch (op) {
                case "+":
                    if (oldNumber == "") {

                        result = 0 + Double.parseDouble(newNumber);
                        break;
                    } else {
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    }

                case "-":
                    if (oldNumber == "") {
                        result = 0 + Double.parseDouble(newNumber);
                        break;
                    } else if (oldNumber == "0") {
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    } else {
                        result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                        break;
                    }

                case "*":
                    if (oldNumber == "") {
                        result = 0 + Double.parseDouble(newNumber);
                        break;
                    } else if (oldNumber == "0") {
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    } else {
                        result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                        break;
                    }
                case "/":
                    if (oldNumber == "") {
                        result = 0 + Double.parseDouble(newNumber);
                        break;
                    } else if (oldNumber == "0") {
                        result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                        break;
                    } else {
                        result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                        break;
                    }
            }
            oldNumber = "0";
            ed1.setText(result + "");
        }
        catch (Exception e)
        {
            ed1.setText("Error");
        }
    }
    public void cleanEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }
    public void numberX(View view){
        if(ed1.getText().toString() == "Error"){
            ed1.setText("");
        }
        else {
            String number = ed1.getText().toString();
            String[] arStr = number.split("");
            List<String> testList = new ArrayList<>(Arrays.asList(arStr));
            testList.remove(arStr.length - 1);
            arStr = testList.toArray(new String[0]);
            String resultString = "";
            for (int i = 0; i < arStr.length; i++) {
                resultString += arStr[i];
            }
            ed1.setText(resultString);
        }

    }
    public void roundButtonClick(View view) {
        if (!ed1.getText().toString().equals("")) {
            double value = Double.parseDouble(ed1.getText().toString());
            double roundedValue = Math.round(value * 10.0) / 10.0; // làm tròn đến 2 chữ số thập phân
            ed1.setText(String.valueOf(roundedValue));
        }
    }
}
