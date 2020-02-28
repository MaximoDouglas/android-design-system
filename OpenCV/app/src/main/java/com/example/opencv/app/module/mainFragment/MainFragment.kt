package com.example.opencv.app.module.mainFragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.opencv.R
import com.example.opencv.databinding.MainFragmentBinding
import com.example.opencv.domain.faceDetection.FaceDetection
import com.google.android.material.snackbar.Snackbar
import java.io.File

class MainFragment : Fragment() {

    private var mBinding: MainFragmentBinding? = null
    private var mUri: Uri?                     = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { FaceDetection.loadModel(it) }

        setupOpenCameraButton()
    }

    private fun setupOpenCameraButton() {
        mBinding?.openCameraButton?.setOnClickListener { _ ->
            if (context?.let { contextNotNull ->
                    ContextCompat.checkSelfPermission(contextNotNull, Manifest.permission.CAMERA)
                } != PackageManager.PERMISSION_GRANTED) {

                activity?.let { fragmentActivity ->
                    ActivityCompat.requestPermissions(
                        fragmentActivity,
                        arrayOf(Manifest.permission.CAMERA),
                        REQUEST_CAMERA_PERMISSION
                    )
                }
            } else {
                startCamera()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA_PERMISSION && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startCamera()
        } else {
            activity?.findViewById<View>(android.R.id.content)?.let {
                Snackbar.make(
                    it, R.string.main_fragment_request_camera_permission_denied,
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun startCamera() {
        mUri = context?.let {
            FileProvider.getUriForFile(
                it,
                "com.example.opencv.fileprovider",
                File.createTempFile(
                    "picture",
                    ".jpg",
                    context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                )
            )
        }

        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE).apply {
            putExtra(
                MediaStore.EXTRA_OUTPUT,
                mUri
            )
        }, REQUEST_IMAGE_CAPTURE)
    }

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 200
        private const val REQUEST_IMAGE_CAPTURE     = 100
    }


}