package martirosyan.taron.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Main";
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
    Double val2 = 0.0;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLIKATION = '*';
    private final char DIVISION = '/';
    private final char EQUALS = 0;
    private final char ARMAT = '√';
    private final char TOKOS = '%';
    private char ACTION;
    private boolean act;


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
                    if (checksTheSimbolsCount()) {
                        action.setText(action.getText().toString() + "0");
                    }
                    setActionTextSize();
                }
                break;
            case R.id.button1:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText().toString() + "1");
                }
                setActionTextSize();
                break;
            case R.id.button2:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText().toString() + "2");
                }
                setActionTextSize();
                break;
            case R.id.button3:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "3");
                }
                setActionTextSize();
                break;
            case R.id.button4:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "4");
                }
                setActionTextSize();
                break;
            case R.id.button5:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "5");
                }
                setActionTextSize();
                break;
            case R.id.button6:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "6");
                }
                setActionTextSize();
                break;
            case R.id.button7:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "7");
                }
                setActionTextSize();
                break;
            case R.id.button8:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "8");
                }
                setActionTextSize();
                break;
            case R.id.button9:
                if (checksTheSimbolsCount()) {
                    action.setText(action.getText() + "9");
                }
                setActionTextSize();
                break;
            case R.id.button_double_id:
                if (action.getText().length() != 0 && action.getText().toString().
                        charAt(action.getText().toString().length() - 1) >= '0' && action.getText().toString().
                        charAt(action.getText().toString().length() - 1) <= '9' && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + ".");
                    hystory.setText(hystory.getText().toString());
                    Log.i("if", "onClick: ---->1");
                } else if (action.getText().length() != 0 && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + ".");
                    hystory.setText(action.getText());
                    Log.i("if", "onClick: ---->2");
                } else if (hystory.getText().toString().length() != 0 && hystory.getText().toString().charAt(
                        hystory.getText().toString().length() - 1) > 0 && hystory.getText().toString().charAt(
                        hystory.getText().toString().length() - 1) < 9 && action.getText().toString().length() > 0) {
                    action.setText(action.getText() + ".");
                    Log.i("if", "onClick: ---->3");


                } else if (action.getText().length() == 0 && !action.getText().toString().contains(".")) {
                    action.setText(action.getText() + "0.");
                    hystory.setText(hystory.getText().toString());
                    Log.i("if", "onClick: ---->4");
                }
                break;
            case R.id.button_delete_id:
                action.setText(null);
                hystory.setText(null);
                val1 = Double.NaN;
                val2 = 0.0;
                setActionTextSize();
                break;

            case R.id.button_gumarum:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                }
                if (operation()) {
                    compute();
                    ACTION = ADDITION;
                    hystory.setText(String.valueOf(val1) + ADDITION);
                    action.setText(null);
                    val2 = 0.0;
                    Log.i(TAG, "button_gumarum: if (operation())" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                } else {
                    //  action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    Toast.makeText(this, "val1 else==" + val1, Toast.LENGTH_SHORT).show();
                    compute();
                    ACTION = ADDITION;
                    hystory.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1) + ADDITION);
                    action.setText(null);
                    // val2 = 0.0;
                    Log.i(TAG, "button_gumarum: else" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);

                }


                break;

            case R.id.button_hanum:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                }

                if (operation() == true) {
                    compute();
                    ACTION = SUBTRACTION;
                    hystory.setText(String.valueOf(val1) + SUBTRACTION);
                    action.setText(null);
                    val2 = 0.0;
                    Log.i(TAG, "button_hanum: if (operation())" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                    return;
                } else {
                    Toast.makeText(this, "mta else", Toast.LENGTH_SHORT).show();
                    compute();
                    ACTION = SUBTRACTION;
                    hystory.setText(action.getText().toString() + SUBTRACTION);
                    action.setText(null);
                    Log.i(TAG, "button_hanum: else" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                    // val2 = 0.0;
                }


                break;

            case R.id.button_bajanum:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                }
                if (operation() == true) {
                    compute();
                    ACTION = DIVISION;
                    hystory.setText(String.valueOf(val1) + DIVISION);
                    action.setText(null);
                    val2 = 0.0;
                    Log.i(TAG, "button_bajanum: if (operation())" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);

                } else {
                    compute();
                    ACTION = DIVISION;
                    hystory.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1) + DIVISION);
                    action.setText(null);
                    Log.i(TAG, "button_bajanum: else" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                }
                break;

            case R.id.button_bazmapatkum:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                }
                if (operation()) {
                    compute();
                    ACTION = MULTIPLIKATION;
                    hystory.setText(String.valueOf(val1) + MULTIPLIKATION);
                    action.setText(null);
                    val2 = 0.0;
                    Log.i(TAG, "button_bazmapatkum: if (operation())" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                } else {
                    compute();
                    ACTION = MULTIPLIKATION;
                    hystory.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1) + MULTIPLIKATION);
                    action.setText(null);
                    Log.i(TAG, "button_bazmapatkum: else" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                }
                break;


            case R.id.button_havasar:
                if (ACTION == DIVISION && action.getText().toString().length() == 0) {
                    Toast.makeText(this, "Not division by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("havasar", "onClick: " + hystory.getText().toString());
                if (hystory.getText().toString().endsWith("-") ||
                        hystory.getText().toString().endsWith("%") ||
                        hystory.getText().toString().endsWith("+") ||
                        hystory.getText().toString().endsWith("*") ||
                        hystory.getText().toString().endsWith("/")
                        ) {

                    if (action.getText().toString().length() != 0 &&
                            !hystory.getText().toString().contains("WRONG FORMAT")) {


                        Log.i("wrong", "onClick: arachin if------ " + action.getText().toString().length());

                        compute();
                        ACTION = EQUALS;
                        AstichanE();
                        hystory.setText(hystory.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                        action.setText(null);

                        if (String.valueOf(val1).toString().length() > 10) {
                            setHystoryTextSize();
                            Log.i(TAG, "onClick: if (String.valueOf(val1).toString().length() > 10) ");
                        }
                    }
                } else if (hystory.getText().toString().contains("WRONG FORMAT")) {
                    Log.i("wrong", "onClick: else if erkrord------ ");
                    hystory.setText(hystory.getText().toString());
                } else if (val2 != null &&
                        hystory.getText().toString().endsWith("+") ||
                        hystory.getText().toString().endsWith("%") ||
                        hystory.getText().toString().endsWith("-") ||
                        hystory.getText().toString().endsWith("*") ||
                        hystory.getText().toString().endsWith("/")) {

                    Log.i("wrong", "onClick: errord else if------ ");
                    hystory.setText(hystory.getText().toString() + " WRONG FORMAT ");
                } else if (hystory.getText().toString().endsWith("+") ||
                        hystory.getText().toString().endsWith("%") ||
                        hystory.getText().toString().endsWith("-") ||
                        hystory.getText().toString().endsWith("*") ||
                        hystory.getText().toString().endsWith("/") &&
                                action.getText().toString().length() == 0) {
                    hystory.setText(hystory.getText().toString() + " = WRONG FORMAT");
                }
                break;

            case R.id.button_back_id:
                if (action.getText().toString().length() > 0 && !action.getText().toString().equals("0.")) {
                    int index = action.getText().toString().length() - 1;
                    action.setText(action.getText().toString().substring(0, index));
                    setActionTextSize();
                } else if (action.getText().toString().equals("0.")) {
                    action.setText("");
                    setActionTextSize();
                }

                break;
            case R.id.button_armat:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                } else if (action.getText().toString().length() != 0) {
                    val1 = Double.parseDouble(action.getText().toString());
                    hystory.setText(ARMAT + action.getText().toString());
                    hystory.setText(ARMAT + String.valueOf(val1));

                    val1 = Math.sqrt(val1);

                    if ((String.valueOf(val1).length() > 6)) {
                        DecimalFormat df = new DecimalFormat("0.00000000##");
                        val1 = Double.parseDouble(df.format(val1));
                        setActionTextSize();
                        hystory.setText(hystory.getText().toString() + " = " + val1);
                        Log.i(TAG, "onClick: if ((String.format(\"%.0f\", val1).toString().length()) > 6) ");
                    }
                    else {
                        val1 = Double.parseDouble(action.getText().toString());
                        hystory.setText(ARMAT + action.getText().toString());
                        hystory.setText(ARMAT + String.valueOf(val1)+ " = " + Math.sqrt(val1));

                        val1 = Math.sqrt(val1);

                    }
//                    hystory.setText(hystory.getText().toString() + " = " + val1);
                    action.setText(null);
                } else if (action.getText().toString().length() == 0 && hystory.getText().toString().length() > 0) {
                    hystory.setText(ARMAT + String.valueOf(val1) + " = " + Math.sqrt(val1));
                    val1 = Math.sqrt(val1);
                }
                break;
            case R.id.button_tokos:
                if (action.getText().toString().equals("") && hystory.getText().toString().equals("")) {
                    Toast.makeText(this, "Wrong Action", Toast.LENGTH_LONG).show();
                    return;
                }
                if (operation()) {
                    compute();
                    ACTION = TOKOS;
                    hystory.setText(String.valueOf(val1) + TOKOS);
                    action.setText(null);

                    val2 = 0.0;
                    Log.i(TAG, "button_gumarum: if (operation())" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);
                } else {

                    //  action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    Toast.makeText(this, "val1 else==" + val1, Toast.LENGTH_SHORT).show();
                    compute();
                    ACTION = TOKOS;
                    hystory.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1) + TOKOS);
                    action.setText(null);
                    val2 = 0.0;
                    Log.i(TAG, "button_gumarum: else" + " val1 " + val1 + " val2 " + val2 + " ACTION " + ACTION);

                }
                break;
        }
    }


    private void compute() {
        Log.i(TAG, "compute: val1 " + val1);
        if (!Double.isNaN(val1)) {
            if (!action.getText().toString().equals("")) {
                val2 = Double.parseDouble(action.getText().toString());
                if (String.valueOf(val2).toString().length() > 12) {
                    val2 = Double.valueOf(String.format("%6.3e", val2));
                    Log.i("val2", "compute: val2 === = = = = = = >" + val2);
                }
                Log.i("ccc", "action.getText().toString()----->" + action.getText().toString());
                Log.i(TAG, "compute:  if (!action.getText().toString().equals(\"\"))" + " val1 " + val1 + " val2 " + val2);
            }
            Log.i(TAG, "compute: if (!Double.isNaN(val1)) " + " val1 " + val1 + " val2 " + val2);
            Toast.makeText(this, "vall====" + val1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "val2====" + val2, Toast.LENGTH_LONG).show();
            switch (ACTION) {


                case ADDITION:
                    if (action.getText().toString().length() != 0) {
                        val1 = val1 + val2;
                        Log.i(TAG, "compute: ADDITION val1 " + val1 + " val2 " + val2);
                    }
                    break;

                case SUBTRACTION:
                    if (action.getText().toString().length() != 0) {
                        val1 = val1 - val2;
                        Log.i(TAG, "compute: SUBTRACTION val1 " + val1 + " val2 " + val2);
                    }
                    break;

                case MULTIPLIKATION:
                    if (action.getText().toString().length() != 0) {
                        val1 = val1 * val2;
                        Log.i(TAG, "compute: MULTIPLIKATION val1 " + val1 + " val2 " + val2);
                        break;
                    }

                case DIVISION:
                    if (action.getText().toString().length() != 0) {
                        if (!action.getText().toString().equals("") && val2 != 0.0) {
                            val1 = val1 / val2;
                            Log.i(TAG, "compute: DIVISION val1 " + val1 + " val2 " + val2);
                        } else {
                            Toast.makeText(this, "Not division by zero", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case ARMAT:
                    if (val1 > 0) {
                        val1 = Math.sqrt(val1);
                    }
                    Log.i(TAG, "compute: ARMAT  val1 = " + val1);
                    break;
                case TOKOS:
                    if (val2 != 0) {
                        val1 = val1 * val2 / 100;
                    }
                    break;
                case EQUALS:
                    break;
            }

        } else {
            val1 = Double.valueOf(action.getText().toString());
            Log.i("compute", "compute: els---if---->");
            Log.i(TAG, "compute: else" + " val1 " + val1 + " val2 " + val2);
        }
    }


    private void setActionTextSize() {
        if (action.getText().toString().length() >= 13) {
            action.setTextSize(20);
        } else {
            action.setTextSize(50);
        }
    }

    private void setHystoryTextSize() {
        if (hystory.getText().toString().length() >= 10) {
            hystory.setTextSize(20);
        }
    }

    private boolean checksTheSimbolsCount() {
        boolean checked;
        String text = action.getText().toString();
        if (text.contains(".")
                && text.substring(text.indexOf(".")).length() > 10) {
            Toast.makeText(this, "Maximum number of digits after decimal point is 10", Toast.LENGTH_SHORT).show();
            checked = false;
        } else {
            checked = true;
        }
        return checked;
    }


    public boolean operation() {

        if (!hystory.getText().toString().endsWith("-") ||
                !hystory.getText().toString().endsWith("+") ||
                !hystory.getText().toString().endsWith("%") ||
                !hystory.getText().toString().endsWith("*") ||
                !hystory.getText().toString().endsWith("/")
                ) {
            // val2 = 0.0;

            act = true;

        } else if (hystory.getText().toString().endsWith("-") ||
                hystory.getText().toString().endsWith("+") ||
                hystory.getText().toString().endsWith("*") ||
                hystory.getText().toString().endsWith("%") ||
                hystory.getText().toString().endsWith("/")
                        && action.getText().toString().length() > 0) {
            act = false;
        }

        return act;
    }


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

    private void AstichanE() {
        if (String.valueOf(val1).toString().length() > 10) {
            val1 = Double.parseDouble(String.format("%6.3e", val1));

            Log.i("exponential", "AstichanE: val1=======" + val1);
        }
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
//        startActivity(i);
//        finish();
//    }
}