package com.seasonfif.architecturecomponentsdemo.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seasonfif.architecturecomponentsdemo.viewmodel.DataViewModel
import com.seasonfif.architecturecomponentsdemo.R
import com.seasonfif.architecturecomponentsdemo.viewmodel.Result
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), View.OnClickListener{

    lateinit var viewModel: DataViewModel
    lateinit var fragment: Fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragment = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(DataViewModel::class.java)

        var observer : Observer<Result> = object : Observer<Result>{
            override fun onChanged(t: Result?) {
                updateUI(t)
            }
        }

        viewModel.selected.observe(this, Observer {
            updateUI(it)
        })

        reto.setOnClickListener(this)
    }

    private fun updateUI(result: Result?) {
        content.text = result?.name
    }

    override fun onClick(view: View?) {
        var ty = activity as MainActivity
        ty.switchFragment(fragment, FeedListFragment())
    }
}