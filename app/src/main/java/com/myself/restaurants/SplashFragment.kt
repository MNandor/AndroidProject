package com.myself.restaurants

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myself.restaurants.room.AppDatabase
import com.myself.restaurants.room.Repository
import com.myself.restaurants.room.User
import retrofit2.Retrofit
import java.lang.Thread.sleep


class SplashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Thread(Runnable {
            var db = Repository().getDAO()
            var test = db.getAll()

            if (test.size < 1){
                var defaultUser = User(id = 1, pic = "", address = "", phone = "", email = "", name = "John", addressCityOnly = "Baltimore", loggedin = true)
                db.insertUser(defaultUser)
                test = listOf(defaultUser)
            }

            ProfileFragment.user = test[0]

            sleep(2000)


            var repo = com.myself.restaurants.retrofit.Retrofit()
            var resp = repo.getCities().execute()

            MainFragment.cities = resp?.body()?.cities

            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)

        }).start()





    }

}