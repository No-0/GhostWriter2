package com.example.studentscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    static final int PORT=10001;// 나중에 수정
    String ip = "111.111.11.11";// 서버  ip주소

    Socket socket;     //클라이언트의 소켓
    DataInputStream is;
    DataOutputStream os;

    TextView receive_msg;  //서버로 부터 받은 메세지를 보여주는 TextView

    boolean isConnected=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.append("영호 바보ㅡㅠㅡ");// 글자 추가+ 추후에 소켓으로 받을때 더 추가

        //폰트 크기 설정
        Button FontUp = (Button)findViewById(R.id.font_up);
        FontUp.setOnClickListener(new View.OnClickListener() {
            TextView textView= (TextView)findViewById(R.id.textView);
            float textSize;
            @Override
            public void onClick(View v) {
                textSize = textView.getTextSize();
                if(textSize<60) {
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize+4);
                }
            }
        });

        Button FontDown = (Button)findViewById(R.id.font_down);
        FontDown.setOnClickListener(new View.OnClickListener() {
            float textSize;
            TextView textView= (TextView)findViewById(R.id.textView);
            @Override
            public void onClick(View v) {
                textSize = textView.getTextSize();
                if(textSize>10) {
                    textSize =textSize-4;
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
                }
            }
        });

    }


}
