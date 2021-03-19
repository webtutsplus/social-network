<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in users" v-bind:key="item.id">
      {{item.name}}
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

</style>
