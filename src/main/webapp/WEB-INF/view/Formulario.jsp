<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
        <p class="legend" >Please fill out this form with the required information</p>
        <main>
            <form action="saludoCool"> <!-- cambiar por saludo o saludoCool -->
                <section class="section-one">
                    <article class="input">
                        <label for="nombre">Ingresa tu nombre:</label>
                        <input type="text" name="nombre" id="nombre" required class="field">
                    </article>
                    <article>
                        <label for="apellido">Ingresa tu apellido:</label>
                        <input type="text" name="apellido" id="apellido" required class="field">
                    </article>
                    <article>
                        <label for="email">Ingresa tu Email:</label>
                        <input type="email" name="email" id="email" required class="field">
                    </article>
                    <article>
                        <label for="password">Ingresa tu contraseña:</label>
                        <input type="password" name="password" id="password" required class="field">
                    </article>
                </section>
                <hr>
                <section class="section-three">
                    <p>Account type (required)</p>
                    <article>
                        <input type="radio" name="account-type" id="personal" required>
                        <label for="personal">Personal</label>
                    </article>
                    <article>
                        <input type="radio" name="account-type" id="business" required>
                        <label for="business">Business</label>
                    </article>
                </section>
                <hr>
                <section class="section-two">
                    <article>
                        <p>Upload a profile picture:</p>
                        <input type="file" name="picture" id="picture" class="field">
                    </article>
                    <article>
                        <label for="age">Input your age (years):</label>
                        <input type="number" name="age" id="age" class="field">
                    </article>
                    <article>
                        <label for="hook">How did you hear about us?</label>
        
                    </article>
                    <article>
                        <label for="bio">Provide a bio:</label>
                        <input type="text" name="bio" id="bio" class="field" placeholder="I like coding on the beach...">
                    </article>
                </section>
                <article>                    
                    <input type="checkbox" id="terms-conditions" required>
                    <label for="terms-conditions">I accept the <a target="_blank" href="https://www.freecodecamp.org/news/terms-of-service/">terms and conditions</a></label>
                </article>
               
                <button type="submit">Submit</button>
            </form>
        </main>
</body>
</html>