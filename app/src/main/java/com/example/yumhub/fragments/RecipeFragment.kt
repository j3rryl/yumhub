package com.example.yumhub.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yumhub.R
import com.example.yumhub.RecipeItemActivity
import com.example.yumhub.adapters.RecyclerAdapter
import com.example.yumhub.roomdb.RecipeApplication
import com.example.yumhub.roomdb.RecipeItem
import com.example.yumhub.roomdb.RecipeItemModelFactory
import com.example.yumhub.roomdb.RecipeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment(), RecyclerAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeArrayList: ArrayList<RecipeItem>
    private val recipeViewModel: RecipeViewModel by viewModels {
        RecipeItemModelFactory((requireActivity().application as RecipeApplication).repository)
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)
        //Toolbar
        val toolbar: Toolbar = root.findViewById(R.id.recipe_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        // Title
        (activity as AppCompatActivity).supportActionBar?.title = "Recipes"

        // Get the reference to the RecyclerView
        recyclerView = root.findViewById(R.id.list_of_recipes)

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(requireContext() as Activity)
//        recyclerView.adapter = RecyclerAdapter(recipeArrayList, this)

        val adapter = RecyclerAdapter(requireActivity(), ArrayList(), this)
        recyclerView.adapter = adapter

        // Observe changes in the database and update the list
        recipeViewModel.allRecipeItems.observe(viewLifecycleOwner, Observer { recipes ->
            adapter.clear()
            adapter.addAll(recipes)
        })
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecipeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecipeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(item: RecipeItem) {
        val recipe_type = item.recipe_type
        val recipe_difficulty = item.recipe_difficulty
        val recipe_image = item.recipe_image
        val recipe_title = item.recipe_title
        val recipe_quantity = item.recipe_quantity
        val recipe_ingredients = item.recipe_ingredients
        val recipe_preparation_steps = item.recipe_preparation_steps


        val i = Intent(requireContext() as Activity, RecipeItemActivity::class.java)
        i.putExtra("recipe_type", recipe_type)
        i.putExtra("recipe_difficulty", recipe_difficulty)
        i.putExtra("recipe_image", recipe_image)

        i.putExtra("recipe_title", recipe_title)
        i.putExtra("recipe_quantity", recipe_quantity)
        i.putExtra("recipe_ingredients", recipe_ingredients)
        i.putExtra("recipe_preparation_steps", recipe_preparation_steps)
        startActivity(i)
    }
}