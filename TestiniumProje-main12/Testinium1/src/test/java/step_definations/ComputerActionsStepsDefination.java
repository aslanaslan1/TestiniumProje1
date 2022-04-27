package step_definations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;
import utilities.Driver;

import java.io.IOException;

public class ComputerActionsStepsDefination {

    WebPage webPage=new WebPage();

    @Given("Kullanici web sayfasinda")
    public void kullanici_web_sayfasinda() {
        Driver.getDriver().get("https://www.gittigidiyor.com/");
        webPage.cookiesAccept();
    }

    @When("Arama kutusuna {string} kelimesi girilir")
    public void arama_kutusuna_bilgisayar_kelimesi_girilir(String string) {
        webPage.ilkTiklama();
        webPage.arama(string);
    }

    @When("Arama sonuclari sayfasindan ikinci sayfa acilir")
    public void arama_sonuclari_sayfasindan_ikinci_sayfa_acilir() {
        webPage.ikinciSayfaTiklama();
    }

    @When("Ikinci sayfanin acildigi kontrol edilir")
    public void Ikinci_sayfanin_acildigi_kontrol_edilir() {
        webPage.ikinciSayfaKontrol();
    }

    @Then("Sonuca gore sergilenen urunlerden rastgele bir urun secilir")
    public void sonuca_gore_sergilenen_urunlerden_rastgele_bir_urun_secilir() {
        webPage.urunSecimi();
    }

    @Then("Secilen urunun urun bilgisi ve tutar bilgisi txt dosyasina yazilir")
    public void secilen_urunun_urun_bilgisi_ve_tutar_bilgisi_txt_dosyasina_yazilir() throws IOException {
        webPage.urunFiyatBilgi();
    }

    @Then("Secilen urun sepete eklenir")
    public void secilen_urun_sepete_eklenir() {
        webPage.sepeteEklendi();
    }

    @Then("Urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir")
    public void urun_sayfasindaki_fiyat_ile_sepette_yer_alan_urun_fiyatinin_dogrulugu_karsilastirilir() {
        webPage.urunFiyatKontrol();
    }

    @Then("Adet arttirilarak urun adedinin iki oldugu dogrularnir")
    public void adet_arttirilarak_urun_adedinin_iki_oldugu_dogrularnir() {
        webPage.urunAdet2();
        webPage.adetArttirildi();
    }

    @Then("Urun sepetten silinerek sepetin bos oldugu kontrol edilir")
    public void urun_sepetten_silinerek_sepetin_bos_oldugu_kontrol_edilir() {
        webPage.urunSilindi();
        webPage.sonKontrol();
    }

}
