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
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DecimalFormat decimalFormat;
    private Button button1, button2,
            button3, button4, button5,
            button6, button7, button8,
            button9, button0, buttonAdd,
            buttonDivide, buttonSubtraction, buttonMultiplication,
            buttonEquals, buttonBack, buttonRoot,
            buttonPercent, buttonDot, buttonDelete;

    private TextView hystory;
    private EditText action;
    private double val1 = Double.NaN;
    private Double val2 = 0.0;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLIKATION = '*';
    private final char DIVISION = '/';
    private final char EQUALS = 0;
    private final char ROOT = '√';
    private final char PERCENT = '%';
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
                if (operation() == true) {
                    compute();
                    ACTION = ADDITION;
                    hystory.setText(String.valueOf(val1) + ADDITION);
                    action.setText(null);
                } else {
                    action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    hystory.setText(action.getText().toString() + ADDITION);
                    ACTION = ADDITION;
                    compute();
                    action.setText(null);
                }
                break;
            case R.id.button_hanum:
                if (operation() == true) {
                    compute();
                    ACTION = SUBTRACTION;
                    hystory.setText(String.valueOf(val1) + SUBTRACTION);
                    action.setText(null);
                } else {
                    action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    hystory.setText(null);
                    compute();
                    ACTION = SUBTRACTION;
                    hystory.setText(action.getText().toString() + SUBTRACTION);
                    action.setText(null);
                }
                break;
            case R.id.button_bajanum:
                if (operation() == true) {
                    compute();
                    ACTION = DIVISION;
                    hystory.setText(String.valueOf(val1) + DIVISION);
                    action.setText(null);
                } else {
                    action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    hystory.setText(null);
                    ACTION = DIVISION;
                    compute();
                    hystory.setText(action.getText().toString() + DIVISION);
                    action.setText(null);
                }
                break;
            case R.id.button_bazmapatkum:
                if (operation() == true) {
                    compute();
                    ACTION = MULTIPLIKATION;
                    hystory.setText(String.valueOf(val1) + MULTIPLIKATION);
                    action.setText(null);
                } else {
                    action.setText(hystory.getText().toString().substring(0, hystory.getText().toString().length() - 1));
                    hystory.setText(null);
                    compute();
                    ACTION = MULTIPLIKATION;
                    hystory.setText(action.getText().toString() + MULTIPLIKATION);
                    action.setText(null);
                }
                break;
            case R.id.button_havasar:
                Log.i("havasar", "onClick: " + hystory.getText().toString());
                if (hystory.getText().toString().endsWith("-") ||
                        hystory.getText().toString().endsWith("+") ||
                        hystory.getText().toString().endsWith("*") ||
                        hystory.getText().toString().endsWith("/") &&
                                !hystory.getText().toString().contains("WRONG FORMAT")
                        ) {
                    Log.i("wrong", "onClick: arachin if------ ");
                    compute();
                    ACTION = EQUALS;
                    hystory.setText(hystory.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                    action.setText(null);
                    val2 = 0.0;
                    if ((String.format("%.0f", val1).toString().length()) > 10) {
                        setActionTextSize();
                        action.setText(String.valueOf(val1));
                        Toast.makeText(this, "" + val1, Toast.LENGTH_SHORT).show();
                    }
                } else if (hystory.getText().toString().contains("WRONG FORMAT")) {
                    Log.i("wrong", "onClick: else if erkrord------ ");
                    hystory.setText(hystory.getText().toString());
                } else if (val2 != null &&
                        hystory.getText().toString().endsWith("+") ||
                        hystory.getText().toString().endsWith("-") ||
                        hystory.getText().toString().endsWith("*") ||
                        hystory.getText().toString().endsWith("/")) {
                    Log.i("wrong", "onClick: errord else if------ ");
                    hystory.setText(hystory.getText().toString() + " WRONG FORMAT ");
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
                action.setText(action.getText() + "√");
                break;
            case R.id.button_tokos:
                compute();
                ACTION = PERCENT;
                hystory.setText(String.valueOf(val1) + "%");
                action.setText(null);
                break;
        }
    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            if (!action.getText().toString().isEmpty()) {
                val2 = Double.valueOf(action.getText().toString());
            }
            Toast.makeText(this, "vall====" + val1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "val2====" + val2, Toast.LENGTH_LONG).show();
            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLIKATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case ROOT:
                    if (val1 > 0) {
                        val1 = Math.sqrt(val1);
                    }
                    break;
                case PERCENT:
                    val1 = val1 * val2 / 100;
                    break;
                case EQUALS:
                    //action.setText(""+result);
                    break;
            }
        } else if (!Double.isNaN(val1) && operation() == false) {
            val1 = Double.valueOf(hystory.getText().toString().substring(0,
                    hystory.getText().toString().length() - 1));
        } else {
            val1 = Double.valueOf(action.getText().toString());
        }
    }

    private void setActionTextSize() {
        if (action.getText().toString().length() >= 13) {
            action.setTextSize(25);
        } else {
            action.setTextSize(50);
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
        if (hystory.getText().toString().length() > 0 &&
                !hystory.getText().toString().endsWith("-") ||
                !hystory.getText().toString().endsWith("+") ||
                !hystory.getText().toString().endsWith("*") ||
                !hystory.getText().toString().endsWith("/")
                ) {
            act = true;
        } else if (hystory.getText().toString().endsWith("-") ||
                hystory.getText().toString().endsWith("+") ||
                hystory.getText().toString().endsWith("*") ||
                hystory.getText().toString().endsWith("/")) {
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
        buttonAdd = findViewById(R.id.button_gumarum);
        buttonDivide = findViewById(R.id.button_bajanum);
        buttonSubtraction = findViewById(R.id.button_hanum);
        buttonMultiplication = findViewById(R.id.button_bazmapatkum);
        buttonEquals = findViewById(R.id.button_havasar);
        buttonRoot = findViewById(R.id.button_armat);
        buttonDot = findViewById(R.id.button_double_id);
        buttonBack = findViewById(R.id.button_back_id);
        buttonDelete = findViewById(R.id.button_delete_id);
        buttonPercent = findViewById(R.id.button_tokos);
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
        buttonAdd.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonRoot.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
    }
}