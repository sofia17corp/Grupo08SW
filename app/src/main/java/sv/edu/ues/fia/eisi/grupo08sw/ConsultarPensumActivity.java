package sv.edu.ues.fia.eisi.grupo08sw;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import sv.edu.ues.fia.eisi.grupo08sw.basedatos.ControlWS;

@SuppressLint("NewApi")
public class ConsultarPensumActivity extends AppCompatActivity {

    EditText editIdPensum;
    TextView txtJson;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pensum);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIdPensum = findViewById(R.id.editIdPensum);
        txtJson = findViewById(R.id.consultarJson);
    }

    public void consultarPensumServidor(View v) {
        txtJson.setText("");
        String url = "http://192.168.0.10/ws_pensum_query.php?" +
                "idPensum=" + editIdPensum.getText().toString();
        String json = ControlWS.consultarPensum(url, this);

        if (json == null) {
            txtJson.setText("No existe");
        } else {
            String[] datosJson = json.split(",");
            String[] id, nombre;
            id = datosJson[0].split(":");

            txtJson.setText(txtJson.getText().toString() + "id= " + id[1] + "\n");

        }
    }
}