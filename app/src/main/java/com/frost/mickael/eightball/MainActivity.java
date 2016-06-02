package com.frost.mickael.eightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] _answers = new String[]{
            "It is certain",
            "It is decidedly so",
            "Without a doubt",
            "Yes, definitely",
            "You may rely on it",
            "As I see it, yes",
            "Most likely",
            "Outlook good",
            "Yes",
            "Signs point to yes",
            "Reply hazy try again",
            "Ask again later",
            "Better not tell you now",
            "Cannot predict now",
            "Concentrate and ask again",
            "Don't count on it",
            "My reply is no",
            "My sources say no",
            "Outlook not so good",
            "Very doubtful"
    };
    private Random _random;
    private String _previusText;

    private Button _actionBtn;
    private EditText _editText;
    private TextView _answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _actionBtn = (Button) findViewById(R.id.actionBtn);
        _editText = (EditText) findViewById(R.id.inputField);
        _answer = (TextView) findViewById(R.id.answ);
        _random = new Random();

        _actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = _editText.getText().toString();
                if (!currentText.equals(_previusText))
                    if (CheckLabelText()) {
                        _previusText = _editText.getText().toString();
                        _answer.setText(_answers[_random.nextInt(_answers.length) + 1]);
                    }
            }
        });
    }

    private boolean CheckLabelText() {
        return _editText.getText() != null ? true : false;
    }
}
