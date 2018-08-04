package tanjore.disastermanagement.tn.tanjore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportIncident extends AppCompatActivity {

    private String[] district_list = { "Tanjore" , "Trichy", "Chennai" , "Madurai" };

    private String[] taluk_list = {"Taluk 1","Taluk 2","Taluk 3","Taluk 4","Taluk 5"};

    private String[] village_list = {"Village 1","Village 2","Village 3","Village 4","Village 5"};

    @BindView(R.id.spinner_district)
    Spinner spinnerDistrict;
    @BindView(R.id.spinner_taluk)
    Spinner spinnerTaluk;
    @BindView(R.id.spinner_village)
    Spinner spinnerVillage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_incident);
        ButterKnife.bind(this);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerDistrict = findViewById(R.id.spinner_district);
        spinnerTaluk = findViewById(R.id.spinner_taluk);
        spinnerVillage = findViewById(R.id.spinner_village);

        setSpinnerAdapter(district_list, spinnerDistrict);
        setSpinnerAdapter(taluk_list, spinnerTaluk);
        setSpinnerAdapter(village_list, spinnerVillage);


    }

    private void setSpinnerAdapter(String[] list, Spinner spinner){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , R.layout.spinner_list , list);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
}
