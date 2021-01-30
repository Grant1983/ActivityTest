package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FiristActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener{
//            finish()
            val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data", data)
            startActivityForResult(intent,1)
//            val intent = Intent("com.example.activitytest.ACTION_THIRD")
//            val intent = Intent(Intent.ACTION_VIEW)
/*
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
*/
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> {
                Toast.makeText(this, "You clicked Add",
                    Toast.LENGTH_SHORT).show()
/*
                val intent1 = Intent("com.example.activitytest.ACTION_START")
                intent1.addCategory("com.example.activitytest.MY_CATEGORY")
                startActivity(intent1)
*/
            }
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
