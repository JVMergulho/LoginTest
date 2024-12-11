package mergulhao.vitor.joao.logistest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mergulhao.vitor.joao.logistest.databinding.ActivityMainBinding
import mergulhao.vitor.joao.logistest.ui.theme.LogisTestTheme
import java.util.Date

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(){
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if(checkCredentials(email, password)){
                Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("USER", email)
                intent.putExtra("DATE_HOUR", Date().toString())
                startActivity(intent)
                // destroy this activity
                finish()
            }
            else
                Toast.makeText(this, "invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkCredentials(email: String, password: String): Boolean{
        return email == "jvlm2@cin.ufpe.br" && password == "1234"
    }
}