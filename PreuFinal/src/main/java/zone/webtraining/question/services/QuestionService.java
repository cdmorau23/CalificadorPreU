package zone.webtraining.question.services;
import zone.webtraining.question.Lista;
import zone.webtraining.question.models.Question;

public class QuestionService extends Lista {
    public Lista getAll(){
        Question prueba= new Question(1,"Funciona?","si","a medias","un poquito","casi nada","nada","si");
        Lista preguntas=new Lista();
        preguntas.insertar(prueba);
        return preguntas;
    }
}
