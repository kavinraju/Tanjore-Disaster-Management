package tanjore.disastermanagement.tn.tanjore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tanjore.disastermanagement.tn.tanjore.R;

public class LogIn extends AppCompatActivity {

    @BindView(R.id.input_txt_layout_login_phn_num)
    TextInputLayout inputLayoutPhoneNumber;
    @BindView(R.id.input_txt_layout_login_et_login_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.et_login_phn_num)
    EditText et_phn_num;
    @BindView(R.id.et_login_password)
    EditText et_password;
    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @OnClick(R.id.btn_login)
    public void onClickLogin(View view){

        validatePassword();
        validatePhoneNumber();
        startActivity(new Intent(this, HomeActivity.class));
        if (validatePhoneNumber() && validatePassword()){

        }
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
