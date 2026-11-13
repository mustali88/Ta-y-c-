# TAŞIYICI Android uygulaması — başlangıç iskeleti

Bu depo TAŞIYICI için bağımsız Android projesidir. Kasas 24 projesinden ayrıdır.

## Şu anki durum
- Android / Kotlin / Jetpack Compose proje iskeleti.
- TAŞIYICI ana ekran taslağı.
- Alınan ödemeler, yapılan işler, masraflar, avans ve taksit gereksinimlerinin ilk modül özeti.
- Yedekleme ekranında güvenlik ve kurtarma akışının açıklaması.

## Henüz tamamlanmadı
Bu ilk iskelet henüz gerçek kayıt/veritabanı, paket arşivi, PDF/WhatsApp paylaşımı, şifreli yedek ve Gmail akışını uygulamaz. Bunlar sonraki adımlarda eklenecek ve test edilecek. Telefon içi yedek tek başına cihaz kaybına karşı yeterli değildir; dışa aktarılan yedek ayrıca saklanmalıdır.

## Derleme
Android Studio ile projeyi açıp Gradle senkronizasyonu yaptıktan sonra `app` yapılandırmasını çalıştırın. APK için Build > Build Bundle(s) / APK(s) > Build APK(s).
