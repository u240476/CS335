document.addEventListener('DOMContentLoaded', function() {

    const forgotForm = document.getElementById('ForgotPasswordForm');
        forgotForm.addEventListener('submit', function(event) {
            const name = document.getElementById('Name1').value.trim();
            const email = document.getElementById('Email1').value.trim();
            const confirmEmail = document.getElementById('ConfirmEmail1').value.trim();
            const msgDiv = document.getElementById('DivMessage1');
            msgDiv.textContent = "";

            if (name.length === 0) {
                event.preventDefault();
                msgDiv.textContent = "Name field cannot be empty.";
                msgDiv.style.color = "red";
            } else if (email !== confirmEmail) {
                event.preventDefault();
                msgDiv.textContent = "Emails must match in order for us to send you your password.";
                msgDiv.style.color = "red";
            } else if (email.length < 10) {
                event.preventDefault();
                msgDiv.textContent = "Emails must be at least 10 characters long to be valid.";
                msgDiv.style.color = "red";
            } else if (!email.endsWith(".com") && !email.endsWith(".ie")) {
                event.preventDefault();
                msgDiv.textContent = "Emails must end with '.com' or '.ie' to be compatible.";
                msgDiv.style.color = "red";
            }
        });
    });
    
