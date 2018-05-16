// Get the Sidebar
var sidebar = document.getElementById("sidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("overlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function openBar() {
    if (sidebar.style.display === 'block') {
        sidebar.style.display = 'none';
        overlay.style.display = "none";
    } else {
        sidebar.style.display = 'block';
        overlay.style.display = "block";
    }
}
// Close the sidebar
function closeBar() {
    sidebar.style.display = "none";
    overlay.style.display = "none";
}
// Function to hide and show html elements (change pw and nickname)
function popout(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") === -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

// Function to change tabs in profile page
function accountChange(evt, accountc) {
    var i, x, tablinks;
    x = document.getElementsByClassName("account");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" w3-blue w3-leftbar", "");
    }
    document.getElementById(accountc).style.display = "block";
    evt.currentTarget.className += " w3-blue w3-leftbar";
}

// Function to display an alert for not logged on users
function loginAlert() {
    alert("Please Login First");
}

// Function to display an alert for when an article is added to basket
function basketalert() {
    alert("Added to Basket");
}