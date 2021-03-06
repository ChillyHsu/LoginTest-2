package com.example.user.logintest;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton = (LoginButton)findViewById(R.id.fb_login_bn);
        textView = (TextView)findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,CheckpersonActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
                //這裡應該要乎告另一個頁面
                // textView.setText("Login Succuess. Welcome~~");
               // String UserId = loginResult.getAccessToken().getUserId() 這個是那個用戶的id 但是似乎無法放這裡
               // String token = loginResult.getAccessToken().getToken();  這個是那個用戶的token(還要查查是啥，但是應該是相關基本資料吧?
                //旅客版首頁
                //Button button01 = (Button)findViewById(R.id.Button01);
                //button01.setOnClickListener(new Button.OnClickListener(){

                 //   public void onClick(View v) {
                        // TODO Auto-generated method stub
                    //    jumpToLayout01();
                  //  }
                //});
                //導遊版首頁
               // Button button02 = (Button)findViewById(R.id.Button02);
                //button02.setOnClickListener(new Button.OnClickListener(){

//                    public void onClick(View v) {
 //                       // TODO Auto-generated method stub
  //                      jumpToLayout02();
   //                 }
    //            });
            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                textView.setText("Login Error");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
