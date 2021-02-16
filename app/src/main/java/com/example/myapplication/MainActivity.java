package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.GuoFangPeng.GoogleLanguageList;
import com.github.GuoFangPeng.GoogleTranslateUtil;

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

        //等于 GoogleTranslateUtil.default_target_language="zh-CN";
        GoogleTranslateUtil.default_target_language= GoogleLanguageList.Chinese_simplified;
        GoogleTranslateUtil g=new GoogleTranslateUtil(this, (type, response) -> {
                mTxtResult.setText(response);
        });
        button.setOnClickListener(view -> {
            g.query(srctext.getText().toString());
//            g.query(srctext.getText().toString(),GoogleLanguageList.English,GoogleLanguageList.Chinese_simplified);
        });
    }
}