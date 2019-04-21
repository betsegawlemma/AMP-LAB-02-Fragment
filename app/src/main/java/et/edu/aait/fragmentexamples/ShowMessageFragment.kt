package et.edu.aait.fragmentexamples


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_show_message.view.*

class ShowMessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show_message, container, false)

        val headerTextView = view.show_header_tv
        val bodyTextView = view.show_body_tv
        // extract fragment arguments
        val message = arguments?.getSerializable("message") as Message

        headerTextView.text = message.header
        bodyTextView.text = message.body

        return view
    }


    companion object {

        fun newInstance(message: Message): ShowMessageFragment {

            val showMessageFragment = ShowMessageFragment()
            val args = Bundle()
            args.putSerializable("message",message)
            showMessageFragment.arguments = args

            return showMessageFragment
        }
    }
}


