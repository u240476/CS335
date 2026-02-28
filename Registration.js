document.addEventListener('DOMContentLoaded', function() {

    const registerForm = document.getElementById('registration-form');
    if (registerForm) {
        registerForm.addEventListener('submit', function(event) {
            const name = document.getElementById('Name3').value.trim();
            const email = document.getElementById('Email3').value.trim();
            const password = document.getElementById('Password3').value.trim();
            const msgDiv = document.getElementById('DivMessage3');
            msgDiv.textContent = "";

            if (name.length === 0) {
                event.preventDefault();
                msgDiv.textContent = "Name field cannot be empty";
                msgDiv.style.color = "red";
            } else if (!email.endsWith(".com") && !email.endsWith(".ie")) {
                event.preventDefault();
                msgDiv.textContent = "Emails must end with '.com' or '.ie' to be compatible";
                msgDiv.style.color = "red";
            } else if (password.length < 8 || !password.includes('@')) {
                event.preventDefault();
                msgDiv.textContent = "Passwords must be at least 8 characters long and contain an @";
                msgDiv.style.color = "red";
            }
        });
    }

});