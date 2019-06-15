package sv.edu.ues.fia.eisi.grupo08sw;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.grupo08sw.basedatos.ControlWS;

@SuppressLint("NewApi")
public class ActualizarCarreraActivity extends AppCompatActivity {
    EditText editIdCarreraA, editNombreCarreraA;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_carrera);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIdCarreraA = findViewById(R.id.idCarreraAct);
        editNombreCarreraA = findViewById(R.id.nombreCarreraAct);

    }

    public void actualizarServidor(View v){
        String url;
        String msj;
        url= "http://eisi.fia.ues.edu.sv/ws_carrera_update.php?" +
                "idcarrera=" +editIdCarreraA.getText().toString()+
                "&nombreCarrera="+ editNombreCarreraA.getText().toString();
        msj = ControlWS.actualizarCarrera(url, this);
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show();
        editNombreCarreraA.setText(url);
    }
}
