package dev.imanity.bbbapi.request.impl

import dev.imanity.bbbapi.request.Method
import dev.imanity.bbbapi.request.Request

class HealthRequest: Request<String>("health", Method.GET, null)