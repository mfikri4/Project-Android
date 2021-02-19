package com.example.go_ruqyah.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.go_ruqyah.Model.DataModel;
import com.example.go_ruqyah.View.Pesanruqyah;
import com.example.go_ruqyah.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listPeruqyah;


    public AdapterData(Context ctx, List<DataModel> listPeruqyah) {
        this.ctx = ctx;
        this.listPeruqyah = listPeruqyah;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_peruqyah, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listPeruqyah.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNamaperuqyah.setText(dm.getNama_peruqyah());
        holder.tvAlamatruqyah.setText(dm.getAlamat());
        holder.tvRatingperuqyah.setText(String.valueOf(dm.getRating()));

        holder.tvNamaperuqyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoDetail = new Intent(ctx, Pesanruqyah.class);
                GoDetail.putExtra("tvId", dm.getId());
                GoDetail.putExtra("tvNamaperuqyah", dm.getId());
                GoDetail.putExtra("tvAlamatruqyah", dm.getId());
                GoDetail.putExtra("tvRatingperuqyah", dm.getId());
                ctx.startActivity(GoDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPeruqyah.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId,tvNamaperuqyah,tvAlamatruqyah, tvRatingperuqyah;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNamaperuqyah = itemView.findViewById(R.id.tv_nama_peruqyah);
            tvAlamatruqyah = itemView.findViewById(R.id.tv_alamat_peruqyah);
            tvRatingperuqyah = itemView.findViewById(R.id.tv_rating_peruqyah);

        }
    }
}
