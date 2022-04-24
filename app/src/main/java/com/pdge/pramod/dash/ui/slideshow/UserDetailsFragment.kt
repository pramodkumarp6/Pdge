package com.pdge.pramod.dash.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdge.pramod.adpter.InfomationAdapter
import com.pdge.pramod.databinding.FragmentSlideshowBinding
import com.pdge.pramod.model.User


class UserDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding
    private lateinit var userDetailsViewModel: UserDetailsViewModel
    private val users: List<User>? = null
    private val  infomationAdapter: InfomationAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        userDetailsViewModel = ViewModelProvider(this).get(UserDetailsViewModel::class.java)
        binding.reclyer.layoutManager = LinearLayoutManager(context)
       // infomationAdapter = InfomationAdapter(get, users)

        /* slideshowViewModel.UserDetails().observe(viewLifecycleOwner,
            Observer<Any> { userResponse ->
                if (!userResponse.isError()) {
                    val users: List<Users> = userResponse.getUserList()



                    val gson = GsonBuilder().setPrettyPrinting().create()
                    Log.e("MainActivity", gson.toJson(users))
                }
            })*/



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}