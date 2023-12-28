package com.example.yumhub.roomdb

import androidx.room.ColumnInfo
import com.example.yumhub.R

object SampleRecipeData {

    fun getSampleRecipes(): List<RecipeItem> {
        return listOf(
            RecipeItem(
                recipe_title = "Chicken Tikka",
                recipe_type = "Dinner",
                recipe_difficulty = "Intermediate",
                recipe_ingredients = "1 cup yogurt\n" +
                        "\n" +
                        "1 tablespoon lemon juice\n" +
                        "\n" +
                        "4 teaspoons ground cumin, divided\n" +
                        "\n" +
                        "1 teaspoon ground cinnamon\n" +
                        "\n" +
                        "2 teaspoons cayenne pepper\n" +
                        "\n" +
                        "2 teaspoons freshly ground black pepper\n" +
                        "\n" +
                        "1 tablespoon minced fresh ginger\n" +
                        "\n" +
                        "2 teaspoons salt, divided, or more to taste\n" +
                        "\n" +
                        "3 boneless skinless chicken breasts, cut into bite-size pieces\n" +
                        "\n" +
                        "4 long skewers\n" +
                        "\n" +
                        "1 tablespoon butter\n" +
                        "\n" +
                        "1 clove garlic, minced\n" +
                        "\n" +
                        "1 jalapeno pepper, finely chopped\n" +
                        "\n" +
                        "2 teaspoons paprika\n" +
                        "\n" +
                        "1 (8 ounce) can tomato sauce\n" +
                        "\n" +
                        "1 cup heavy cream\n" +
                        "\n" +
                        "¼ cup chopped fresh cilantro",
                recipe_preparation_steps="Place the chicken pieces into a bowl with yogurt, garlic, ginger, lemon juice, coriander, turmeric, cumin, paprika, chilli powder, cinnamon, salt and pepper.\n" +
                        "Mix together, cover and marinate in the fridge for 2-3 hours.\n" +
                        "Thread onto skewers, then brush with oil.\n" +
                        "Cook on a griddle plate, under the grill (broiler) or on the barbecue for 8-10 minutes until cooked through.\n" +
                        "Serve with a sprinkling of freshly chopped coriander.\n",
                recipe_quantity=3,
                recipe_image = R.drawable.chicken
            ),
            RecipeItem(
                recipe_title = "Beef Barbaque",
                recipe_type = "Lunch",
                recipe_difficulty = "Intermediate",
                recipe_ingredients = "recipe_ingredients\n" +
                        "1 ½ cups ketchup\n" +
                        "\n" +
                        "¼ cup packed brown sugar\n" +
                        "\n" +
                        "¼ cup red wine vinegar\n" +
                        "\n" +
                        "2 tablespoons prepared Dijon-style mustard\n" +
                        "\n" +
                        "2 tablespoons Worcestershire sauce\n" +
                        "\n" +
                        "1 teaspoon liquid smoke flavoring\n" +
                        "\n" +
                        "½ teaspoon salt\n" +
                        "\n" +
                        "¼ teaspoon ground black pepper\n" +
                        "\n" +
                        "¼ teaspoon garlic powder\n" +
                        "\n" +
                        "1 (4 pound) boneless chuck roast",
                recipe_preparation_steps="Combine ketchup, brown sugar, red wine vinegar, Dijon-style mustard, Worcestershire sauce, and liquid smoke. Stir in salt, pepper, and garlic powder.\n" +
                        "\n" +
                        "Place chuck roast in a slow cooker. Pour ketchup mixture over chuck roast. Cover and cook on Low for 8 to 10 hours.\n" +
                        "\n" +
                        "Remove chuck roast from slow cooker, shred with a fork, and return to the slow cooker. Stir meat to evenly coat with sauce. Continue cooking for approximately 1 hour more.",
                recipe_quantity=5,
                recipe_image = R.drawable.bolognese
            ),
            RecipeItem(
                recipe_title = "Spanish Omelette",
                recipe_type = "Breakfast",
                recipe_difficulty = "Beginner",
                recipe_ingredients = "Heat the oil in a nonstick medium-sized (30cm/12-inch) pan. Fry potatoes until crispy, golden and tender. Add the onion and fry until transparent. Drain oil (use a metal colander if you have one), until all of the oil is drained. \n" +
                        "Return potatoes and onions to the pan, arranging them in a single layer. Reduce heat down to low.\n" +
                        "Beat eggs with salt and pepper to taste. Pour egg mixture into the pan, moving the potatoes and onions around the eggs using a plastic spatula. Every so often, move the eggs around the potatoes while it's cooking to ensure the eggs cook on the bottom, so there's not much eggs left on the top.\n" +
                        "\n" +
                        "Place a big, round plate on top of the pan, and with your hand holding the plate, flip the tortilla onto the plate. Then, slide the tortilla back into the pan carefully, moving the onion and potatoes carefully back into the pan along with the tortilla.\n" +
                        "Keep cooking, gently shaking the pan occasionally, until completely cooked through.\n" +
                        "To remove the tortilla from the pan, place a clean plate on top of the tortilla and flip again onto the plate. Garnish with parsley (optional).\n" +
                        "Serve with a salad, or use as an entree or appetiser. Great for snacks. Traditionally served as tapas in little squares.",
                recipe_preparation_steps="Combine ketchup, brown sugar, red wine vinegar, Dijon-style mustard, Worcestershire sauce, and liquid smoke. Stir in salt, pepper, and garlic powder.\n" +
                        "\n" +
                        "Place chuck roast in a slow cooker. Pour ketchup mixture over chuck roast. Cover and cook on Low for 8 to 10 hours.\n" +
                        "\n" +
                        "Remove chuck roast from slow cooker, shred with a fork, and return to the slow cooker. Stir meat to evenly coat with sauce. Continue cooking for approximately 1 hour more.",
                recipe_quantity=2,
                recipe_image = R.drawable.beef
            ),
            RecipeItem(
                recipe_title = "Egg curry and spaghetti\n",
                recipe_type = "Supper",
                recipe_difficulty = "Advanced",
                recipe_ingredients = "Spaghetti\n" +
                        "2 eggs\n" +
                        "1 onion - diced\n" +
                        "2 tomatoes diced\n" +
                        "Salt\n" +
                        "Cooking oil",
                recipe_preparation_steps="Step 1\n" +
                        "Boil water then add spaghetti and salt and let it cook\n" +
                        "Step 2\n" +
                        "Drain water when spaghetti is cooked. Then boil eggs\n" +
                        "Step 3\n" +
                        "Fry onions and tomatoes then add boiled eggs and salt\n" +
                        "Step 4\n" +
                        "Stir a little then remove and serve.",
                recipe_quantity=3,
                recipe_image = R.drawable.avocado
            ),
            RecipeItem(
                recipe_title = "Mahamri",
                recipe_type = "Breakfast",
                recipe_difficulty = "Beginner",
                recipe_ingredients = "Plain Flour – all purpose flour, maida, for the dough and extra for dusting.\n" +
                        "Sugar – normal white sugar.\n" +
                        "Yeast – use instant or normal dry active yeast.\n" +
                        "Coconut Milk – use thick coconut milk for full coconut flavour.\n" +
                        "Milk – hot\n" +
                        "Cardamom Powder – elachi\n" +
                        "Ghee – clarified butter is the preferred choice. If you don’t have any then use butter.\n" +
                        "Oil – any of your choice for deep frying.",
                recipe_preparation_steps="PREPARATION OF THE DOUGH:\n" +
                        "Sieve flour into a big bowl and mix in the cardamom powder and sugar.\n" +
                        "Add the instant yeast and mix well.\n" +
                        "Add 1 tbsp ghee and rub it into the flour.\n" +
                        "Mix the hot milk and coconut milk.\n" +
                        "Using the milk mixture, form a soft dough.\n" +
                        "Using the remaining butter or ghee, knead the dough for 5 minutes till it becomes smooth.\n" +
                        "Lightly grease a bowl. Place the dough in it. Cover with cling film and let the dough rise for about 1½ - 2 hours. Fermenting time will depend on how cold or warm your place is.\n" +
                        "ROLLING THE MAHAMRI:\n" +
                        "Sieve some flour onto baking sheets or trays sparingly.\n" +
                        "Knead the dough gently. Divide the dough into 8 parts.\n" +
                        "Roll each part into a ball.\n" +
                        "Roll out one ball into a 6  inch diameter circle, using some flour.\n" +
                        "Cut it into 4 parts using a sharp knife or a pizza cutter.\n" +
                        "Place the triangles onto the floured baking sheet or tray.\n" +
                        "Repeat with the remaining dough.\n" +
                        "FRYING MAHAMRI:\n" +
                        "Heat oil in a frying pan, wok or karai oer medium heat. Add a small piece of the dough into the hot oil. If it sizzles and comes up immedaitely then the oil is ready.\n" +
                        "When it is hot, place the triangles (3 to 4 at a time) in it gently and fry till they are golden brown. Remember not to fry them over high heat as they will brown quickly and the inside will remain raw.\n" +
                        "Remove the fried mahamri into a colander and repeat with the remaining triangles.\n" +
                        "Serve hot with any curry of your choice or some spicy tea or coffee.",
                recipe_quantity=4,
                recipe_image = R.drawable.curry
            ),
        )
    }
}