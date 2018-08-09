package tanjore.disastermanagement.tn.tanjore.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tanjore.disastermanagement.tn.tanjore.Objects.IncidentClass;
import tanjore.disastermanagement.tn.tanjore.IncidentHistoryRecyclerView.IncidentHistoryAdapter;
import tanjore.disastermanagement.tn.tanjore.R;

public class IncidentHistoryList extends AppCompatActivity {


    List<IncidentClass> fakeData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_history_list);

        //RECYCLER VIEW
        RecyclerView incidentHistory = findViewById(R.id.incident_history_list);
        dummyData();
        IncidentHistoryAdapter myAdapter = new IncidentHistoryAdapter(fakeData);
        incidentHistory.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        incidentHistory.setLayoutManager(layoutManager);
    }

    private void dummyData(){
        for(int i=0;i<10;i++){
            IncidentClass temp = new IncidentClass();
            temp.incidentName = "Incident "+i;
            temp.incidentTime = "Time "+i;
            fakeData.add(temp);
        }
    }
}
