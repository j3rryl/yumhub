package com.example.yumhub.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.yumhub.R
import com.example.yumhub.roomdb.RecipeItem
import com.example.yumhub.roomdb.RecipeItemDatabase
import com.example.yumhub.roomdb.RecipeItemRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddRecipeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var inputTitle: TextInputEditText
    private lateinit var inputDifficulty: TextInputEditText
    private lateinit var inputType: TextInputEditText
    private lateinit var inputIngredients: TextInputEditText
    private lateinit var inputServings: TextInputEditText
    private lateinit var inputPreps: TextInputEditText

    private val database by lazy { RecipeItemDatabase.getDatabase(requireActivity()) }
    val repository by lazy { RecipeItemRepository(database.recipeItemDao()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        inputTitle = view.findViewById(R.id.input_title)

        inputDifficulty = view.findViewById(R.id.input_difficulty)

        inputType = view.findViewById(R.id.input_type)

        inputIngredients = view.findViewById(R.id.input_ingredients)

        inputPreps = view.findViewById(R.id.input_prep)

        inputServings = view.findViewById(R.id.input_servings)


        val saveButton: Button = view.findViewById(R.id.save_recipe_button)

        saveButton.setOnClickListener{
            var titleText: String = inputTitle.text.toString().trim()
            var difficultyText: String = inputDifficulty.text.toString().trim()
            var typeText: String = inputType.text.toString().trim()
            var ingredientsText: String = inputIngredients.text.toString().trim()
            var prepText: String = inputPreps.text.toString().trim()
            var servingsText: String = inputServings.text.toString().trim()
            var recipeQuantity: Int = if (servingsText.isNotEmpty()) {
                try {
                    servingsText.toInt()
                } catch (e: NumberFormatException) {
                    // Handle the case where the input is not a valid integer
                    // For example, show an error message or log the issue
                    0 // Default value if the conversion fails
                }
            } else {
                1 // Default value if servingsText is empty
            }

            val resourceIds = intArrayOf(
                R.drawable.avocado,
                R.drawable.beef,
                R.drawable.bolognese,
                R.drawable.burrito,
                R.drawable.chicken,
                R.drawable.curry,
                R.drawable.lemon,
                R.drawable.pancakes,
                R.drawable.panini,
                R.drawable.salmon,
                R.drawable.shrimp,
                R.drawable.veggie,
                R.drawable.wrap,
                R.drawable.yorgurt,
                R.drawable.quinoa
            )

            val randomIndex = Random.nextInt(resourceIds.size) // Generates a random number from 0 to 9

            val selectedResourceId = resourceIds[randomIndex]

            val item = RecipeItem (
                recipe_title = titleText,
                recipe_type = typeText,
                recipe_difficulty = difficultyText,
                recipe_ingredients = ingredientsText,
                recipe_preparation_steps= prepText,
                recipe_quantity= recipeQuantity,
                recipe_image = selectedResourceId
            )
            lifecycleScope.launch {
                repository.insertRecipeItem(item)
            }
            val newFragment = RecipeFragment()

            // Begin the fragment transaction
            val transaction = requireActivity().supportFragmentManager.beginTransaction()

            // Replace the current fragment with the new one
            transaction.replace(R.id.frame_layout, newFragment)

            // Add the transaction to the back stack (optional, enables back navigation)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddRecipeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddRecipeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}