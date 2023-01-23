package com.irancell.nwg.ios.views.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.irancell.nwg.ios.R


abstract class BaseFragment<V : ViewBinding> : Fragment() {

    protected lateinit var viewBinding: V

    protected lateinit var lifecycleOwner : LifecycleOwner
    protected abstract fun inflateBiding(inflater: LayoutInflater?, container: ViewGroup?): V
    protected abstract fun initView()
    abstract fun onActivityResult(resultCode: Int, data: Intent?,bundle: Bundle)


    fun tabNavigate(destination : Int){
        val navController = findNavController()
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .setLaunchSingleTop(true)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()

        navController.navigate(destination, null, navOptions);
    }

    fun navigate(destination : Int){
        val navController = findNavController()
        val navOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_from_left)
            .setPopExitAnim(R.anim.enter_to_right)
            .setPopEnterAnim(R.anim.exit_to_left)
            .build()
        navController.navigate(destination, null, navOptions);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = inflateBiding(inflater, container)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    lateinit var bundle : Bundle
    fun startForResultsExtras(action : String,bundle: Bundle)
    {
        val chooserIntent = Intent(action)
        this.bundle = bundle
        startActivityIntent.launch(chooserIntent)
    }

    private var startActivityIntent: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        onActivityResult(it.resultCode,it.data,this.bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}