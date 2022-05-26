package co.com.choucair.objperdidos.tasks;

import co.com.choucair.objperdidos.userinterfaces.ObjetosPerdidosPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ObjetosPerdidos implements Task {
    private ObjetosPerdidosPagina objetosPerdidosPagina;
    String name;

    public static ObjetosPerdidos the(){
        return Tasks.instrumented(ObjetosPerdidos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ObjetosPerdidosPagina.CLICK_SERVICIOS),

                Click.on(ObjetosPerdidosPagina.CLICK_INFORMACION),

                Click.on(ObjetosPerdidosPagina.CLICK_EXTRAVIADOS),

                Click.on(ObjetosPerdidosPagina.CLICK_PDF)

        );


    }
}
