package com.example.algchymns.data.remote.response_models

data class ApkUpdate(
    val url: String,
)

data class CheckForUpdatesResponse(
    val success: Boolean,
    val hasContentUpdate: Boolean? = null,
    val hasApkUpdate: ApkUpdate? = null,
    val debug: Map<String, Any>? = null,
)