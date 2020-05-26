package application.example.mynewapplication.activites;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import application.example.mynewapplication.R;
import application.example.mynewapplication.util.ConstantUtil;
import application.example.mynewapplication.util.SharedPrefUtil;

public class LandingActivity extends AppCompatActivity {

   private Button mLogoutBtn;
   private TextView mDisplayUser;
   private SharedPrefUtil mSharedPrefUtil;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        mLogoutBtn = findViewById(R.id.logout_btn);
        mDisplayUser = findViewById(R.id.loged_user);
        mSharedPrefUtil=new SharedPrefUtil(getApplicationContext());
       String str=mSharedPrefUtil.getSharedPrefUtil(ConstantUtil.MESSAGE_KEY);
       mDisplayUser.setText(str);
        mLogoutBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view)
            {
                // Creating explicit intent
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

}
