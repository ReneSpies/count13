package me.renespies.count13.fragment.bottomnavigationsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import me.renespies.count13.R
import me.renespies.count13.Util
import me.renespies.count13.databinding.FragmentBottomNavigationSheetBinding
import timber.log.Timber


/**
 *    Created on: 3 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class BottomNavigationSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomNavigationSheetBinding // Binding for the layout
    private lateinit var bottomNavigationSheetViewModel: BottomNavigationSheetViewModel // Corresponding ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.d("onCreateView: called")

        binding = FragmentBottomNavigationSheetBinding.inflate(inflater, container, false)

        bottomNavigationSheetViewModel = ViewModelProvider(this).get(BottomNavigationSheetViewModel::class.java)
        binding.viewModel = bottomNavigationSheetViewModel

        bottomNavigationSheetViewModel.navigateTo.observe(viewLifecycleOwner) {

            navigateTo(it) // Navigate to the appropriate fragment

        }

        return binding.root

    }

    /**
     * Evaluates the [destination] parameter and navigates accordingly using
     * a [androidx.navigation.NavController].
     */
    private fun navigateTo(destination: Util.Navigate) {

        Timber.d("navigateTo: called")

        val navigationHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment // Find the NavigationHostFragment
        val navigationController = navigationHostFragment.navController // Collect the NavigationController from the NavigationHostFragment

        // Build a NavigationOptions object with animation and a popUpTo target
        val navigationOptions = NavOptions.Builder().setPopUpTo(R.id.counterListFragment, false).setEnterAnim(R.anim.fade_in).setPopEnterAnim(R.anim.fade_in).setExitAnim(R.anim.fade_out).setPopExitAnim(R.anim.fade_out).build()

        // Use the NavigationController to navigate to the desired location
        when (destination) {

            Util.Navigate.DEFAULT -> {
            } // Default branch is here for null safety

            Util.Navigate.TO_HOME -> navigationController.navigate(R.id.counterListFragment, null, navigationOptions) // Navigate to CounterListFragment

            Util.Navigate.TO_SIGN_UP -> navigationController.navigate(R.id.signUpFragment, null, navigationOptions) // Navigate to SignUpFragment

            Util.Navigate.TO_SETTINGS -> navigationController.navigate(R.id.settingsFragment, null, navigationOptions) // Navigate to SettingsFragment

        }

    }

}