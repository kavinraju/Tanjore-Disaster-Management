package tanjore.disastermanagement.tn.tanjore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tanjore.disastermanagement.tn.tanjore.R;

public class RegistrationActivity extends AppCompatActivity {

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
    @BindView(R.id.btn_create_account)
    Button btn_create_account;

    private String name,phn_num, password, email;
    private boolean isMale,isFemale,isOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            isMale = isFemale = isOther = false;
        }else{

        }
    }

    @OnClick(R.id.btn_create_account)
    public void onClickSignUp(View view){

        validateName();
        validatePhoneNumber();
        validatePassword();
        startActivity(new Intent(this, LogIn.class));
        if (validateName() && validatePhoneNumber() && validateName() &&
                validatePassword()&& (isMale || isFemale || isOther)){

            // Post details into server
        }
    }

    public void getEntries(){
        name = et_name.getText().toString();
        phn_num = et_phn_num.getText().toString();
        password = et_password.getText().toString();
        email = et_email.getText().toString();
        isMale = rb_male.isChecked();
        isFemale = rb_female.isChecked();
        isOther = rb_other.isChecked();
    }

    public void check(EditText editText){
        if (editText.getText().length() == 0){

        }
    }

    private boolean validateName() {
        if (et_name.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError("Mandatory Field");
            requestFocus(et_name);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhoneNumber() {
        if (et_phn_num.getText().toString().trim().isEmpty()) {
            inputLayoutPhoneNumber.setError("Verify Phone Number");
            requestFocus(et_phn_num);
            return false;
        } else {
            inputLayoutPhoneNumber.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (et_phn_num.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError("Please enter password");
            requestFocus(et_password);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}