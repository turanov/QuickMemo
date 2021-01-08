package kg.turanov.quickmemo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.turanov.quickmemo.data.models.NoteData

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun getAllData():LiveData<List<NoteData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(noteData: NoteData)

    @Update
    suspend fun updateData(noteData: NoteData)


    @Delete
    suspend fun deleteItem(noteData: NoteData)


    @Query("DELETE FROM note_table")
    suspend fun deleteAll()


    @Query("SELECT * FROM note_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<NoteData>>
}