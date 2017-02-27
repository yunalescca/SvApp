package com.example.yunalescca.swedishpronunciations.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.controllers.*;

/**
 * Created by Yunalescca on 26/09/16.
 */

public class Tools extends AppCompatActivity implements SearchView.OnQueryTextListener{

    String lastText="";
    SearchView searchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem searchItem = menu.findItem(R.id.search);

        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                searchView.post(new Runnable() {
                    @Override
                    public void run() {
                        if(lastText.length()>0) {
                            searchView.setQuery(lastText, false);
                        } else {
                            searchView.setQueryHint("e.g. A");
                        }
                    }
                });
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        lastText=query;
        searchView.setQuery(lastText,false);
        search(query);
        return false;
        }

    private void search(String s) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("text", s);
        startActivity(intent);

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false; }
}
