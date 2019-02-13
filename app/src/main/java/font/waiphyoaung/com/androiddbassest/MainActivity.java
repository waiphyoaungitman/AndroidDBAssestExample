package font.waiphyoaung.com.androiddbassest;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  {

    private SQLiteDatabase db;
    private Cursor c ;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);
        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        } catch (SQLException sqle) {

            throw sqle;

        }

        c = myDbHelper.query("student", null, null, null, null, null, null);

        if (c.moveToNext()) {
            do {
                textView.append(c.getString(0));
                textView.append("  " +c.getString(1) + "\n");




            } while (c.moveToNext());
        }



    }









}










