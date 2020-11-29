package com.myself.restaurants

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.myself.restaurants.room.AppDatabase
import com.myself.restaurants.room.Repository


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
            var test = db.getAll().size.toString()
            activity?.runOnUiThread(Runnable {
                Toast.makeText(context, test, Toast.LENGTH_SHORT).show()
            })

        }).start()





    }

}