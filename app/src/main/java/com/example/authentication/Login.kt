package com.example.authentication

import android.app.Notification
import android.hardware.biometrics.BiometricPrompt
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.authentication.data.db
import kotlinx.android.synthetic.main.fragment_login.*
import java.security.MessageDigest
import java.util.*
import androidx.biometric.*

class Login : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            val md= MessageDigest.getInstance("SHA-256")
            if(Base64.getEncoder().encodeToString(md.digest(mpin.text.toString().encodeToByteArray()))== db.mpin)
            findNavController().navigate(R.id.action_login_to_dashboard);
            else
                Toast.makeText(context,"Invalid MPIN",Toast.LENGTH_SHORT).show()

        }
        button_biommetric.setOnClickListener {
            val executor= ContextCompat.getMainExecutor(it.context)
            var biometricPrompt : androidx.biometric.BiometricPrompt=
                BiometricPrompt(this,executor,object : androidx.biometric.BiometricPrompt.AuthenticationCallback(){
                    override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        findNavController().navigate(R.id.action_login_to_dashboard)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        Toast.makeText(it.context,"Authentication Failed",Toast.LENGTH_SHORT).show()
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        Toast.makeText(it.context,"Please enable device biometric authentication",Toast.LENGTH_SHORT).show()
                    }
                })
            val promptInfo=androidx.biometric.BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setDescription("Use FingerPrint")
                .setNegativeButtonText("Use MPIN instead")
                .build()
            biometricPrompt.authenticate(promptInfo)
        }

        }

    override fun onStart() {
        super.onStart()

    }
    }