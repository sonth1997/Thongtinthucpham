package com.wes.app.ui.screens.settingprofile.add

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wes.app.R
import com.wes.app.ui.screens.settingprofile.done.SettingProfile
import com.wes.base.fragments.BaseAppFragment
import com.wes.base.util.goBack
import kotlinx.android.synthetic.main.fragment_add_configuration.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class AddConfigurationFragment : BaseAppFragment(),AddConfigurationAdapter.onClickItemAddConfiguration{

    override val layoutRes = R.layout.fragment_add_configuration
    private lateinit var adapterAddConfiguration: AddConfigurationAdapter
    private var mdata: MutableList<AddConfiguration> = mutableListOf(
            AddConfiguration("Chicken", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("Main core", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("First", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("Salad", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("Dink", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("Coffee", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99))),
            AddConfiguration("Rice", Color.rgb(Random().nextInt(99), Random().nextInt(99), Random().nextInt(99)))
    )

    private var mdataResult: MutableList<AddConfiguration> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mdataResult.clear()
        adapterAddConfiguration = AddConfigurationAdapter(this)
        adapterAddConfiguration.setData(mdata)
        rcvCheckAdd.adapter = adapterAddConfiguration

        tvDone.setOnClickListener {
            if (edtNumber.text.toString().isNullOrEmpty()){
                    toast("Import Number of people or Choose Course")
            }else{
                if(mdataResult.size == 0){
                    toast("Configuration empty")
                }else{
                    EventBus.getDefault().post(
                            SettingProfile(edtNumber.text.toString().toInt(), mdataResult)
                    )
                }
                goBack()
            }
        }
    }
    fun toast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }
    override fun onClickItemAddConfiguration(addConfiguration: AddConfiguration, isChecked: Boolean) {
        if(isChecked){
            mdataResult.add(addConfiguration)
        }else{
            mdataResult.removeAt(mdataResult.indexOf(addConfiguration))
        }
    }
}
