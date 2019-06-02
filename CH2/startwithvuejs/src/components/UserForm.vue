<template>
  <div class="hello">
    <input v-model="name" placeholder="edit me">
    <input v-model="email" placeholder="edit me" :readonly = "mode == 'update'">
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
  @Prop() private mode:string = 'create'
  @Prop() private user!:User
  private name:string = ''
  private email:string = ''
  private password:string = ''
  private role:Role = Role.USER

  mounted () {
    this.name = this.user!.name
    this.email = this.user!.email
    this.password = this.user!.password
    this.role = this.user!.role
  }

  save () {
    let user:User = new User(this.name, this.email, this.password, this.role)

    this.$emit('saveUser', user)
  }
}
</script>
