package dev.imanity.bbbapi.request.impl.conversation

import dev.imanity.bbbapi.model.Conversation
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListUnreadConversationsRequest(
    sortOptions: SortOptions
): Request<Array<Conversation>>(
    "conversations/conversations${sortOptions}",
    Method.GET,
    null
)