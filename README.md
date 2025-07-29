# Firebase Auth App – SignUp & Login

An Android app built using **Java** and **Firebase Authentication** that allows users to **register** and **login** securely using their email and password. The app features a clean Material UI, progress indicators, input validation, and redirection to a Dashboard upon successful login.

---

## ✨ Features

- 📧 Register new users using Firebase Email/Password Auth
- 🔐 Login existing users securely
- 🧭 Redirect users to a Dashboard after login
- ✅ Input validation for email and password
- 🔄 Switch between login and signup screens
- 📱 Fullscreen Material UI with progress bars

---


## 🛠 Tech Stack

- **Java** (Android SDK)
- **Firebase Authentication**
- **Material Design Components**
- **XML Layouts with ConstraintLayout**

---

## 🧠 How It Works

### 🔹 Sign-Up Flow
1. User enters email & password (min 6 chars, must include `@`).
2. Input is validated.
3. Firebase's `createUserWithEmailAndPassword()` is called.
4. On success → input is cleared, Toast is shown.

### 🔹 Login Flow
1. User enters credentials.
2. If valid, Firebase's `signInWithEmailAndPassword()` is called.
3. On success → user is redirected to the `Dashboad` activity with UID & email.
4. Errors are shown via Toast on failure.

---

