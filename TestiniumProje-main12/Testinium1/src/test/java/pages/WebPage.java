package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WebPage extends AbstractBasePage {

    @FindBy(xpath = "//span[contains(text(),'Kapat')]")
    protected WebElement cookiesAccept;

    @FindBy(xpath = "//input[@type='text']")
    protected WebElement aramaEkraniKutusu;

    @FindBy(xpath = "//input[@type='text']")
    protected WebElement aramaEkraniYazma;

    @FindBy(css = "a[aria-label='2. sayfa']")
    protected WebElement ikincSayfaTiklama;

    @FindBy(css = "h2[title='Teknobiyotik Amd Ryzen 3 4100 3.8Ghz 16Gb Ram 256Gb Ssd 4Gb GTX1650 Ekran Kartlı Oyun Bilgisayarı'")
    protected WebElement urunSecildi;

    @FindBy(css = "#sp-title")
    protected WebElement urunBilgisi;

    @FindBy(css = "#sp-price-lowPrice")
    protected WebElement tutarBilgisi;

    static String itemPriceStatic;

    @FindBy(css = "#add-to-basket")
    protected WebElement sepeteEklendi;

    @FindBy(css = "p[class='new-price']")
    protected WebElement fiyatKontrol;

    @FindBy(css = "span[class='basket-title']")
    protected WebElement sepeteGit;

    @FindBy(xpath = "//select[@class='amount']")
    protected WebElement miktar;

    @FindBy(css = "option[value='2']")
    protected WebElement select2;

    @FindBy(xpath = "//a[@title='Sil']")
    protected WebElement urunSilindi;

    @FindBy(xpath = "//h2[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]")
    protected WebElement sonMesaj;

    public void cookiesAccept(){
        BrowserUtilities.wait(6);
        cookiesAccept.click();
    }

    public void ilkTiklama(){
        BrowserUtilities.wait(2);
        aramaEkraniKutusu.click();
    }

    public void arama(String searchKey){
        BrowserUtilities.wait(2);
        aramaEkraniYazma.sendKeys(searchKey, Keys.ENTER);
    }

    public void ikinciSayfaTiklama(){
        BrowserUtilities.wait(2);
        ikincSayfaTiklama.click();
        jsExecutor("window.scrollBy(0,3750)");
        logger.info("Ikinci sayfa tiklandi");
    }

    public void ikinciSayfaKontrol(){
        BrowserUtilities.wait(2);
        Assert.assertTrue(driver.getCurrentUrl().endsWith("2"));
        logger.info(driver.getCurrentUrl());
    }

    public void urunSecimi(){
        BrowserUtilities.wait(5);
        urunSecildi.click();
    }

    public void urunFiyatBilgi() throws IOException {
        BrowserUtilities.wait(10);
        FileWriter fileWriter = new FileWriter("namePrice.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        itemPriceStatic = tutarBilgisi.getText();
        printWriter.println(urunBilgisi.getText());
        printWriter.println(itemPriceStatic);
        printWriter.close();
    }

    public void sepeteEklendi(){
        BrowserUtilities.wait(3);
        sepeteEklendi.click();
    }

    public void urunFiyatKontrol(){
        BrowserUtilities.wait(6);
        sepeteGit.click();
        BrowserUtilities.wait(3);
        Assert.assertEquals(itemPriceStatic,fiyatKontrol.getText());
        logger.info("Urunun fiyati ile Sepetteki fiyati kontrol edildi:"+fiyatKontrol.getText());
    }

    public void urunAdet2(){
        BrowserUtilities.wait(3);
        miktar.click();
        BrowserUtilities.wait(3);
        select2.click();
        BrowserUtilities.wait(5);
    }

    public void adetArttirildi(){
        Assert.assertEquals("2", miktar.getAttribute("value"));// burasi yanlis value olmayacak
        logger.info("Sepetteki urun 1 arttirildi:"+ miktar.getSize());
    }

    public void urunSilindi(){
        BrowserUtilities.wait(3);
        urunSilindi.click();
    }

    public void sonKontrol(){
        BrowserUtilities.wait(4);
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",sonMesaj.getText());
        logger.info("Sepetinizde ürün bulunmamaktadır."+sonMesaj.getText());
    }
}




