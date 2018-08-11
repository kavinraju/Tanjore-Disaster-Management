package tanjore.disastermanagement.tn.tanjore.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tanjore.disastermanagement.tn.tanjore.R;

public class EditAccount extends AppCompatActivity {

    @BindView(R.id.textInput_name)
    TextInputLayout inputLayoutName;
    @BindView(R.id.textInput_phoneNumber)
    TextInputLayout inputLayoutPhoneNumber;
    @BindView(R.id.textInput_email)
    TextInputLayout inputLayoutEmail;
    @BindView(R.id.textInput_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.et_Name)
    EditText et_name;
    @BindView(R.id.et_phoneNumber)
    EditText et_phn_num;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_email)
    EditText et_email;
    @BindView(R.id.rb_male)
    RadioButton rb_male;
    @BindView(R.id.rb_female)
    RadioButton rb_female;
    @BindView(R.id.rb_other)
    RadioButton rb_other;
    @BindView(R.id.fab_update)
    FloatingActionButton fab_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void setUIComponents(){
        et_name.setText("");
        et_phn_num.setText("");
        et_password.setText("");
        et_email.setText("");

        if (rb_male.isChecked()){
            rb_male.isChecked();
        }else if (rb_female.isChecked()){
            rb_female.isChecked();
        }else if (rb_other.isChecked()){
            rb_other.isChecked();
        }
    }

    @OnClick(R.id.fab_update)
    public void onClickFabUpdateProfile(View view){

        Snackbar.make(view, "Updating Profile...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
