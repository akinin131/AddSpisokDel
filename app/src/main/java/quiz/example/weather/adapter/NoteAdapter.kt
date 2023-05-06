package quiz.example.weather.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import quiz.example.weather.*
import quiz.example.weather.screens.BottomSheetDetail

import quiz.example.weather.databinding.ItemLayoutBinding
import quiz.example.weather.model.NoteModel
import quiz.example.weather.screens.ProgressFragment.MyClass.Companion.PointsForCompletedTasksStatic
import quiz.example.weather.viewModel.UpdateNoteViewModel

import java.util.Collections.emptyList

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()

    inner class NoteViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteModel) {
            binding.apply {
                textView3.text = note.title
                checkBox.setOnCheckedChangeListener(null) // Удалите существующий прослушиватель, чтобы избежать дублирования обновлений.
                checkBox.isChecked = note.isCompleted
                checkBox.setOnCheckedChangeListener { _, isChecked ->
                    note.isCompleted = isChecked
                    UpdateNoteViewModel().update(note) {}
                    if (note.isCompleted) {
                        checkBox.isChecked = true
                        PointsForCompletedTasksStatic += 1

                    } else {
                        checkBox.isChecked = false
                        if (PointsForCompletedTasksStatic > 0) {
                            PointsForCompletedTasksStatic -= 1
                        }
                    }
                }

                if (note.isCompleted) {
                    textView3.paintFlags = textView3.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    checkBox.isChecked = true

                } else {
                    textView3.paintFlags =
                        textView3.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    checkBox.isChecked = false

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = listNote[position]
        holder.bind(note)
        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "$position", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount() = listNote.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            val note = listNote[holder.adapterPosition]
            val bottomSheet = BottomSheetDetail.newInstanceDetail(note)
            bottomSheet.show(
                (holder.itemView.context as MainActivity).supportFragmentManager,
                "MyBottomSheetDialogFragment"
            )
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}





