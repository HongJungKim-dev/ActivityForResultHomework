package kr.ac.konkuk.activityforresult_201714283;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    static final int GET_STRING=1;   //요청코드
    EditText edit;   //1차로 받을 입력
    EditText edit2;   //2차로 받을 입력

    public void onCreate(Bundle savedInstanceState) {   //레이아웃 생성
        super.onCreate(savedInstanceState);   //초기 컴포넌트 초기화
        setContentView(R.layout.sub);   //화면에 나타날 view가 담긴 xml파일을 불러와서 액티비티 설정

        edit = (EditText) findViewById(R.id.edit);   //edit EditText 아이디 저장
        edit2 = (EditText) findViewById(R.id.edit2);   //edit2 EditText 아이디 저장
        Button button_ok = (Button) findViewById(R.id.button_ok);   //2차 데이터입력 버튼 아이디 저장
        Button button_ok2 = (Button) findViewById(R.id.button_ok2);  //입력완료 버튼 아이디 저장
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //입력완료 누른다면
                String[] extraList = new String[2];   //보낼 extra배열 생성
                Intent intent = new Intent();   //보낼 인텐트 생성

                extraList[0] = edit.getText().toString();   //1차로 받은 입력을 extra배열 첫번째 공간에 저장
                extraList[1] = edit2.getText().toString();   //2차로 받은 입력을 extra배열 두번째 공간에 저장

                intent.putExtra("INPUT_TEXT", extraList);   //인텐트에 보내는 이름과 extra들이 들어있는 배열 저장
                setResult(RESULT_OK,intent);   //RESUlT_OK결과코드와 인텐트 보내기
                finish();   //종료하고 이전 액티비티로
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //취소를 누른다면
                setResult(RESULT_CANCELED);   //RESUlT_CANCELED결과코드 보내기
                finish();   //종료하고 이전 액티비티로
            }
        });

        button_ok2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {   //2차 데이터입력 버튼 누른다면
                Intent in = new Intent(SubActivity.this, SubActivity2.class);   //띄울 인텐트 생성
                startActivityForResult(in, GET_STRING);   //인텐트와 GET_STRING요청코드 보내어 새로운 SubActivity2 띄우기
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data2) {   //Activity띄울때 전달했던 요청코드, 새로 띄운 SubActivity에서 전달받은 결과코드, 전달받은 인텐트로 결과 실행
        super.onActivityResult(requestCode, resultCode, data2);
        if (requestCode == GET_STRING) {   //요청코드가 GET_STRING이라면
            if (resultCode == RESULT_OK) {   //전달받은 결과 코드가 RESULT_OK이라면
                edit2.setText(data2.getStringExtra("INPUT_TEXT2"));   //2차로 입력한 곳에 입력결과 출력
            }
        }
    }
}
