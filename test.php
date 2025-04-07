<?php
// Test PHP File
// This PHP script demonstrates various features of PHP, including functions, arrays, and more.

// Display a greeting message
function displayGreeting() {
    echo "<h1>Hello, World!</h1>";
    echo "<p>This is a test PHP file.</p>";
}

displayGreeting();  // Call the greeting function

// Function to display user information
function displayUserInfo($name, $age, $isStudent, $height) {
    echo "<h2>User Information</h2>";
    echo "<p>Name: $name</p>";
    echo "<p>Age: $age</p>";
    echo "<p>Student: " . ($isStudent ? "Yes" : "No") . "</p>";
    echo "<p>Height: $height feet</p>";
}

$name = "John Doe";
$age = 30;
$isStudent = false;
$height = 5.9;

displayUserInfo($name, $age, $isStudent, $height);  // Call function to display user info

// Function to display an array of fruits
function displayFruitList($fruits) {
    echo "<h2>Fruit List</h2>";
    echo "<ul>";
    foreach ($fruits as $fruit) {
        echo "<li>$fruit</li>";
    }
    echo "</ul>";
}

$fruits = array("Apple", "Banana", "Cherry", "Date");

displayFruitList($fruits);  // Call function to display fruits

// Function to display an associative array (user profile)
function displayUserProfile($user) {
    echo "<h2>User Profile</h2>";
    echo "<p>Username: " . $user['username'] . "</p>";
    echo "<p>Email: " . $user['email'] . "</p>";
    echo "<p>Country: " . $user['country'] . "</p>";
}

$user = array(
    "username" => "johndoe123",
    "email" => "john.doe@example.com",
    "country" => "USA"
);

displayUserProfile($user);  // Call function to display user profile

// Function to greet the user
function greetUser($userName) {
    return "Welcome, $userName!";
}

echo "<h2>Function Example</h2>";
echo "<p>" . greetUser($name) . "</p>";  // Call function to greet user

// Function to categorize age
function ageCategory($age) {
    if ($age < 18) {
        return "You are a minor.";
    } else {
        return "You are an adult.";
    }
}

echo "<h2>Age Category</h2>";
echo "<p>" . ageCategory($age) . "</p>";  // Call function to check age category

// Function to display numbers in a range
function displayNumbers($start, $end) {
    echo "<h2>Numbers $start to $end</h2>";
    echo "<ul>";
    for ($i = $start; $i <= $end; $i++) {
        echo "<li>$i</li>";
    }
    echo "</ul>";
}

displayNumbers(1, 5);  // Call function to display numbers from 1 to 5

// Function to get current date and time
function displayDateTime() {
    echo "<h2>Current Date and Time</h2>";
    echo "<p>Today's date is: " . date("Y-m-d") . "</p>";
    echo "<p>Current time is: " . date("H:i:s") . "</p>";
}

displayDateTime();  // Call function to display date and time

// Function to display a constant
define("SITE_NAME", "My Test Website");

function displaySiteName() {
    echo "<h2>Constant Example</h2>";
    echo "<p>Site Name: " . SITE_NAME . "</p>";
}

displaySiteName();  // Call function to display site name

// Function to demonstrate the use of PHP superglobals ($_GET, $_POST)
function displaySuperglobalsExample() {
    echo "<h2>Superglobals Example</h2>";
    echo "<p>PHP is a server-side language. Use a form to send data using POST or GET methods.</p>";
}

displaySuperglobalsExample();  // Call function to demonstrate superglobals

// End of the script
function endOfScript() {
    echo "<p>End of the PHP test script.</p>";
}

endOfScript();  // Call function to indicate the end of the script
?>
