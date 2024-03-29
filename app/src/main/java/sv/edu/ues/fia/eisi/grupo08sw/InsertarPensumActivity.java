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
public class InsertarPensumActivity extends AppCompatActivity {

    EditText editIdPensum, editNombrePensum;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_pensum);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIdPensum = findViewById(R.id.idPensum);
        editNombrePensum = findViewById(R.id.nombrePensum);
    }

    public void insertarPensum(View v){
        String url;
        String msj;
        url= "http://eisi.fia.ues.edu.sv/GPO08/HC14030/ws_pensum_insert.php?" +
                "idpesum=" +editIdPensum.getText().toString()+
                "&nombrePesum="+ editNombrePensum.getText().toString();
        msj = ControlWS.insertarPensumServidor(url, this);
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show();

    }
}
