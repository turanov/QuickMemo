package kg.turanov.quickmemo.data.repo

import androidx.lifecycle.LiveData
import kg.turanov.quickmemo.data.dao.NoteDao
import kg.turanov.quickmemo.data.models.NoteData

class NoteRepo(private val noteDao: NoteDao) {
    val getAllData: LiveData<List<NoteData>> = noteDao.getAllData()

    suspend fun insertData(noteData: NoteData){
        noteDao.insertData(noteData)
    }

    suspend fun updateData(noteData: NoteData){
        noteDao.updateData(noteData)
    }

    suspend fun deleteItem(noteData: NoteData){
        noteDao.deleteItem(noteData)
    }

    suspend fun deleteAll(){
        noteDao.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<NoteData>> {
        return noteDao.searchDatabase(searchQuery)
    }
}