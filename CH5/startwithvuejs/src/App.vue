<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/delivery">Delivery</router-link>
      <template v-if="!isLoggedIn"> | <router-link to="/login">Login</router-link></template>
      <template v-if="isLoggedIn"> | <router-link :to="{ name: 'food_service_view', params: { email: loggedIn }}">Settings</router-link></template> |
      <router-link to="/about">About</router-link> |
    </div>
    <router-view/>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'

@Component
export default class App extends Vue {
  get isLoggedIn () {
    return this.$store.getters.getCurrentFoodServiceLoggedIn() !== ''
  }
  get loggedIn () {
    return this.$store.getters.getCurrentFoodServiceLoggedIn()
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
