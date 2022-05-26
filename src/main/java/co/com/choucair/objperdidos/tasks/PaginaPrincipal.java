package co.com.choucair.objperdidos.tasks;

import co.com.choucair.objperdidos.userinterfaces.AbrirPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class PaginaPrincipal implements Task {
    private AbrirPagina abrirPagina;

    public static PaginaPrincipal laPagina(){
        return Tasks.instrumented(PaginaPrincipal.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(abrirPagina));

    }
}
