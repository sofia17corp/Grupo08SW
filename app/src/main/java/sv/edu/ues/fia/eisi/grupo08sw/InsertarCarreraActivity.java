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
public class InsertarCarreraActivity extends AppCompatActivity {

    EditText editIdCarrera, editNombreCarrera;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carrera);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIdCarrera = findViewById(R.id.idCarrera);
        editNombreCarrera = findViewById(R.id.nombreCarrera);
    }

    public void ingresarServidor(View v){
        String url;
        String msj;
        url= "http://eisi.fia.ues.edu.sv/GPO08/HC14030/ws_carrera_insert.php?" +
                "idcarrera=" +editIdCarrera.getText().toString()+
                "&nombreCarrera="+ editNombreCarrera.getText().toString();
        msj = ControlWS.insertarServidor(url, this);
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show();
        editNombreCarrera.setText(url);
    }
}
