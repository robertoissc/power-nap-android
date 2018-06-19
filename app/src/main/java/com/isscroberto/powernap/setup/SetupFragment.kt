package com.isscroberto.powernap.setup


import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.isscroberto.powernap.R
import com.isscroberto.powernap.data.NAP_TYPE_COFFEE
import com.isscroberto.powernap.data.NAP_TYPE_POWER
import com.isscroberto.powernap.data.NAP_TYPE_RECHARGE
import com.isscroberto.powernap.data.NAP_TYPE_REFRESH
import kotlinx.android.synthetic.main.fragment_setup.*

/**
 * Setup section view.
 */
class SetupFragment : Fragment(), SetupContract.View {

    override lateinit var presenter: SetupContract.Presenter

    override fun onResume() {
        super.onResume()
        presenter.start();
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setup, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners for nap types.
        layout_power.setOnClickListener(View.OnClickListener {
            presenter.selectDescription(NAP_TYPE_POWER);
        })

        layout_refresh.setOnClickListener(View.OnClickListener {
            presenter.selectDescription(NAP_TYPE_REFRESH);
        })

        layout_recharge.setOnClickListener(View.OnClickListener {
            presenter.selectDescription(NAP_TYPE_RECHARGE);
        })

        layout_coffee.setOnClickListener(View.OnClickListener {
            presenter.selectDescription(NAP_TYPE_COFFEE);
        })
    }

    override fun showDescription(napType: Int) {

        TransitionManager.beginDelayedTransition(layout_content);

        when(napType){
            NAP_TYPE_POWER -> {
                layout_refresh.visibility = View.GONE
                layout_recharge.visibility = View.GONE
                layout_coffee.visibility = View.GONE
            }
            NAP_TYPE_REFRESH -> {
                layout_power.visibility = View.GONE
                layout_recharge.visibility = View.GONE
                layout_coffee.visibility = View.GONE
            }
            NAP_TYPE_RECHARGE -> {
                layout_power.visibility = View.GONE
                layout_refresh.visibility = View.GONE
                layout_coffee.visibility = View.GONE
            }
            NAP_TYPE_COFFEE -> {
                layout_power.visibility = View.GONE
                layout_refresh.visibility = View.GONE
                layout_recharge.visibility = View.GONE
            }
        }
    }

    companion object {
        fun newInstance():SetupFragment {
            return SetupFragment()
        }
    }

}
