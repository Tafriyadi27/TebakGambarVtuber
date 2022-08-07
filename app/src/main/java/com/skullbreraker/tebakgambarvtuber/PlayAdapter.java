package com.skullbreraker.tebakgambarvtuber;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skullbreraker.tebakgambarvtuber.model.VtuberModel;

import java.util.List;

public class PlayAdapter extends RecyclerView.Adapter<PlayAdapter.PlayViewHolder> {
    private final Context context;
    private List<VtuberModel> levelList;

    @SuppressLint("NotifyDataSetChanged")
    public void setLevelList(List<VtuberModel> levelList) {
        this.levelList = levelList;
        notifyDataSetChanged();
    }

    public PlayAdapter(Context context){this.context = context;;}

    @NonNull
    @Override
    public PlayAdapter.PlayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_play,parent,false);
        return new PlayAdapter.PlayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayAdapter.PlayViewHolder holder, int position) {
        holder.btnlevel.setText(this.levelList.get(position).getLevelIdLevel().toString());
        holder.btnlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(context, LevelActivity.class);
                intent.putExtra("level",levelList.get(holder.getAdapterPosition()).getLevelIdLevel().toString());
                intent.putExtra("images",levelList.get(holder.getAdapterPosition()).getImage());
                context.startActivity(intent);
            }
        });
        Log.d("level", levelList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        if(levelList != null){
            return levelList.size();
        }

        return 0;
    }

    public class PlayViewHolder extends RecyclerView.ViewHolder {
        Button btnlevel;
        public PlayViewHolder(@NonNull View itemView) {
            super(itemView);
            btnlevel = itemView.findViewById(R.id.btnlevel);
        }
    }
}
