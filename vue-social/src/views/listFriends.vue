<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in users" v-bind:key="item.id">
      <div class="row">
        <div class="col" v-if="item.name === null">
          {{ item.email }}
        </div>
        <div class="col" v-else>
          {{ item.name }}
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

export default {
  name: "listFriends",
  data() {
    return {
      "users": [],
    }
  }, mounted() {
    this.getfriends()
  },
  methods: {
    getfriends() {
      axios.get("http://localhost:8080/private/listFriends", {
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

</style>