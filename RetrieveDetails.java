package works.samarae.earnpoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RetrieveDetails extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView myListView;

    private ArrayList<String>mlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_details);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        myListView = (ListView)findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mlist);

    }
}
