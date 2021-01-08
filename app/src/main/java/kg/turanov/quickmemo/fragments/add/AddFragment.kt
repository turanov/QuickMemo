package kg.turanov.quickmemo.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kg.turanov.quickmemo.R
import kg.turanov.quickmemo.data.models.NoteData
import kg.turanov.quickmemo.data.viewmodel.NoteViewModel
import kg.turanov.quickmemo.fragments.SharedViewModel
import org.w3c.dom.Text

class AddFragment : Fragment() {
    private lateinit var viewAdd: View
    private val mNoteViewModel: NoteViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewAdd = inflater.inflate(R.layout.fragment_add, container, false)

        //Set Menu
        setHasOptionsMenu(true)

        return viewAdd
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            insertDataToDb();
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val title = viewAdd.findViewById<TextView>(R.id.add_et_title)
        val description = viewAdd.findViewById<TextView>(R.id.add_et_description)

        val validation =
            mSharedViewModel.verifyDataFromUser(title.toString(), description.toString())
        if (validation) {
            val newData = NoteData(
                0,
                title.text.toString(),
                description.text.toString()
            )
            mNoteViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT)
                .show()
        }
    }


}