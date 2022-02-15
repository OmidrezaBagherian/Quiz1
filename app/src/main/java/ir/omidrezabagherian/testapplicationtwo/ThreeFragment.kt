package ir.omidrezabagherian.testapplicationtwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ir.omidrezabagherian.testapplicationtwo.databinding.FragmentThreeBinding
import okhttp3.Request
import java.util.concurrent.Executors

class ThreeFragment : Fragment(R.layout.fragment_three) {

    private lateinit var threeFragmentbinding: FragmentThreeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        threeFragmentbinding = FragmentThreeBinding.bind(view)

        var i = 100

        threeFragmentbinding.imageView.setOnClickListener {
            val index = i + 1
            Glide.with(view).load("https://picsum.photos/id/$index/300/300")
                .into(threeFragmentbinding.imageView)
        }


    }
}
