package com.example.carrair;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Flyer;
import com.amplifyframework.datastore.generated.model.Sender;
import com.example.carrair.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean signUpModeActive = false;
    TextView textViewSignUp;

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.textViewSignUp){

            Log.i("Switch", "was tapped ");
            Button signUpButton = findViewById(R.id.buttonLogin);

            if(signUpModeActive){
                signUpModeActive = false;
                signUpButton.setText("Sign up");
                textViewSignUp.setText("or Login");
            } else{
                signUpModeActive = true;
                signUpButton.setText("Login");
                textViewSignUp.setText("or Sign up");
            }
        }
    }

    public void signUpClicked(View view){
        EditText signUpEmail = findViewById(R.id.editTextLoginEmailAddress);
        EditText signUpPassword = findViewById(R.id.editTextLoginPassword);

        if(signUpEmail.getText().toString().matches("") || signUpPassword.getText().toString().matches("")){
            Toast.makeText(this,"A username and password is required",Toast.LENGTH_SHORT).show();
        }
        else {
            if(signUpModeActive){
                //Signup/register user
                signUpUser(signUpEmail.getText().toString(),signUpPassword.getText().toString());
                confirmSignUpCall(signUpEmail.getText().toString(),"1234");
            }else{
                //Login user
                SignInUser(signUpEmail.getText().toString(),signUpPassword.getText().toString());
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSignUp = findViewById(R.id.textViewSignUp);
        textViewSignUp.setOnClickListener(this);

        AuthUser currentUser = Amplify.Auth.getCurrentUser();

        Intent intent;
        if(currentUser == null){
            //Go to the login screen
            intent = new Intent(getApplicationContext(), LoginActivity.class);
        }
        else{
            //Go to the send item screen
            intent = new Intent(getApplicationContext(), SendItemActivity.class);
        }

        //Start activity
        startActivity(intent);
        finish();
//        Amplify.DataStore.observe(Sender.class,
//                started -> Log.i("Tutorial", "Observation began."),
//                change -> Log.i("Tutorial", change.item().toString()),
//                failure -> Log.e("Tutorial", "Observation failed.", failure),
//                () -> Log.i("Tutorial", "Observation complete.")
//        );
        createItem();


//        new AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Are you sure!?")
//                .setMessage("Do you want to continue with delete?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this, "It's done", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("No",null)
//                .show();
//
//
    }


    public void createItem (){
        Flyer item = Flyer.builder()
                .firstName("Alawna")
                .lastName("Jamison")
                .knownTravelerNumber("")
                .address("11053 Little Five Loop")
                .build();
        Amplify.DataStore.save(item,
                success -> Log.i("Tutorial", "Saved item: " + success.item().getFirstName() + success.item().getLastName()),
                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
        );
    }
    public void getSenderItem(){
        Amplify.DataStore.query(Sender.class,
                senderIterator -> {
                    while (senderIterator.hasNext()) {
                        Sender sender = senderIterator.next();

                        Log.i("Tutorial", "==== Todo ====");
                        Log.i("Tutorial", "Name: " + sender.getFirstName() + " "+ sender.getLastName());

                        if (sender.getAddress() != null) {
                            Log.i("Tutorial", "Address: " + sender.getAddress());
                        }
                    }
                },
                failure -> Log.e("Tutorial", "Could not query DataStore", failure)
        );
    }
    public void signUpUser(String signUpEmail, String signUpPassword){
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                //.userAttribute(AuthUserAttributeKey.email(), "my@email.com")
                .userAttribute(AuthUserAttributeKey.birthdate(), "")
                .build();
        Amplify.Auth.signUp(signUpEmail, signUpPassword, options,
                result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );
    }
    public void confirmSignUpCall(String signUpEmail, String signUpConfirmationCode){
        Amplify.Auth.confirmSignUp(
                signUpEmail,
                signUpConfirmationCode,
                result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }
    public void SignInUser(String signInEmail, String signInPassword){
        Amplify.Auth.signIn(
                signInEmail,
                signInPassword,
                result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.main_menu,menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        super.onOptionsItemSelected(item);
//
//        switch (item.getItemId()){
//            case R.id.settings:
//                Log.i("Selected item was: ", "Settings");
//                return true;
//            case R.id.help:
//                Log.i("Selected item was: ", "Help");
//                return true;
//            case R.id.profile:
//                Log.i("Selected item was: ", "Profile");
//                return true;
//            default:
//                return false;
//        }
//    }
}