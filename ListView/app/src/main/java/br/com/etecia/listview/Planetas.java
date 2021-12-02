package br.com.etecia.listview;


public class Planetas {
    private String nomePlanetas;
    private int imgPlanetas;

    //Método Construtor
    public Planetas(){

    }

    public Planetas(String nomePlanetas, int imgePlanetas) {
    }

    //__________________________________
    public String getNomePlanetas(){
        return nomePlanetas;
    }

    public void setNomePlanetas(String nomePlanetas){
        this.nomePlanetas = nomePlanetas;
    }

    public int getImgPlanetas(){
        return imgPlanetas;
    }

    public void setImgPlanetas(int imgPlanetas){
        this.imgPlanetas = imgPlanetas;
    }

}
