package com.example.myruralapp.productModule;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.myruralapp.productModule.Model.Products;
import com.example.myruralapp.productModule.Prevalent.Prevalent;
import com.example.myruralapp.productModule.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myruralapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

public class CustomerProductHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseReference productRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_product_home);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            type = Objects.requireNonNull(Objects.requireNonNull(getIntent().getExtras()).get("Product Admin")).toString();

        }

        productRef = FirebaseDatabase.getInstance().getReference().child("Product Seller");
        Paper.init(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!type.equals("Product Admin")){
                    Intent intent = new Intent(CustomerProductHome.this, CartActivity.class);
                    startActivity(intent);
                }
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.user_profile_name);
        CircleImageView profileImageView = headerView.findViewById(R.id.user_profile_image);

        if (!type.equals("Product Admin")){
            userNameTextView.setText(Prevalent.currentOnlineUser.getName());
            Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.ic_person_black_24dp).into(profileImageView);

        }

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(productRef, Products.class)
                        .build();

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i, @NonNull final Products products) {
                        productViewHolder.txtProductName.setText(products.getPname());
                        productViewHolder.txtProductDescription.setText(products.getDescription());
                        productViewHolder.txtProductPrice.setText("Price:" + products.getPrice() + "Rs");

                        Picasso.get().load(products.getImage()).into(productViewHolder.imageView);

                        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (type.equals("Product Admin")){
                                    Intent intent = new Intent(CustomerProductHome.this, AdminMaintainProductsActivity.class);
                                    intent.putExtra("pid", products.getPid());
                                    startActivity(intent);
                                }else {

                                    Intent intent = new Intent(CustomerProductHome.this, ProductDetailsActivity.class);
                                    intent.putExtra("pid", products.getPid());
                                    startActivity(intent);
                                }


                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                        return new ProductViewHolder(view);
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customer_product_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_cart) {
            if (!type.equals("Product Admin")){
                Intent intent = new Intent(CustomerProductHome.this, CartActivity.class);
                startActivity(intent);
            }


        } else if (id == R.id.nav_search) {
            if (!type.equals("Product Admin")){
                Intent intent = new Intent(CustomerProductHome.this, SearchProductsActivity.class);
                startActivity(intent);
            }


        } else if (id == R.id.nav_categories) {


        } else if (id == R.id.nav_settings) {
            if (!type.equals("Product Admin")){
                Intent intent = new Intent(CustomerProductHome.this, SettingsActivity.class);
                startActivity(intent);
            }


        } else if (id == R.id.nav_logout) {
            if (!type.equals("Product Admin")){
                Paper.book().destroy();

                Intent intent = new Intent(CustomerProductHome.this, MainActivityProduct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
