package co.com.choucair.objperdidos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObjetosPerdidosPagina extends PageObject {
    public static final Target CLICK_SERVICIOS = Target.the("hacer click en servicios").located(By.xpath("//*[@id=\"menutop\"]/ul/li[4]/a"));
    public static final Target CLICK_INFORMACION = Target.the("hacer click en Informacion del viajero").located(By.xpath("//*[@id=\"menutop\"]/ul/li[4]/ul/li[1]/a"));
    public static final Target CLICK_EXTRAVIADOS = Target.the("hacer click en Objetos extraviados").located(By.xpath("//*[@id=\"menutop\"]/ul/li[4]/ul/li[1]/ul/li[8]/a"));
    public static final Target CLICK_PDF = Target.the("hacer click en PDF").located(By.xpath("//*[@id=\"content\"]/div[1]/div/p[5]/a[1]/img"));



}
