package com.example.carrair.ui.login;

import android.app.Activity;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Amplify;
import com.example.carrair.R;
import com.example.carrair.SendItemActivity;
import com.example.carrair.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.carrair.databinding.ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.usernameEditText;
        final EditText passwordEditText = binding.passwordEditText;
        final Button loginButton = binding.loginButton;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            loginButton.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                usernameEditText.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                passwordEditText.setError(getString(loginFormState.getPasswordError()));
            }
        });

        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult == null) {
                return;
            }
            loadingProgressBar.setVisibility(View.GONE);
            if (loginResult.getError() != null) {
                showLoginFailed(loginResult.getError());
            }
            if (loginResult.getSuccess() != null) {
                updateUiWithUser(loginResult.getSuccess());
            }
            setResult(Activity.RESULT_OK);

            //Complete and destroy login activity once successful
            finish();
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
            return false;
        });

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            loginViewModel.login(usernameEditText.getText().toString(),
                    passwordEditText.getText().toString());
        });
    }

    public void onPressLogin(View view) {
        EditText textUsername = findViewById(R.id.usernameEditText);
        EditText textPassword = findViewById(R.id.passwordEditText);

        SignInUser(textUsername.getText().toString(),textPassword.getText().toString());
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    public void SignInUser(String signInEmail, String signInPassword){
        Amplify.Auth.signIn(
                signInEmail,
                signInPassword,
                this::onLoginSuccess,
                this::onLoginError
                //result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                //error -> Log.e("AuthQuickstart", error.toString())
        );
    }

    private void onLoginError(AuthException e) {
        this.runOnUiThread(() -> {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        });

    }

    private void onLoginSuccess(AuthSignInResult authSignInResult) {
        //Go to 'SendItemActivity Screen'
        Intent intent = new Intent(this, SendItemActivity.class);
        startActivity(intent);
    }
}