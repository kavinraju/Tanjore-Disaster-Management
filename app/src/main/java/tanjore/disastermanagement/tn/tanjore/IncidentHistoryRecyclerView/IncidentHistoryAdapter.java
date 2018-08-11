package tanjore.disastermanagement.tn.tanjore.IncidentHistoryRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tanjore.disastermanagement.tn.tanjore.Activities.IncidentHistoryList;
import tanjore.disastermanagement.tn.tanjore.Objects.IncidentClass;
import tanjore.disastermanagement.tn.tanjore.R;

public class IncidentHistoryAdapter extends RecyclerView.Adapter<IncidentHistoryAdapter.IncidentHistoryViewholder> {

    View v;
    List<IncidentClass>data;
    public IncidentHistoryAdapter(List<IncidentClass> data, IncidentItemClickListener itemClickListener){
        this.data = data;
        incidentItemClickListener = itemClickListener;
    }

    final private IncidentItemClickListener incidentItemClickListener;

    public interface IncidentItemClickListener {
        void onIncidentItemClick(int view_id ,int clickedItemIndex);
    }

    @NonNull
    @Override
    public IncidentHistoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.incident_history_item,parent,false);
        IncidentHistoryViewholder holder = new IncidentHistoryViewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull IncidentHistoryViewholder holder, int position) {
        holder.incidentName.setText(data.get(position).incidentName);
        holder.timeOfreport.setText(data.get(position).incidentTime);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // ViewHolder Class is here

    public class IncidentHistoryViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView incidentName,timeOfreport;
        CardView cardView;

        public IncidentHistoryViewholder(View itemView) {
            super(itemView);
            incidentName = itemView.findViewById(R.id.incident_name);
            timeOfreport = itemView.findViewById(R.id.incident_time);
            cardView = itemView.findViewById(R.id.cardview_incidentHistory);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            incidentItemClickListener.onIncidentItemClick(v.getId(),0);
        }
    }

}
