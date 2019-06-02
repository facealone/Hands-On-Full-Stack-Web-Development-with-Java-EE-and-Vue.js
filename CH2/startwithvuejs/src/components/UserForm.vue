<template>
  <div class="row">
    <div class="col-sm">
      <div class="form-group">
        <label for="name">Name</label>
        <input
          v-model="user.name"
          type="text"
          class="form-control"
          id="name"
          placeholder="Name"
          required
        >
      </div>
      <div class="form-group">
        <label for="role">Role</label>
        <select class="custom-select" id="role" v-model="user.role">
          <option selected value="ADMIN">ADMIN</option>
          <option value="USER">USER</option>
        </select>
      </div>
      <div class="form-group">
        <label for="email">Email address</label>
        <input
          v-model="user.email"
          type="email"
          class="form-control"
          id="email"
          aria-describedby="emailHelp"
          placeholder="Enter email"
          :readonly="updateMode"
          required
        >
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
          v-model="user.password"
          type="password"
          class="form-control"
          id="password"
          placeholder="Password"
          required
        >
      </div>
      <button class="btn btn-primary" v-on:click="save">{{updateMode ? 'Update' : 'Save'}}</button>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import { User } from '../entities/User'
import { Role } from '../entities/Role'

// https://github.com/vuejs/vue-class-component

@Component
export default class UserForm extends Vue {
  @Prop() private readonly type!: string
  @Prop({ default: () => User.emptyUser() }) private readonly user!: User

  save () {
    this.$emit('userFilled', this.user)
  }

  get updateMode () {
    return this.type === 'update'
  }
}
</script>
