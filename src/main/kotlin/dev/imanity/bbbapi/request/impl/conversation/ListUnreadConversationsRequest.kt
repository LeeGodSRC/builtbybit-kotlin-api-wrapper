package dev.imanity.bbbapi.request.impl.conversation

import dev.imanity.bbbapi.decodeResponse
import dev.imanity.bbbapi.model.Conversation
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request
import dev.imanity.bbbapi.request.Response
import io.ktor.client.statement.*

data class ListUnreadConversationsRequest(
    val sortOptions: SortOptions
): Request<Array<Conversation>>(
    "conversations/conversations${sortOptions}",
    Method.GET,
    null
) {
    override suspend fun decode(httpResponse: HttpResponse): Response<Array<Conversation>> {
        return decodeResponse(httpResponse)
    }
}