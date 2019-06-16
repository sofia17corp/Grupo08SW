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
public class EliminarCarreraActivity extends AppCompatActivity {

    EditText editNombreCarrera;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_carrera);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editNombreCarrera=findViewById(R.id.editNombreCarreraEliminar);
    }

    public void eliminarCarreraServidor(View v){
        String url="http://eisi.fia.ues.edu.sv/GPO08/HC14030/ws_equipo_delete.php?"+"nombreCarrera="+editNombreCarrera.getText().toString();
        String msj= ControlWS.eliminarCarrera(url, this);
        Toast.makeText(this,msj,Toast.LENGTH_LONG).show();

    }
}
