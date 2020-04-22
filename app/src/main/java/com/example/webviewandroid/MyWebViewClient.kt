package com.example.webviewandroid

import android.app.Activity
import android.os.Build
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi


class MyWebViewClient internal constructor(private val activity: Activity,private val progress: ProgressBar) : WebViewClient() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        progress.visibility = View.VISIBLE
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }

    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        progress.visibility = View.VISIBLE
        webView.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        progress.visibility = View.GONE
        super.onPageFinished(view, url)
    }

    override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
        Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
    }
}

