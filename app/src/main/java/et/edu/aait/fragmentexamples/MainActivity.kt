package et.edu.aait.fragmentexamples

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


const val MESSAGE = "message"

class MainActivity : AppCompatActivity(), InputMessageFragment.OnSendMessageButtonClicked{

    override fun onSendMessageButtonClicked(message: Message) {

      if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

         val showMessageFragment = ShowMessageFragment.newInstance(message)

          supportFragmentManager.beginTransaction()
              .replace(R.id.show_message_frame, showMessageFragment)
              .commit()
      }

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

           /* val showMessageIntent = Intent(this,ShowMessgeActivity::class.java)
            showMessageIntent.putExtra(MESSAGE,message)
            startActivity(showMessageIntent) */

            val showMessageFragment = ShowMessageFragment.newInstance(message)

          supportFragmentManager.beginTransaction()
              .replace(android.R.id.content, showMessageFragment)
              .addToBackStack(null)
              .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            val inputMessageFragment = InputMessageFragment()
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content,inputMessageFragment)
                .commit()
        }

    }

}
