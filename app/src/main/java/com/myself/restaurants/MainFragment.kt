package com.myself.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.myself.restaurants.retrofit.Retrofit


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.profileButton).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_profileFragment)
        }

        view.findViewById<Button>(R.id.searchButton).setOnClickListener {
            var t = view.findViewById<EditText>(R.id.citySelector).text.toString()

            var correct = cities?.contains(t)
            if (!correct!!)
                Toast.makeText(context, "Not a valid city!", Toast.LENGTH_LONG).show()
            else
            {
                Thread(Runnable {
                    var repo = Retrofit()
                    var call = repo.getRestaurants(t)
                    var res = call.execute()


                    var lin = view.findViewById<LinearLayout>(R.id.dirtyLinear)

                    requireActivity().runOnUiThread({
                        lin.removeAllViews()
                        for (restaurant in res.body()?.restaurants!!)
                        {
                            var tx = TextView(context)
                            tx.text = restaurant.name

                            lin.addView(tx)

                        }
                    })


                }).start()

            }
        }



    }

    companion object {
        var cities:List<String?>? = null
    }

}