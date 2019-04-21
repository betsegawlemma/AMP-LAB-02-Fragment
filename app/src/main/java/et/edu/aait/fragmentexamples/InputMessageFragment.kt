package et.edu.aait.fragmentexamples


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_input_message.view.*

class InputMessageFragment : Fragment() {

    private lateinit var listener: OnSendMessageButtonClicked

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is OnSendMessageButtonClicked) {
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view  = inflater.inflate(R.layout.fragment_input_message, container, false)

        val headerEditText = view.input_header_et
        val bodyEditText = view.input_body_et
        val sendMessageButton = view.send_message_btn

        sendMessageButton.setOnClickListener {

            val message = Message(headerEditText.text.toString(), bodyEditText.text.toString())
            listener.onSendMessageButtonClicked(message)

        }

        return view
    }

    interface OnSendMessageButtonClicked {
      fun  onSendMessageButtonClicked(message:Message)
    }
}


