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
        <div v-if="email !== item.email">
          <button class="btn btn-primary pull-right" @click="addfriend(item.id)">Add Friend</button>
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
import axios from 'axios';
import firebase from 'firebase';

export default {
  name: "listuers",
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

      axios.get('http://localhost:8080/public/users').then(resp => {
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
      axios.get('http://localhost:8080/private/addFriend/?friendId='+id,{'headers' :{
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
