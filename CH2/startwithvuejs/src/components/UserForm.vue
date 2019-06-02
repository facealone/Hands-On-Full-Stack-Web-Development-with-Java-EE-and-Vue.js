<template>
  <div class="hello">
    <input v-model="name" placeholder="edit me">
    <input v-model="email" placeholder="edit me">
    <input v-model="password" placeholder="edit me">
    <input v-model="role" placeholder="edit me">
    <button v-on:click="save">Save</button>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { User } from '../entities/User'
import { Role } from '../entities/Role'

// https://github.com/vuejs/vue-class-component

@Component
export default class UserForm extends Vue {
  private name:string = ''
  private email:string = ''
  private password:string = ''
  private role:Role = Role.USER

  save () {
    let user:User = new User(this.name, this.email, this.password, this.role)

    this.$store.commit('saveUser', user)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
