package tanjore.disastermanagement.tn.tanjore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tanjore.disastermanagement.tn.tanjore.Fragments.ReportIncidentByAddress;
import tanjore.disastermanagement.tn.tanjore.Fragments.ReportIncidentByGPSLocation;

public class ReportIncident extends AppCompatActivity {

    @BindView(R.id.btn_report_by_address)
    Button btn_report_by_address;
    @BindView(R.id.btn_report_by_gps)
    Button btn_report_by_gps_location;

    //Constants
    private static String REPORT_BY_ADDRESS = "address";
    private static String REPORT_BY_GPS = "gps";
    private static String REPORT_BY_ADDRESS_FRAGMENT_KEY ="report_by_address_fragment";
    private static String REPORT_BY_GPS_FRAGMENT_KEY ="report_by_gps_fragment";
    private static String currentSelectedOption = REPORT_BY_ADDRESS;

    private FragmentManager fragmentManager;
    private ReportIncidentByAddress mReportIncidentByAddress;
    private ReportIncidentByGPSLocation mReportIncidentByGPSLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_incident);
        ButterKnife.bind(this);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null){

            mReportIncidentByAddress = (ReportIncidentByAddress) getSupportFragmentManager()
                    .getFragment(savedInstanceState, REPORT_BY_ADDRESS);
            mReportIncidentByGPSLocation = (ReportIncidentByGPSLocation) getSupportFragmentManager()
                    .getFragment(savedInstanceState, REPORT_BY_GPS);

            if (mReportIncidentByAddress == null){
                mReportIncidentByAddress = new ReportIncidentByAddress();
            }

            if (mReportIncidentByGPSLocation == null){
                mReportIncidentByGPSLocation = new ReportIncidentByGPSLocation();
            }

        }else {
            mReportIncidentByAddress = new ReportIncidentByAddress();
            mReportIncidentByGPSLocation = new ReportIncidentByGPSLocation();
        }

        fragmentManager = getSupportFragmentManager();

        if (currentSelectedOption.equals(REPORT_BY_ADDRESS)){
            fragmentManager.beginTransaction()
                    // Its been added to avoid Fragment is not currently in the FragmentManager
                    .add(R.id.container_for_report_incident, mReportIncidentByGPSLocation, REPORT_BY_GPS)
                    .replace(R.id.container_for_report_incident, mReportIncidentByAddress, REPORT_BY_ADDRESS)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit();
            Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
        }else if (currentSelectedOption.equals(REPORT_BY_GPS)){
            fragmentManager.beginTransaction()
                    .replace(R.id.container_for_report_incident, mReportIncidentByGPSLocation, REPORT_BY_GPS)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if ( getSupportFragmentManager().findFragmentByTag(REPORT_BY_ADDRESS).isAdded() ){
            getSupportFragmentManager().putFragment(outState, REPORT_BY_ADDRESS_FRAGMENT_KEY, mReportIncidentByAddress);
        }

        if ( getSupportFragmentManager().findFragmentByTag(REPORT_BY_GPS).isAdded() ){
            getSupportFragmentManager().putFragment(outState, REPORT_BY_GPS_FRAGMENT_KEY, mReportIncidentByGPSLocation);
        }

    }

    @OnClick(R.id.btn_report_by_address)
    public void onClickReportByAddress(View view){

        currentSelectedOption = REPORT_BY_ADDRESS;
        if(fragmentManager.findFragmentByTag(REPORT_BY_ADDRESS) instanceof ReportIncidentByAddress){
            mReportIncidentByAddress = (ReportIncidentByAddress) fragmentManager.findFragmentByTag(REPORT_BY_ADDRESS);
        }

        fragmentManager.beginTransaction()
                .replace(R.id.container_for_report_incident, mReportIncidentByAddress, REPORT_BY_ADDRESS)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();

        Log.d(ReportIncident.class.getSimpleName(), "onClickReportByAddress");
    }

    @OnClick(R.id.btn_report_by_gps)
    public void onClickReportByGPS(View view){

        currentSelectedOption = REPORT_BY_GPS;
        if(fragmentManager.findFragmentByTag(REPORT_BY_GPS) instanceof ReportIncidentByGPSLocation){
            mReportIncidentByGPSLocation = (ReportIncidentByGPSLocation) fragmentManager.findFragmentByTag(REPORT_BY_GPS);
        }

        fragmentManager.beginTransaction()
                .replace(R.id.container_for_report_incident, mReportIncidentByGPSLocation, REPORT_BY_GPS)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();

        Log.d(ReportIncident.class.getSimpleName(), "onClickReportByGPS");
    }


}
