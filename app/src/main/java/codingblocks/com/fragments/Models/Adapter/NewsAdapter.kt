package codingblocks.com.fragments.Models.Adapter

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codingblocks.com.fragments.Database.ResponseDatabase
import codingblocks.com.fragments.Models.Response
import codingblocks.com.fragments.R
import codingblocks.com.fragments.activity.ViewActivity
import codingblocks.com.fragments.fragment.ViewFragment
import kotlinx.android.synthetic.main.item_row.view.*
import android.webkit.WebView
import android.support.v7.app.AlertDialog


class NewsAdapter(private val news:ArrayList<Response>,val db:ResponseDatabase):RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    lateinit var context : Context
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): NewsHolder {
       context=viewGroup.context

        return NewsHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false))

    }

    override fun getItemCount() =news.size

    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) {
      val currentNews= news[position]


        newsHolder.itemView.setOnClickListener {


           val intent = Intent(context, ViewActivity::class.java)

            intent.putExtra("url",currentNews.url)
            Log.e("Tag","url is ${currentNews.url}")

            context.startActivity(intent)

//            val wv = WebView(context)
//            wv.loadUrl(currentNews.url)

        }


        with(newsHolder.itemView) {
            tvTitle.text=currentNews.title.toString()
            tvUrl.text=currentNews.url.toString()
            tvScore.text=currentNews.score.toString()
            tvDescendants.text=currentNews.descendants.toString()




        }


    }




    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}