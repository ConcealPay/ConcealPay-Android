package com.concealpay.android.data.remote

import com.concealpay.android.util.Constants
import com.concealpay.android.util.SharedPrefFunctions
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named


class AuthenticationInterceptor @Inject constructor(
    private val sharedPrefFunctions: SharedPrefFunctions

) : Interceptor {

    @Named("androidId")
    @Inject
    lateinit var deviceId: String

    @Named("userDevice")
    @Inject
    lateinit var userDevice: String

    override fun intercept(chain: Interceptor.Chain): Response {
        val authKey = sharedPrefFunctions.getPref(Constants.ACCESSTOKEN, null)
        var request = chain.request()


        if (authKey.isNullOrEmpty()) {
            request = request.newBuilder()
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .addHeader("Accept", "*/*")
                .build()
        } else {
            Timber.tag("authKey").d("Bearer $authKey")
            request = request.newBuilder()
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
                .addHeader("Accept", "*/*")
                .addHeader("user-device", userDevice)
                .build()

            if (request.headers["Authorization"].isNullOrEmpty()) {
                request = request.newBuilder()
                    .addHeader("Authorization", "Bearer $authKey")
                    .build()
            }
        }

        Timber.tag("requestUrl").d("${request.url}")
        Timber.tag("requestUrl").d(request.url.toUrl().path)
        Timber.tag("requestUrl").d(request.headers["Authorization"])
        Timber.tag("requestHeaders").d("${request.headers}")
        return chain.proceed(request)
    }

    companion object {
        private const val CONTENT_TYPE_JSON = "application/json"
    }
}