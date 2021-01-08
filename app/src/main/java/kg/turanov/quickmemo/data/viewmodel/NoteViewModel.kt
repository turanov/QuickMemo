package kg.turanov.quickmemo.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kg.turanov.quickmemo.data.NoteDatabase
import kg.turanov.quickmemo.data.models.NoteData
import kg.turanov.quickmemo.data.repo.NoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    private val noteDao = NoteDatabase.getDatabase(
        application
    ).toDoDao()
    private val noteRepo: NoteRepo

    val getAllData: LiveData<List<NoteData>>
    init {
        this.noteRepo = NoteRepo(noteDao)
        getAllData = this.noteRepo.getAllData
    }
    fun insertData(noteData: NoteData) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.insertData(noteData)
        }
    }

    fun updateData(noteData: NoteData) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.updateData(noteData)
        }
    }

    fun deleteItem(noteData: NoteData) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.deleteItem(noteData)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.deleteAll()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<NoteData>>{
        return this.noteRepo.searchDatabase(searchQuery)
    }

}