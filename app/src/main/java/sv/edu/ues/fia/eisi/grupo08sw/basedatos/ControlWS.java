package sv.edu.ues.fia.eisi.grupo08sw.basedatos;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class ControlWS {

    public static String obtenerRespuestaPeticion(String url, Context ctx) {

        String respuesta = " ";

        // Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);

        // Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static String insertarServidor(String peticion, Context context){
        String msj;
        String json = obtenerRespuestaPeticion(peticion, context);
        String[] resultado=json.split(";");
        //si el jason esta bueno dara {resultado:1}
        if (resultado[1].equals("{\"resultado\":1}")){
            return msj = "Carrera ingresada con exito";
        }else{return msj="No se puede ingresar carrera";}

    }

    public static String consultarCarrera (String peticion, Context context){
        String msj;
        String json = obtenerRespuestaPeticion(peticion, context);
        String parseado1 = json.replace("{", "");
        String parseado2 = parseado1.replace("}", "");
        String parseado3 = parseado2.replace("[", "");
        String parseado4 = parseado3.replace("]", "");
        String parseado5 = parseado4.replace("\"", "");
        String[] resultado= parseado5.split(",");
        if (resultado[0].equals("No existe")){
            return null;
        }else{
            return parseado5;
        }

    }
}
