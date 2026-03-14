package com.nibm.mad.lesson5;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsyncTask  extends AsyncTask<Void,String,String> {

    TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Pre executed method");
    }

    @Override
    protected String doInBackground(Void... voids)   {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Task Completed";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values.toString());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}
