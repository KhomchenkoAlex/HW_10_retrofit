package com.example.android.hw10.ui.userDetails

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.android.hw10.R
import com.example.android.hw10.model.User
import com.example.android.hw10.ui.Spinner
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity(), UserDetailsView {

    private val presenter by lazy { UserDetailsPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val studentGitHubUsername = intent.getStringExtra("GitHubUsername")
        presenter.getGithubUserData(studentGitHubUsername)
    }

    override fun showUserData(user: User) {
        Picasso.with(this)
            .load(user.avatarUrl)
            .placeholder(R.drawable.man)
            .error(R.drawable.man)
            .into(profile_image)

        name.text = user.name
        location.text = user.location
        public_repos.text = user.publicRepos.toString()
        public_gists.text = user.publicGists.toString()
        email.text = user.email
        followers.text = user.followers.toString()
        following.text = user.following.toString()
    }

    override fun showSpinner() {
        user_details.visibility = View.GONE
        Spinner().show(supportFragmentManager, Spinner::class.java.name)
    }

    override fun hideSpinner() {
        val spinner = supportFragmentManager.findFragmentByTag(Spinner::class.java.name) as? DialogFragment
        if (spinner !== null) {
            spinner.dismiss()
            user_details.visibility = View.VISIBLE
        }
    }
}
