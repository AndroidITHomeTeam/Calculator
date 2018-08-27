package martirosyan.taron.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DecimalFormat decimalFormat;
    private Button button1, button2,
            button3, button4, button5,
            button6, button7, button8,
            button9, button0, buttonGumar,
            buttonBajanum, buttonHanum, buttonBazmapatkum,
            buttonEquals, buttonBack, buttonArmat,
            buttonTokos, buttonDouble, buttonDelete;

    private TextView hystory;
    private EditText action;
    private double val1 = Double.NaN;
    private Double val2;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLIKATION = '*';
    private final char DIVISION = '/';
    private final char EQUALS = 0;
    private final char ARMAT = '√';
    private final char TOKOS = '%';
    private char ACTION;
    double result;
    int countAction = 0;
    LinkedHashMap<String, Character> actionType = new LinkedHashMap<>();
    DecimalFormat decimalFormat1=new DecimalFormat("0.00");


    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewID();
        SetOnClick();

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button0:
                if (action.getText().length() != 0) {
                    action.setText(action.getText().toString() + "0");
                    //  hystory.setText(action.getText());
                }
                break;
            case R.id.button1:
                action.setText(action.getText().toString() + "1");
                // hystory.setText(action.getText());
                break;
            case R.id.button2:
                action.setText(action.getText().toString() + "2");
                hystory.setText(hystory.getText().toString());
                break;
            case R.id.button3:
                action.setText(action.getText() + "3");
                // hystory.setText(action.getText());
                break;
            case R.id.button4:
                action.setText(action.getText() + "4");
                //  hystory.setText(action.getText());
                break;
            case R.id.button5:
                action.setText(action.getText() + "5");
                //hystory.setText(action.getText());
                break;
            case R.id.button6:
                action.setText(action.getText() + "6");
                // hystory.setText(action.getText());
                break;
            case R.id.button7:
                action.setText(action.getText() + "7");
                //  hystory.setText(action.getText());
                break;
            case R.id.button8:
                action.setText(action.getText() + "8");
                //  hystory.setText(action.getText());
                break;
            case R.id.button9:
                action.setText(action.getText() + "9");
                //  hystory.setText(action.getText());
                break;
            case R.id.button_double_id:
                if (action.getText().length() != 0 && action.getText().toString().
                        charAt(action.getText().toString().length() - 1) >= '0' && action.getText().toString().
                        charAt(action.getText().toString().length() - 1) <= '9' && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + ".");
                    hystory.setText(hystory.getText().toString());
                    Log.i("if", "onClick: ---->1");
                    count++;
                } else if ( action.getText().length() != 0 && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + ".");
                    hystory.setText(action.getText());
                    Log.i("if", "onClick: ---->2");
                    count++;
                }
                else if (hystory.getText().toString().length()!=0 && hystory.getText().toString().charAt(
                        hystory.getText().toString().length()-1)>0 &&hystory.getText().toString().charAt(
                        hystory.getText().toString().length()-1)<9 && action.getText().toString().length()>0 ){
                    action.setText(action.getText()+".");
                    Log.i("if", "onClick: ---->3");


                }
                else if (action.getText().length() == 0 && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + "0.");
                    hystory.setText(hystory.getText().toString());
                    count++;
                    Log.i("if", "onClick: ---->4");
                }
                break;
            case R.id.button_delete_id:
                action.setText(null);
                hystory.setText(null);
                val1 = Double.NaN;
                val2 = 0.0;
                count = 0;
                break;

            case R.id.button_gumarum:
//                if (!hystory.getText().toString().contains("=")){
//                   // hystory.setText(action.getText().toString());
//                    hystory.setText("");
//               // if (action.getText().toString().length() > 0) {
//                    actionType.put("Action", ADDITION);
//                    Log.i("map_size", "gumarum: " + actionType.size());
//                    for (Map.Entry<String, Character> i : actionType.entrySet()) {
//                        ACTION = i.getValue();
//                        Log.i("map", "Action===== " + i.getValue());
//                        compute();
//                        hystory.setText(String.valueOf(val1) + i.getValue());
//                        action.setText(null);
//                   }
//                }else {
                compute();
                    actionType.put("Action", ADDITION);
                    Log.i("map_size", "gumarum: " + actionType.size());
                    for (Map.Entry<String, Character> i : actionType.entrySet()) {
                        ACTION = i.getValue();
                        Log.i("map", "Action===== " + i.getValue());

                        hystory.setText(String.valueOf(val1)+ ACTION);
                        action.setText(null);
                    }




                break;

            case R.id.button_hanum:

                  //  compute();
//                    actionType.put("Action", SUBTRACTION);
//                    Log.i("map_size", "gumarum: " + actionType.size());
//                    for (Map.Entry<String, Character> i : actionType.entrySet()) {
//                        ACTION = i.getValue();
//                        Log.i("map", "Action===== " + i.getValue());

                        if (hystory.getText().toString().endsWith("+")){
                            hystory.setText(String.valueOf(val1) + SUBTRACTION);
                            action.setText(null);
                        }else {
//                            compute();
//                            ACTION=SUBTRACTION;
                            hystory.setText(String.valueOf(val1) + SUBTRACTION);
                            action.setText(null);
                        }
                compute();
                ACTION=SUBTRACTION;



                break;

            case R.id.button_bajanum:
                compute();
                ACTION = DIVISION;

                hystory.setText(String.valueOf( val1)+ "/");
                action.setText(null);
                break;

            case R.id.button_bazmapatkum:
                compute();
                countAction++;
                ACTION = MULTIPLIKATION;
                hystory.setText(String.valueOf(val1) + "*");
                action.setText(null);
                break;


            case R.id.button_havasar:
