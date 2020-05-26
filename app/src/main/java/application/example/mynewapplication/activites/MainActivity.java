package application.example.mynewapplication.activites;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import application.example.mynewapplication.R;
import application.example.mynewapplication.util.ConstantUtil;
import application.example.mynewapplication.util.SharedPrefUtil;


public class MainActivity extends AppCompatActivity {
    private Button mLoginBtn;
    private EditText mNameET;
    private SharedPrefUtil msharedPref;
    //app initializes the code that maintains the UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the user interface layout for this activity
        // the layout file is defined in the project res/layout/main_activity.xml file
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_SHORT).show();
        mLoginBtn = findViewById(R.id.login_button);
        mNameET = findViewById(R.id.user_name);
        mLoginBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view)
            {
                String userName=mNameET.getText().toString();
                msharedPref=new SharedPrefUtil(getApplicationContext());
                 msharedPref.setSharedPrefUtil(ConstantUtil.MESSAGE_KEY,userName);
                // Creating explicit intent
                Intent i = new Intent(getApplicationContext(), LandingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

            }
        });
    }
    // activity to enter the foreground and become interactive.

    //When the activity moves to the started state, any lifecycle-aware component
    // tied to the activity's lifecycle will receive the ON_START event.
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    //onCreate and onStart finishes quickly and contigously and then the activity goes to resume state
    //user interaction takes places at this stage
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
    }
    //as long as the activity is visible in multi-window system
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
    }
    //no longer visible to user
    // maintains all state and member information, but is not attached to the window manager.
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
    }


}
