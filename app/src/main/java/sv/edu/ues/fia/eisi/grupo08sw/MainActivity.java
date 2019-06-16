package sv.edu.ues.fia.eisi.grupo08sw;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends ListActivity {

    
    String[] menu ={"Insertar Carrera", "Consultar Carrera", "Eliminar Carrera", "Actualizar Carrera", "Insertar Pensum", "Consultar Pensum", "Eliminar Pensum"};
    String[] activities ={"InsertarCarreraActivity", "ConsultarCarreraActivity", "EliminarCarreraActivity", "ActualizarCarreraActivity", "InsertarPensumActivity", "ConsultarPensumActivity", "EliminarPensumActivity"};


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, menu));

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);


        if(position!=7){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("sv.edu.ues.fia.eisi.grupo08sw."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{

        }
    }
}

