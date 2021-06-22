package sg.edu.np.s10194187_practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
// using java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public static ArrayList<User> userList; //Global static variable, Not the best practice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        ImageView imageBtn = findViewById(R.id.imageBtn);
//
//        imageBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//                builder.setTitle("Profile");
//                builder.setMessage("MADness");
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//                        Random rand1 = new Random();
//
//                        int rand_int1 = rand1.nextInt();
//
//                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
//                        activityName.putExtra("randNum", rand_int1);
//                        startActivity(activityName);
//
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//
//                    }
//                });
//
//                AlertDialog alert = builder.create();
//                alert.show();
//
//            }
//        });

        userList = new ArrayList<>();

        for (int i=1; i<20; i++){
            User user = new User();
            Random r = new Random();
            int minNum = 100000000;
            int maxNum = 1000000000;
            int randNum = r.nextInt((maxNum-minNum) + 1) + minNum;
            int randNum2 = r.nextInt((maxNum-minNum) + 1) + minNum;
            String n = String.valueOf(randNum);
            String n1 = String.valueOf(randNum2);
            user.setName("Name" + n);
            user.setDescription("Description " + n1);
            user.setId(randNum);
            user.setFollowed(false);
            userList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);
        UserAdapter mAdapter =
                new UserAdapter(userList);

        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


    }


}