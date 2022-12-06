package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Thread(
    @SerializedName("thread_id") val threadId: Int,
    @SerializedName("forum_name") val forumName: String,
    val title: String,
    @SerializedName("reply_count") val replyCount: Int,
    @SerializedName("view_count") val viewCount: Int,
    @SerializedName("post_date") val postDate: Long,
    @SerializedName("is_thread_open") val isThreadOpen: Boolean,
    @SerializedName("last_post_date") val lastPostDate: Long
)