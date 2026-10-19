package com.example.recyclerviewtutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final String[] mois = {
            "Janvier", "Février", "Mars", "Avril",
            "Mai", "Juin", "Juillet", "Août",
            "Septembre", "Octobre", "Novembre", "Décembre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MoisAdapter(mois));
    }

    private static class MoisAdapter
            extends RecyclerView.Adapter<MoisAdapter.MoisViewHolder> {

        private final String[] donnees;

        MoisAdapter(String[] donnees) {
            this.donnees = donnees;
        }

        @Override
        public MoisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View vue = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_row_item, parent, false);
            return new MoisViewHolder(vue);
        }

        @Override
        public void onBindViewHolder(MoisViewHolder holder, int position) {
            holder.texte.setText(donnees[position]);
        }

        @Override
        public int getItemCount() {
            return donnees.length;
        }

        private static class MoisViewHolder extends RecyclerView.ViewHolder {
            final TextView texte;

            MoisViewHolder(View itemView) {
                super(itemView);
                texte = itemView.findViewById(R.id.textView);
            }
        }
    }
}