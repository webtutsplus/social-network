<template>
  <div>
    <div v-for="items in posts" :key="items.id" class="card" style="">
      <div class="card-body">
        <h5 class="card-title">{{ items.user.name }}</h5>
        <h6 class="card-subtitle mb-2 text-muted">{{ items.user.email }}</h6>
        <p class="card-text">{{ items.content }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import {API_BASE_URL} from '/src/config.js';

export default {
  name: "Posts",
  data() {
    return {
      posts: [],
    }
  },
  mounted() {
    this.getPost();
  },
  methods: {
    getPost() {
      axios.get(API_BASE_URL + "public/posts").then(resp => {
        this.posts = resp.data
      });
    }
  }
}
</script>

<style scoped>

</style>