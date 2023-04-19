package quiz.example.weather.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import quiz.example.weather.db.dao.NoteDao
import quiz.example.weather.model.NoteModel


@Database(entities = [NoteModel::class], version = 2)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNotDao(): NoteDao

    companion object {
        private var database: NoteDataBase? = null


        @Synchronized
        fun getInstance(context: Context): NoteDataBase {

            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db")
                    .fallbackToDestructiveMigration()
                    .build()
                database as NoteDataBase
            } else {
                database as NoteDataBase
            }
        }
    }
}




