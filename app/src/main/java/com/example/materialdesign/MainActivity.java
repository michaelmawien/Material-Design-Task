package com.example.materialdesign;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.materialdesign.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Setup Toolbar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup FAB
        ExtendedFloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Create new item clicked", Snackbar.LENGTH_LONG)
                    .setAnchorView(R.id.fab)
                    .setAction("UNDO", v -> Toast.makeText(MainActivity.this, "Undo clicked", Toast.LENGTH_SHORT).show())
                    .show();
        });

        // Bottom App Bar
        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(view -> {
            new MaterialAlertDialogBuilder(MainActivity.this)
                    .setTitle("Navigation")
                    .setMessage("Where would you like to go?")
                    .setPositiveButton("Home", (dialog, which) -> {})
                    .setNegativeButton("Cancel", (dialog, which) -> {})
                    .show();
        });

        // Example Material Button
        MaterialButton materialButton = findViewById(R.id.material_button);
        materialButton.setOnClickListener(v -> {
            // Show a beautiful Material dialog
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Material Dialog")
                    .setMessage("This is a stunning Material Design dialog!")
                    .setPositiveButton("OK", (dialog, which) -> {})
                    .setNegativeButton("CANCEL", null)
                    .show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}