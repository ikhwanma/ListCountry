package ikhwan.binar.latihanlistcountryretrofit.network

import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponse
import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getCountry(): Call<ArrayList<GetCountryResponseItem>>
}