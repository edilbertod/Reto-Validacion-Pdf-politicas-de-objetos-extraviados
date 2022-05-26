package co.com.choucair.objperdidos.stepdefinitions;

import co.com.choucair.objperdidos.questions.PreguntaPdfObjPerdidos;
import co.com.choucair.objperdidos.tasks.ObjetosPerdidos;
import co.com.choucair.objperdidos.tasks.PaginaPrincipal;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.io.File;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ObjPerdidosStepDefinitions {

    private static final String DOWNLOADED_PDF_FILES_PATH = "C:/Users/eduncan/Downloads";
    private static final String STATEMENT_FILE_NAME = "politicas-objetos-extraviados.pdf";

    @Before public void setStage(){OnStage.setTheStage(new OnlineCast());}

    @Before public static void statementsDownloaded() {File downloadsDirectory = new File(DOWNLOADED_PDF_FILES_PATH);
            for (File file : downloadsDirectory.listFiles()) {if (isAStatement(file.getName())) {file.delete();}}}
            private static boolean isAStatement(String fileName) {if (fileName.contains(STATEMENT_FILE_NAME)) {return true;}return false;}


    @Dado("que entro a la seccion de objetos perdidos")
    public void queEntroALaSeccionDeObjetosPerdidos() {
        theActorCalled("Edi").wasAbleTo(PaginaPrincipal.laPagina());
    }

    @Cuando("consulto el pdf")
    public void consultoElPdf() {
        theActorInTheSpotlight().attemptsTo(ObjetosPerdidos.the());
    }

    @Entonces("verifico que sea el correcto")
    public void verificoQueSeaElCorrecto(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        List<List<String>> rowsWithoutHead = rows.subList(1, rows.size());
        for (List<String> obj : rowsWithoutHead) {
            theActorInTheSpotlight().should(GivenWhenThen.seeThat(PreguntaPdfObjPerdidos.the(obj.get(0))));
        }
    }

}
