package com.kotlin.siddhant.asynctaskexample

import android.app.Activity
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async_task.*

public class AsyncTaskActivity : AppCompatActivity(),View.OnClickListener {

    var count=0;
    public var stopAsync:Boolean?=true
    var btnStart:Button?=null
    var btnStop:Button?=null
    var tvCount:TextView?=null

    var task:AsyncTask<Int,Int,Int>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        btnStart=findViewById(R.id.btnStartTask)
        btnStop=findViewById(R.id.btnStopTask)
        tvCount=findViewById(R.id.tvCount)


        btnStart?.setOnClickListener(this as View.OnClickListener)
        btnStop?.setOnClickListener(this as View.OnClickListener)


    }

    override fun onClick(id: View?) {
        when(id) {
            btnStart ->
            {
                stopAsync = false;
                task=AsyncTaskExample(stopAsync,this,count)
                task?.execute(count)

            }
            btnStop -> task?.cancel(true) // or you can use stopAsync=false
        }
    }

    private class AsyncTaskExample(stopAsync:Boolean?,activity:Activity,count:Int) : AsyncTask<Int,Int,Int>()
    {

        var incrementedCounter:Int?=count
        var stopAsync=stopAsync
        var activity=activity
        override fun onPreExecute() {
            super.onPreExecute()

        }


        override fun doInBackground(vararg value: Int?): Int {
            incrementedCounter=value[0]

          
            while(!this!!.stopAsync!!)
            {

                try {
                    Thread.sleep(200)
                    incrementedCounter=incrementedCounter?.plus(1)

                }catch (e:Exception)
                {

                }
                publishProgress(incrementedCounter)
            }
            return this!!.incrementedCounter!!
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            activity.tvCount.text=values[0].toString()

        }
        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            activity.tvCount.text=result.toString()
        }

    }
}
