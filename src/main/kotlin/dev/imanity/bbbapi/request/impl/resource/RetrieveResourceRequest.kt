package dev.imanity.bbbapi.request.impl.resource

import dev.imanity.bbbapi.model.Resource
import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class RetrieveResourceRequest(resourceId: Int) :
    Request<Resource>("resources/$resourceId", Method.GET, null)