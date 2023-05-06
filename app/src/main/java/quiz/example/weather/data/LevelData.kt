package quiz.example.weather.data

import android.content.Context
import androidx.annotation.StringRes
import quiz.example.weather.R
import quiz.example.weather.model.LevelModel

object LevelData {

    fun getLevelUser(context: Context) = listOf(
        LevelModel(context.getString(R.string.Worm), 7),
        LevelModel(context.getString(R.string.Newbie), 9),
        LevelModel(context.getString(R.string.Student), 11),
        LevelModel(context.getString(R.string.Amateur), 400),
        LevelModel(context.getString(R.string.Advanced), 600),
        LevelModel(context.getString(R.string.Expert), 900),
        LevelModel(context.getString(R.string.Master), 1200),
        LevelModel(context.getString(R.string.Summoned), 1500),
        LevelModel(context.getString(R.string.Legend), 1700),
        LevelModel(context.getString(R.string.King), 2000),
        LevelModel(context.getString(R.string.Titanium), 2200),
        LevelModel(context.getString(R.string.God), 2500),
        LevelModel(context.getString(R.string.TDeity), 2800),
        LevelModel(context.getString(R.string.TGuru), 3200),
        LevelModel(context.getString(R.string.Wizard), 3500),
        LevelModel(context.getString(R.string.Superman), 3800),
        LevelModel(context.getString(R.string.Mutant), 4200),
        LevelModel(context.getString(R.string.Monster), 4500),
        LevelModel(context.getString(R.string.Immortal), 5000)
    )
}