package com.example.alex.hiproj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.annotation.Target;

import static android.view.View.*;

// Activity: A rectangular area that displays something. think of UI
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hiButton = (Button) findViewById(R.id.hiButton);

        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // - Intent: An action being requested that the device should try to performe
                // - IntentService: Services that can handle intent requests and process the work to be done
                // - BroadcastReceivers: Receives an intent from a sendBroadcast method offten indicating that
                // some wrok has been completed
                // - When you use an explicit intent, intent resolution is straightforward.
                // The intent explicitly says which component the intent is directed
                // at, so Android has clear instructions about what to do.
//                An explicit intent specifies the component the intent is targeted at. You create an explicit intent using
//                Intent intent = new Intent(this, Target.class);
//                - When you use an implicit intent, Android uses the information in the
//                intent to figure out which components are able to receive it. It does this
//                by checking the intent filters in every app’s copy of AndroidManifest.xml.
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//                Use the get*Extra() methods to retrieve extra information associated with the intent.
//                        getStringExtra() retrieves a String, getIntExtra() retrieves an int, and so on
                intent.putExtra("myMessage", "Hello, World");
                startActivity(intent);
            }
        });


        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        // ctrl+shift+up = mv
        // ctrl+y = del
        // ctrl + / = comment
        // ctrl + h = show hierarchy
        googleBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // why use intent:  One of the reasons is that passing intents
//                to Android tells Android the sequence in which activities are
//                started. This means that when you click on the Back button on
//                your device, Android knows exactly where to take you back to
                // also ACTION_DIAL, ACTION_SEND
                // implicit intent means android needs to find out who can do it
//                To create an implicit intent that specifies an action, use Intent intent = new Intent(action);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }
}


//    On your device, open “Developer options” (in Android 4.0
//        onward, this is hidden by default). To enable “Developer
//        options,” go to Settings → About Phone and tap the build
//        number seven times. When you return to the previous
//        screen, you should now be able to see “Developer options.”