package com.tusalud.ui.slideshow

import android.annotation.SuppressLint
import android.media.session.MediaController
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tusalud.R
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

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textSlideshow

        val mediaController = android.widget.MediaController(requireContext())
        val videoView =  binding.videoView
        val videoUri = Uri.parse("android.resource://com.tusalud/raw/" + R.raw.importante_vacunarse)
        videoView.setVideoURI(videoUri)
        videoView.setMediaController(mediaController)
        mediaController.setMediaPlayer(videoView)
        videoView.keepScreenOn = true
        videoView.start()



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