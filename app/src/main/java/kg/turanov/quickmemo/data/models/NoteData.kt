package kg.turanov.quickmemo.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var Id:Int,
    var title:String,
    var description:String
):Parcelable