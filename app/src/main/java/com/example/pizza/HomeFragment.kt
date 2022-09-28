package com.example.pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.databinding.FragmentHomeBinding
import com.example.pizza.model.OrderViewModel
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val sharedViewModel : OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = FragmentHomeBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context,2)
        binding.recycler.layoutManager = layoutManager

        val adapter:RecyclerView.Adapter<MenuAdapter.ViewHolder> = MenuAdapter()
        binding.recycler.adapter = adapter

        sharedViewModel?.pizzaMutableLiveData?.observe(viewLifecycleOwner,pizzaListUpdateObserver)
        var pizzaListUpdateObserver : Observer<ArrayList<Pizza>?> =
            Observer<ArrayList<Pizza>?> { pizzas ->
                val adapter:RecyclerView.Adapter<MenuAdapter.ViewHolder> = MenuAdapter()
                binding.recycler.adapter = adapter
            }


    }

    fun goToPizzaDetails(){
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

}