<template>
  <div>Authorization</div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { Token } from '../../entities/Token'
import { AuthorizationService } from '../../services/AuthorizationService'
import { User } from '../../entities/User'

@Component
export default class AuthorizationCallback extends Vue {
  mounted () {
    let code:string = this.$route.query.code as string

    AuthorizationService.getToken('authorization_code', code, process.env.VUE_APP_SSO_REDIRECT_URL)
      .then(response => {
        console.log(response.data)
        Vue.axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.accessToken}`
      })
  }
}
</script>
