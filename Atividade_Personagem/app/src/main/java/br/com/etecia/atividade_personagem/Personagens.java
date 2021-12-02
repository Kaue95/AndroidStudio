package br.com.etecia.atividade_personagem;

public class Personagens {

        private String nome;
        private String idade;private int imagem;
      private int rating;

    public Personagens(String nome, String idade, int imagem, int rating) {
        this.nome = nome;
        this.idade = idade;
        this.imagem = imagem;
        this.rating = rating;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

