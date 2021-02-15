
class SessionScrollListener (
    private val layoutManager: LinearLayoutManager,
    private val callback: () -> Unit
) : RecyclerView.OnScrollListener() {

    private var loading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
        if (loading && (visibleItemCount + firstVisibleItem) == totalItemCount-2) {
            loading = false
            callback()
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
            loading = true;
        }
    }
}
