const URL = 'http://localhost:8081';
let entries = [];
let mode = 'create';
let currentEntry;

// API Requests
const loginUser = (entry) => {
    console.log(entry);
    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        if (result.ok) {
            localStorage.setItem('token', result.headers.get("Authorization"));
            window.location.replace(`${URL}/index.html`);
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

    loginUser(entry);

    resetForm();
}

document.addEventListener('DOMContentLoaded', function () {
    const entryForm = document.querySelector('#loginForm');
    entryForm.addEventListener('submit', saveForm);
    entryForm.addEventListener('reset', resetForm);
});