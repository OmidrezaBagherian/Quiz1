package ir.omidrezabagherian.testapplicationtwo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import ir.omidrezabagherian.testapplicationtwo.databinding.FragmentTwoBinding
import okhttp3.*
import java.io.IOException

class TwoFragment : Fragment(R.layout.fragment_two) {

    lateinit var twoFragmentbinding: FragmentTwoBinding

    val client by lazy { OkHttpClient() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        twoFragmentbinding = FragmentTwoBinding.bind(view)

        val mHandler = Handler(Looper.getMainLooper());

        val request =
            Request.Builder().url("https://picsum.photos/v2/list")
                .build()

        var body = ""

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("App", "API execute failed")
            }

            override fun onResponse(call: Call, response: Response) {
                body = response.body()?.string().toString()
                mHandler.post(Runnable {
                    twoFragmentbinding.textFragmentTwo.text = body
                })

            }

        })
        try {
            twoFragmentbinding.textFragmentTwo.text = body
        }catch (e:Exception){
            twoFragmentbinding.textFragmentTwo.text = e.toString()
        }


    }
}