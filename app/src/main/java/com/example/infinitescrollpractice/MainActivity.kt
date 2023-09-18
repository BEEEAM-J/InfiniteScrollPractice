package com.example.infinitescrollpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infinitescrollpractice.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

var cnt = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvAdapter = InfiniteScrollAdapter()
        val data = mutableListOf<Data>()
        val handler = Handler()


        setItem(data)

        binding.apply {
            binding.recycler.adapter = rvAdapter
            rvAdapter.submitList(data)

//            TODO("아이템 개수 vs 마지막 아이템 위치 비교 + 스크롤 확인 방법")        아무 동작 안함(if문 내부 실행 X)
//            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    val lastVisiblePosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
//                    val isBottom = lastVisiblePosition + 1 == recyclerView.adapter?.itemCount
//                    val isDownScroll = dy > 0
//
//                    if (isBottom and isDownScroll) {
//                        val delayMillis = 1000
//
//                        handler.postDelayed({
//                            Log.d("last", "최하단")
//                            data.removeAt(data.lastIndex)
//                            setItem(data)
//                            rvAdapter.submitList(data)
//                            rvAdapter.notifyItemRangeInserted(data.lastIndex, 2)
//                        }, delayMillis.toLong())
//
//                    }
//                }
//            })

//            TODO("아이템 개수 vs 마지막 아이템 위치 비교 + 스크롤 확인 방법 + 딜레이 제거")        아무 동작 안함(if문 내부 실행 X)
//            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    val lastVisiblePosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
//                    val isBottom = lastVisiblePosition + 1 == recyclerView.adapter?.itemCount
//                    val isDownScroll = dy > 0
//
//                    if (isBottom and isDownScroll) {
//                        Log.d("last", "최하단")
//                        data.removeAt(data.lastIndex)
//                        setItem(data)
//                        rvAdapter.submitList(data)
//                        rvAdapter.notifyItemRangeInserted(data.lastIndex, 2)
//                    }
//                }
//            })

//            TODO("아이템 개수 vs 마지막 아이템 위치 비교 방법 + 딜레이 제거")      리사이클러뷰를 밑으로 스크롤 해야 동작함
//            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    val lastVisiblePosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
//                    val isBottom = lastVisiblePosition + 1 == recyclerView.adapter?.itemCount
//
//                    if (isBottom) {
//                        Log.d("last", "최하단")
//                        data.removeAt(data.lastIndex)
//                        setItem(data)
//                        rvAdapter.submitList(data)
//                        rvAdapter.notifyItemRangeInserted(data.lastIndex, 2)
//                    }
//                }
//            })

//            TODO("canScrollVertically(1) 사용 방법")      실행 되자마자 바로 추가 데이터 받아옴(정상)
//            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    if (!recycler.canScrollVertically(1)) {
//                        val delayMillis = 1000
//
//                        handler.postDelayed({
//                            Log.d("last", "최하단")
//                            data.removeAt(data.lastIndex)
//                            setItem(data)
//                            rvAdapter.submitList(data)
//                            rvAdapter.notifyItemRangeInserted(data.lastIndex, 2)
//                        }, delayMillis.toLong())
//                    }
//                }
//            })

//            TODO("canScrollVertically(1) 사용 방법 + 딜레이 제거")      리사이클러뷰를 밑으로 스크롤 해야 동작함
//            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    if (!recycler.canScrollVertically(1)) {
//                        Log.d("last", "최하단")
//                        data.removeAt(data.lastIndex)
//                        setItem(data)
//                        rvAdapter.submitList(data)
//                        rvAdapter.notifyItemRangeInserted(data.lastIndex, 2)
//                    }
//                }
//            })

        }
    }
}

fun setItem(data: MutableList<Data>) {
    for (i in 0 until  2) {
        data.add(Data("제목 $cnt", "내용 $cnt"))
        cnt ++
    }
    data.add(Data("", ""))
}