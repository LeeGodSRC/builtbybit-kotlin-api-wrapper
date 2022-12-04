package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.model.Resource
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

data class RetrieveResourceRequest(val resourceId: Int) :
    Request<Resource>("resources/$resourceId", Method.GET, null)