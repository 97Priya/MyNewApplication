package application.example.mynewapplication.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import application.example.mynewapplication.R;
import application.example.mynewapplication.adapters.RecyclerViewAdapter;
import application.example.mynewapplication.models.Contact;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView=findViewById(R.id.contact_rec);

        mLayoutManager=new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);


        Contact c1=new Contact("Priya","9728289343");
        Contact c2=new Contact("Mohit","9996440554");
        Contact c3=new Contact("Rajwanti","97206490157");
        Contact c4=new Contact("Balraj","925406490");
        ArrayList<Contact> FamilyContacts=new ArrayList<>();
        FamilyContacts.add(c1);
        FamilyContacts.add(c2);
        FamilyContacts.add(c3);
        FamilyContacts.add(c4);

        mAdapter=new RecyclerViewAdapter(FamilyContacts);
        mRecyclerView.setAdapter(mAdapter);

    }
}
