Feature: Echo support in Amazon website

  Scenario: Echo support in Amazon website
  Given Go to Amazon main page
  When Locate at the upper right corner the button: Hello, Sign In Account & lists and click on it
  Then Click on “New customer? Start right here”
  * Fill Name field with the response of this API => [Options in the AC]
  * Fill Email field with the data from the API response Firstname.Lastname@fake.com
  * Click on Condition of Use link
  * Locate the search bar and Search for Echo
  * Locate “Echo support” options and click on it
  * Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting
  And Close browser