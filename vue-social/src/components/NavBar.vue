<template>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><img id="logo" src="/assets/icon.png" class="img-fluid" /></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link class="nav-link" :to="'/'">Home</router-link>
        </li>

        <li class="nav-item">
          <router-link class="nav-link" :to="'/listusers'">Users</router-link>
        </li>

        <li class="nav-item" v-if="!username">
          <router-link class="nav-link"  :to="'/login'">Log In</router-link>
        </li>

        <li class="nav-item" v-if="!username">
          <router-link class="nav-link"  :to="'/login'">Chat</router-link>
        </li>

        <li class="nav-item" v-if="!username">
          <router-link class="nav-link" :to="'/signup'">Sign Up</router-link>
        </li>

        <li class="nav-item" v-else>
          <a class="nav-link" href="#" @click="signOut">Sign Out</a>
        </li>

        <li class="nav-item" v-if="username">
          <router-link class="nav-link"  :to="'/room/'+this.username">Chat</router-link>
        </li>



      </ul>
    </div>
  </nav>
  <!-- Navbar Ends -->

</template>

<script>
export default {
  name: "Navbar",
  data() {
    return {
      username : localStorage.getItem('username')
    }
  },
  watch: {
    $route() {
      this.username = localStorage.getItem('username')
    }
  },
  methods: {
    signOut() {
      localStorage.removeItem('username');
      this.username = null;
      this.$router.replace('login')
    }
  }
}
</script>

<style scoped>
#logo {
  width: 70%;
}
</style>
