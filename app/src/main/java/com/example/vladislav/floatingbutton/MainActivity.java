package com.example.vladislav.floatingbutton;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout=  (CoordinatorLayout)findViewById(R.id.coordinatorLayout);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Basic Components");

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showSimpleSnackBar(View view){
        Snackbar.make(coordinatorLayout, "Hello from simple SnackBar", Snackbar.LENGTH_SHORT).show();

    }

    public void showSnackBarWithActionCallBack(View view) {

        Snackbar snackBar = Snackbar.make(coordinatorLayout, "Error Loading file", Snackbar.LENGTH_SHORT);
        snackBar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "File Loaded Successfully!", Snackbar.LENGTH_SHORT).show();

            }
        });
        snackBar.show();
    }

    public void showSnackBarWithColoredText(View view) {

        Snackbar snackBar = Snackbar.make(coordinatorLayout, "Download Failed!", Snackbar.LENGTH_SHORT);
        snackBar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        View snackBarLayout= snackBar.getView();
        snackBarLayout.setBackgroundColor(Color.BLUE);

        //Snack Bar Message Text Color
        TextView txvMessage = (TextView)snackBarLayout.findViewById(android.support.design.R.id.snackbar_text);
        txvMessage.setTextColor(Color.YELLOW);

        //Changing Action Button Text Color(RETRY)
        snackBar.setActionTextColor(Color.RED);
        snackBar.show();
    }
}
