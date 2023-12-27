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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yuhub.models.RecipeItem
import com.example.yumhub.R
import com.example.yumhub.RecipeItemActivity
import com.example.yumhub.adapters.RecyclerAdapter

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

        // Sample data for the ListView
        val recipe_images = intArrayOf(
            R.drawable.pancakes,
            R.drawable.veggie,
            R.drawable.avocado,
            R.drawable.burrito,
            R.drawable.yorgurt,
            R.drawable.chicken,
            R.drawable.quinoa,
            R.drawable.panini,
            R.drawable.shrimp,
            R.drawable.wrap,
            R.drawable.bolognese,
            R.drawable.lemon,
            R.drawable.curry,
            R.drawable.beef,
            R.drawable.salmon,
        )
        val recipe_titles = arrayOf(
            "Pancakes",
            "Veggie Omelette",
            "Avocado Toast",
            "Breakfast Burritos",
            "Greek Yogurt Parfait",
            "Chicken Caesar Salad",
            "Vegetarian Quinoa Bowl",
            "Grilled Veggie Panini",
            "Shrimp and Broccoli Stir-Fry",
            "Chicken and Avocado Wrap",
            "Spaghetti Bolognese",
            "Lemon Herb Roasted Chicken",
            "Vegetarian Chickpea Curry",
            "Beef Stir-Fry with Broccoli",
            "Baked Salmon with Roasted Vegetables"
        )
        val recipe_types = arrayOf(
            "Breakfast",
            "Breakfast",
            "Breakfast",
            "Breakfast",
            "Breakfast",
            "Lunch",
            "Lunch",
            "Lunch",
            "Lunch",
            "Lunch",
            "Supper",
            "Supper",
            "Supper",
            "Supper",
            "Supper"
        )
        val recipe_difficulties = arrayOf(
            "Beginner",
            "Intermediate",
            "Beginner",
            "Advanced",
            "Beginner",
            "Beginner",
            "Intermediate",
            "Intermediate",
            "Advanced",
            "Beginner",
            "Advanced",
            "Intermediate",
            "Beginner",
            "Advanced",
            "Intermediate"
        )
        val recipe_quantites = intArrayOf(
            4,2,1,3,1,2,4,2,5,2,3,4,4,3,2
        )
        val recipe_ingredients= arrayOf(
            "1 cup all-purpose flour\n" +
                    "2 tablespoons granulated sugar\n" +
                    "2 teaspoons baking powder\n" +
                    "1/2 teaspoon salt\n" +
                    "1 cup milk\n" +
                    "1 large egg\n" +
                    "2 tablespoons unsalted butter, melted\n" +
                    "Cooking spray or extra butter for greasing the pan\n",
            "4 large eggs\n" +
                    "1/4 cup diced bell peppers (any color)\n" +
                    "1/4 cup diced onions\n" +
                    "1/4 cup diced tomatoes\n" +
                    "1/4 cup shredded cheddar cheese\n" +
                    "Salt and pepper to taste\n" +
                    "1 tablespoon vegetable oil or butter\n",
            "1 ripe avocado\n" +
                    "2 slices of whole-grain bread\n" +
                    "1 tablespoon lemon juice\n" +
                    "Salt and pepper to taste\n" +
                    "Optional toppings: sliced tomatoes, red pepper flakes, poached eggs, or feta cheese\n",
            "6 large eggs\n" +
                    "1/4 cup milk\n" +
                    "Salt and pepper to taste\n" +
                    "1 tablespoon vegetable oil\n" +
                    "1/2 cup cooked and crumbled breakfast sausage or bacon\n" +
                    "1/4 cup diced bell peppers (any color)\n" +
                    "1/4 cup diced onions\n" +
                    "1/2 cup shredded cheddar cheese\n" +
                    "3 large flour tortillas\n",
            "1 cup Greek yogurt\n" +
                    "1/2 cup granola\n" +
                    "1/2 cup mixed fresh berries (strawberries, blueberries, raspberries)\n" +
                    "1 tablespoon honey\n" +
                    "1/4 teaspoon vanilla extract\n",
            "2 boneless, skinless chicken breasts\n" +
                    "1 head of romaine lettuce, washed and chopped\n" +
                    "1/2 cup Caesar dressing\n" +
                    "1/4 cup grated Parmesan cheese\n" +
                    "1 cup croutons\n" +
                    "Salt and pepper to taste\n",
            "1 cup quinoa\n" +
                    "2 cups vegetable broth\n" +
                    "1 tablespoon olive oil\n" +
                    "1 medium onion, finely chopped\n" +
                    "2 cloves garlic, minced\n" +
                    "1 cup diced vegetables (bell peppers, zucchini, carrots, etc.)\n" +
                    "1 can (15 oz) chickpeas, drained and rinsed\n" +
                    "1/4 cup chopped fresh parsley\n" +
                    "Juice of 1 lemon\n" +
                    "Salt and pepper to taste\n",
            "4 slices of whole-grain bread\n" +
                    "1/2 cup sliced bell peppers (any color)\n" +
                    "1/2 cup sliced zucchini\n" +
                    "1/2 cup sliced eggplant\n" +
                    "1/4 cup sliced red onion\n" +
                    "1/4 cup sliced tomatoes\n" +
                    "1/2 cup shredded mozzarella cheese\n" +
                    "2 tablespoons pesto sauce\n" +
                    "Olive oil or butter for grilling\n",
            "1 lb large shrimp, peeled and deveined\n" +
                    "2 cups broccoli florets\n" +
                    "1 red bell pepper, sliced\n" +
                    "1/4 cup soy sauce\n" +
                    "2 tablespoons oyster sauce\n" +
                    "2 tablespoons hoisin sauce\n" +
                    "2 cloves garlic, minced\n" +
                    "1 teaspoon grated ginger\n" +
                    "2 tablespoons vegetable oil\n" +
                    "Cooked white rice for serving\n",
            "2 large flour tortillas\n" +
                    "1 cup cooked and shredded chicken breast\n" +
                    "1 ripe avocado, sliced\n" +
                    "1/4 cup diced tomatoes\n" +
                    "1/4 cup shredded lettuce\n" +
                    "2 tablespoons mayonnaise\n" +
                    "1 tablespoon Dijon mustard\n" +
                    "Salt and pepper to taste\n",
            "8 oz (225g) spaghetti\n" +
                    "1 lb (450g) ground beef\n" +
                    "1 can (14 oz) crushed tomatoes\n" +
                    "1/2 cup diced onions\n" +
                    "2 cloves garlic, minced\n" +
                    "1 tablespoon olive oil\n" +
                    "1 teaspoon dried oregano\n" +
                    "1 teaspoon dried basil\n" +
                    "Salt and pepper to taste\n" +
                    "Grated Parmesan cheese (optional, for serving)\n",
            "2 bone-in, skin-on chicken breasts\n" +
                    "2 tablespoons olive oil\n" +
                    "1 lemon, juiced and zested\n" +
                    "2 cloves garlic, minced\n" +
                    "1 teaspoon dried thyme\n" +
                    "1 teaspoon dried rosemary\n" +
                    "Salt and pepper to taste\n",
            "2 cans (15 oz each) chickpeas, drained and rinsed\n" +
                    "1 can (14 oz) diced tomatoes\n" +
                    "1 cup coconut milk\n" +
                    "1 cup vegetable broth\n" +
                    "1 large onion, finely chopped\n" +
                    "2 cloves garlic, minced\n" +
                    "1 tablespoon curry powder\n" +
                    "1 teaspoon ground cumin\n" +
                    "1 teaspoon ground coriander\n" +
                    "1 tablespoon vegetable oil\n" +
                    "Salt and pepper to taste\n" +
                    "Fresh cilantro, for garnish (optional)\n",
            "1 lb (450g) beef sirloin or flank steak, thinly sliced\n" +
                    "2 cups broccoli florets\n" +
                    "1/4 cup soy sauce\n" +
                    "2 tablespoons oyster sauce\n" +
                    "1 tablespoon hoisin sauce\n" +
                    "2 cloves garlic, minced\n" +
                    "1 teaspoon grated ginger\n" +
                    "1 tablespoon vegetable oil\n" +
                    "Cooked white rice for serving\n",
            "2 salmon fillets\n" +
                    "1 cup cherry tomatoes\n" +
                    "1 cup asparagus spears\n" +
                    "1 tablespoon olive oil\n" +
                    "1 teaspoon dried dill\n" +
                    "1/2 teaspoon garlic powder\n" +
                    "1/2 teaspoon onion powder\n" +
                    "Salt and pepper to taste\n" +
                    "Lemon wedges for serving\n"
        )
        val recipe_preparation_steps = arrayOf(
            "In a large mixing bowl, whisk together the flour, sugar, baking powder, and salt.\n" +
                    "In a separate bowl, whisk together the milk, egg, and melted butter.\n" +
                    "Pour the wet ingredients into the dry ingredients and mix until just combined (a few lumps are okay).\n" +
                    "Preheat a non-stick skillet or griddle over medium heat and lightly grease with cooking spray or butter.\n" +
                    "Pour 1/4 cup of batter onto the hot skillet for each pancake.\n" +
                    "Cook until bubbles form on the surface, then flip and cook until golden brown on both sides.\n" +
                    "Serve the pancakes warm with your favorite toppings like maple syrup, fresh fruit, or whipped cream.\n",
            "In a bowl, whisk the eggs and season with salt and pepper.\n" +
                    "Heat oil or butter in a non-stick skillet over medium heat.\n" +
                    "Add the diced vegetables to the skillet and sauté until they are softened.\n" +
                    "Pour the whisked eggs over the vegetables in the skillet.\n" +
                    "Sprinkle shredded cheddar cheese over one half of the omelette.\n" +
                    "Cook until the eggs are set and the cheese has melted.\n" +
                    "Fold the omelette in half and slide it onto a plate to serve.\n",
            "Cut the avocado in half, remove the pit, and scoop the flesh into a bowl.\n" +
                    "Add lemon juice, salt, and pepper to the bowl and mash the avocado with a fork until smooth.\n" +
                    "Toast the slices of bread until they are lightly browned and crispy.\n" +
                    "Spread the mashed avocado mixture evenly on the toasted bread.\n" +
                    "Add optional toppings if desired.\n" +
                    "Serve the avocado toast immediately.\n",
            "In a bowl, whisk the eggs, milk, salt, and pepper together.\n" +
                    "Heat vegetable oil in a skillet over medium heat.\n" +
                    "Pour the egg mixture into the skillet and scramble the eggs until they are cooked through.\n" +
                    "Add the cooked breakfast sausage or bacon, diced bell peppers, and onions to the skillet and cook for a few more minutes until the vegetables are tender.\n" +
                    "Warm the flour tortillas in a separate skillet or microwave.\n" +
                    "Divide the scrambled eggs mixture among the tortillas and top with shredded cheddar cheese.\n" +
                    "Roll up the tortillas into burritos and serve.\n",
            "In a small bowl, mix the Greek yogurt with honey and vanilla extract.\n" +
                    "Layer half of the Greek yogurt in a glass or bowl.\n" +
                    "Add half of the granola on top of the yogurt.\n" +
                    "Layer half of the mixed fresh berries over the granola.\n" +
                    "Repeat the layers with the remaining ingredients.\n" +
                    "Finish with a few extra berries on top for garnish.\n" +
                    "Serve the Greek yogurt parfait immediately or refrigerate for later.\n",
            "Season the chicken breasts with salt and pepper.\n" +
                    "Grill or pan-fry the chicken until fully cooked.\n" +
                    "Let the chicken rest for a few minutes, then slice it into strips.\n" +
                    "In a large bowl, toss the chopped romaine lettuce with Caesar dressing.\n" +
                    "Top the salad with sliced chicken, grated Parmesan cheese, and croutons.\n" +
                    "Serve immediately as a delicious and hearty lunch.\n",
            "Rinse quinoa under cold water and drain.\n" +
                    "In a saucepan, bring vegetable broth to a boil, then add quinoa.\n" +
                    "Reduce heat, cover, and simmer for about 15-20 minutes or until quinoa is cooked and liquid is absorbed.\n" +
                    "In a large skillet, heat olive oil and sauté onions and garlic until softened.\n" +
                    "Add diced vegetables and cook until tender.\n" +
                    "Stir in chickpeas and cooked quinoa, mixing everything well.\n" +
                    "Season with salt, pepper, lemon juice, and fresh parsley.\n" +
                    "Serve the vegetarian quinoa bowl as a nutritious and satisfying lunch option.\n",
            "Preheat a grill pan or panini press.\n" +
                    "Brush one side of each bread slice with olive oil or butter.\n" +
                    "On the non-oiled side, spread pesto sauce on two bread slices.\n" +
                    "Layer the sliced vegetables and mozzarella cheese on top of the pesto.\n" +
                    "Top with the other two bread slices, oiled side facing up.\n" +
                    "Grill the panini until the bread is toasted, and the cheese is melted.\n" +
                    "Slice the panini in half and serve warm.\n",
            "In a bowl, mix together soy sauce, oyster sauce, hoisin sauce, minced garlic, and grated ginger to create the sauce.\n" +
                    "Heat vegetable oil in a large skillet or wok over medium-high heat.\n" +
                    "Add shrimp and stir-fry until they turn pink and opaque. Remove shrimp from the pan and set aside.\n" +
                    "In the same pan, stir-fry broccoli and red bell pepper until they become tender-crisp.\n" +
                    "Add the cooked shrimp back into the pan.\n" +
                    "Pour the sauce over the shrimp and vegetables, tossing everything together until well coated and heated through.\n" +
                    "Serve the shrimp and broccoli stir-fry over cooked white rice.\n",
            "Lay out the flour tortillas on a clean surface.\n" +
                    "In a small bowl, mix together mayonnaise, Dijon mustard, salt, and pepper to create the dressing.\n" +
                    "Spread the dressing evenly on each tortilla.\n" +
                    "Place the shredded chicken, avocado slices, diced tomatoes, and shredded lettuce on one side of each tortilla.\n" +
                    "Roll up the tortillas tightly, enclosing the filling.\n" +
                    "Slice the wraps in half and secure with toothpicks if needed.\n" +
                    "Serve the chicken and avocado wraps as a delightful lunch option.\n",
            "Cook the spaghetti according to the package instructions until al dente. Drain and set aside.\n" +
                    "In a large skillet, heat olive oil over medium heat.\n" +
                    "Add diced onions and minced garlic to the skillet and sauté until softened.\n" +
                    "Add the ground beef to the skillet and cook until browned and fully cooked.\n" +
                    "Stir in crushed tomatoes, dried oregano, dried basil, salt, and pepper. Let it simmer for about 15 minutes.\n" +
                    "Serve the Bolognese sauce over the cooked spaghetti, and sprinkle with grated Parmesan cheese if desired.\n",
            "2 bone-in, skin-on chicken breasts\n" +
                    "2 tablespoons olive oil\n" +
                    "1 lemon, juiced and zested\n" +
                    "2 cloves garlic, minced\n" +
                    "1 teaspoon dried thyme\n" +
                    "1 teaspoon dried rosemary\n" +
                    "Salt and pepper to taste\n",
            "In a large skillet, heat vegetable oil over medium heat.\n" +
                    "Add chopped onions and minced garlic to the skillet and sauté until onions are translucent.\n" +
                    "Stir in curry powder, ground cumin, and ground coriander, and cook for a minute until fragrant.\n" +
                    "Add drained chickpeas, diced tomatoes, coconut milk, and vegetable broth to the skillet. Season with salt and pepper.\n" +
                    "Bring the mixture to a simmer and let it cook for about 15-20 minutes until the flavors meld and the sauce thickens slightly.\n" +
                    "Garnish with fresh cilantro before serving. This curry pairs well with steamed rice or naan bread.\n",
            "In a bowl, mix together soy sauce, oyster sauce, hoisin sauce, minced garlic, and grated ginger to create the sauce.\n" +
                    "Heat vegetable oil in a large skillet or wok over medium-high heat.\n" +
                    "Add the sliced beef to the skillet and stir-fry until it's browned and cooked to your desired doneness. Remove the beef from the skillet and set aside.\n" +
                    "In the same skillet, stir-fry the broccoli until it becomes tender-crisp.\n" +
                    "Return the cooked beef to the skillet and pour the sauce over the beef and broccoli.\n" +
                    "Toss everything together until the beef and broccoli are evenly coated with the sauce.\n" +
                    "Serve the beef stir-fry with broccoli over cooked white rice.\n",
            "Preheat the oven to 400°F (200°C).\n" +
                    "Place the salmon fillets on a baking sheet lined with parchment paper.\n" +
                    "In a bowl, toss the cherry tomatoes and asparagus spears with olive oil, dried dill, garlic powder, onion powder, salt, and pepper.\n" +
                    "Arrange the seasoned vegetables around the salmon fillets on the baking sheet.\n" +
                    "Bake in the preheated oven for about 15-20 minutes or until the salmon is cooked through and the vegetables are tender.\n" +
                    "Serve the baked salmon with roasted vegetables and lemon wedges on the side.\n"

        )
        // Create an ArrayAdapter to populate the ListView with data
        recipeArrayList=ArrayList()
        for (i in recipe_types.indices){
            val recipe = RecipeItem(recipe_types[i],recipe_titles[i], recipe_quantites[i], recipe_difficulties[i], recipe_ingredients[i], recipe_preparation_steps[i], recipe_images[i] )
            recipeArrayList.add(recipe)
        }

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(requireContext() as Activity)
        recyclerView.adapter = RecyclerAdapter(recipeArrayList, this)

//        listView.setOnItemClickListener { parent, view, position, id ->
//            val recipe_type = recipe_types[position]
//            val recipe_difficulty = recipe_difficulties[position]
//            val recipe_image = recipe_images[position]
//            val recipe_title = recipe_titles[position]
//            val recipe_quantity = recipe_quantites[position]
//            val recipe_ingredients = recipe_ingredients[position]
//            val recipe_preparation_steps = recipe_preparation_steps[position]
//
//
//            val i = Intent(requireContext() as Activity, RecipeItemActivity::class.java)
//            i.putExtra("recipe_type", recipe_type)
//            i.putExtra("recipe_difficulty", recipe_difficulty)
//            i.putExtra("recipe_image", recipe_image)
//
//            i.putExtra("recipe_title", recipe_title)
//            i.putExtra("recipe_quantity", recipe_quantity)
//            i.putExtra("recipe_ingredients", recipe_ingredients)
//            i.putExtra("recipe_preparation_steps", recipe_preparation_steps)
//
//
//            startActivity(i)
//
//        }

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