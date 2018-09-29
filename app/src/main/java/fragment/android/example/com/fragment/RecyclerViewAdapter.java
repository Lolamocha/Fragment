package fragment.android.example.com.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Elenco>mData;

    public RecyclerViewAdapter(Context mContext, List<Elenco> mData) {

        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.custom_item,parent,false);
        return new MyViewHolder(v);
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

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName,txtSurname;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.name);
            txtSurname = itemView.findViewById(R.id.surname);
            mImageView = itemView.findViewById(R.id.image);
        }
    }

}
