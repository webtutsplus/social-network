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
        <div class="input-group rounded">
          <input type="search" class="form-control rounded" placeholder="post your content here...." aria-label="Search"
                 aria-describedby="search-addon" v-model="content"/>
          <BButton @click="addpost">Add Post</BButton>
        </div>
      </li>
    </ul>
    <b-container>
      <div class="row">
        <div v-for="item in posts" :key="item.id" class="col-md-10">
          <div class="card">
            <div class="card-body">
              <section class="">
                <div class="row">
                  <div class="col-md-11">
                    <div class="media">
                      <div class="media-left">
                        <a href="#">
                          <img v-if="item.user" class="media-object photo-profile"
                               :src="item.user.picture"
                               width="50" height="50" alt="...">
                          <img v-else class="media-object photo-profile"
                               :src="user.picture"
                               width="50" height="50" alt="...">
                        </a>
                      </div>
                      <div class="media-body">
                        <a v-if="item.user" href="#" class="anchor-username"><h4 class="media-heading">
                          {{ item.user.name || item.user.email }}</h4></a>
                        <a v-else href="#" class="anchor-username"><h4 class="media-heading">
                          {{ user.name || user.email }}</h4></a>
                        <div class="anchor-time"><h6>51 mins</h6></div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-1">
                    <a href="#"><i class="glyphicon glyphicon-chevron-down"></i></a>
                  </div>
                </div>
              </section>
              <section class="post-body">
                <p>{{item.content}}</p>
              </section>
              <section class="post-footer">
                <hr>
                <div class="post-footer-option container">
                  <ul class="list-unstyled">
                    <li><a href="#">
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                           class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                        <path
                            d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                      </svg>
                      Like</a></li>
                    <li><a href="#">
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                           class="bi bi-share" viewBox="0 0 16 16">
                        <path
                            d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5zm-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3z"/>
                      </svg>
                      Share</a></li>
                  </ul>
                </div>
              </section>
            </div>
          </div>
        </div>
      </div>
    </b-container>
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
      users: [],
      selected: null,
      user: null,
    }
  },
  mounted() {
    this.getPost();
    this.getuser();
  },
  methods: {
    getPost() {
      axios.get(API_BASE_URL + "public/posts").then(resp => {
        this.posts = resp.data
      });
    },
    getmypost() {
      axios.get(API_BASE_URL + "private/mypost", {
        "headers": {
          "Authorization": "Bearer " + localStorage.getItem("idToken")
        }
      }).then(res => {
        this.posts = res.data
      }).catch(err => console.log(err));
    },
    addpost() {
      axios.post(API_BASE_URL + "private/addpost", {"content": this.content}, {
        "headers": {
          "Authorization": "Bearer " + localStorage.getItem("idToken")
        }
      }).then(res => {
        alert("post added");
        console.log(res.data);
        this.getPost();
      }).catch(err => console.log(err));
    },
    getpostofuser() {
      console.log(this.selected);
      axios.get(API_BASE_URL + "public/" + this.selected + "/posts").then(res => {
        this.posts = res.data
        console.log(res.data);
      }).catch(err => console.log(err));
    },
    getuser() {
      axios.get(API_BASE_URL + "private/user-details", {
        "headers": {
          "Authorization": "Bearer " + localStorage.getItem("idToken")
        }
      }).then(res => {
        this.user = res.data
      }).catch(err => console.log(err));
    }
  }
}
</script>

<style scoped>
/*-- Global Selectors --*/
a {
  color: #47649F;
}


/*-- Bootstrap Override Style --*/

.card {
  margin-top: 10px;
}

/*-- Content Style --*/
.post-footer-option li {
  float: left;
  margin-right: 50px;
  padding-bottom: 15px;
}

.post-footer-option li a {
  color: #AFB4BD;
  font-weight: 500;
  font-size: 1.3rem;
}

.photo-profile {
  border: 1px solid #DDD;
}

.anchor-username h4 {
  font-weight: bold;
}

.anchor-time {
  color: #ADB2BB;
  font-size: 1.2rem;
}

.post-footer-comment-wrapper {
  background-color: #F6F7F8;
}

body {
  background-color: #eee
}

.time {
  font-size: 9px !important
}

.socials i {
  margin-right: 14px;
  font-size: 17px;
  color: #d2c8c8;
  cursor: pointer
}

.feed-image img {
  width: 100%;
  height: auto
}
</style>