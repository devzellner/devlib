package devlib.devmaker.com.br.utils.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class GPSUtils {


    /**
     * Retorna a latitude e longitude do endereco passado
     * @param endereco Endereco no formato: Rua, numero,Cidade, Estado. Ex: Carlos Drummond de Andrade, 448, Pinhais, PR
     * @param context contexto para iniciar o geocoder.
     * @return
     */
    public static LatLng getLocalizacao(String endereco, Context context){

        Geocoder geocoder =  new Geocoder(context);
        List<Address> address;
        LatLng localizacao = null;


        try {

            address = geocoder.getFromLocationName(endereco, 1);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            localizacao = new LatLng(location.getLatitude(), location.getLongitude() );

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return  localizacao;
    }

}
