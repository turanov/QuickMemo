package kg.turanov.quickmemo.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kg.turanov.quickmemo.data.models.NoteData

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    val emptyDatabase:MutableLiveData<Boolean> = MutableLiveData(true)

    fun checkIsDatabaseEmpty(noteData: List<NoteData>){
        emptyDatabase.value = noteData.isEmpty()
    }
    fun verifyDataFromUser(title: String, description: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }
}