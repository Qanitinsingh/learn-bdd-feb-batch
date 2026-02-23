# =========================================================
# Feature File: E-Commerce Shopping Functionality
# Tags at Feature level apply to ALL scenarios inside file
# =========================================================

@Ecommerce @Regression
Feature: E-Commerce Shopping Functionality
  # Feature describes the high-level business functionality.
  # Here we are testing login, add to cart, remove and checkout.

  This feature verifies core shopping functionalities like login,
  adding products to cart, and checkout process.

  # ---------------------------------------------------------
  # Background section runs BEFORE every scenario
  # Used for common preconditions like launching browser & login
  # ---------------------------------------------------------

  @Smoke @Login
  Background:
    Given User launches the application
    # Opens browser

    And User navigates to "https://demo-ecommerce.com"
    # Opens application URL

    And User logs in with username "standard_user" and password "password123"
    # Common login step reused across scenarios


  # ---------------------------------------------------------
  # Simple Scenario (Single Test Case)
  # Tests adding one product to cart
  # ---------------------------------------------------------

  @Sanity @AddToCart @Priority1
  Scenario: Add a single product to cart
    # Scenario = one complete test case

    When User searches for product "iPhone 15"
    # Searching specific product

    And User clicks on "Add to Cart"
    # Adds product into cart

    Then Product "iPhone 15" should be added to the cart
    # Validate correct product added

    And Cart count should be "1"
    # Validate cart badge count


  # ---------------------------------------------------------
  # Another Scenario (Remove functionality validation)
  # ---------------------------------------------------------

  @Regression @RemoveFromCart @Priority2
  Scenario: Remove product from cart
    When User searches for product "Samsung Galaxy S24"
    And User clicks on "Add to Cart"
    And User removes the product from cart
    # Remove product action

    Then Cart should be empty
    # Validate cart is empty after removal


  # ---------------------------------------------------------
  # Scenario Outline (Data Driven Testing)
  # Same steps run multiple times using different test data
  # ---------------------------------------------------------

  @Regression @Checkout @DataDriven
  Scenario Outline: Successful checkout with multiple users
    # Scenario Outline allows parameterization using < > values

    When User searches for product "<ProductName>"
    # Product name comes from Examples table

    And User adds the product to cart
    And User proceeds to checkout

    And User enters shipping address "<Address>"
    # Address comes from Examples table

    Then Order should be placed successfully
    # Validate order confirmation

    # Examples table provides multiple sets of data
    # This scenario will run 3 times (3 rows below)

    Examples:
      | ProductName        | Address              |
      | iPhone 15          | Delhi, India         |
      | MacBook Pro        | Mumbai, India        |
      | Nike Shoes         | Bangalore, India     |


  # ---------------------------------------------------------
  # Data Table Example
  # Used to pass multiple rows of data in a single scenario
  # ---------------------------------------------------------

  @Regression @BulkOrder @DataTable
  Scenario: Add multiple products using DataTable
    # DataTable is useful for bulk operations

    When User adds following products to cart:
      | ProductName      | Quantity |
      | iPhone 15        | 1        |
      | MacBook Air      | 2        |
      | Sony Headphones  | 1        |
    # Each row will be converted into List<Map<String,String>>
    # Used for bulk product addition

    Then All products should be added successfully
    # Validate all items present in cart

    And Cart total should be calculated correctly
    # Validate total price calculation