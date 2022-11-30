package dev.imanity.bbbapi.request.impl.resource.download

import dev.imanity.bbbapi.model.Download
import dev.imanity.bbbapi.model.sort.SortOptions
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class ListResourceDownloadsByVersionRequest(resourceId: Int, versionId: Int, sortOptions: SortOptions) : Request<Array<Download>>(
    "resources/$resourceId/downloads/versions/$versionId${sortOptions}",
    Method.GET,
    null
)