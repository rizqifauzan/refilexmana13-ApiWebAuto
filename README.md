# Refi API Web Automation

Proyek automation testing untuk API dan Web menggunakan **Cucumber BDD**, **Selenium**, dan **Rest Assured**.

## Daftar Isi
- [Prasyarat](#prasyarat)
- [Setup Environment](#setup-environment)
- [Konfigurasi Token](#konfigurasi-token)
- [Menjalankan Tests](#menjalankan-tests)
- [Struktur Proyek](#struktur-proyek)
- [Fitur](#fitur)

## Prasyarat

Sebelum memulai, pastikan Anda sudah menginstal:

- **Java JDK 11+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Git** - [Download](https://git-scm.com/)
- **Gradle** (opsional, project ini sudah menyediakan wrapper)

## Setup Environment

### 1. Clone Repository

```bash
git clone https://github.com/yourusername/refilexmana13-ApiWebAuto.git
cd refilexmana13-ApiWebAuto
```

### 2. Setup File Environment Variables

File `.env` digunakan untuk menyimpan kredensial dan konfigurasi sensitif. **JANGAN** commit file ini ke repository.

#### Membuat File `.env`

1. Buat file `.env` di root directory project:

```bash
# Windows (PowerShell)
New-Item -Path ".env" -Type File

# Linux/Mac
touch .env
```

2. Tambahkan variabel environment:

```env
TOKEN=your_api_token_here
BASE_URL=https://gorest.co.in
BROWSER=chrome
HEADLESS_MODE=false
```

### 3. Git Configuration

Pastikan file `.env` tidak ter-commit ke repository:

```bash
# Tambahkan ke .gitignore
echo ".env" >> .gitignore
git add .gitignore
git commit -m "Add .env to gitignore"
```

## Konfigurasi Token

### Tentang TOKEN

Token API digunakan untuk autentikasi ke REST API. Dalam proyek ini:

- **Sumber Token**: File `.env` pada root directory
- **Format**: Environment variable `TOKEN`
- **Keamanan**: Jangan pernah commit file `.env` ke public repository

### Menggunakan Token dalam Test

Token dapat diakses dalam Java code menggunakan **dotenv-java** library:

```java
import io.github.cdimascio.dotenv.Dotenv;

public class BaseApi {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String TOKEN = dotenv.get("TOKEN");
    
    // Gunakan TOKEN dalam RestAssured requests
    given()
        .header("Authorization", "Bearer " + TOKEN)
        .when()
        .get(baseUrl)
        .then()
        .statusCode(200);
}
```

### Mendapatkan Token API

Untuk mendapatkan token baru dari [gorest.co.in](https://gorest.co.in):

1. Kunjungi https://gorest.co.in
2. Login atau daftar akun
3. Generate API token di settings
4. Copy token dan simpan di file `.env`

## Menjalankan Tests

### Menjalankan Semua API Tests

```bash
./gradlew runApiTests
```

### Menjalankan Semua Web Tests

```bash
./gradlew runWebTests
```

### Menjalankan Test Spesifik (Windows)

```bash
# API Tests
.\gradlew.bat runApiTests

# Web Tests
.\gradlew.bat runWebTests
```

### View Test Reports

Setelah menjalankan tests, lihat laporan di:

```
build/reports/tests/runApiTests/index.html  (API Tests)
build/reports/tests/test/index.html         (Web Tests)
```

## Struktur Proyek

```
refilexmana13-ApiWebAuto/
├── .env                          # Environment variables (JANGAN COMMIT)
├── .gitignore                    # Git ignore rules
├── build.gradle                  # Gradle configuration
├── README.md                     # Dokumentasi ini
├── src/test/java/
│   └── com/refi/
│       ├── api/
│       │   ├── baseApi/          # Base API class
│       │   ├── runners/          # API test runner
│       │   └── stepdef/          # API step definitions
│       └── Web/
│           ├── Base/             # Base test class
│           ├── Pages/            # Page Object Model
│           ├── Runner/           # Web test runner
│           └── StepDef/          # Web step definitions
└── src/test/resources/
    └── features/
        ├── api/                  # API feature files
        └── Web/                  # Web feature files
```

## Dependencies

### Testing Framework
- **Cucumber JUnit** (7.15.0) - BDD framework
- **JUnit 4** (4.13.2) - Unit testing

### API Testing
- **Rest Assured** (5.4.0) - API testing library
- **JSON Schema Validator** (6.0.0) - JSON validation

### Web Testing
- **Selenium WebDriver** (4.40.0) - Browser automation
- **WebDriverManager** (6.3.3) - Driver management

### Utilities
- **dotenv-java** (3.0.0) - Environment variables
- **JSON** (20251224) - JSON processing

## Fitur

✅ **API Automation Testing**
- Cucumber BDD scenarios
- Rest Assured untuk HTTP requests
- JSON schema validation
- Token-based authentication

✅ **Web UI Automation**
- Selenium WebDriver
- Page Object Model pattern
- Cucumber step definitions
- Cross-browser support

✅ **Environment Management**
- Dotenv untuk secure credential storage
- Configuration management
- Token-based API authentication

## Kontribusi

1. Create feature branch (`git checkout -b feature/AmazingFeature`)
2. Commit changes (`git commit -m 'Add some AmazingFeature'`)
3. Push to branch (`git push origin feature/AmazingFeature`)
4. Open a Pull Request

## Security Notes

⚠️ **PENTING**: 
- Jangan pernah commit file `.env` yang berisi token asli
- Gunakan `.env.example` untuk dokumentasi variabel yang diperlukan
- Ganti token secara berkala untuk keamanan maksimal
- Jika token ter-expose, segera generate token baru

## Troubleshooting

### Token tidak valid
```
Error: 401 Unauthorized
```
Solusi: Cek apakah token di `.env` benar dan belum expired

### Test gagal menjalankan
```
Error: Could not find or load class apiTestRunner
```
Solusi: Jalankan `./gradlew clean build` terlebih dahulu

### Browser driver tidak ditemukan
```
Error: ChromeDriver not found
```
Solusi: WebDriverManager akan otomatis download driver yang sesuai

## Lisensi

Proyek ini dilindungi oleh lisensi proprietary.

---

**Last Updated**: Februari 2026
