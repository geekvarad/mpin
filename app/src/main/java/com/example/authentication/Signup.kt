package com.example.authentication

import java.util.Base64
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.authentication.data.database
import com.example.authentication.data.db
import com.example.authentication.data.table
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.coroutines.*
import java.security.MessageDigest
import kotlin.coroutines.CoroutineContext
import org.apache.*;

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [Signup.newInstance] factory method to
 * create an instance of this fragment.
 */
class Signup : Fragment(R.layout.fragment_signup) {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_create.setOnClickListener {
            if(setup_mpin.text.toString()==confirm_mpin.text.toString() && setup_mpin.text.toString()!="")
            {
                db.mpin=setup_mpin.text.toString();
                val md=MessageDigest.getInstance("SHA-256")
                db.mpin=Base64.getEncoder().encodeToString(md.digest(db.mpin.encodeToByteArray()))
                val instance=database.getInstance(it.context)
                val myContext: CoroutineContext = SupervisorJob() + Dispatchers.IO
                val scope=CoroutineScope(myContext)
                scope.async {
                        instance.handler().delete()
                        instance.handler().setMpin(table(0, db.mpin))

                }
                findNavController().navigate(R.id.action_signup_to_dashboard)
            }
            else
                Toast.makeText(context,"MPIN does not match",Toast.LENGTH_SHORT).show()
        }
    }

}