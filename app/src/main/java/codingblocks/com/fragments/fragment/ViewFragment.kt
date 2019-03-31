package codingblocks.com.fragments.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.view.ViewGroup
import android.webkit.WebViewClient
import codingblocks.com.fragments.R
import kotlinx.android.synthetic.main.fragment_view.*





class ViewFragment :Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       var url = activity?.intent?.getStringExtra("url")

        Log.e("ViewFragment",url)

//        if(url==null){
//            if(requireActivity().intent.data!=null){
//                url=requireActivity().intent.data.toString()
//            }
//        }


        if (url != null) {

            webView.webViewClient = WebViewClient()
            webView.settings.loadsImagesAutomatically = true
            webView.scrollBarStyle= SCROLLBARS_INSIDE_OVERLAY
            webView.loadUrl(url)


        }

    }
}



