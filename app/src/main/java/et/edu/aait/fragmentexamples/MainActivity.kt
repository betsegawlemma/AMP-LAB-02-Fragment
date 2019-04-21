package et.edu.aait.fragmentexamples

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
    InputMessageFragment.OnSendMessageButtonClicked{

    override fun onSendMessageButtonClicked(message: Message) {

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val showMessageFragment = ShowMessageFragment.newInstance(message)
            supportFragmentManager.beginTransaction()
                .replace(R.id.show_frame, showMessageFragment)
                .commit()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

