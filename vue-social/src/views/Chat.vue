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

export default {
  name: "listusers",
  data() {
    return {
      messages: [],
    }
  },
  mounted() {
    this.getusers();
  },
  methods: {
    getusers() {

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
