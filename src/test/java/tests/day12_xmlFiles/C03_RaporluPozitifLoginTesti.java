package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapilabilmeli");
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Qualitydemy anasayfaya gidildi");

        // login linkine tiklayin
        QdPage qdPage= new QdPage();
        qdPage.ilkLoginLinki.click();
        extentTest.info("Ilk login linkine tiklandi");

        // gecerli kullanici adi ve password ile giris yapin
        qdPage.cookiesElementi.click();
        ReusableMethods.bekle(5);
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("Gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("Gecerli password yazildi");
        qdPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        ReusableMethods.bekle(2);

        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Basarili sekilde giris yapildigi test edildi");

        Driver.closeDriver();

    }
}
