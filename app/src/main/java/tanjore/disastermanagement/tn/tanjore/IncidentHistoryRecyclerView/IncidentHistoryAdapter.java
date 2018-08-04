package tanjore.disastermanagement.tn.tanjore.IncidentHistoryRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tanjore.disastermanagement.tn.tanjore.IncidentClass;
import tanjore.disastermanagement.tn.tanjore.R;

public class IncidentHistoryAdapter extends RecyclerView.Adapter<IncidentHistoryViewholder> {

    View v;
    List<IncidentClass>data;
    public IncidentHistoryAdapter(List<IncidentClass> data){
        this.data = data;
    }
    @NonNull
    @Override
    public IncidentHistoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.incident_history_item,null,false);
        IncidentHistoryViewholder holder = new IncidentHistoryViewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull IncidentHistoryViewholder holder, int position) {
        holder.incidentName.setText("INCIDENT");
        holder.timeOfreport.setText("19:15");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
