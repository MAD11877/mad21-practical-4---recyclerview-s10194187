package sg.edu.np.s10194187_practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    User tom = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hello = findViewById(R.id.hello);
        TextView description = findViewById(R.id.description);
        Button followbtn = findViewById(R.id.followbtn);

/*
        tom.followed = false;
        tom.name = "MAD ";
        tom.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
*/

        description.setText(tom.description);

        Intent recievingEnd = getIntent();
        Integer id = recievingEnd.getIntExtra("Id", -1);

        ArrayList<User> userList = ListActivity.userList;
        for(User user: userList){
            if(user.getId() == id){
                tom = user;
            }
        }

        Integer message = recievingEnd.getIntExtra("randNum", 1);
        String name = recievingEnd.getStringExtra("Name");
        String desc =  recievingEnd.getStringExtra("Description");

        hello.setText(tom.getName());
        description.setText(tom.getDescription());

        if(tom.followed == true){
            followbtn.setText("Unfollow");
        } else {
            followbtn.setText("Follow");
        }




        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tom.followed == false){
                    followbtn.setText("Unfollow");
                    tom.followed = true;

                    Context context = getApplicationContext();
                    CharSequence text = "Followed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    followbtn.setText("Follow");
                    tom.followed = false;

                    Context context = getApplicationContext();
                    CharSequence text = "Unfollowed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                //update the arraylist
                ArrayList<User> userList = ListActivity.userList;
                for(int i = 0; i < userList.size(); i++){
                    if(userList.get(i).getId() == tom.getId()){
                        userList.set(i,tom); // update user follow status
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug","destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug","restart");
    }


}