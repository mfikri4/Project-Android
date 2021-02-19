package com.example.aplikasinajwashop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aplikasinajwashop.DetailActivity;
import com.example.aplikasinajwashop.Model.DataModel;
import com.example.aplikasinajwashop.PembayaranActivity;
import com.example.aplikasinajwashop.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listBarang;

    public AdapterData(Context ctx, List<DataModel> listBarang) {
        this.ctx = ctx;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_awal, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listBarang.get(position);

        Glide.with(ctx).asBitmap().load(dm.getGambar()).into(holder.ivGambar);
        holder.tvNamabarang.setText(dm.getNama_barang());
        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNamabarang.setText(dm.getNama_barang());
        holder.tvDeskripsi.setText(dm.getDeskripsi());
        holder.tvHargabarang.setText(String.valueOf(dm.getHarga_barang()));




        holder.tvNamabarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Detail = new Intent(ctx, DetailActivity.class);
                Detail.putExtra("tv_id", dm.getId());
                Detail.putExtra("tv_nama_barang", dm.getNama_barang());
                Detail.putExtra("tv_deskripsi", dm.getDeskripsi());
                Detail.putExtra("tv_harga_barang", dm.getHarga_barang());;
                Detail.putExtra("iv_gambar",dm.getGambar());
                ctx.startActivity(Detail);


            }
        });

        holder.ivGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Checkout = new Intent(ctx, PembayaranActivity.class);
                Checkout.putExtra("tv_id", dm.getId());
                Checkout.putExtra("tv_nama_barang", dm.getNama_barang());
                Checkout.putExtra("tv_harga_barang", dm.getHarga_barang());
                ctx.startActivity(Checkout);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId,tvNamabarang,tvDeskripsi, tvHargabarang;
        ImageView ivGambar;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNamabarang = itemView.findViewById(R.id.tv_nama_barang);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvHargabarang = itemView.findViewById(R.id.tv_harga_barang);
            ivGambar = itemView.findViewById(R.id.iv_gambar);

        }

    }
}
