document.addEventListener('DOMContentLoaded', function() {

    const loginForm = document.getElementById('login-form');
        loginForm.addEventListener('submit', function(event) {
            const email = document.getElementById('Email2').value.trim();
            const password = document.getElementById('Password2').value.trim();
            const msgDiv = document.getElementById('DivMessage2');
            msgDiv.textContent = "";

            if (password.length === 0) {
                event.preventDefault();
                msgDiv.textContent = "Password field cannot be empty";
                msgDiv.style.color = "red";
            } else if (!email.endsWith(".com") && !email.endsWith(".ie")) {
                event.preventDefault();
                msgDiv.textContent = "Emails must end with '.com' or '.ie' to be compatible.";
                msgDiv.style.color = "red";
            }
        });
    });