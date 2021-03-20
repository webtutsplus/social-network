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
      </div>
    </li>
  </ul>
</template>

<script>
import axios from 'axios';

export default {
  name: "listuers",
  data() {
    return {
      users: [],
    }
  },
  mounted() {
    this.getusers();
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
