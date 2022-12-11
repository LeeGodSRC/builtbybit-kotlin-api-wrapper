package dev.imanity.bbbapi.request.impl.member.post

import dev.imanity.bbbapi.model.ProfilePost
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Request

import io.ktor.client.statement.*

data class ListProfilePostsRequest(
    val sortOptions: SortOptions
): Request<Array<ProfilePost>>(
    "members/self/profile-posts${sortOptions}",
    dev.imanity.bbbapi.request.Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<ProfilePost> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}