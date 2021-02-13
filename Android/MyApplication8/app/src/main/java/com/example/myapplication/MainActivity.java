package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.user969335755.GoogleTranslateUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtResult;
    private EditText srctext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtResult = findViewById(R.id.actual_result);
        srctext = findViewById(R.id.ed_text);
        Button button = findViewById(R.id.btn_call_api);

        GoogleTranslateUtil g=new GoogleTranslateUtil(this, (type, response) -> {
            mTxtResult.post(() -> {     //一定要post 回到主进程  方式随意  但一定要回到主进程
                mTxtResult.setText(response);
            });
        });
        button.setOnClickListener(view -> {
            g.query(srctext.getText().toString().replaceAll("\r|\n", " "));
        });
    }
}