package quiz.example.weather.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var title: String = "",
    @ColumnInfo
    var description: String = "",
    @ColumnInfo
    var isChecked: Boolean = false, // add isChecked field for checkbox state
    @ColumnInfo
    var isCompleted: Boolean = false // add boolean field for checkbox
) : Serializable