package com.example.pizza.model

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.pizza.Pizza
import com.example.pizza.R
import java.text.NumberFormat

class OrderViewModel : ViewModel() {

    var pizzaMutableLiveData : MutableLiveData<ArrayList<Pizza>?> = MutableLiveData()
    var pizzas : ArrayList<Pizza>? = null

    fun init(){
        createMenu()
        pizzaMutableLiveData.value = pizzas
    }

    private val _image = MutableLiveData<Int>()
    val image : LiveData<Int> = _image

    private val _flavor = MutableLiveData<String>()
    val flavor : LiveData<String> = _flavor

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _size = MutableLiveData<String>()
    val size : LiveData<String> = _size

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        // Format the price into the local currency and return this as LiveData<String>
        NumberFormat.getCurrencyInstance().format(it)
    }


    fun setImage(photo : Int){
        _image.value = photo
    }

    fun setFlavor(desiredFlavor : String){
        _flavor.value = desiredFlavor
    }

    fun setQuantity(amount :Int){
        _quantity.value = amount
    }

    fun setSize(desiredSize : String){
        _size.value = desiredSize
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _size.value = ""
        _image.value = 0
        _price.value = 0.0
    }








    fun createMenu(){
        var pizza = Pizza()
        pizza.name = "Mushroom Pizza"
        pizza.img = R.drawable.pizza1
        pizza.size = "Medium"
        pizza.price = 9.00
        pizza.description = "White pizza with garlic infused olive oil, goat cheese from Jumpin’ Good Goat Dairy, \n" +
                "mozzarella fior di latte and organic, locally raised Shitake mushrooms from Hazel \n" +
                "Dell"
        pizzas?.add(pizza)

        pizza = Pizza()
        pizza.name = "Shrimp Pizza"
        pizza.img = R.drawable.pizza2
        pizza.size = "Medium"
        pizza.price = 14.00
        pizza.description = "White pizza with garlic infused olive oil, goat cheese, fresh mozzarella fior di latte, \n" +
                "prosciutto fired off then topped with arugula and shaved parmesan."
        pizzas?.add(pizza)

        pizza = Pizza()
        pizza.name = "Neapolitan Pizza"
        pizza.img = R.drawable.pizza3
        pizza.size = "Medium"
        pizza.price = 8.00
        pizza.description = "San Marzano tomato sauce, fresh mozzarella fior di latte, fresh organic basil"
        pizzas?.add(pizza)

        pizza = Pizza()
        pizza.name = "Pepperoni Pizza"
        pizza.img = R.drawable.pizza4
        pizza.size = "Medium"
        pizza.price = 10.50
        pizza.description = "San Marzano tomato sauce, fresh mozzarella, grated parmesan and pepperoni from \n" +
                "Il Mondo Vecchio"
        pizzas?.add(pizza)

        pizza = Pizza()
        pizza.name = "Veggie Pizza"
        pizza.img = R.drawable.pizza5
        pizza.size = "Medium"
        pizza.price = 8.00
        pizza.description = "mozzarella, potato, fresh rosemary, extra virgin olive oil"
        pizzas?.add(pizza)

        pizza = Pizza()
        pizza.name = "Four Cheese Pizza"
        pizza.img = R.drawable.pizza6
        pizza.size = "Medium"
        pizza.price = 11.50
        pizza.description = "mozzarella, parmesan, provolone, blue cheese"
        pizzas?.add(pizza)
    }

}