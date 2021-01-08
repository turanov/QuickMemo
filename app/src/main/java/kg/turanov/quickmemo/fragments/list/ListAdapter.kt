package kg.turanov.quickmemo.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kg.turanov.quickmemo.R
import kg.turanov.quickmemo.data.models.NoteData

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var dataList = emptyList<NoteData>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = holder.itemView.findViewById<TextView>(R.id.list_tv_title)
        val description = holder.itemView.findViewById<TextView>(R.id.list_tv_description)
        val rowBackground = holder.itemView.findViewById<ConstraintLayout>(R.id.row_background)

        title.text = dataList[position].title
        description.text = dataList[position].description

        rowBackground.setOnClickListener {
            val action =ListFragmentDirections.actionListFragmentToUpdateFragment(dataList[position])
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData(noteData: List<NoteData>) {
        this.dataList = noteData
        notifyDataSetChanged()
    }
}