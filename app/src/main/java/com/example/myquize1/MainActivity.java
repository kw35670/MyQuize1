package com.example.myquize1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView result;
    private RadioButton rdi_1;
    private RadioButton rdi_2;
    private RadioButton rdi_3;
    private RadioButton rdi_4;
    private Button finalAnswer;
    private RadioGroup rdi_grp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        question.setText("北海道情報大学が開学したのはいつですか");

        rdi_1 = findViewById(R.id.rdi_1);
        rdi_1.setText("1979年");

        rdi_2 = findViewById(R.id.rdi_2);
        rdi_2.setText("1984年");

        rdi_3 = findViewById(R.id.rdi_3);
        rdi_3.setText("1989年");

        rdi_4 = findViewById(R.id.rdi_4);
        rdi_4.setText("1994年");

        rdi_grp = (RadioGroup) findViewById(R.id.rdi_grp);
        result = findViewById(R.id.result);

        Button button = findViewById(R.id.finalAnswer);
        AtomicInteger checkedId = new AtomicInteger();

        button.setOnClickListener( v-> {
            checkedId.set(rdi_grp.getCheckedRadioButtonId());
            RadioButton radioButton = (RadioButton) findViewById(checkedId.get());
            String text = radioButton.getText().toString();

            if (text == "1989年") {
                result.setText("正解です");
            } else {
                result.setText("間違いです");
            }
        });
    }
}