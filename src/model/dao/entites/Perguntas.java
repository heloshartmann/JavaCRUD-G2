package model.dao.entites;

public class Perguntas {
    private int ID_Pergunta;
    private String pontuacao;
    private String Pergunta;
    private String imagem_doc;

    public Perguntas() {
    }

    public Perguntas(int ID_Pergunta, String Pergunta, String pontuacao, String imagem_doc){
        this.ID_Pergunta = ID_Pergunta;
        this.Pergunta = Pergunta;
        this.pontuacao = pontuacao;
       this.imagem_doc = imagem_doc; 
       }
       
    public int getIdQuestionario() {
        return ID_Pergunta;
    }

    public void setIdQuestionario(int ID_Pergunta) {
        this.ID_Pergunta = ID_Pergunta;
    }

    public String getNome() {
        return Pergunta;
    }

    public void setNome(String Pergunta) {
        this.Pergunta = Pergunta;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

   public void setimagem_doc(String imagem_doc) {
        this.imagem_doc = imagem_doc;
    }

 public String getimagem_doc() {
        return imagem_doc;
    }


}