package application.example.mynewapplication.activites;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import application.example.mynewapplication.R;

public class CameraActivity extends AppCompatActivity {
    private Button mCaptureBtn;
    private ImageView mMyPhoto;
    private final int CAM_CODE=69;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        mCaptureBtn =findViewById(R.id.capture_btn);
        mMyPhoto=findViewById(R.id.img_view);
        mCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAM_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==CAM_CODE){
                Bitmap bitmap=(Bitmap) data.getExtras().get("data");
                Log.d("uri",bitmap.toString());
                mMyPhoto.setImageBitmap(bitmap);
            }
        }

    }
}
