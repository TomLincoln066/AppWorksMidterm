package com.example.projecttodelete

//class HomeFragmentAdapter :
//    ListAdapter<String, DetailColorAdapter.DetailViewHolder>(
//        DiffCallback
//    ) {
//    /**
//     * The MarsPropertyViewHolder constructor takes the binding variable from the associate
//     * GridViewItem, which nicely gives it access to the full [MarsProperty] information.
//     */
//
//    class DetailViewHolder(private var binding: DetailColorItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(string: String) {
//            binding.color = string
//            // This is important, because it forces the data binding to execute immediately,
//            // which allows the RecyclerView to make the correct view size measurements
//            binding.executePendingBindings()
//        }
//    }
//
//    /**
//     * Allows the RecyclerView to determine which items have changed when the [List] of [MarsProperty]
//     * has been updated.
//     */
//    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
//        override fun areItemsTheSame(
//            oldItem: String,
//            newItem: String
//        ): Boolean {
//            return oldItem === newItem
//        }
//
//        override fun areContentsTheSame(
//            oldItem: String,
//            newItem: String
//        ): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    /**
//     * Create new [RecyclerView] item views (invoked by the layout manager)
//     */
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): DetailViewHolder {
//        return DetailViewHolder(
//            DetailColorItemBinding.inflate(LayoutInflater.from(parent.context))
//        )
//    }
//
//    /**
//     * Replaces the contents of a view (invoked by the layout manager)
//     */
//    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
//        val string = getItem(position)
//        holder.bind(string)
//    }
//}


