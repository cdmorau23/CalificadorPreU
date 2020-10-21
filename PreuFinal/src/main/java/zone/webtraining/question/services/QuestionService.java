package zone.webtraining.question.services;
import zone.webtraining.question.Lista;
import zone.webtraining.question.models.Question;

public class QuestionService extends Lista {

    public Lista getAll(){

        long start = System.nanotime();

        int num = 10000;
        Lista preguntas = new Lista();
        Question prueba;
        for(int i = 0; i < num; i++){
            prueba = new Question(i+1, "Pregunta"+(i+1), "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 3", "Opcion 4", "Opcion 5");
            preguntas.insertar(prueba);
        }

        long end = System.nanotime();

        double time = (end - start) * 1.0e-9;
        System.out.println();

        return preguntas;
    }
}
