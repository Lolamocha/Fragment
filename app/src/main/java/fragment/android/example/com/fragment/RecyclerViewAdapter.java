package fragment.android.example.com.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
   private  TextView nameElenco,surElenco;
    private Context mContext;
    private List<Elenco>mData;
    private Dialog myDialog;



    RecyclerViewAdapter(Context mContext, List<Elenco> mData) {

        this.mContext = mContext;
        this.mData = mData;


     }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
       // v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,parent,false);
        v = LayoutInflater.from(mContext).inflate(R.layout.custom_item,parent,false);
       final MyViewHolder viewHolder = new MyViewHolder(v);


       myDialog = new Dialog(mContext);
       myDialog.setContentView(R.layout.dialog_elenco);
       myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        ImageButton btnElenco = myDialog.findViewById(R.id.play_btn);
        btnElenco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "DO NOTHING !!",
                        Toast.LENGTH_LONG).show();
            }
        });

       viewHolder.customItem.setOnClickListener(new View.OnClickListener() {

           // sostituire il click listener con la freccia al click e no item

           @Override
           public void onClick(View v) {
               ImageView imgElenco;
               nameElenco = myDialog.findViewById(R.id.name_elenco);
               nameElenco.setText(mData.get(viewHolder.getAdapterPosition()).getName());
               surElenco =  myDialog.findViewById(R.id.sur_elenco);
               surElenco.setText(mData.get(viewHolder.getAdapterPosition()).getSurname());
               imgElenco =  myDialog.findViewById(R.id.img_elenco);
               imgElenco.setImageResource(mData.get(viewHolder.getAdapterPosition()).getPhoto());
               Toast.makeText(mContext,"Test Click"+String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
               myDialog.show();
           }
       });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtName.setText(mData.get(position).getName());
        holder.txtSurname.setText(mData.get(position).getSurname());
        holder.mImageView.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

     static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout customItem;
        private TextView txtName,txtSurname;
        private ImageView mImageView;

         MyViewHolder(View itemView) {
            super(itemView);

            customItem = itemView.findViewById(R.id.custom_item_id);
            txtName = itemView.findViewById(R.id.name);
            txtSurname = itemView.findViewById(R.id.surname);
            mImageView = itemView.findViewById(R.id.image);
        }


     }

}
