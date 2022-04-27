Feature:Sepete urun ekleme

  Kullanici bilgisayar satin almak istiyor

  Scenario: Sepete bilgisayar ekleme islemi
    Given Kullanici web sayfasinda
    When Arama kutusuna "bilgisayar" kelimesi girilir
    And Arama sonuclari sayfasindan ikinci sayfa acilir
    And Ikinci sayfanin acildigi kontrol edilir
    Then Sonuca gore sergilenen urunlerden rastgele bir urun secilir
    And Secilen urunun urun bilgisi ve tutar bilgisi txt dosyasina yazilir
    And Secilen urun sepete eklenir
    Then Urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir
    And Adet arttirilarak urun adedinin iki oldugu dogrularnir
    Then Urun sepetten silinerek sepetin bos oldugu kontrol edilir