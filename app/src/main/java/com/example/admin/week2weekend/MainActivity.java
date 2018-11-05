package com.example.admin.week2weekend;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    private SharedPreferences preferences;
    private SharedPreferences.Editor prefEditor;
    private TextView appName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.content_frame);
        linearLayout.setBackgroundColor(android.graphics.Color.rgb(0,133,119));
        appName = findViewById(R.id.app_name);
    }
    @Override
    protected void onStart(){
        super.onStart();
        try{
            preferences = getSharedPreferences("com.example.admin.week2weekend", Context.MODE_PRIVATE);
            prefEditor = preferences.edit();
            prefEditor.putString("FONT_SIZE", "Medium");
            prefEditor.putString("Color", "Green");
            prefEditor.apply();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String currentFontSize = preferences.getString("FONT_SIZE", null);
        String currentColor = preferences.getString("Color", null);
        System.out.println(currentFontSize);
        switch (item.getItemId()) {
            case R.id.action_menu_red:
                // Red item was selected
                if(item.isChecked()) item.setChecked(false);
                prefEditor.putString("Color", "Red");
                prefEditor.apply();
                switch (currentFontSize){
                    case "Very Small":
                        setTheme(R.style.FontSizeVerySmallRed);
                        break;
                    case "Small":
                        setTheme(R.style.FontSizeSmallRed);
                        break;
                    case "Medium":
                        setTheme(R.style.FontSizeMediumRed);
                        break;
                    case "Medium Large":
                        setTheme(R.style.FontSizeMediumLargeRed);
                        break;
                    case "Large":
                        setTheme(R.style.FontSizeLargeRed);
                        break;
                }
                setContentView(R.layout.activity_main);
                return true;
            case R.id.action_menu_green:
                // Green item was selected
                if(item.isChecked()) item.setChecked(false);
                prefEditor.putString("Color", "Green");
                prefEditor.apply();
                switch (currentFontSize){
                    case "Very Small":
                        setTheme(R.style.FontSizeVerySmallGreen);
                        break;
                    case "Small":
                        setTheme(R.style.FontSizeSmallGreen);
                        break;
                    case "Medium":
                        setTheme(R.style.FontSizeMediumGreen);
                        break;
                    case "Medium Large":
                        setTheme(R.style.FontSizeMediumLargeGreen);
                        break;
                    case "Large":
                        setTheme(R.style.FontSizeLargeGreen);
                        break;
                }
                setContentView(R.layout.activity_main);
                return true;
           /* case R.id.action_menu_blue:
                //Blue item was selected
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                linearLayout.setBackgroundColor(Color.BLUE);
                prefEditor.putString("Color", "Blue");
                prefEditor.apply();
                return true;
            case R.id.action_menu_yellow:
                //Yellow item was selected
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                linearLayout.setBackgroundColor(Color.YELLOW);
                prefEditor.putString("Color", "Blue");
                prefEditor.apply();
                return true;
*/
            case R.id.action_increase_textsize:
                switch (currentFontSize){
                    case "Very Small":
                        prefEditor.putString("FONT_SIZE", "Small");
                        prefEditor.apply();
                        switch (currentColor){
                            case "Red":
                                setTheme(R.style.FontSizeSmallRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeSmallGreen);
                                break;
                        }
                        break;
                    case "Small":
                        prefEditor.putString("FONT_SIZE", "Medium");
                        prefEditor.apply();
                        switch (currentColor) {
                            case "Red":
                                setTheme(R.style.FontSizeMediumRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeMediumGreen);
                                break;
                        }
                        break;
                    case "Medium":
                        prefEditor.putString("FONT_SIZE", "Medium Large");
                        prefEditor.apply();
                        switch (currentColor) {
                            case "Red":
                                setTheme(R.style.FontSizeMediumLargeRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeMediumLargeGreen);
                                break;
                        }
                        break;
                    case "Medium Large":
                        prefEditor.putString("FONT_SIZE", "Large");
                        prefEditor.apply();
                        switch (currentColor) {
                            case "Red":
                                setTheme(R.style.FontSizeLargeRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeLargeGreen);
                                break;
                        }
                        break;
                }
                setContentView(R.layout.activity_main);
                return true;
            case R.id.action_decrease_textsize:
               switch (currentFontSize){
                    case "Small":
                        switch (currentColor){
                            case "Red":
                                setTheme(R.style.FontSizeVerySmallRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeVerySmallGreen);
                                break;
                        }
                        prefEditor.putString("FONT_SIZE", "Very Small");
                        prefEditor.apply();
                        break;
                    case "Medium":
                        switch (currentColor){
                            case "Red":
                                setTheme(R.style.FontSizeSmallRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeSmallGreen);
                                break;
                        }
                        prefEditor.putString("FONT_SIZE", "Small");
                        prefEditor.apply();
                        break;
                    case "Medium Large":
                        switch (currentColor) {
                            case "Red":
                                setTheme(R.style.FontSizeMediumRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeMediumGreen);
                                break;
                        }
                        prefEditor.putString("FONT_SIZE", "Medium");
                        prefEditor.apply();
                        break;
                    case "Large":
                        switch (currentColor) {
                            case "Red":
                                setTheme(R.style.FontSizeMediumLargeRed);
                                break;
                            case "Green":
                                setTheme(R.style.FontSizeMediumLargeGreen);
                                break;
                        }
                        prefEditor.putString("FONT_SIZE", "Medium Large");
                        prefEditor.apply();
                        break;
                }
                setContentView(R.layout.activity_main);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
