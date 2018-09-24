package jp.example.hoge.testfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_hoge.*

// eFragment で ListView を表示させています
class HogeFragment : Fragment() {
//    private var listener: OnFragmentInteractionListener? = null
    private val mSampleData = ClsListData()
    var mContext :Context? = null
    //
    companion object {
        fun createInstance( mc : Context): HogeFragment {
            val carDetailFragment = HogeFragment()
            carDetailFragment.mContext = mc

            return carDetailFragment
        }
    }
    //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val r =inflater.inflate(R.layout.fragment_hoge, container, false)
        return r
    }
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        listRedisply()
        view.findViewById<Button>(R.id.btnAdd1).setOnClickListener {
            mSampleData.putItem()
            listRedisply()
        }
    }
    //
    private fun listRedisply() {
        if ( null != mContext ) {
            val listAdapter = ArrayAdapter<String>(mContext, android.R.layout.simple_expandable_list_item_1)

            val data = mSampleData.listData
            for (i: Int in 1..data.size) {
                listAdapter.add(data[i - 1])
            }
            listView1.adapter = listAdapter
        }
    }
}
