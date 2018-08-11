package tanjore.disastermanagement.tn.tanjore.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import tanjore.disastermanagement.tn.tanjore.R;

public class ReportIncidentByAddress extends Fragment {

    private String[] district_list = { "Tanjore" , "Trichy", "Chennai" , "Madurai" };

    private String[] taluk_list = {"Taluk 1","Taluk 2","Taluk 3","Taluk 4","Taluk 5"};

    private String[] village_list = {"Village 1","Village 2","Village 3","Village 4","Village 5"};

    //@BindView(R.id.spinner_district)
    Spinner spinnerDistrict;
    //@BindView(R.id.spinner_taluk)
    Spinner spinnerTaluk;
    //@BindView(R.id.spinner_village)
    Spinner spinnerVillage;


    public ReportIncidentByAddress() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_report_incident_by_address, container, false);

        spinnerDistrict = rootView.findViewById(R.id.spinner_district);
        spinnerTaluk = rootView.findViewById(R.id.spinner_taluk);
        spinnerVillage = rootView.findViewById(R.id.spinner_village);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        setSpinnerAdapter(district_list, spinnerDistrict);
        setSpinnerAdapter(taluk_list, spinnerTaluk);
        setSpinnerAdapter(village_list, spinnerVillage);
    }

    private void setSpinnerAdapter(String[] list, Spinner spinner){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.spinner_list , list);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
}
