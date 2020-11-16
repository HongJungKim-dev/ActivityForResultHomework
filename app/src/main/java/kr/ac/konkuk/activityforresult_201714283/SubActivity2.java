package kr.ac.konkuk.activityforresult_201714283;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    EditText edit;   //사용자 입력

    public void onCreate(Bundle savedInstanceState) {   //레이아웃 생성
        super.onCreate(savedInstanceState);   //초기 컴포넌트 초기화
        setContentView(R.layout.sub2);   //화면에 나타날 view가 담긴 xml파일을 불러와서 액티비티 설정

        edit = (EditText) findViewById(R.id.edit);   //edit EditText 아이디 저장
        Button button_ok = (Button) findViewById(R.id.button_ok);   //입력완료버튼 아이디 저장
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //입력완료버튼을 누른다면
                Intent intent = new Intent();  //보낼 인텐트 생성
                intent.putExtra("INPUT_TEXT2", edit.getText().toString());   //"INPUT_TEXT2"이름으로 사용자로부터 입력받은 내용을 string으로 변환하여 저장
                setResult(RESULT_OK,intent);   //RESULT_OK결과코드와 인텐트 전송
                finish();   //종료하고 이전액티비티로 돌아가기
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);   //취소버튼 아이디 저장
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //취소버튼을 누른다면
                setResult(RESULT_CANCELED);   //RESULT_CANCELED코드를 전송
                finish();   //종료하고 이전액티비티로 돌아가기
            }
        });
    }
}
