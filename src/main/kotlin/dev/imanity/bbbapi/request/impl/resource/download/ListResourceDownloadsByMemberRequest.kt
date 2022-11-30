package dev.imanity.bbbapi.request.impl.resource.download

import dev.imanity.bbbapi.model.Download
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListResourceDownloadsByMemberRequest(resourceId: Int, memberId: Int, sortOptions: SortOptions) : Request<Array<Download>>(
    "resources/$resourceId/downloads/members/$memberId${sortOptions}",
    Method.GET,
    null
)