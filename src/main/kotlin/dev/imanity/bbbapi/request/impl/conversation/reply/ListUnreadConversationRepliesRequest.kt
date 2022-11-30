package dev.imanity.bbbapi.request.impl.conversation.reply

import dev.imanity.bbbapi.model.Reply
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListUnreadConversationRepliesRequest(
    conversationId: Int,
    sortOptions: SortOptions
): Request<Array<Reply>>(
    "conversations/$conversationId/replies${sortOptions}",
    Method.GET,
    null
)