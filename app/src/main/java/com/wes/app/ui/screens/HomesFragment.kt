package com.wes.app.ui.screens


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.wes.app.R
import com.wes.app.ui.adapter.CustomAdapter
import com.wes.app.ui.models.Food
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_homes.*
import kotlinx.android.synthetic.main.fragment_homes.title
import java.text.SimpleDateFormat


/**
 * A simple [Fragment] subclass.
 */
class HomesFragment : BaseAppFragment(), CustomAdapter.onClickItemFood {

    private lateinit var adapterFood: CustomAdapter
    override val layoutRes = R.layout.fragment_homes
    private val date = System.currentTimeMillis()
    private val formatDate = SimpleDateFormat("yyyy/MM/dd 'at' HH:mm:ss")

    private var mdata: MutableList<Food> = mutableListOf(
            Food("First", "Cha ca", R.drawable.bitmap),
            Food("First", "Cha ca", R.drawable.bitmaptwo),
            Food("First", "Cha ca", R.drawable.bitmapthree)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterFood = CustomAdapter(this)
        adapterFood.setData(mdata)
        rvHomeFood.adapter = adapterFood
        title.text = formatDate.format(date)
    }
    override fun OnClickItemFood(food: Food) {
        findNavController().navigate(R.id.action_homes_to_details)

    }

}

