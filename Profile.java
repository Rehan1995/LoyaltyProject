package works.samarae.earnpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Profile extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }



    public void Import(View v){
        startActivity(new Intent(Profile.this,AddDetails.class));

    }

    public void Show(View v){
        startActivity(new Intent(Profile.this,UpdateDetails.class));

    }
    public void Update(View v){
        startActivity(new Intent(Profile.this,DeleteDetails.class));

    }
    public void Logout(View v){
        startActivity(new Intent(Profile.this,RetrieveDetails.class));

    }


}
