<template>
    <div class="login">
        <h3>Sign In</h3>
        <input type="text" v-model="email" placeholder="Email"><br>
        <input type="password" v-model="password" placeholder="Password"><br>
        <button @click="login">Connection</button>
        <p>You don't have an account ? You can <router-link to="/sign-up">create one</router-link></p>
        <button @click="socialGithubLogin">Github</button>
    </div>
</template>

<script>
    import firebase from 'firebase';
    import axios from 'axios'
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
                        alert("you are now connexted");
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

                localStorage.setItem("idToken",idToken)
                const token = "Bearer "+idToken

                 axios.get('http://localhost:8080/private/saveUser',{ 'headers': { 'Authorization': token } })
                    .then(resp => {
                        console.log(resp);

                        if(resp.status === 200){
                            console.log('saved the user!!!')
                        }
                        else {
                            console.log("bad request by client")
                        }
                    }).catch(err => {
                        console.log(err)
                    })
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
</style>
