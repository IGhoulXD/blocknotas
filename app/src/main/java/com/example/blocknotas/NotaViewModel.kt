import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NotaViewModel(private val repository: NotaRepository) : ViewModel() {

    val todasLasNotas: LiveData<List<Nota>> = repository.todasLasNotas

    fun insertarNota(nota: Nota) = viewModelScope.launch {
        repository.insertarNota(nota)
    }

    fun actualizarNota(nota: Nota) = viewModelScope.launch {
        repository.actualizarNota(nota)
    }

    fun eliminarNota(nota: Nota) = viewModelScope.launch {
        repository.eliminarNota(nota)
    }
}

class NotaViewModelFactory(private val repository: NotaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
