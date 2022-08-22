package quiz.example.weather.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import quiz.example.weather.APP
import quiz.example.weather.R
import quiz.example.weather.databinding.ItemLayoutBinding
import quiz.example.weather.model.NoteModel
import quiz.example.weather.screens.start.StartFragment
import java.util.Collections.emptyList

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    var ListNote = emptyList<NoteModel>()

    class NoteViewHolder (view:View):RecyclerView.ViewHolder(view){
        private val binding = ItemLayoutBinding.bind(view)
        fun bind(note: NoteModel) {
            binding.apply{
                binding.textView3.text =note.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(ListNote [position])
        holder.itemView.setOnClickListener{
            Toast.makeText(APP, ""+position,Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return ListNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        ListNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(ListNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}




