package br.com.etecia.atividade_personagem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Personagens> listarPerso = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView RecyclerView = findViewById(R.id.id_recyclerView);
    
        criarPersonagem();

        Adapter adapter = new Adapter(listarPerso);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                LinearLayout.VERTICAL));

        recyclerView.setAdapter(adapter);
    }

    private void criarPersonagem(){
        Personagens personagens = new Personagens("Yasuo","34",R.drawable.Yasuo,10);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Yone","62",R.drawable.Yone,10);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Caitlyn","19",R.drawable.Caitlyn,9);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Vi","20",R.drawable.Vi,10);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Jinx","15",R.drawable.Jinx,10);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Heimerdinger","307",R.drawable.Heimerdinger,10);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Jayce","24",R.drawable.Jayce,8);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Viktor","22",R.drawable.Viktor,9);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Singed","75",R.drawable.Singed,7);
        this.listarPerso.add(personagens);
        personagens = new Personagens("Ekko","17", R.drawable.Ekko,9);


    }
}