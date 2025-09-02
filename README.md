# OnlineShopping-end2end-automationsuite
A robust Selenium-based end-to-end automation testing framework for online shopping platforms. Covers key user flows like login, product search, add to cart, checkout, and payment validations.

OnlineShopping-End2End-AutomationSuite is a modular and scalable test automation framework built with Selenium WebDriver, designed to simulate and verify real-world user journeys in eCommerce environments.

It automates critical workflows such as:

User registration & login

Product search and filtering

Add to cart and wishlist features

Checkout and payment process

Order confirmation and history
## 📌 Features

- ✅ Modular Page Object Model (POM) design
- ✅ Cross-browser support (Chrome, Firefox, Edge)
- ✅ Data-driven testing (Excel/CSV/JSON)
- ✅ Easy-to-configure test environment
- ✅ Extensible for mobile and API testing
- ✅ Integrated logging and reporting (ExtentReports)
- 
## 🚀 Test Coverage

| Module            | Covered Scenarios                               |
|-------------------|--------------------------------------------------|
| User Auth         | Sign Up, Login, Logout                          |
| Product Search    | Search, Filter, Sort, View Details              |
| Cart & Wishlist   | Add/Remove Items, Save for Later, Quantity Edit |
| Checkout Process  | Address, Shipping, Payment                      |
| Order Management  | Order Confirmation, History                     |
## 🧱 Tech Stack

- **Language**: Java
- **Framework**: Selenium WebDriver
- **Build Tool**: Maven 
- **Design Pattern**: Page Object Model (POM)
- **Test Runner**: TestNG 
- **Reporting**:ExtentReports 
- **CI/CD**: GitHub Actions / Jenkins *(optional)*
## 📂 Project View

```plaintext
OnlineShopping-End2End-AutomationSuite/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       ├── tests/
│   │       ├── utils/
│   │       └── config/
│   └── test/
│       ├── TestRunner.java
│       └── TestData/
├── drivers/
├── logs/
├── reports/
├── resources/
│   └── config.properties
├── .gitignore
├── pom.xml
├── README.md
└── LICENSE
```
