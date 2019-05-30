package me.yashims.routersample

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import me.yashims.korouter.KoRouter
import me.yashims.korouter.OutOfHistoryRangeException
import me.yashims.korouter.Presenter
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Presenter {

    private val router: KoRouter = KoRouter {
        route("") {
            name = ""
            component = this@MainActivity

            children {
                route("/") {
                    name = "top"
                    component = TopFragment()
                }

                route("gallery") {
                    name = "gallery"
                    component = GalleryFragment()

                    children {
                        route(":detail") {
                            name = "detail"
                            component = GalleryDialogFragment()
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        App.router = router
        App.fragmentManager = WeakReference(this.supportFragmentManager)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        Log.d("korouter", "MainActivity@onCreate push: /")
        router.push("/")

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            try {
                App.router.back()
            } catch (e: OutOfHistoryRangeException) {
                super.onBackPressed()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_top -> {
                router.push("/")
            }
            R.id.nav_gallery -> {
                router.push("/gallery")
            }
            R.id.nav_gallery_detail -> {
                router.push("/gallery/aaaa")
            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSwapInChild(name: String?, child: Presenter?, args: Map<String, String>?) {
        Log.d("korouter", "MainActivity@onSwapInChild name: $name child:$child args:$args")
        if (child is Fragment) {
            this.supportFragmentManager.beginTransaction().apply {
                replace(R.id.content_main, child)
                commit()
            }
        }
    }

    override fun onSwapOutChild(name: String?, child: Presenter?) {
        Log.d("korouter", "MainActivity@onSwapOutChild name:$name, child:$child")
    }
}
