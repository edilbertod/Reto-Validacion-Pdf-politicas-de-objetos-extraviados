package co.com.choucair.objperdidos.questions;

import co.com.choucair.objperdidos.abilities.LeerPdf;
import co.com.choucair.objperdidos.userinterfaces.ObjetosPerdidosPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.util.EnvironmentVariables;


import java.io.IOException;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PreguntaPdfObjPerdidos implements Question<Boolean> {
    private String titulo;
    private String pdfText;
    private EnvironmentVariables environmentVariables;
    String downloadFolder;
    String fileName;

    public PreguntaPdfObjPerdidos(String titulo) {
        this.titulo = titulo;
    }

    public static PreguntaPdfObjPerdidos the(String titulo){
        return new PreguntaPdfObjPerdidos(titulo);

    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean result;

        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);
        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);

        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);

        try {
            theActorInTheSpotlight().whoCan(LeerPdf.downloadedInPath(statementFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pdfText = LeerPdf.as(theActorInTheSpotlight()).getText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(pdfText.contains(titulo)){
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
