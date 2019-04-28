package mx.itesm.aml.gefc;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();

            switch (item.getItemId()) {
                //REEMPLAZAR CODIGO CON EL DEL FRAGMENTO PROPIO
                case R.id.navigation_bitacora:
                    //if (fm.findFragmentByTag("boton") == null) {
                    fm.popBackStackImmediate(null, fm.POP_BACK_STACK_INCLUSIVE);
                    BitacoraFrag fragBita = new BitacoraFrag();
                    transaction.replace(R.id.contFrag, fragBita, "bitacora");
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    //}
                    return true;

                case R.id.navigation_signosVitales:
                    //if (fm.findFragmentByTag("mapa") == null) {
                    fm.popBackStackImmediate(null, fm.POP_BACK_STACK_INCLUSIVE);
                    SignosVitalesFrag fragSV = new SignosVitalesFrag();
                    transaction.replace(R.id.contFrag, fragSV, "signoVital");
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    //}
                    return true;

                case R.id.navigation_streaming:
                    //if (fm.findFragmentByTag("reporte") == null){
                    fm.popBackStackImmediate(null, fm.POP_BACK_STACK_INCLUSIVE);
                    StreamFrag fragStream = new StreamFrag();
                    transaction.replace(R.id.contFrag,fragStream,"stream");
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    //}
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        SignosVitalesFrag fragSV = new SignosVitalesFrag();

        transaction.replace(R.id.contFrag,fragSV);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if(fm.getBackStackEntryCount() > 1){
            fm.popBackStack();
        }
        /*else{
            super.onBackPressed();
        }*/

    }

}
