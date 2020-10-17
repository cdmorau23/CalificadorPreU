package zone.webtraining.question.models;


public class Question {
    private int numero;
    private String enunciado;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String op5;
    private String correcta;
    public Question() {
    }

    public Question(int numero, String enunciado, String op1, String op2, String op3, String op4, String op5, String correcta) {
        this.numero = numero;
        this.enunciado = enunciado;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.op5 = op5;
        this.correcta = correcta;
    }


    public String getCorrecta() {
        return correcta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getNumero() {
        return numero;
    }

    public String getOp1() {
        return op1;
    }


    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getOp5() {
        return op5;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOp5(String op5) {
        this.op5 = op5;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPregunta " + numero + " : " + enunciado);
        sb.append("\n" + op1);
        sb.append("\n" + op2);
        sb.append("\n" + op3);
        sb.append("\n" + op4);
        sb.append("\n" + op5);
        return sb.toString();
    }
}
