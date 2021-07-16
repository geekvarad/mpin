package com.example.authentication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.authentication.data.database
import com.example.authentication.data.db
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment(R.layout.fragment_home) {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var db_instance=database.getInstance(view.context)
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            val temp=db_instance.handler().get()
            Log.d("database_debugging",temp.toString())
            if(temp.isNotEmpty())
                db.mpin=temp[0].mpin
        }
        button_setup.setOnClickListener {
            if(db.mpin!="")
            findNavController().navigate(R.id.action_homeFragment_to_login)
            else
                findNavController().navigate(R.id.action_homeFragment_to_signup)
        }
    }

}