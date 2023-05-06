package quiz.example.weather.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import quiz.example.weather.data.LevelData

class ViewModelProgress : ViewModel() {
    private val _level = MutableLiveData<String?>()
    val level: LiveData<String?>
        get() = _level

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    fun setLevelAndScore(score: Int, context: Context) {
        val levels = LevelData.getLevelUser(context)
        var currentLevel = levels[0]
        for (level in levels) {
            if (score >= level.countLevel) {
                currentLevel = level
            } else {
                break
            }
        }
        _level.value = currentLevel.nameLevel
        _score.value = score
    }
}