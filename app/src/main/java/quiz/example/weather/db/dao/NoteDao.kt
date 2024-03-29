package quiz.example.weather.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import quiz.example.weather.model.NoteModel


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(noteModel: NoteModel)

    @Delete
    fun delete(noteModel: NoteModel)

    @Update
    fun update(noteModel: NoteModel)

    @Query("SELECT *from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}


