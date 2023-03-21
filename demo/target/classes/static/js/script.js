// Disable the back button to prevent the user from going back to the logged-out page
    history.pushState(null, null, location.href);
    window.apostate = function(event) {
        history.go(1);
    };
    // Break the session by redirecting the user to the login page
    window.location.href = 'http://localhost:8080/';