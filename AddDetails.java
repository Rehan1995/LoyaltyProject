package works.samarae.earnpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDetails extends AppCompatActivity implements View.OnClickListener{

    private Button savebutton;

    private EditText editfname;
    private EditText editlname;
    private EditText editYourNumber;
    private EditText editage;
    private EditText editsport;




    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);


        firebaseAuth = FirebaseAuth.getInstance();


        databaseReference = FirebaseDatabase.getInstance().getReference();


        savebutton = (Button) findViewById(R.id.SaveInformation);

        editfname = (EditText) findViewById(R.id.fname);
        editlname = (EditText) findViewById(R.id.lname);
        editYourNumber =(EditText) findViewById(R.id.editMobile);
        editage = (EditText)findViewById(R.id.age);
        editsport = (EditText)findViewById(R.id.sport) ;




        savebutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v== savebutton) {
            Savedetails();

        }
        startActivity(new Intent(AddDetails.this,Profile.class));

//        if( v == loadbutton){
//            loadData();
//        }

    }
//    private void addData() {
//
//        savebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                boolean isInserted = myDb.insertData(num.getText().toString());
//
//
//                if (isInserted == true) {
//                    Toast.makeText(AddDetails.this, "Number has been saved.", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(AddDetails.this, "Unable to save.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }

//    public void loadData() {
//        loadbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor result = myDb.getDate();
//                if (result.getCount() == 0) {
//                    showMessage("Error", "There are no numbers.");
//                } else {
//
//                    StringBuffer buff = new StringBuffer();
//                    while (result.moveToNext()) {
//                        buff.append("First name : " + result.getString(0) + "\n");
//                        buff.append("Last name  : " + result.getString(1) + "\n");
//                        buff.append("User's age : " + result.getString(2) + "\n");
//                        buff.append("User's mobile number: " + result.getString(3) + "\n");
//                        buff.append("blood type: " + result.getString(4) + "\n");
//                        buff.append("Allergies: " + result.getString(5) + "\n\n");
//                        buff.append("Number: " + result.getString(6) + "\n");
//                    }
//                    showMessage("User information:", buff.toString());
//                }
//            }
//        });
//
//    }

//    private void showMessage(String type, String msg) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(type);
//        builder.setMessage(msg);
//        builder.show();
//    }

    private void Savedetails(){

        String First_name = editfname.getText().toString().trim();
        if(TextUtils.isEmpty(First_name)){
            // first name  is empty
            Toast.makeText(this,"Hey please fill your first name",Toast.LENGTH_SHORT).show();
            return;
        }

        String Last_name = editlname.getText().toString().trim();
        if(TextUtils.isEmpty(Last_name)){
            // lastname is empty
            Toast.makeText(this,"Hey please fill your last name",Toast.LENGTH_SHORT).show();
            return;
        }

        String yourmobile = editYourNumber.getText().toString().trim();
        if(TextUtils.isEmpty(yourmobile)){
            // yourmobile is empty
            Toast.makeText(this,"Hey please fill your mobile number",Toast.LENGTH_SHORT).show();
            return;
        }

        String age = editage.getText().toString().trim();
        if(TextUtils.isEmpty(age)){
            // Age is empty
            Toast.makeText(this,"Hey please fill your age",Toast.LENGTH_SHORT).show();
            return;
        }

        String sportType = editsport.getText().toString().trim();
        if(TextUtils.isEmpty(age)){
            // Age is empty
            Toast.makeText(this,"Hey please fill your age",Toast.LENGTH_SHORT).show();
            return;
        }


        SaveClass save = new SaveClass(First_name,Last_name,yourmobile,age,sportType);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(save);

        Toast.makeText(this,"save information",Toast.LENGTH_SHORT).show();
    }

}
