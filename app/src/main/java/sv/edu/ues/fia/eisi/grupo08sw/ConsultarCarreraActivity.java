package sv.edu.ues.fia.eisi.grupo08sw;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import sv.edu.ues.fia.eisi.grupo08sw.basedatos.ControlWS;

@SuppressLint("NewApi")
public class ConsultarCarreraActivity extends AppCompatActivity {

    EditText editNombre;
    TextView txtJson;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carrera);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editNombre = findViewById(R.id.nombreCarrera);
        txtJson = findViewById(R.id.consultarJson);
    }

    public void consultarServidor(View v){
        txtJson.setText("");

        String url = "http://192.168.1.4/ws_carrera_query.php?" +
                "nombreCarrera="+ editNombre.getText().toString().toUpperCase();
        String json = ControlWS.consultarCarrera(url, this );

        if (json == null){
            txtJson.setText("No existe");
        }else {
            String[] datosJason = json.split(",");
            String[] id, nombre;
            id = datosJason[0].split(":");
            nombre = datosJason[1].split(":");

            txtJson.setText(txtJson.getText().toString()+"id= "+id[1]+"\n");
            txtJson.setText(txtJson.getText().toString()+"nombre= "+nombre[1]+"\n");
        }

    }
}
