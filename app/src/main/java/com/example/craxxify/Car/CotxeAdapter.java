package com.example.craxxify.Car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.craxxify.R;

import java.util.ArrayList;
import java.util.List;

public class CotxeAdapter extends RecyclerView.Adapter<CotxeAdapter.CotxeViewHolder> {

    private List<Cotxe> cotxeList = new ArrayList<>();
    private Context context;
    private int selected = -1;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void clearSelection() {
        selected = -1;
        notifyDataSetChanged();
    }
    private OnItemClickListener listener;

    private int selectedPosition = RecyclerView.NO_POSITION;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setCotxeList(List<Cotxe> cotxeList) {
        this.cotxeList = cotxeList;
        notifyDataSetChanged();
    }
    public void addCotxe(Cotxe cotxe) {
        cotxeList.add(cotxe);
        notifyItemInserted(cotxeList.size() - 1);
    }
    public CotxeAdapter(Context context, List<Integer> cotxeImages) {
        this.context = context;
        for (int image : cotxeImages) {
            cotxeList.add(new Cotxe(image));
        }
    }
    @NonNull
    @Override
    public CotxeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_car_recycler, parent, false);
        return new CotxeViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CotxeViewHolder holder, int position) {
        Cotxe cotxe = cotxeList.get(position);
        holder.cotxeIMG.setImageResource(cotxe.getId());
    }

    @Override
    public int getItemCount() {
        return cotxeList.size();
    }

    static class CotxeViewHolder extends RecyclerView.ViewHolder {
        ImageView cotxeIMG;

        public CotxeViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            cotxeIMG = itemView.findViewById(R.id.charImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
