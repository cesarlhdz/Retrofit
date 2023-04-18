package edu.iest.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import edu.iest.retrofit.models.ImageRandom
import edu.iest.retrofit.models.ListBreed
import edu.iest.retrofit.network.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        traerImagenAleatoria()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_images, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.option_menu_list_images) {
            Toast.makeText(this, "OPTION menu 1", Toast.LENGTH_SHORT).show()
            val apiCall = API().crearServicioAPI()
            apiCall.listaImagenesDePerrosPorRaza("hound")
                .enqueue(object : Callback<ListBreed> {
                    override fun onResponse(call: Call<ListBreed>, response: Response<ListBreed>) {
                        val dogs = response.body()?.message
                        Log.d("PRUEBAS", "Status de la respuesta ${response.body()?.status}")
                        if (dogs != null) {
                            for (dog in dogs!!) {
                                Log.d("PRUEBAS", "Perro es $dog")
                            }
                        }
                    }
                    override fun onFailure(call: Call<ListBreed>, t: Throwable) {

                    }
                })
        }
        return super.onOptionsItemSelected(item)
    }
    private fun traerImagenAleatoria(){
        val apiCall = API().crearServicioAPI()
        val ivPicasso= findViewById<ImageView>(R.id.ivPicasso)
        apiCall.imagenAleatoria().enqueue(object : Callback<ImageRandom>
    }
}