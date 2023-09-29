package com.tech.cablebill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustlistAdapter extends RecyclerView.Adapter<CustlistAdapter.ListHolder> {
    private final List<Customerlistplanet> mPlanetlist;
    String id;

    private static UserlistAdapter.onItemClick mListener;


    public CustlistAdapter(List<Customerlistplanet> mPlanetlist) {
        this.mPlanetlist = mPlanetlist;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.customerlist,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        id=mPlanetlist.get(position).getId();

        holder.Custname.setText(mPlanetlist.get(position).getCustomername());
        holder.Settopbox.setText(mPlanetlist.get(position).getSettopbox());
        holder.Phoneno.setText(mPlanetlist.get(position).getPhoneno());


    }

    @Override
    public int getItemCount() { return mPlanetlist.size(); }
    public void setOnItemClick(UserlistAdapter.onItemClick Listener)
    {
        this.mListener=Listener;
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        TextView id, Custname,Settopbox,Phoneno;

        public ListHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            Custname = (TextView) itemView.findViewById(R.id.tv_Custname);
            Settopbox = (TextView) itemView.findViewById(R.id.tv_Settopbox);
            Phoneno = (TextView) itemView.findViewById(R.id.tv_Phoneno);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        Customerlistplanet position = mPlanetlist.get(getAdapterPosition());
//                        mListener.onItemClickSelected(position);
                    }
                }
            });
        }


    }

}


