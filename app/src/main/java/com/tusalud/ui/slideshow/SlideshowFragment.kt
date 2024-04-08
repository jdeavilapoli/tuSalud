package com.tusalud.ui.slideshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tusalud.databinding.FragmentSlideshowBinding


class SlideshowFragment : Fragment() {
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        val video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jneZui11gnk?si=9XJI3KoAuTD2U4o4\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textSlideshow

        val webview: WebView= binding.webView
        webview.loadData(video,"text/html","utf-8")
        webview.settings.javaScriptEnabled = true
        webview.webChromeClient = WebChromeClient()
        webview.webViewClient = WebViewClient()

        val root: View = binding.root

        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}