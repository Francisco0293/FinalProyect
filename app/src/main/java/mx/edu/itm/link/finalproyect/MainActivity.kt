package mx.edu.itm.link.finalproyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navView.setupWithNavController(navController)

        //val database = Firebase.database
        //val myRef = database.reference

        //myRef.child("ejemplo_usuarios").child("usuario_1").setValue(User("francisco","Nivel_03","creado el 7 de mayo",3))
        //myRef.child("ejemplo_usuarios").child("usuario_2").setValue(User("deni","Nivel 5","creado el 21 de abril del 2019",5))

/*        myRef.child("ejemplo_usuarios").child("usuario_1").get().addOnSuccessListener { response ->
            //TODO value
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            //TODO
            Log.e("firebaseResponse","Error getting data", it)
        }*/
    }
}