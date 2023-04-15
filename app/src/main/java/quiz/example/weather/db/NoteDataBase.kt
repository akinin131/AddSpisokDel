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
            return database ?: Room.databaseBuilder(
                context.applicationContext,
                NoteDataBase::class.java,
                "db"
            ).addMigrations(MIGRATION_1_2).build().also {
                database = it
            }
        }

        // Migration from version 1 to 2
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS note_table (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT, description TEXT, isCompleted INTEGER NOT NULL DEFAULT 0)"
                )
            }
        }
    }
}






