package ikhwan.binar.latihanlistcountryretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponse
import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponseItem
import ikhwan.binar.latihanlistcountryretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
    }

    private fun fetchData() {
       ApiClient.instance.getCountry()
           .enqueue(object : Callback<ArrayList<GetCountryResponseItem>>{
               /*override fun onResponse(
                   call: Call<List<GetCountryResponseItem>>,
                   response: Response<List<GetCountryResponseItem>>
               ) {
                   if (response.isSuccessful){
                       Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
                   }
               }

               override fun onFailure(call: Call<List<GetCountryResponseItem>>, t: Throwable) {
                   Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                   Log.d("fail", call.toString())
               }*/

               override fun onResponse(
                   call: Call<ArrayList<GetCountryResponseItem>>,
                   response: Response<ArrayList<GetCountryResponseItem>>
               ) {
                   if (response.isSuccessful){
                       showList(response.body())
                   }
               }

               override fun onFailure(call: Call<ArrayList<GetCountryResponseItem>>, t: Throwable) {
                   Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                   Log.d("fail", t.message!!)
               }
           })
    }

    private fun showList(listCountry: List<GetCountryResponseItem>?) {
        rv_country.layoutManager = GridLayoutManager(this, 2)
        val adapter = CountryAdapter(listCountry!!)
        rv_country.adapter = adapter
    }
}