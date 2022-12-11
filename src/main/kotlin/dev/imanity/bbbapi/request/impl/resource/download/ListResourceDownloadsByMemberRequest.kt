package dev.imanity.bbbapi.request.impl.resource.download

import dev.imanity.bbbapi.model.Download
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListResourceDownloadsByMemberRequest(
    val resourceId: Int,
    val memberId: Int,
    val sortOptions: SortOptions
) : Request<Array<Download>>(
    "resources/$resourceId/downloads/members/$memberId${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Array<Download> {
        return dev.imanity.bbbapi.decodeResponse(httpResponse)
    }
}