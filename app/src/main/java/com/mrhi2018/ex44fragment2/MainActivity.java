package com.mrhi2018.ex44fragment2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //동적으로 Fragment를 추가하기..
        //id값을 R.id.container로 설정한 LinearLayout에 추가

        //프레그먼트를 동적으로 추가하려면 프레그먼트관리자 객체에게
        //모든 작업을 요청해야함.
        //즉, 프레그먼트는 제어하는 모든 작업은 이 매니저 객체에게 요청해야함
        FragmentManager fragmentManager= getSupportFragmentManager();

        //동적제어의 종류 : 추가(add), 제거(remove), 재배치(replace)
        MyFragment frag= new MyFragment();


        //프레그먼트 이런 작업을 수행할 때 Transaction이라는 작업단위로 처리함
        //트랜잭션(Transaction): 롤백기능이 있는 프로세스
        FragmentTransaction tran= fragmentManager.beginTransaction();

        //프레그먼트를 추가하면서 값 전달하기(선택구현)
        Bundle bundle= new Bundle(); //데이터를 보관하는 보따리!!
        bundle.putString("Name", "홍길동");
        bundle.putInt("Age", 20);
        frag.setArguments(bundle);

        //가상의 작업들 시작
        tran.add(R.id.container, frag);

        //프레그먼트를 액티비티처럼 BackStack(백스택)에 추가
        //뒤로가기버튼을 눌렀을때 액티비티가 종료되지 않고 이전
        //프레그먼트가 보여짐
        tran.addToBackStack(null);

        //가상작업을 실제로 반영하기(Transaction 완료)
        tran.commit();

    }
}
