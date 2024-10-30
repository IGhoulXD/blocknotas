import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_nota.*

class NotaFragment : Fragment(R.layout.fragment_nota) {

    private val notaViewModel: NotaViewModel by viewModels {
        NotaViewModelFactory((requireActivity().application as NotaApp).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NotaAdapter()
        recyclerViewNotas.layoutManager = LinearLayoutManager(context)
        recyclerViewNotas.adapter = adapter

        notaViewModel.todasLasNotas.observe(viewLifecycleOwner) { notas ->
            notas?.let { adapter.submitList(it) }
        }

        fabAgregarNota.setOnClickListener {
            findNavController().navigate(R.id.action_notaFragment_to_agregarNotaFragment)
        }
    }
}
