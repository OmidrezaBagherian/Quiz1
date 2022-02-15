package ir.omidrezabagherian.testapplicationtwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.omidrezabagherian.testapplicationtwo.databinding.FragmentOneBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class OneFragment:Fragment(R.layout.fragment_one) {

    val client by lazy {
        OkHttpClient()
    }

    private val executer by lazy { Executors.newSingleThreadExecutor() }

    private lateinit var oneFragmentbinding: FragmentOneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request =
            Request.Builder().url("https://picsum.photos/v2/list")
                .build()

        oneFragmentbinding = FragmentOneBinding.bind(view)

        try {
            val future: Future<String?> = executer.submit(Callable<String?> {
                val newCall = client.newCall(request)
                val response: Response = newCall.execute()
                response.body()?.string()
            })

            val data: String? = future.get()
            oneFragmentbinding.textFragmentOne.text = data.toString()
        } catch (e: Exception) {
            oneFragmentbinding.textFragmentOne.text = e.javaClass.simpleName
        }



    }
}