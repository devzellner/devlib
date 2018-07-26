package devlib.devmaker.com.br.utils.utils

import android.app.Activity
import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import java.io.IOException


/**
 * Retorna a latitude e longitude do endereco passado
 * @param endereco Endereco no formato: Rua, numero,Cidade, Estado. Ex: Carlos Drummond de Andrade, 448, Pinhais, PR
 * @param context contexto para iniciar o geocoder.
 * @return
 */
fun Activity.getLocalizacao(endereco: String, context: Context): LatLng? {

    val geocoder = Geocoder(context)
    val address: List<Address>?
    var localizacao: LatLng? = null


    try {

        address = geocoder.getFromLocationName(endereco, 1)
        if (address == null) {
            return null
        }

        val location = address[0]
        localizacao = LatLng(location.latitude, location.longitude)

    } catch (ex: IOException) {
        ex.printStackTrace()
    }

    return localizacao
}