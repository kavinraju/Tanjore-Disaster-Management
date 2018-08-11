package tanjore.disastermanagement.tn.tanjore.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import tanjore.disastermanagement.tn.tanjore.R;

public class ReportIncidentByGPSLocation extends Fragment implements View.OnClickListener {

    // Constants
    public static final String TAG = ReportIncidentByGPSLocation.class.getSimpleName();
    private static final int PERMISSIONS_REQUEST_FINE_LOCATION = 111;
    private static final int PLACE_PICKER_REQUEST = 1;

    private String[] incident_type_list = {"Incident 1","Incident 2","Incident 3","Incident 4","Incident 5"};

    //@BindView(R.id.spinner_incident_type)
    Spinner spinnerIncidentType;
    Button btn_place_picker;
    TextView txt_view_adress;

    private Context mContext;

    public ReportIncidentByGPSLocation() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_report_incident_by_gps, container, false);

        assert container != null;
        mContext = container.getContext();
        //ButterKnife.bind(rootView);
        spinnerIncidentType = rootView.findViewById(R.id.spinner_incident_type);
        btn_place_picker = rootView.findViewById(R.id.btn_place_picker);
        txt_view_adress = rootView.findViewById(R.id.txt_view_address);

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

                if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                            PERMISSIONS_REQUEST_FINE_LOCATION);
                    Toast.makeText(mContext,getResources().getString(R.string.location_permission_message), Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                    Intent i = builder.build(Objects.requireNonNull(getActivity()));
                    startActivityForResult(i, PLACE_PICKER_REQUEST);
                }catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Log.e(TAG, String.format("GooglePlayServices Not Available [%s]", e.getMessage()));
                } catch (Exception e) {
                    Log.e(TAG, String.format("PlacePicker Exception: %s", e.getMessage()));
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST && resultCode == Objects.requireNonNull(getActivity()).RESULT_OK) {
            Place place = PlacePicker.getPlace(mContext, data);
            if (place == null) {
                Log.i(TAG, "No place selected");
                return;
            }

            String placeName = place.getName().toString();
            String placeAddress = Objects.requireNonNull(place.getAddress()).toString();
            String placeID = place.getId();

            txt_view_adress.setText(placeName + "\n" + placeAddress);

        }
    }

}
