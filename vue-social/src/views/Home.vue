<template>
  <div class="home">
    <h3 > Simplecoding Social </h3>
    <img alt="Vue logo" src="../assets/logo.png">
    <h4 id="login"> Login to get Started</h4>
  </div>
</template>

<script>
// @ is an alias to /src
import firebase from 'firebase';
import $ from 'jquery'

export default {
  name: 'Home',
  methods: {
    checkLoggedIn: function () {
      if (firebase.auth().currentUser ) {
        $("#login").html("Welcome " + firebase.auth().currentUser.displayName);
      }
    }
  },
  mounted() {
    this.checkLoggedIn();
  }
}
</script>
