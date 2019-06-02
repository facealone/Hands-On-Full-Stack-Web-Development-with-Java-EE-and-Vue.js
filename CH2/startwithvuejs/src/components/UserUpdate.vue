<template>
  <div>
    <UserForm v-on:update="update($event)" mode="update" :user="user"></UserForm>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import UserForm from '@/components/UserForm.vue'
import { User } from '../entities/User'

// https://github.com/vuejs/vue-class-component

@Component({
  components: {
    UserForm
  }
})
export default class UserUpdate extends Vue {
  private user!:User;

  // lifecycle hook
  mounted () {
    this.getUser(this.$route.params.email)
  }

  getUser (email:string) {
    this.user = this.$store.getters.getUserByEmail(email)
  }

  update (user:User) {
    this.$store.commit('updateUser', user)
  }
}
</script>
