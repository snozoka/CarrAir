package com.example.carrair;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.AmplifyModelProvider;

public class AmplifyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            // Add this line, to include the Auth plugin.
            //AmplifyModelProvider modelProvider = AmplifyModelProvider.getInstance();
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Tutorial", "Initialized Amplify");

            Amplify.Auth.fetchAuthSession(
                    result -> Log.i("AmplifyQuickstart", result.toString()),
                    error -> Log.e("AmplifyQuickstart", error.toString())
            );
        } catch (AmplifyException failure) {
            Log.e("Tutorial", "Could not initialize Amplify", failure);
        }
    }
}
