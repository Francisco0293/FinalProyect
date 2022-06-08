package mx.edu.itm.link.finalproyect

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import mx.edu.itm.link.finalproyect.databinding.FragmentProfileBinding
import org.json.JSONObject

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container,false)

        val database = Firebase.database


        //myRef.child("ejemplo_usuarios").child("usuario_3").setValue(User("jonathan","Nivel 6","Creado el 2de agosto del 2016",10))


        binding.btnGetUser.setOnClickListener {
            val myRef = database.reference
            val userArgument = binding.editTextUser.text.toString()
            myRef.child("ejemplo_usuarios").child("$userArgument").get().addOnSuccessListener { response ->
                val gson = Gson()
                val json = gson.toJson(response.value)
                val user: User = gson.fromJson(json, User::class.java)

                binding.textView.text = user.name
                binding.textView2.text = user.level
                binding.textView3.text = user.date
                binding.textView4.text = user.item.toString()

                Log.d("firebaseResponse", response.value.toString())
            }.addOnFailureListener {
                Log.e("firebaseResponse","Error getting data", it)
            }

        }

        return binding.root
    }
}