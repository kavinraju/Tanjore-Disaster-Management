package tanjore.disastermanagement.tn.tanjore.IncidentHistoryRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tanjore.disastermanagement.tn.tanjore.R;

public class IncidentHistoryViewholder extends RecyclerView.ViewHolder {

    TextView incidentName,timeOfreport;

    public IncidentHistoryViewholder(View itemView) {
        super(itemView);
        incidentName = itemView.findViewById(R.id.incident_name);
        timeOfreport = itemView.findViewById(R.id.incident_time);
    }
}
