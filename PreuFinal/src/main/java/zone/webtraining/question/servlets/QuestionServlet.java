package zone.webtraining.question.servlets;

import zone.webtraining.question.Lista;
import zone.webtraining.question.models.Question;
import zone.webtraining.question.services.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType( "text/html; charset=iso-8859-1" );
        //get questions
        QuestionService questionservice= new QuestionService();
        Lista hola=questionservice.getAll();
        for(int i=0;i<hola.contar();i++){
            Question question =hola.obtener(i);
            out.println("<h2>Pregunta "+question.getNumero()+":</h2>");
            out.println("<h3>"+question.getEnunciado()+"</h3>");
            out.println("<input type=radio name=preguntas value=1>"+question.getOp1() +
                    "<br>");
            out.println("<input type=radio name=preguntas value=2>"+question.getOp2() +
                    "<br>");
            out.println("<input type=radio name=preguntas value=3>"+question.getOp3() +
                    "<br>");
            out.println("<input type=radio name=preguntas value=4>"+question.getOp4() +
                    "<br>");
            out.println("<input type=radio name=preguntas value=5>"+question.getOp5() +
                    "<br>");
        }

    }
}

