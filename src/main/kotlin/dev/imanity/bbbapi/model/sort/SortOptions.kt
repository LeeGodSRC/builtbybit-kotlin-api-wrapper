package dev.imanity.bbbapi.model.sort

data class SortOptions(private val sortableField: String?, private val order: Order?, val page: Int?) {
    override fun toString(): String {
        var retVal = "";

        sortableField ?.let { retVal += "?sort=$it" }
        order ?.let {
            retVal += if (retVal.isEmpty())
                "?order=$it"
            else
                "&order=$it"
        }

        page ?.let {
            retVal += if (retVal.isEmpty())
                "?page=$it"
            else
                "&page=$it"
        }

        return retVal
    }

    companion object {
        val DEFAULT = SortOptions(null, null, null)
    }
}