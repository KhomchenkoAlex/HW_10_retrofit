package com.example.android.hw10.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.android.hw10.R
import com.example.android.hw10.ui.recyclerView.Adapter
import com.example.android.hw10.ui.recyclerView.ItemDecorator
import com.example.android.hw10.ui.userDetails.UserDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClick {

    private val adapter: Adapter by lazy {
        Adapter(
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(ItemDecorator())
        recycler_view.adapter = adapter
    }

    override fun onUserClicked(position: Int) {
        val extra = adapter.getStudentGitHubUsername(position)
        val intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("GitHubUsername", extra)
        startActivity(intent)
    }

}
