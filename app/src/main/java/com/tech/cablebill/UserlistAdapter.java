package com.tech.cablebill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class UserlistAdapter extends RecyclerView.Adapter<UserlistAdapter.ListHolder> {
    private final List<Planet_route> mPlanetlist;
//    List<Planet_route>  cplanetlist= new ArrayList<Planet_route>();
    String id;


    private static onItemClick mListener;

    public UserlistAdapter(List<Planet_route> mPlanetlist) {
        this.mPlanetlist = mPlanetlist;

    }

    public interface onItemClick
    {
        void onItemClickSelected(Planet_route planet);

    }

    @NonNull
    @Override
    public UserlistAdapter.ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.userlist,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserlistAdapter.ListHolder holder, int position) {
        id=mPlanetlist.get(position).getId();

        holder.Routename.setText(mPlanetlist.get(position).getRoutename());



    }

    @Override
    public int getItemCount() {
        return mPlanetlist.size();
    }
    public void setOnItemClick(onItemClick Listener)
    {
        this.mListener=Listener;
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        TextView id, Routename;

        public ListHolder(@NonNull @NotNull View itemView) {
            super(itemView);
//          id=(TextView)itemView.findViewById() ;
             Routename = (TextView) itemView.findViewById(R.id.tv_routename);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        Planet_route position = mPlanetlist.get(getAdapterPosition());
                        mListener.onItemClickSelected(position);
                    }
                }
            });
        }


    }}
