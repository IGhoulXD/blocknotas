import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_agregar_nota.*

class AgregarNotaFragment : Fragment(R.layout.fragment_agregar_nota) {

    private val notaViewModel: NotaViewModel by viewModels {
        NotaViewModelFactory((requireActivity().application as NotaApp).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGuardarNota.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val descripcion = etDescripcion.text.toString()
            val nota = Nota(titulo = titulo, descripcion = descripcion, fechaHora = System.currentTimeMillis(), esImportante = cbImportante.isChecked)
            notaViewModel.insertarNota(nota)
            findNavController().popBackStack()
        }
    }
}

