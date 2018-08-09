package tanjore.disastermanagement.tn.tanjore.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import tanjore.disastermanagement.tn.tanjore.R;

public class ReportIncidentByGPSLocation extends Fragment implements View.OnClickListener {

    private String[] incident_type_list = {"Incident 1","Incident 2","Incident 3","Incident 4","Incident 5"};

    //@BindView(R.id.spinner_incident_type)
    Spinner spinnerIncidentType;
    Button btn_place_picker;

    public ReportIncidentByGPSLocation() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_report_incident_by_gps, container, false);

        //ButterKnife.bind(rootView);
        spinnerIncidentType = rootView.findViewById(R.id.spinner_incident_type);
        btn_place_picker = rootView.findViewById(R.id.btn_place_picker);

        setSpinnerAdapter(incident_type_list, spinnerIncidentType);
        btn_place_picker.setOnClickListener(this);

        return rootView;
    }

    private void setSpinnerAdapter(String[] list, Spinner spinner){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.spinner_list , list);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_place_picker:

                break;
        }
    }
}
