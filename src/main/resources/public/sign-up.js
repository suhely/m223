const URL = 'http://localhost:8081';
let entries = [];
let mode = 'create';
let currentEntry;

// API Requests
const registerUser = (entry) => {
    console.log(entry);
    fetch(`${URL}/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        if (result.ok) {
            window.location.replace(`${URL}/login.html`);
        }
    });
};

// Rendering
const resetForm = () => {
    const entryForm = document.querySelector('#signUpForm');
    entryForm.reset();
    mode = 'create';
    currentEntry = null;
}

const saveForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['username'] = formData.get('username');
    entry['password'] = formData.get('password');

    registerUser(entry);

    resetForm();
}

document.addEventListener('DOMContentLoaded', function () {
    const entryForm = document.querySelector('#signUpForm');
    entryForm.addEventListener('submit', saveForm);
    entryForm.addEventListener('reset', resetForm);
});