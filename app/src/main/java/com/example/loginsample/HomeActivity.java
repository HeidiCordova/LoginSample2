package com.example.loginsample;

<<<<<<< HEAD
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.app.FragmentManager;
=======
import android.os.Bundle;
import android.view.MenuItem;
>>>>>>> a4d120992573fdb82d35ebde060c065491cbb37a
//import android.app.FragmentTransaction;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

<<<<<<< HEAD
import com.example.loginsample.fragments.CuadrosFragment;
=======
import com.example.loginsample.fragments.ListaFragments;
>>>>>>> a4d120992573fdb82d35ebde060c065491cbb37a
import com.example.loginsample.fragments.HomeFragment;
import com.example.loginsample.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    private androidx.fragment.app.FragmentManager fragmentManager=null;
    private FragmentTransaction fragmentTransaction=null;
    private HomeFragment homeFragment =null;
<<<<<<< HEAD
    private CuadrosFragment cuadrosFragment =null;
=======
    private ListaFragments listaFragments =null;
>>>>>>> a4d120992573fdb82d35ebde060c065491cbb37a
    private MapaFragment mapaFragment =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //recupera los valores
        //   String accountEntity= getIntent().getStringExtra("ACCOUNT");
       // Log.d("HomeActivity",accountEntity);

        //declaracoin del fragment maneager
        fragmentManager = getSupportFragmentManager();

        //los fragments
        BottomNavigationView bottomNavigationView  = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()== R.id.menu_home){
                    homeFragment=HomeFragment.newInstance("","");
                    loadFragment(homeFragment);
                    return true;
                }else if (menuItem.getItemId()==R.id.menu_cuadros){
<<<<<<< HEAD
                    cuadrosFragment=CuadrosFragment.newInstance("","");
                    loadFragment(cuadrosFragment);
=======
                    listaFragments = ListaFragments.newInstance("","");
                    loadFragment(listaFragments);
>>>>>>> a4d120992573fdb82d35ebde060c065491cbb37a
                    return true;
                }
                else if (menuItem.getItemId()==R.id.menu_mapa){
                    mapaFragment =MapaFragment.newInstance("","");
                    loadFragment(mapaFragment);
                    return true;
                }
                else{
                    return false;
                }

            }
        });
    }
    //METODO para cargar los fragmentos
    private void loadFragment(Fragment fragment){
        if (fragmentManager!=null){
<<<<<<< HEAD
            //instaciar al fragment transaccion
            fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
            //eñ replace, con el fragment que se a crado antes, lo destruye
=======
            //instanciar al fragment transaccion
            fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
            //el replace, con el fragment que se a creado antes, lo destruye
>>>>>>> a4d120992573fdb82d35ebde060c065491cbb37a
            fragmentTransaction.commit();

        }
    }
}