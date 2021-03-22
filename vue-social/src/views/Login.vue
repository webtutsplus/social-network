<template>
    <div class="login">
        <h3>Sign In</h3>
        <input type="text" v-model="email" placeholder="Email"><br>
        <input type="password" v-model="password" placeholder="Password"><br>
        <button class="btn btn-success" @click="login">Login</button>
        <p>You don't have an account ? You can <router-link to="/sign-up">create one by Github </router-link></p>
        <button class="social-button" @click="socialGithubLogin"><img src="../assets/github_logo.png"></button>
    </div>
</template>

<script>
    import firebase from 'firebase';
    import {saveUser} from "@/helpers";

    import {API_BASE_URL} from "../config";
    export default {
        name: 'login',
        data() {
            return {
                email: '',
                password: ''
            }
        },
        methods: {
            login: function() {
                firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
                    (user) => {
                        console.log("user logged ins", user);
                        //alert("you are now connexted");
                        this.$router.replace('home')
                    },
                    (err) => {
                        alert('Oops. ' + err.message)
                    }
                );
            },

            socialGithubLogin () {
            const provider = new firebase.auth.GithubAuthProvider();

            firebase.auth().signInWithPopup(provider).then((result)=>{
                console.log("result", result);
                firebase.auth().currentUser.getIdToken(true).then(function(idToken) {

                  localStorage.setItem("idToken",idToken);
                  const token = "Bearer "+idToken
                  const url = `${API_BASE_URL}private/saveUser`;
                  saveUser(url, token);
                })
                }).catch((err)=>{
                    alert('Oops. ' + err.message)
                })
            }
        }

    }

</script>

<style scoped>  /* "scoped" attribute limit the CSS to this component only */
.login {
    margin-top: 40px;
}
input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
}
button {
    margin-top: 20px;
    width: 10%;
    cursor: pointer;
}
p {
    margin-top: 40px;
    font-size: 13px;
}
p a {
    text-decoration: underline;
    cursor: pointer;
}
.social-button {
    width: 75px;
    background: white;
    padding: 10px;
    border-radius: 100%;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2);
    outline: 0;
    border: 0;
}
.social-button:active {
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.1);
}
.social-button img {
    width: 100%;
}
</style>
