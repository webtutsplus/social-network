<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in users" v-bind:key="item.id">
      <div class="row">
        <div class="col">
          <div v-if="item.name === null">
            {{ item.email }}
          </div>
          <div v-else>
            {{ item.name }}
          </div>
        </div>
        <div class="col">
          <img class="img" v-bind:src="item.picture" alt="avatar">
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
import axios from "axios";
import {API_BASE_URL} from '/src/config.js';
import firebase from 'firebase';

export default {
  name: "listFriends",
  data() {
    return {
      "users": [],
    }
  }, mounted() {
    this.getfriends()
    this.user = firebase.auth().currentUser;
  },
  methods: {
    getfriends() {
      axios.get(API_BASE_URL + "private/listFriends", {
        'headers': {
          'Authorization': 'Bearer ' + localStorage.getItem('idToken'),
        }
      })
          .then(resp => {
            if (resp.status === 200) {
              console.log(resp.data)
              this.users = resp.data
            }
          }).catch(err => console.log(err));

    }
  }
}
</script>

<style scoped>
.img {
  max-width: 70px;
  max-height: 70px;
}
</style>