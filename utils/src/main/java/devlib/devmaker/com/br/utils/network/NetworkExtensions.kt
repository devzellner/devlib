package devlib.devmaker.com.br.utils.network

import android.telecom.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> callback(response: (response: Response<T>?) -> Unit,
                 failure: (throwable: Throwable?) -> Unit): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response(response)
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failure(t)
        }
    }
}