package com.example.scan;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scan.apihelper.list_kursi;

import java.util.ArrayList;
import java.util.List;

public class ad_kursi extends RecyclerView.Adapter<ad_kursi.MyViewHolder> {
    public interface ChnageStatusListener{
        void onItemChangeListener(int position, list_kursi model);
    }

    View v;
    List<list_kursi> daftarkursi;
    StringBuilder booked;
    Context context;
    ChnageStatusListener chnageStatusListener;

    public ad_kursi(List<list_kursi> contacts, Context context, StringBuilder booked) {
        this.daftarkursi = contacts;
        this.context = context;
        this.booked = booked;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kursi, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {
        list_kursi model=daftarkursi.get(i);

        if(model!=null){
            holder.cek.setText(model.getKursi());
            holder.position=i;

            String listBooked[] = booked.toString().split(" ");

            for(int j=0; j<listBooked.length; j++) {
                if( model.getKursi().equals( listBooked[j] )  ) {
                    holder.itemView.setEnabled(false);
                    holder.cek.setBackgroundColor(Color.parseColor("#E94818"));
                }
            }

            if(model.isSelect()){
                if(getSelected().size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j=0; j<getSelected().size(); j++) {
                        stringBuilder.append(getSelected().get(j).getKursi());
                        stringBuilder.append("\n");
                    }
                    Toast.makeText(context, stringBuilder.toString().trim(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, model.getKursi(), Toast.LENGTH_SHORT).show();
                }

                holder.itemView.setBackgroundColor(Color.parseColor("#8BC34A"));
            }
            else{
                holder.itemView.setBackgroundColor(Color.parseColor("#029DDE"));
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list_kursi model1=daftarkursi.get(i);
                if(model1.isSelect()){
                    model1.setSelect(false);
                }else{
                    model1.setSelect(true);
                }
                daftarkursi.set(holder.position,model1);
                if(chnageStatusListener!=null){
                    chnageStatusListener.onItemChangeListener(holder.position,model1);
                }
                notifyItemChanged(holder.position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return daftarkursi.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public int position;
        CheckBox cek;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cek = itemView.findViewById(R.id.kursi);
        }
    }

    public ArrayList<list_kursi> getSelected() {
        ArrayList<list_kursi> selected = new ArrayList<>();
        for(int i=0; i<daftarkursi.size(); i++) {
            if(daftarkursi.get(i).isSelect()) {
                selected.add(daftarkursi.get(i));
            }
        }
        return selected;
    }
}
