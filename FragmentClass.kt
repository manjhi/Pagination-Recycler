 
        assignManagerSession(groupItems, LinearLayoutManager(context))
 
 
 private fun assignManagerSession(rv: RecyclerView, layoutManager: LinearLayoutManager) {
        val scrollListener = SessionScrollListener(layoutManager) {
            if (sessionTotal >= pageNumberSession) {
                sessionCall(pageNumberSession++, true)
            }
        }
        rv.addOnScrollListener(scrollListener)
        rv.layoutManager = layoutManager
    }
