import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarNota(nota: Nota)

    @Update
    suspend fun actualizarNota(nota: Nota)

    @Delete
    suspend fun eliminarNota(nota: Nota)

    @Query("SELECT * FROM nota ORDER BY fechaHora DESC")
    fun obtenerTodasLasNotas(): LiveData<List<Nota>>
}
