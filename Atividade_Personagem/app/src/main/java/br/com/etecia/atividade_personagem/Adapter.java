package br.com.etecia.atividade_personagem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Personagens> listaPerso;
    public Adapter(List<Personagens> lista) {
        this.listaPerso = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Personagens Personagens = listaPerso.get(position);

        holder.nome.setText(Personagens.getNome());
        holder.idade.setText(Personagens.getIdade());
        holder.rating.setRating(5);
        holder.imagem.setImageResource(Personagens.getImagem());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome,idade;
        ImageView imagem;
        RatingBar rating;
        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            idade = itemView.findViewById(R.id.idade);
            rating = itemView.findViewById(R.id.rating);
            imagem = itemView.findViewById(R.id.imagem);

        }
    }
}
