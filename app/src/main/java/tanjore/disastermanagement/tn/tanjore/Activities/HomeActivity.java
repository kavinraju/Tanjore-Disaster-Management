package tanjore.disastermanagement.tn.tanjore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import tanjore.disastermanagement.tn.tanjore.R;

import tanjore.disastermanagement.tn.tanjore.ReportIncident;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //NAVIGATION DRAWER AND TOOLBAR
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void buttonClicked(View v){
        switch (v.getId()) {

            case R.id.report_incident:
                startActivity(new Intent(HomeActivity.this, ReportIncident.class));
                Log.d("MSG", "report");
                break;
            case R.id.incident_history:
                startActivity(new Intent(HomeActivity.this, IncidentHistoryList.class));
                Log.d("MSG", "history");
                break;
            case R.id.emergency_num:

                Log.d("MSG", "emergency");
                break;
            case R.id.safety_tips:
                startActivity(new Intent(HomeActivity.this,SafetyTips.class));
                Log.d("MSG", "tips");
                break;
            case R.id.edit_account:
                startActivity(new Intent(HomeActivity.this,EditAccount.class));
                Log.d("MSG", "edit");
                break;
            case R.id.delete_account:

                Log.d("MSG", "delete");
                break;
            case R.id.help:

                Log.d("MSG", "help");
                break;
            case R.id.log_out:
                startActivity(new Intent(HomeActivity.this,LogIn.class));
                Log.d("MSG","LOG IN");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //RESTfulJerseyClient obj = new RESTfulJerseyClient();
            //obj.test();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
