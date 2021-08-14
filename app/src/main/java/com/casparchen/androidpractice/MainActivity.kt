package com.casparchen.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.casparchen.androidpractice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var linearManager = LinearLayoutManager(this)
        linearManager.orientation = LinearLayoutManager.VERTICAL

        binding.restaurantView.layoutManager = linearManager

        val apiErrorAlert = AlertDialog.Builder(this)
        val apiService = AppClientManager.client.create(ApiService::class.java)
        apiService.callPackage().enqueue(object: Callback<RowPackage> {
            override fun onResponse(
                call: Call<RowPackage>,
                response: Response<RowPackage>
            ) {
//                Log.i("test", response.body()?.data?.rowInfosObject?.rowList?.count().toString() ?: "-1")
                var list = response.body()?.data?.rowInfosObject?.rowList
                if (list != null) {
                    binding.restaurantView.adapter = CellAdapter(list)
                }
            }

            override fun onFailure(call: Call<RowPackage>, t: Throwable) {
                apiErrorAlert.setTitle("Error")
                apiErrorAlert.setMessage("API is failure ${t.localizedMessage}")
                apiErrorAlert.show()
                Log.i("test", "API is failure ${t.localizedMessage}")
            }

        })



        Log.i("test", "end")
    }
}
