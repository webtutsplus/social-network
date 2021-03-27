<template>
  <div>
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <button class="nav-link" @click="getPost()">All posts</button>
      </li>
      <li class="nav-item">
        <button class="nav-link" @click="getmypost()">My posts</button>
      </li>
      <li class="nav-item">
        <select v-on:change="getpostofuser()" v-model="selected">
          <option v-for="item in this.users" :key="item.id" :value="item.id">{{item.email}}</option>
        </select>
      </li>
    </ul>
    <label>Content : </label><input type="text" v-model="content"/>
    <button @click="addpost()">Add Post</button>
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
      content: "",
      users :[],
      selected: null,
    }
  },
  mounted() {
    this.getPost();
    this.getusers();
  },
  methods: {
    getPost() {
      axios.get(API_BASE_URL + "public/posts").then(resp => {
        this.posts = resp.data
      });
    },
    getmypost(){
      axios.get(API_BASE_URL + "private/mypost",{"headers" : {
          "Authorization":"Bearer "+localStorage.getItem("idToken")
        }}).then(res => {
          this.posts = res.data
      }).catch(err => console.log(err));
    },
    addpost(){
      axios.post(API_BASE_URL+"private/addpost",{"content" : this.content},{"headers" : {
          "Authorization":"Bearer "+localStorage.getItem("idToken")
        }}).then(res => {
          alert("post added");
          console.log(res.data);
      }).catch(err => console.log(err));
    },
    getpostofuser(){
      console.log(this.selected);
      axios.get(API_BASE_URL + "public/"+this.selected+"/posts").then(res => {
        this.posts = res.data
      }).catch(err => console.log(err));
    },
    getusers() {
      axios.get(API_BASE_URL+"public/users").then(res => {
        this.users = res.data
      }).catch(err => console.log(err));
    }
  }
}
</script>

<style scoped>

</style>