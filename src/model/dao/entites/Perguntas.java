package model.dao.entites;

public class Perguntas {
    private int IDpergunta;
    private String pontuacao;
    private String pergunta;
    private String imagemDoc;

    public Perguntas() {
    }

    public Perguntas(int IDpergunta, String Pergunta, String pontuacao, String imagem_doc){
        this.IDpergunta = IDpergunta;
        this.pergunta = Pergunta;
        this.pontuacao = pontuacao;
       this.imagemDoc = imagem_doc;
       }

    public int getIDpergunta() {
        return IDpergunta;
    }

    public void setIDpergunta(int IDpergunta) {
        this.IDpergunta = IDpergunta;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getImagemDoc() {
        return imagemDoc;
    }

    public void setImagemDoc(String imagemDoc) {
        this.imagemDoc = imagemDoc;
    }
}