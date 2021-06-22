package sg.edu.np.s10194187_practical2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> userList;

    public UserAdapter(ArrayList<User> input) {
        userList = input;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.user_view_2,
                parent,
                false);

        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
         User u = userList.get(position);
         holder.Name.setText(u.getName());
         holder.Description.setText((u.description));

         //Checking if the last character in the name is 7
         if(u.getName().charAt(u.getName().length()-1) == '7'){
             holder.ppic2.setVisibility(View.VISIBLE);
         } else {
             holder.ppic2.setVisibility(View.GONE);
         }

         holder.ppic.setOnClickListener(new View.OnClickListener(){
             public void onClick(View V)
             {
                 AlertDialog.Builder builder = new AlertDialog.Builder(V.getContext());

                 builder.setTitle("Profile");
                 builder.setMessage(u.name);
                 builder.setCancelable(false);
                 builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                     public void onClick(DialogInterface dialog, int id){
                         Intent v = new Intent(V.getContext(), MainActivity.class);

                         Bundle extras = new Bundle();
                         extras.putInt("Id", u.getId());
                         v.putExtras(extras);
                         V.getContext().startActivity(v);
                     }

                 });
                 builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                     public void onClick(DialogInterface dialog, int id){
                     }
                 });

                 builder.show();

             }
         });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }



//    @Override
//    @NonNull
//    public UserViewHolder onCreateViewHolder(
//            ViewGroup parent,
//            int viewType) {
//        View item = LayoutInflater.from(parent.getContext()).inflate(
//                android.R.layout.user_view,
//                parent,
//                false);
//
//        return new UserViewHolder(item);
//    }
//
//    @Override
//    public void onBindViewHolder(
//            UserViewHolder holder,
//            int position) {
//    }
//
//    public int getItemCount(){
//        return userList.size();
//    }
//
//    //used to decide which layout to use
//    @Override
//    public int getItemViewType(int position) {
//        if(data.get(position).getAge() % 3 == 0)
//            return 0;
//        return 1;
//    }
}