package com.example.rxjavapractice.view.activity

import android.os.Bundle
import androidx.fragment.app.commit
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.databinding.ActivityMainBinding
import com.example.rxjavapractice.view.fragment.MainFragment
import com.example.rxjavapractice.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate, MainViewModel::class.java,
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            if (savedInstanceState == null) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(binding.fragmentContainerMain.id, MainFragment())
                }
            }
    }

}