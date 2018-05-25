package com.midasit.challenge.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.midasit.challenge.application.ApplicationController;
import com.midasit.challenge.R;
import com.midasit.challenge.model.LoginRequestObject;
import com.midasit.challenge.model.LoginResponseObject;
import com.midasit.challenge.ui.main.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextInputLayout mTextInputUsername;
    private TextInputLayout mTextInputPassword;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginButton = view.findViewById(R.id.login_button);
        mTextInputUsername = view.findViewById(R.id.text_input_username);
        mTextInputPassword = view.findViewById(R.id.text_input_password);

        loginButton.setOnClickListener(v -> {

            String username = mTextInputUsername.getEditText().getText().toString().trim();
            String password = mTextInputPassword.getEditText().getText().toString().trim();

            LoginRequestObject loginRequsetObject = new LoginRequestObject(username,password);
            //TODO: 서버통신
            Call<LoginResponseObject> signUp = ApplicationController.getInstance().getNetworkService().login(loginRequsetObject);
            signUp.enqueue(new Callback<LoginResponseObject>() {
                @Override
                public void onResponse(Call<LoginResponseObject> call, Response<LoginResponseObject> response) {

                    if (response.isSuccessful()) {
                        LoginResponseObject responseObject = response.body();

                        mTextInputUsername.getEditText().setText("");
                        mTextInputPassword.getEditText().setText("");

                        mTextInputUsername.setError(null);
                        mTextInputPassword.setError(null);

                        //TODO:
                        startActivity(new Intent(getActivity(), MainActivity.class));

                        Log.d("AAA", "로그인 성공" + responseObject.token);
                        return;



                    } else {

                        int code = response.code();
                        if (code == 401) {
                            Toast.makeText(getContext(), "비밀번호가 틀렸습니다", Toast.LENGTH_LONG).show();
                            mTextInputUsername.getEditText().setText("");
                            mTextInputPassword.getEditText().setText("");
                            mTextInputPassword.getEditText().clearFocus();
                            Log.d("AAA", "로그인 아이디 비번 틀렸습니다");
                            return;
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginResponseObject> call, Throwable t) {
                    Log.d("AAA", t.getMessage());
                }
            });

        });
    }
}
