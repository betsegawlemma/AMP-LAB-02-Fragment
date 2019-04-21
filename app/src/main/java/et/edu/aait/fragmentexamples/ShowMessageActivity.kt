package et.edu.aait.fragmentexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShowMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null) {
            val showMessageFragment = ShowMessageFragment()
            showMessageFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, showMessageFragment)
                .commit()
        }
    }
}
