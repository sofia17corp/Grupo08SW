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
public class EliminarPensumActivity extends AppCompatActivity {

    EditText editNombre;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_pensum);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editNombre=findViewById(R.id.editNombreEliminar);
    }

    public void eliminarPensumServidor(View v){
        String url="http://eisi.fia.ues.edu.sv/GPO08/HC14030/ws_equipo_delete.php?"+"nombrePensum="+editNombre.getText().toString();
        String msj= ControlWS.eliminarPensum(url, this);
        Toast.makeText(this,msj,Toast.LENGTH_LONG).show();

    }
}

