package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var idEditText: EditText
    private lateinit var addButton: Button
    private lateinit var viewButton: Button
    private var contactList = ArrayList<Agenda>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        idEditText = findViewById(R.id.idEditText)
        addButton = findViewById(R.id.addButton)
        viewButton = findViewById(R.id.viewButton)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val newContact = Agenda(name, id)
            contactList.add(newContact)
        }

        viewButton.setOnClickListener {
            if (contactList.isNotEmpty()) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("contactName", contactList[0].nombre)
                startActivity(intent)
            }
        }
    }
}

class Agenda(val nombre: String, val noControl: String)
