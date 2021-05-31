package sg.edu.rp.c346.id2006248.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btDBS;
    Button btOCBC;
    Button btUOB;
    int options;
    boolean whiteDBS = true;
    boolean whiteOCBC = true;
    boolean whiteUoB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDBS = findViewById(R.id.buttonDBS);
        btOCBC = findViewById(R.id.buttonOCBC);
        btUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btDBS);
        registerForContextMenu(btOCBC);
        registerForContextMenu(btUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,getResources().getString(R.string.website));
        menu.add(0,1,1,getResources().getString(R.string.contact_the_bank));
        menu.add(0,2,2,getResources().getString(R.string.toggle_favourite));

        if(v == btDBS){
            options = 1;
        }
        else if(v == btOCBC){
            options = 2;
        }
        else if(v == btUOB){
            options = 3;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // DBS
        if(options == 1){
            if(item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.dbsWeb)));
                startActivity(intentWeb);

                return true;
            }
            else if(item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getResources().getString(R.string.dbsNum)));
                startActivity(intentCall);

                return true;
            }
            else if(item.getItemId() == 2 && whiteDBS) {
                btDBS.setTextColor(Color.parseColor("#FF0000"));
                whiteDBS = false;
            }
            else if(item.getItemId() == 2 && !whiteDBS) {
                btDBS.setTextColor(Color.parseColor("#FFFFFF"));
                whiteDBS = true;
            }
        }

        //OCBC
        else if(options == 2){
            if(item.getItemId()==0) {
                Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.ocbcWeb)));
                startActivity(intentWeb);

                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getResources().getString(R.string.ocbcNum)));
                startActivity(intentCall);

                return true;
            }
            else if(item.getItemId() == 2 && whiteOCBC) {
                btDBS.setTextColor(Color.parseColor("#FF0000"));
                whiteOCBC = false;
            }
            else if(item.getItemId() == 2 && !whiteOCBC) {
                btDBS.setTextColor(Color.parseColor("#FFFFFF"));
                whiteOCBC = true;
            }
        }

        //UOB
        else if(options == 3){
            if(item.getItemId()==0) {
                Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.uob)));
                startActivity(intentWeb);

                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getResources().getString(R.string.uobNum)));
                startActivity(intentCall);

                return true;
            }
            else if(item.getItemId() == 2 && whiteUoB) {
                btDBS.setTextColor(Color.parseColor("#FF0000"));
                whiteUoB = false;
            }
            else if(item.getItemId() == 2 && !whiteUoB) {
                btDBS.setTextColor(Color.parseColor("#FFFFFF"));
                whiteUoB = false;
            }
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.english) {
            btUOB.setText(R.string.uob);
            btOCBC.setText(R.string.ocbc);
            btDBS.setText(R.string.dbs);

        } else if (id == R.id.chinese) {
            btUOB.setText(R.string.uobChinese);
            btOCBC.setText(R.string.ocbcChinese);
            btDBS.setText(R.string.dbsChinese);
        }

        return super.onOptionsItemSelected(item);
    }

}