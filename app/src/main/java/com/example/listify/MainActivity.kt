package com.example.listify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.FragmentTransaction
import com.example.listify.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity(), FragmentResultListener, View.OnClickListener {

    private lateinit var  binding : ActivityMainBinding
    private lateinit var fm:FragmentManager
    private lateinit var mainFragment: main
    private lateinit var adapter:MainAdapter
    private lateinit var presenter: MoviesPresenter
    private lateinit var ft:FragmentTransaction;
    private lateinit var fragmentList:list

    override fun onCreate(savedInstanceState: Bundle ?) {
        super.onCreate(savedInstanceState)


        this.binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setOnClickListener(this)


       // var ab :ActionBarDrawerToggle
       // ab= ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.Open,R.string.Close)
      //  binding.drawerLayout.addDrawerListener(ab)
       // ab.syncState()

        this.mainFragment=main.newInstance("main") //home
        this.fragmentList=list.newInstance("list");

        this.fm=getSupportFragmentManager()
        this.fm.beginTransaction()
            .add(R.id.fragment,this.mainFragment)
            .commit()

//        this.presenter= MoviesPresenter()
//        this.adapter= MainAdapter(this,this.presenter)
//        this.fm.setFragmentResultListener("routeListener",this,this)
//        binding.fragmentContainer.adapter(this)




    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        TODO("Not yet implemented")
    }


    fun onClickNavigation(clicked: View){
            this.fm=supportFragmentManager;
            this.ft=fm.beginTransaction();
        //AddBtn,HomeBtn,ListBtn
        for(frag in this.fm.fragments){
            ft.hide(frag)
        }

        if (clicked.id==R.id.ListBtn){
            if(this.fragmentList.isAdded){
                ft.show(this.fragmentList)
            }else{
                ft.add(R.id.fragment,this.fragmentList)
            }

        }else if(clicked.id==R.id.HomeBtn) {
            if (this.mainFragment.isAdded) {
                ft.show(this.mainFragment)
            } else {
                ft.add(R.id.fragment, this.mainFragment)
            }


        }
        ft.commit();
    }





    override fun onClick(v: View?) {
        if(v==binding.toolbar){
            //buat drawer

        }

    }


}