package sg.edu.np.s10194187_practical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView ppic2;
    ImageView ppic;
    TextView Name;
    TextView Description;
    public UserViewHolder(View itemView) {
        super(itemView);
        ppic2 = itemView.findViewById(R.id.ppic2);
        ppic = itemView.findViewById(R.id.ppic);
        Name = itemView.findViewById(R.id.Name);
        Description = itemView.findViewById(R.id.Description);
    }
}
