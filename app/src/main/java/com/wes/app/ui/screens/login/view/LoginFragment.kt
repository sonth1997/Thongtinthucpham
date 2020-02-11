package com.wes.app.ui.screens.login.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.wes.app.R
import com.wes.app.pref.AppPrefs
import com.wes.app.ui.activities.MainActivity
import com.wes.app.ui.screens.login.model.LoginRequest
import com.wes.base.fragments.BaseAppFragment
import com.wes.base.util.AppLog
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseAppFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_login
    var navController: NavController? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = edtUsername.text.toString()
        val pass = edtPassword.text.toString()

        val loginRequest = LoginRequest(email, pass)
        api?.login("login", loginRequest, success = { request, apiResponse ->
            if (apiResponse.isSuccess) {
                val user = apiResponse.data
                AppLog.d("data: ${user?.email} -- ${user?.name}")
                AppPrefs.getInstance().user = user
                gotoHome()
            } else {
                Toast.makeText(context, "Loi code: ${apiResponse.code} ", Toast.LENGTH_SHORT).show()
            }
        }, error = { requestId, e ->
            Toast.makeText(context, "Loi message: ${e.message}", Toast.LENGTH_SHORT).show()
        })
    }

    private fun gotoHome() {
        startActivity(Intent(context, MainActivity::class.java))
        activity?.finish()
    }
}
