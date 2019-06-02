<template>
  <div class="hello">
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Password</th>
          <th>Role</th>
          <th>Action</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <!--https://vuejs.org/v2/guide/list.html#Maintaining-State-->
        <tr v-for="user in users" v-bind:key="user.email">
          <td>{{user.name}}</td>
          <td>{{user.email}}</td>
          <td>{{user.password}}</td>
          <td>{{user.role}}</td>
          <td><a :href="'/user/update/' + user.username">Update</a></td>
          <td><a v-on:click="remove(user)" href="#">Delete</a></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { User } from '../entities/User'

// https://github.com/vuejs/vue-class-component

@Component
export default class UserList extends Vue {
  users:User[] = [];
  // https://vuejs.org/v2/guide/instance.html#Instance-Lifecycle-Hooks

  // lifecycle hook
  mounted () {
    this.getUsers()
  }

  getUsers () {
    this.users = this.$store.state.users
  }

  remove (userToRemove:User) {
    this.$store.commit('removeUser', userToRemove)
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
