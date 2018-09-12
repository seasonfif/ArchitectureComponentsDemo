package com.seasonfif.architecturecomponentsdemo.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seasonfif.architecturecomponentsdemo.viewmodel.BeanViewModel
import com.seasonfif.project.R
import com.seasonfif.architecturecomponentsdemo.viewmodel.Result
import kotlinx.android.synthetic.main.fragment_list.*

class FeedListFragment : Fragment(), View.OnClickListener {

    lateinit var viewModel: BeanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(BeanViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.btn1 -> {
                viewModel.selected.value = getModel(0)
                goto()
            }

            R.id.btn2 -> {
                viewModel.selected.value = getModel(1)
                goto()
            }
        }
    }

    private fun goto() {
        var ty = activity as MainActivity
        ty.switchFragment(this, DetailFragment())

    }

    private fun getModel(index: Int): Result {
        var result = MainActivity.model.results.get(index)
        return result
    }
}
