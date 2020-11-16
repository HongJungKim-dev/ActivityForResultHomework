package kr.ac.konkuk.activityforresult_201714283;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING=1;   //요청코드
    TextView text;   //첫번째 받을 string
    TextView text2;   //두번째 받을 string

    @Override
    public void onCreate(Bundle icicle) {   //레이아웃 생성
        super.onCreate(icicle);  //초기 컴포넌트 초기화
        setContentView(R.layout.activity_main);  //화면에 나타날 view가 담긴 xml파일을 불러와서 액티비티 설정

        Button button = (Button) findViewById(R.id.button);   //button 버튼아이디 저장
        text = (TextView) findViewById(R.id.text);   //text TextView아이디 저장
        text2 = (TextView) findViewById(R.id.text2);   //text TextView아이디 저장
        button.setOnClickListener(new View.OnClickListener() {   //button을 눌렀을때 동작

            @Override
            public void onClick(View v) {   //onClick방식
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);   //생성된 인텐트와 GET_STRING 요청코드 전송하여 SubActivity 띄움
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //Activity띄울때 전달했던 요청코드, 새로 띄운 SubActivity에서 전달받은 결과코드, 전달받은 인텐트로 결과 실행
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {   //요청코드가 GET_STRING이라면
            if (resultCode == RESULT_OK) {   //전달받은 결과 코드가 RESULT_OK이라면
                String[] extraList = data.getStringArrayExtra("INPUT_TEXT");   //"INPUT_TEXT이름을 가진 인텐트의 Extra배열을 저장
                text.setText(extraList[0]);   //전달받은 text를 출력
                text2.setText(extraList[1]);   //전달받은 text2를 출력
            }
        }
    }

}