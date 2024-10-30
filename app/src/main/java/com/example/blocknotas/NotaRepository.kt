class NotaRepository(private val notaDao: NotaDao) {

    val todasLasNotas: LiveData<List<Nota>> = notaDao.obtenerTodasLasNotas()

    suspend fun insertarNota(nota: Nota) {
        notaDao.insertarNota(nota)
    }

    suspend fun actualizarNota(nota: Nota) {
        notaDao.actualizarNota(nota)
    }

    suspend fun eliminarNota(nota: Nota) {
        notaDao.eliminarNota(nota)
    }
}
