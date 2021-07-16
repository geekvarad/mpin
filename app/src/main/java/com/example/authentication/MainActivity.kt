package com.example.authentication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import com.example.authentication.data.database
import com.example.authentication.data.database_handler
import com.example.authentication.data.db
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    //lateinit var db_instance: database;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("ResourceType")
    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
       // db_instance= database.getInstance(this)


        super.onCreate(savedInstanceState, persistentState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<homeFragment>(R.id.fragment_main)
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }

}
