<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in users" v-bind:key="item.id">
      <div class="row">
        <div class="col">
          <div v-if="item.name === null">
            {{item.email}}
          </div>
          <div v-else>
            {{item.name}}
          </div>
        </div>
        <div class="col">
          <img class="img" v-bind:src="item.picture" alt="avatar">
        </div>
        <div class="col">
          <button v-if="email !== item.email" class="btn btn-primary pull-right" @click="addfriend(item.id)">Add Friend</button>
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
import axios from 'axios';
import firebase from 'firebase';
import {API_BASE_URL} from '/src/config.js';

export default {
  name: "listusers",
  data() {
    return {
      users: [],
      email: '',
    }
  },
   mounted() {
    this.getusers();
    //console.log(firebase.auth().currentUser.email)
    this.email = firebase.auth().currentUser.email;
  },
  methods: {
    getusers() {
      const url = `${API_BASE_URL}public/users`;
      axios.get(url).then(resp => {
        console.log(resp);
        if(resp.status === 200){
          this.users = resp.data;
        }else {
          console.log("bad request by client")
        }
      }).catch(err => {
        console.log(err)
      })
    },
    addfriend(id){
      axios.get(`${API_BASE_URL}private/addFriend/?friendId=${id}`,{'headers' :{
          'Authorization': 'Bearer '+localStorage.getItem('idToken'),
        }}).then(resp => {
          console.log(resp.data);
          if(resp.status === 200){
            alert("friend added! ");
          }
      }).catch(err => console.log(err))
    }
  }
}
</script>

<style scoped>

.img{
  max-width: 70px;
  max-height: 70px;
}

</style>