//                compute();
//                ACTION = EQUALS;
//                hystory.setText(hystory.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
//
//                if ( String.format("%.0f", val1).toString().length() > 12 ) {
//                    action.setText(String.format("%.0f", val1));
//                } else {
//                    action.setText(String.valueOf(val1));
//                }
//                break;
                Log.i("havasar", "onClick: " + hystory.getText().toString());
                if (hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '+'
                        || hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '-'
                        ||hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '*'
                        ||hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '/'
                        && action.getText().toString().length() > 0) {

                    compute();
                    ACTION = EQUALS;
                    hystory.setText(hystory.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                    if ((String.format("%.0f", val1).toString().length()) > 10) {
                        setActionTextSize();
                        action.setText(String.valueOf(val1));
//                    action.setText(new DecimalFormat("##.####").format(val1));
                        Toast.makeText(this, "" + val1, Toast.LENGTH_SHORT).show();
                    }
//                    action.setText(new DecimalFormat("##.#####").format(Double.parseDouble(action.getText().toString())));
//                    }
// else {
//                        action.setText(String.format("%.0f", val1));
//                    }
                } else if (hystory.getText().toString().contains("WRONG FORMAT")) {
                    hystory.setText(hystory.getText().toString() );
                } else {
                    hystory.setText(hystory.getText().toString() + " WRONG FORMAT ");
                }
                break;

            case R.id.button_back_id:
                if (action.getText().toString().length() > 0 && !action.getText().toString().equals("0.")) {
                    int index = action.getText().toString().length() - 1;
                    action.setText(action.getText().toString().substring(0, index));
                    hystory.setText(action.getText());
                    count = 0;
                } else if (action.getText().toString().equals("0.")) {
                    action.setText("");
                   // hystory.setText(action.getText());
                    count = 0;
                }

                break;
            case R.id.button_armat:
                // action.setText(action.getText() + "√");

                break;
            case R.id.button_tokos:

                compute();
                ACTION = TOKOS;

                hystory.setText(String.valueOf(val1) + "%");
                action.setText(null);
                break;
        }
    }


    private void compute() {
        if (!Double.isNaN(val1)) {
            // val1=Double.parseDouble(hystory.getText().toString());
            val2 = Double.valueOf(action.getText().toString());
            //   Toast.makeText(this, "mtav", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "vall====" + val1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "val2====" + val2, Toast.LENGTH_LONG).show();
            switch (ACTION) {

                case ADDITION:
                    // if (hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '+') {
                    val1 = val1 + val2;
                    // }
                    break;

                case SUBTRACTION:
                    // if (hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '-') {
                    val1 = val1 - val2;
                    //  }
                    break;

                case MULTIPLIKATION:
                    val1 = val1 * val2;
                    break;

                case DIVISION:
                    val1 = val1 / val2;
                    break;

                case ARMAT:
                    if (val1 > 0) {

                        val1 = Math.sqrt(val1);
                    }
                    break;
                case TOKOS:
                    val1 = val1 * val2 / 100;
                    break;
                case EQUALS:
                    //action.setText(""+result);

                    break;
            }
//        } else if (Double.isNaN(val1)){
//            val1 = Double.valueOf(hystory.getText().toString().substring(0,
//                    hystory.getText().toString().length()-1));

        }

        else {
            val1= Double.valueOf(action.getText().toString());
        }
    }



    private void setActionTextSize() {
        if (action.getText().toString().length() >= 13) {
            action.setTextSize(25);
        } else {
            action.setTextSize(50);
        }
    }


//    public boolean operation() {
//
//        if (hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '-' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '+' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '/' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) != '*') {
//
//           act=true;
//
//        } else if (hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '-' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '+' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '/' ||
//                hystory.getText().toString().charAt(hystory.getText().toString().length() - 1) == '*') {
//          act=false;
//        }
//
//          return act;
//        }

//    public void Sum() {
//        if (action.getText().toString().length() != 0 && count == 0) {
//            action.setText(action.getText().toString() + "+");
//            hystory.setText(hystory.getText().toString() + "+");
//            count++;
//        } else if (action.getText().toString().length() == 0 && count == 0) {
//            action.setText("");
//            hystory.setText("");
//        } else if (action.getText().toString().length() != 0 && count > 0 && action.getText().toString().
//                charAt(action.getText().toString().length()-1)=='+') {
//
//            for (int i = 0; i <action.getText().toString().length() ; i++) {
//
//                result=
//            }
//
//
//        }
//
//        // return result;
//
//    }


    public void getViewID() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonGumar = findViewById(R.id.button_gumarum);
        buttonBajanum = findViewById(R.id.button_bajanum);
        buttonHanum = findViewById(R.id.button_hanum);
        buttonBazmapatkum = findViewById(R.id.button_bazmapatkum);
        buttonEquals = findViewById(R.id.button_havasar);
        buttonArmat = findViewById(R.id.button_armat);
        buttonDouble = findViewById(R.id.button_double_id);
        buttonBack = findViewById(R.id.button_back_id);
        buttonDelete = findViewById(R.id.button_delete_id);
        buttonTokos = findViewById(R.id.button_tokos);
        action = findViewById(R.id.textView_action_id);
        hystory = findViewById(R.id.textView_hystory_id);

    }

    public void SetOnClick() {

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonGumar.setOnClickListener(this);
        buttonBajanum.setOnClickListener(this);
        buttonHanum.setOnClickListener(this);
        buttonBazmapatkum.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonArmat.setOnClickListener(this);
        buttonDouble.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonTokos.setOnClickListener(this);

    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
//        startActivity(i);
//        finish();
//    }
}

