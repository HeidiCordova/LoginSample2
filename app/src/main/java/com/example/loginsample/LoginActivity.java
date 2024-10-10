package com.example.loginsample;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsample.databinding.ActivityMainBinding;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
    private  static String TAG="MainActivity";
    private ActivityMainBinding binding;
    private AccountEntity accountEntity;
    private String accountEntityString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        EditText edtUsername=binding.edtUsername;
        EditText edtPassword= binding.edtPassword;
        Button btnLogin= binding.btnLogin;
        Button btnAddAccount = binding.btnAddAccount;

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Bienvenido a mi app", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Bienvenido a mi app");

                    Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtra("ACCOUNT",accountEntityString);

                    startActivity(intent);

                } else{
                    Toast.makeText(getApplicationContext(),"Error en la autenticación", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Error en la autenticación");
                }
            }
        });

        //activity, cuando se cierre tiene que recuperar un valor
        ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(
                //DOS PARARMETROS
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult activityResult) {
                        //AQUI VOY A RECUPERAR EL VALOR
                        Integer resulcode= activityResult.getResultCode();
                        Log.d("LoginActivity","resulcode: "+resulcode);
                        if(resulcode==AccountActivity.ACCOUNT_ACEPTAR){
                            Intent data=  activityResult.getData(); //aqui ya esta recuperando
                            accountEntityString =data.getStringExtra(AccountActivity.ACCOUNT_RECORD);
                            //operacion invverson del gson
                            Gson gson=new Gson();
                            accountEntity= gson.fromJson( accountEntityString,AccountEntity.class);
                            String firstname=accountEntity.getFirstname();
                            Toast.makeText(getApplicationContext(),"Nombre: "+firstname,Toast.LENGTH_SHORT).show();
                            Log.d("LoginActivity","Nombre: "+firstname);
                        }
                        else if(resulcode==AccountActivity.ACCOUNT_CANCELAR){
                            Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_SHORT).show();
                            Log.d("LoginActivity","Cancelado");
                        }
                    }
                }
        );
        btnAddAccount.setOnClickListener(v ->{
            Intent intent= new Intent(getApplicationContext(),AccountActivity.class);
            // ActivityResultLauncher<Intent> activityResultLauncher;
            activityResultLauncher.launch(intent);
        });
    }
}