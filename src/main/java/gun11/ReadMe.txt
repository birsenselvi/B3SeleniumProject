Implicitly Wait
    driver bünyesinde tanimlanir. Bir sefer tanimlanir. Sürec icinde tekrar tanimlanabilir.
    Bu bekleme element presence oluncaya kadar her element icin beklenir.
    presence : var oluncaya kadar. Kodlarda olan element presence'dir.

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));





ExplicitWait : Elemente özel islemleri gerceklestirir.
    Elemente özel durumlari beklemek icin kullanilir.
    visible olmasini, precense olmasini, renginin deismesini,
    invisible olmasini, element sayisini, elementin textini,
    driverin title'ini,..., vs

    //tanimlanmasi : bir nesne olarak tanimlanir.
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(300));

    tanimlamada, driver (zorunlu), bekleme süresi (zorunlu) ve sleep (optional) süresi tanimlanir.
    uygulama icinde istenilen kadar wait tanimlanabilir.

