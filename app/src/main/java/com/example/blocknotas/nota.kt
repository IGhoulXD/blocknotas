import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nota")
data class Nota(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val fechaHora: Long,
    val esImportante: Boolean
)
